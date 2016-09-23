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

import com.runrong.managecenter.business.aop.CheckPermission;
import com.runrong.managecenter.business.model.datacollection.EnterpriseFinancialData;
import com.runrong.managecenter.business.service.DataService;
import com.runrong.managecenter.business.service.StatementTemplateService;
import com.runrong.managecenter.common.base.ResultModel;
import com.runrong.managecenter.common.dictionary.Constant;
import com.runrong.managecenter.common.util.AssignListHelper;
import com.runrong.managecenter.config.StatementConfig;

/**
 * 数据控制层
 * @author yanyimin
 *
 */
@Controller
@RequestMapping("/managecenter")
public class DataController {
	
	@Autowired
	DataService dataService;
	
	@Autowired
	StatementTemplateService statementTemplateService;
	
	/**
	 * 插入资产负债表
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveBalance")
	@ResponseBody
	@CheckPermission
	public ResultModel saveBalanceStatementPOST(HttpServletRequest request){
		
		return dataService.saveBalance(request);
		
	}
	
	
	/**
	 * 插入利润表
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveProfitStatement")
	@ResponseBody
	@CheckPermission
	public ResultModel saveProfitStatementPOST(HttpServletRequest request){
		
		return dataService.saveProfitStatement(request);
	}
	
	/**
	 * 插入资金流量表
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveCashFlowStatement")
	@ResponseBody
	@CheckPermission
	public ResultModel saveCashFlowStatementPOST(HttpServletRequest request){
		
		return dataService.saveCashFlowStatement(request);
				
	}
	
	
	/**
	 * 修改资产负债表
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateBalanceStatement")
	@ResponseBody
	@CheckPermission
	public ResultModel updateBalanceStatementPOST(HttpServletRequest request){
		
		return dataService.updateBalanceStatement(request);
	}
	
	
	/**
	 * 修改资金流量表
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateCashFlowStatement")
	@ResponseBody
	@CheckPermission
	public ResultModel updateCashFlowStatementPOST(HttpServletRequest request){
		
		return dataService.updateCashFlowStatement(request);
	}
	
	/**
	 * 修改利润表
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateProfitStatement")
	@ResponseBody
	@CheckPermission
	public ResultModel updateProfitStatementPOST(HttpServletRequest request){
		
		return dataService.updateProfitStatement(request);
	}
	
	
	
	/**
	 * 删除资产负债表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deleteBalanceStatement",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel deleteBalanceStatementPOST(HttpServletRequest request){
		
		return dataService.deleteBalanceStatement(request);
	}
	
	/**
	 * 删除现金流量表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deleteCashFlowStatement",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel deleteCashFlowStatementPOST(HttpServletRequest request){
		
		return dataService.deleteCashFlowStatement(request);
	}
	
	/**
	 * 删除利润表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deleteProfitStatement",method=RequestMethod.POST)
	@ResponseBody
	@CheckPermission
	public ResultModel deleteProfitStatementPOST(HttpServletRequest request){
		
		return dataService.deleteProfitStatement(request);
	}
	
	
	/**
	 * 通过注册号、表名来查找
	 * @param request
	 * @return
	 */
	@RequestMapping("/findByEnterpriseFinancialData")
	@ResponseBody
	public ModelAndView findByEnterpriseFinancialData(HttpServletRequest request,ModelMap map){
		ResultModel r=dataService.findByEnterpriseFinancialData(request);
		if( r.getCode()==0 ){
		EnterpriseFinancialData efd =(EnterpriseFinancialData) r.getBody();
		map.put("EnterpriseFinancialData", efd);
		}
		return new ModelAndView("/managecenter/findstatement");
	}
	
	/**
	 * 查找表的数据
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/findFinancialStatement")
	@ResponseBody
	public ModelAndView findFinancialStatement(HttpServletRequest request,ModelMap map){
		ResultModel rm=dataService.findFinancialStatement(request);
		if(rm.Fail()){						
			return new ModelAndView("/managecenter/findstatement");
		}
		EnterpriseFinancialData efd=(EnterpriseFinancialData) rm.getBody();
		if(efd==null){
			return new ModelAndView("/managecenter/findstatement");
		}
			
		map.put("EnterpriseFinancialData", efd);
		if(efd.getBalanceStatements()!=null){	
			return (ModelAndView)statementTemplateService.getBalanceStatementTemplateSelected(request, map, "/managecenter/updatebalancestatement", 
					AssignListHelper.assignBalanceStatementList(efd,StatementConfig.balanceStatementList),Constant.BALANCE_STATEMENT).getBody();	 
		}
		if(efd.getCashFlowStatements()!=null){
			return (ModelAndView)statementTemplateService.getCashflowStatementTemplateSelected(request, map, "/managecenter/updatecashflowstatement", 
					AssignListHelper.assignCashflowStatementList(efd,StatementConfig.cashflowStatementList),Constant.CASHFLOW_STATEMENT).getBody();
		}
		if(efd.getProfitStatements()!=null){
			return (ModelAndView)statementTemplateService.getProfitStatementTemplateSelected(request, map, "/managecenter/updateprofitstatement", 
					AssignListHelper.assignProfitStatementList(efd,StatementConfig.profitStatementList),Constant.PROFIT_STATEMENT).getBody();
		}
				
		return new ModelAndView("/managecenter/findstatement");
		
	}
}
