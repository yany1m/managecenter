package com.runrong.managecenter.business.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runrong.managecenter.business.dao.LoginDao;
import com.runrong.managecenter.business.model.Administrator;
import com.runrong.managecenter.common.base.ResultModel;
import com.runrong.managecenter.common.encrypt.MD5;

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
		if(username==null || password==null){
			return ResultModel.failModel("参数有误");
		}
		//盐加密密码
		password=MD5.encoderByMd5Salt(request.getParameter("password"), username);
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
}
