package com.runrong.managecenter.business.aop;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

import com.runrong.managecenter.business.cache.PermissionCache;
import com.runrong.managecenter.business.service.AdminService;
import com.runrong.managecenter.common.base.BaseLogger;
import com.runrong.managecenter.common.base.ResultModel;

@Configuration
@Aspect
public class PermissionProxy extends BaseLogger{
	@Autowired
	AdminService adminService;
	@Autowired
	PermissionCache permissionCache;
	
	@Around("@annotation(com.runrong.managecenter.business.aop.CheckPermission)")
	public Object check(ProceedingJoinPoint point) throws Throwable {
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();
		String className=signature.getDeclaringTypeName();
		String methodName=method.getName();
		
        for (Object arg : point.getArgs()) {
            if (!(arg instanceof HttpServletRequest)) {
                continue;
            }
            HttpServletRequest request = (HttpServletRequest) arg;
            HttpSession session =request.getSession();
            int id=(int) session.getAttribute("admin_id");
            int type=(int) session.getAttribute("admin_type");
            
            //每次都需要查询数据库  权限验证较为频繁可以引入缓存
            List<String> permission;
            if(permissionCache.get(String.valueOf(id)) == null){
            	permission=adminService.getAdminPermission(id);
            	//写入缓存中
            	permissionCache.put(String.valueOf(id),permission);
            }else{
            	//logger.info("用户："+id+",从缓存中验证权限："+className+"_"+methodName);
            	permission=permissionCache.get(String.valueOf(id));
            }
            
            if(type==0){
            	return point.proceed();
            }
            
            //如果用户权限中包含此方法名                   
    		if(permission.contains(className+"_"+methodName)){
    			return point.proceed();   		
    		}
    		 
    		if(methodName.endsWith("POST")){
    			//无权限使用  所以没必要停留在原页面可以作为成功进行跳转
    			return ResultModel.successModel("无权限使用此功能");
    		}
    		return new ModelAndView("redirect:/managecenter/nopermission.html");    		
        }
        
        throw new RuntimeException("the method which use @CheckPermission must has a HttpServletRequest as Parameter");

    }
}
