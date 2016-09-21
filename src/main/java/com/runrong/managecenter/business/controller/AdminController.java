package com.runrong.managecenter.business.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.runrong.managecenter.business.aop.CheckPermission;
import com.runrong.managecenter.business.service.AdminGroupService;
import com.runrong.managecenter.business.service.AdminService;
import com.runrong.managecenter.common.base.ResultModel;

/**
 * 管理员账号控制层
 * @author yanyimin
 *
 */
@Controller
@RequestMapping("/managecenter")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	@Autowired
	AdminGroupService adminGroupService;
	
	/**
	 * 添加管理员
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value="/addAdministrator" ,method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView addAdministratorGET(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException{
//		System.out.println("get");
		return new ModelAndView("/managecenter/addAdministrator");
	}
	
	/**
	 * 添加管理员
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value="/addAdministrator" ,method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel addAdministratorPOST(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException{
//		System.out.println("post");
//		JSONObject json=(JSONObject)JSON.toJSON(adminService.addAdministrator(request));
//		return json.toJSONString();
		return adminService.addAdministrator(request);
	}
	
	
	/**
	 * 修改管理员
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value="/updateAdministrator",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView updateAdministratorGET(HttpServletRequest request,ModelMap map) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		
		List<?> adminGroupList =(List<?>)adminGroupService.getAdminGroup(request).getBody();
		map.put("adminGroupList",adminGroupList);
		
		map.put("id", request.getParameter("id"));
		map.put("username", request.getParameter("username1"));
		map.put("adminGroupId", Integer.valueOf(request.getParameter("adminGroupId")));
	    return new ModelAndView("/managecenter/updateAdministrator");
	
	}
	
	/**
	 * 修改管理员
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value="/updateAdministrator",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel updateAdministratorPOST(HttpServletRequest request,ModelMap map) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		return adminService.updateAdministrator(request);
	}
	
	
	/**
	 * 删除管理员
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value="/deleteAdministrator",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel deleteAdministratorPOST(HttpServletRequest request) {
		
		 return adminService.deleteAdministrator(request);
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
