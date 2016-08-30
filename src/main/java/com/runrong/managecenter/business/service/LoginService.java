package com.runrong.managecenter.business.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runrong.managecenter.business.dao.LoginDao;
import com.runrong.managecenter.business.model.Administrator;
import com.runrong.managecenter.common.base.ResultModel;
import com.runrong.managecenter.common.dictionary.DefineType;
import com.runrong.managecenter.common.encrypt.MD5;
import com.runrong.managecenter.common.encrypt.RSAUtils;

/**
 * 登录处理层
 * @author yanyimin
 *
 */
@Service
public class LoginService {
	@Autowired
	LoginDao loginDao;
	
	/**
	 * 登录
	 * @param request
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public ResultModel login(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		String username=request.getParameter("username");		
		String password=request.getParameter("password");
		String verifyCode=request.getParameter("verifycode");
		
		if((username==null && username.equals("")) || (password==null && password.equals("")) || (verifyCode==null && verifyCode.equals(""))){
			return ResultModel.failModel("参数有误");
		}
		//检查验证码
		ResultModel checkVerifyCode=checkVerifyCode(request, verifyCode);
		if(checkVerifyCode.Fail()){
			return checkVerifyCode;
		}
		//RSA解密
		username=RSAUtils.decryptStringByJs(username);
		password=RSAUtils.decryptStringByJs(password);
		//盐加密密码
		password=MD5.encoderByMd5Salt(password, username);
		List<Administrator> list=loginDao.login(username, password);
		
		if(list==null || list.size()==0){
			return ResultModel.failModel("用户名或者密码错误");
		}
		
		//登录成功，将信息注册到session中。
		Administrator admin=list.get(0);
		HttpSession session=request.getSession();
		//管理员id,管理员组id,管理员账号,管理员类型
		session.setAttribute("admin_id",admin.getUuid() );
		session.setAttribute("admin_group_id",admin.getAdminGroupid() );
		session.setAttribute("username", admin.getUsername());
		session.setAttribute("admin_type", admin.getType());
		return ResultModel.successModel("登录成功");
	}
	
	/**
	 * 获取登录账号
	 * @param request
	 * @return
	 */
	public String getLoginAccount(HttpServletRequest request){
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		
		return username;
	}
	
	/**
	 * 验证验证码
	 * @param request
	 * @param verifyCode
	 * @return
	 */
	public ResultModel checkVerifyCode(HttpServletRequest request,String verifyCode){
		Timestamp timeStamp= (Timestamp) request.getSession().getAttribute("verifyCodeCreateTime");
		Date date=new Date();		
		if(date.getTime()-timeStamp.getTime()>DefineType.VALIDTIME){
			return ResultModel.failModel("验证码过期");
		}
		//判断验证码是否正确
		if(!verifyCode.equals(request.getSession().getAttribute("verifyCode"))){
			return ResultModel.failModel("验证码错误");
		}	
		
		return ResultModel.successModel();
	}
}
