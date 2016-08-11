package com.runrong.managecenter.business.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.runrong.managecenter.business.aop.CheckPermission;
import com.runrong.managecenter.business.service.AdminService;
import com.runrong.managecenter.common.base.ResultModel;

/**
 * 管理员账号控制层
 * @author yanyimin
 *
 */
@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	/**
	 * 添加管理员
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping("/addAdministrator")
	@ResponseBody
	@CheckPermission
	public ModelAndView addAdministrator(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		 ResultModel r=adminService.addAdministrator(request);
		 
		 if(r.getCode()==1){
			 return new ModelAndView("addAdministrator");
		 }
		 return new ModelAndView("redirect:/admin");
	}
	
	/**
	 * 修改管理员
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping("/updateAdministrator")
	@ResponseBody
	@CheckPermission
	public ModelAndView updateAdministrator(HttpServletRequest request,ModelMap map) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		ResultModel r=adminService.updateAdministrator(request);
		
		 if(r.getCode()==1){
			 map.put("id", request.getParameter("id"));
			 map.put("username", request.getParameter("username1"));		
			 return new ModelAndView("updateAdministrator");
		 }		 
		return new ModelAndView("redirect:/admin");
	}
	
	/**
	 * 删除管理员
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping("/deleteAdministrator")
	@ResponseBody
	@CheckPermission
	public ModelAndView deleteAdministrator(HttpServletRequest request) {
		
		ResultModel r= adminService.deleteAdministrator(request);
		 
		 if(r.getCode()==1){
			 return new ModelAndView("deleteAdministrator");
		 }
		 return new ModelAndView("redirect:/admin");
	}
	
	/**
	 * 查询管理员
	 * @param request
	 * @return
	 * @throws ParseException 
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping("/getAdministrator")
	@ResponseBody
	public ResultModel getAdministrator(HttpServletRequest request) throws ParseException {
		
		return adminService.getAdministrator(request);
	}
	
}
