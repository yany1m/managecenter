package com.runrong.managecenter.business.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.runrong.managecenter.business.aop.CheckPermission;
import com.runrong.managecenter.business.service.AdminService;
import com.runrong.managecenter.business.service.UserService;
import com.runrong.managecenter.common.base.ResultModel;

@Controller
@RequestMapping("/managecenter")
public class RouteController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	UserService userService;
	
	/**
	 * 管理员界面
	 * @param request
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/admin")
	@ResponseBody
	public ModelAndView admin(HttpServletRequest request,ModelMap map) throws ParseException{
				
		List list=(List) adminService.getAdministrator(request).getBody();
		
		map.put("list", list);
		return new ModelAndView("/managecenter/admin");
	}
	
	

	/**
	 * 用户界面
	 * @param request
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/user")
	@ResponseBody
	public ModelAndView user(HttpServletRequest request,ModelMap map) throws ParseException{
				
		List list=(List) userService.getUser(request).getBody();
		
		map.put("list", list);
		return new ModelAndView("/managecenter/user");
	}
	
}
