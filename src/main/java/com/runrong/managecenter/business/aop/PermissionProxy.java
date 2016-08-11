package com.runrong.managecenter.business.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

import com.runrong.managecenter.business.dao.AdminDao;
import com.runrong.managecenter.business.model.Administrator;
import com.runrong.managecenter.common.base.ResultModel;

@Configuration
@Aspect
public class PermissionProxy {
	@Autowired
	AdminDao adminDao;
	
	@Around("@annotation(com.runrong.managecenter.business.aop.CheckPermission)")
	public Object check(ProceedingJoinPoint point) throws Throwable {
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();
		String methodName=method.getName();
		
        for (Object arg : point.getArgs()) {
            if (!(arg instanceof HttpServletRequest)) {
                continue;
            }
            HttpServletRequest request = (HttpServletRequest) arg;
            HttpSession session =request.getSession();
            int id=(int) session.getAttribute("admin_id");
            int type=(int) session.getAttribute("admin_type");
            
            if(type==0){
            	return point.proceed();
            }
    		if(methodName.equals("checkLogin")){
    			return point.proceed();
    		
    		}
    		   		
    		return new ModelAndView("index");
        }
        
        throw new RuntimeException("the method which use @CheckPermission must has a HttpServletRequest as Parameter");

    }
}
