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
import com.runrong.managecenter.business.service.PermissionService;
import com.runrong.managecenter.common.base.ResultModel;
/**
 * 权限控制层
 * @author yanyimin
 *
 */
@Controller
@RequestMapping("/managecenter")
public class PermissionController {
	
	@Autowired
	PermissionService permissionService;
	
	/**
	 * 查看权限
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPermission")
	@ResponseBody
	public ModelAndView getPermission(HttpServletRequest request,ModelMap map){
		
		List list=(List) permissionService.getPermission(request).getBody();		
		map.put("list", list);
		return new ModelAndView("/managecenter/getPermission");
	}
	
	/**
	 * 添加权限
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addPermission",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView addPermissionGET(HttpServletRequest request){
		
		return new ModelAndView("/managecenter/addPermission");
	}
	
	/**
	 * 添加权限
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addPermission",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel addPermissionPOST(HttpServletRequest request){
		
		return permissionService.addPermission(request);
	}
	
	/**
	 * 修改权限
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updatePermission",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView updatePermissionGET(HttpServletRequest request,ModelMap map){
		
		Integer id=Integer.valueOf(request.getParameter("id"));			
		String permission=request.getParameter("permission")==null?null:request.getParameter("permission");
		String permissionName=request.getParameter("permissionName")==null?null:request.getParameter("permissionName");
		String parent=request.getParameter("parent")==null?null:request.getParameter("parent");
		String parentName=request.getParameter("parentName")==null?null:request.getParameter("parentName");
		
		map.put("id", id);
		map.put("permission", permission);
		map.put("permissionName", permissionName);
		map.put("parent", parent);
		map.put("parentName", parentName);
		return new ModelAndView("/managecenter/updatePermission");
	}

	/**
	 * 修改权限
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updatePermission",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel updatePermissionPOST(HttpServletRequest request,ModelMap map){
		
		return permissionService.updatePermission(request);
	}
	
	/**
	 * 删除权限
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deletePermission",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel deletePermissionPOST(HttpServletRequest request){
		
		return permissionService.deletePermission(request);
	}
	
}
