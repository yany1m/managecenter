package com.runrong.managecenter.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.runrong.managecenter.business.aop.CheckPermission;
import com.runrong.managecenter.business.model.ConfigTemplate;
import com.runrong.managecenter.business.service.ConfigTemplateService;
import com.runrong.managecenter.common.base.ResultModel;
import com.runrong.managecenter.common.util.JsonUtil;
/**
 * 配置模板控制层
 * @author yanyimin
 *
 */
@Controller
@RequestMapping("/managecenter")
public class ConfigTemplateController {

	@Autowired
	ConfigTemplateService configTemplateService;
	
	/**
	 * 获取配置模板
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getAllQyCreditConfig",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel getAllQyCreditConfigPOST(HttpServletRequest request){
		
		return configTemplateService.getAllQyCreditConfig(request);
	}
	
	/**
	 * 获取配置模板
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getAllQyCreditConfig",method=RequestMethod.GET)
	@ResponseBody
	@CheckPermission
	public ModelAndView getAllQyCreditConfig(HttpServletRequest request,ModelMap map){
		ResultModel r = configTemplateService.getAllQyCreditConfig(request);
		if(r.Success()){
			map.put("list", r.getBody());
		}		
		return new ModelAndView("/managecenter/getAllQyCreditConfig");
	}
	
	/**
	 * 添加配置模板
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addQyCreditConfig",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel addQyCreditConfigPOST(HttpServletRequest request){
		
		return configTemplateService.addQyCreditConfig(request);
	}
	
	/**
	 * 添加配置模板
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addQyCreditConfig",method=RequestMethod.GET)
	@ResponseBody
	@CheckPermission
	public ModelAndView addQyCreditConfig(HttpServletRequest request,ModelMap map){
		ConfigTemplate configTemplate = (ConfigTemplate)configTemplateService.getQyCreditConfigById(request).getBody();
		map.put("configTemplate", configTemplate);
		map.put("content", JsonUtil.getJsonFromObject(configTemplate.getContent()).toJSONString());
		return new ModelAndView("/managecenter/addQyCreditConfig");
	}
	
	/**
	 * 删除配置模板
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deleteQyCreditConfigById",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel deleteQyCreditConfigByIdPOST(HttpServletRequest request,ModelMap map){
		
		return configTemplateService.deleteQyCreditConfigById(request);
	}
	
	/**
	 * 获取配置模板
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/selectQyCreditConfig",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel selectQyCreditConfigPOST(HttpServletRequest request,ModelMap map){
		
		return configTemplateService.selectQyCreditConfig(request);
	}
}
