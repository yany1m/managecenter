package com.runrong.managecenter.business.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.runrong.managecenter.business.aop.CheckPermission;
import com.runrong.managecenter.business.service.UserService;
import com.runrong.managecenter.common.base.ResultModel;
/**
 * 用户控制层
 * @author yanyimin
 *
 */
@Controller
@RequestMapping("/managecenter")
public class UserController {
	@Autowired
	UserService userService;
	
	/**
	 * 添加用户
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	@ResponseBody
	@CheckPermission
	public ModelAndView addUserGET(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		 ResultModel r=userService.addUser(request);
		 
		 if(r.getCode()==1){
			 return new ModelAndView("/managecenter/addUser");
		 }
		 return new ModelAndView("redirect:/managecenter/user");
	}
	
	/**
	 * 添加用户
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel addUserPOST(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException{	
		
		return userService.addUser(request);
	}
	
	/**
	 * 修改用户
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value="/updateUser",method=RequestMethod.GET)
	@ResponseBody
	@CheckPermission
	public ModelAndView updateUserGET(HttpServletRequest request,ModelMap map) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		ResultModel r=userService.updateUser(request);
		
		 if(r.getCode()==1){
			 map.put("id", request.getParameter("id"));
			 map.put("username", request.getParameter("username1"));
			 map.put("realname", request.getParameter("realname1"));
			 return new ModelAndView("/managecenter/updateUser");
		 }		 
		return new ModelAndView("redirect:/managecenter/user");
	}
	
	/**
	 * 修改用户
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel updateUserPOST(HttpServletRequest request,ModelMap map) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	
		return userService.updateUser(request);
	}
	
	/**
	 * 删除用户
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel deleteUserPOST(HttpServletRequest request) {
			 		
		 return userService.deleteUser(request);
	}
	
	/**
	 * 查询用户
	 * @param request
	 * @return
	 * @throws ParseException 
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping("/getUser")
	@ResponseBody
	public ResultModel getUser(HttpServletRequest request) throws ParseException {
		
		return userService.getUser(request);
	}
	
}
