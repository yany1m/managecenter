package com.runrong.managecenter.business.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.runrong.managecenter.business.service.LoginService;
import com.runrong.managecenter.common.base.ResultModel;
/**
 * 登录控制层
 * @author yanyimin
 *
 */
@Controller
@RequestMapping("/managecenter")
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
	@ResponseBody
	public ResultModel login(HttpServletRequest request, ModelMap map) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		return loginService.login(request);
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
		return new ModelAndView("redirect:/managecenter/login");
	}
	
	
	/**
	 * 进入主页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletRequest request,ModelMap map){
		return new ModelAndView("/managecenter/index");
	}
}
