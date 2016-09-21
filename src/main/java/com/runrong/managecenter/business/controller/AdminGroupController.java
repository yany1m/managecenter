package com.runrong.managecenter.business.controller;

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
import com.runrong.managecenter.common.base.ResultModel;

/**
 * 管理组控制层
 * @author yanyimin
 *
 */
@Controller
@RequestMapping("/managecenter")
public class AdminGroupController {

	@Autowired
	AdminGroupService adminGroupService;
	
	/**
	 * 根据管理组Id查询管理组所有权限
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getAdminGroupPermissionById",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel getAdminGroupPermissionByIdPOST(HttpServletRequest request){
		
		return adminGroupService.getAdminGroupPermissionById(request);
	}
	
	/**
	 * 更新管理组的权限
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateAdminGroupPermission",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel updateAdminGroupPermissionPOST(HttpServletRequest request){
		
		return adminGroupService.updateAdminGroupPermission(request);
	}
	
	/**
	 * 添加管理组
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addAdminGroup",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView addAdminGroupGET(HttpServletRequest request){
	
		return new ModelAndView("/managecenter/addAdminGroup");
	}
	
	/**
	 * 添加管理组
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addAdminGroup",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel addAdminGroupPOST(HttpServletRequest request){
		
		return adminGroupService.addAdminGroup(request);
	}
	
	/**
	 * 查询管理组
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getAdminGroup",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView getAdminGroupGET(HttpServletRequest request,ModelMap map){
		List<?> list=(List<?>) adminGroupService.getAdminGroup(request).getBody();
		map.put("list", list);
		return new ModelAndView("/managecenter/getAdminGroup");
	}
	
	/**
	 * 查询管理组
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getAdminGroup",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel getAdminGroupPOST(HttpServletRequest request){
	
		return adminGroupService.getAdminGroup(request);
	}
	
	/**
	 * 更新管理组
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateAdminGroup",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel updateAdminGroupPOST(HttpServletRequest request){
		
		return adminGroupService.updateAdminGroup(request);
	}
	
	/**
	 * 更新管理组
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateAdminGroup",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView updateAdminGroupGET(HttpServletRequest request,ModelMap map){
		map.put("id", request.getParameter("id"));
		map.put("name", request.getParameter("name"));
		
		return new ModelAndView("/managecenter/updateAdminGroup");
	}
	
	/**
	 * 删除管理组
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deleteAdminGroup",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel deleteAdminGroupPOST(HttpServletRequest request){
		
		return adminGroupService.deleteAdminGroup(request);
	}
}
