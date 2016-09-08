package com.runrong.managecenter.business.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.runrong.managecenter.business.service.StatementTemplateService;
import com.runrong.managecenter.common.base.ResultModel;
import com.runrong.managecenter.common.util.JsonUtil;
import com.runrong.managecenter.config.StatementConfig;

/**
 * 报表模板控制层
 * @author yanyimin
 *
 */
@Controller
@RequestMapping("/managecenter")
public class StatementTemplateController {
	
	@Autowired
	StatementTemplateService statementTemplateService;
	
	/**
	 * 查询报表模板
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getStatementTemplate",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel getStatementTemplatePOST(HttpServletRequest request){
		
		return statementTemplateService.getStatementTemplate(request);
	}
	
	
	
	/**
	 * 添加报表模板
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addStatementTemplate",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel addStatementTemplatePOST(HttpServletRequest request){
		
		return statementTemplateService.addStatementTemplate(request);
	}
	
	/**
	 * 添加报表模板
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addStatementTemplate",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView addStatementTemplateGET(HttpServletRequest request,ModelMap map){
		map.put("type", request.getParameter("type"));
		
		Map statementMap = null;
		switch (request.getParameter("type")){
			case "资产负债表":
				statementMap=StatementConfig.balanceStatementMap;
				break;
			case "现金流量表":
				statementMap=StatementConfig.cashflowStatementMap;
				break;
			case "利润表":
				statementMap=StatementConfig.profitStatementMap;
				break;
			
		}
		map.put("template", JsonUtil.getJsonFromObject(statementMap).toJSONString());
		return new ModelAndView("/managecenter/addStatementTemplate");
	}
	
	/**
	 * 更新报表模板
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateStatementTemplate",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel updateStatementTemplatePOST(HttpServletRequest request){
		
		return statementTemplateService.updateStatementTemplate(request);
	}
	
	/**
	 * 更新报表模板
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateStatementTemplate",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView updateStatementTemplateGET(HttpServletRequest request,ModelMap map){
		List list=(List) statementTemplateService.getStatementTemplate(request).getBody();
		map.put("statementTemplate",list.get(0));
		return new ModelAndView("/managecenter/updateStatementTemplate");
	}
	
	/**
	 * 删除报表模板
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deleteStatementTemplate",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel deleteStatementTemplatePOST(HttpServletRequest request){
		
		return statementTemplateService.deleteStatementTemplate(request);
	}
	
	/**
	 * 更新被选中的报表模板
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateStatementTemplateSelected",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel updateStatementTemplateSelectedPOST(HttpServletRequest request){
		
		return statementTemplateService.updateStatementTemplateSelected(request);
	}
	
	/**
	 * 报表模板页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/statementTemplate")
	@ResponseBody
	public ModelAndView statementTemplate(HttpServletRequest request,ModelMap map){
		List list=(List) statementTemplateService.getStatementTemplate(request).getBody();
		map.put("list", list);
		return new ModelAndView("/managecenter/statementTemplate");
	}	
}
