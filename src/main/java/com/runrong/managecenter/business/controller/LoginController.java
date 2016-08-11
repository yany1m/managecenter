package com.runrong.managecenter.business.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.runrong.managecenter.business.aop.CheckPermission;
import com.runrong.managecenter.business.service.LoginService;
import com.runrong.managecenter.common.base.ResultModel;
/**
 * 登录控制层
 * @author yanyimin
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	/**
	 * 登录入口
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value="/loginIn")
	public ModelAndView login(HttpServletRequest request, ModelMap map) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		//进行登录验证，成功则注册session可以进入index，否则会被转发至login.html
		loginService.login(request);
		return new ModelAndView("redirect:/index");
	}
	
	/**
	 * 登出入口
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value="/loginOut")
	public ModelAndView loginOut(HttpServletRequest request, ModelMap map) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		HttpSession session= request.getSession();
		session.invalidate();
		return new ModelAndView("redirect:/login");
	}
	
	
	/**
	 * 进入主页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletRequest request,ModelMap map){
		return new ModelAndView("index");
	}
}
