package com.runrong.managecenter.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.runrong.managecenter.common.base.ResultModel;
/**
 * 权限控制层
 * @author yanyimin
 *
 */
@Controller
@RequestMapping("/managecenter")
public class PermissionController {
	
	/**
	 * 查看权限
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPermission")
	@ResponseBody
	public ResultModel getPermission(HttpServletRequest request){
		
		return ResultModel.successModel();
	}
	
	/**
	 * 添加权限
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPermission")
	@ResponseBody
	public ResultModel addPermission(HttpServletRequest request){
		
		return ResultModel.successModel();
	}
	
	/**
	 * 修改权限
	 * @param request
	 * @return
	 */
	@RequestMapping("/updatePermission")
	@ResponseBody
	public ResultModel updatePermission(HttpServletRequest request){
		
		return ResultModel.successModel();
	}
	
	/**
	 * 删除权限
	 * @param request
	 * @return
	 */
	@RequestMapping("/deletePermission")
	@ResponseBody
	public ResultModel deletePermission(HttpServletRequest request){
		
		return ResultModel.successModel();
	}
}
