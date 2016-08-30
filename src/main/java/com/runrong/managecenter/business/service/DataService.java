package com.runrong.managecenter.business.service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runrong.managecenter.business.dao.DataDao;
import com.runrong.managecenter.business.model.datacollection.BalanceStatement;
import com.runrong.managecenter.business.model.datacollection.CashFlowStatement;
import com.runrong.managecenter.business.model.datacollection.EnterpriseFinancialData;
import com.runrong.managecenter.business.model.datacollection.ProfitStatement;
import com.runrong.managecenter.common.base.ResultModel;
import com.runrong.managecenter.common.dictionary.BalanceConstant;
import com.runrong.managecenter.common.dictionary.CashFlowConstant;
import com.runrong.managecenter.common.dictionary.ProfitConstant;
import com.runrong.managecenter.common.util.FormatDateUtil;

@Service
public class DataService {

	@Autowired
	DataDao dataDao;
	
	/**
	 * 插入资产负债表
	 * @param request
	 * @return
	 */
	public ResultModel saveBalance(HttpServletRequest request){
		
		String enterpriseRegistrationNumber=request.getParameter("enterpriseRegistrationNumber");
		if(enterpriseRegistrationNumber==null || enterpriseRegistrationNumber.equals("")){
			return ResultModel.failModel("注册号为空");
		}
		String year=request.getParameter("year");
		if(year==null || year.equals("")){
			return ResultModel.failModel("年份为空");
		}
		//获得content
		Map map=BalanceConstant.createMap(request);
		//生成资产负债表
		BalanceStatement bs=new BalanceStatement();	
		bs.setDate(FormatDateUtil.formatToMongoDate(year));
		bs.setContent(map);
		//加入list
		List<BalanceStatement> list=new ArrayList<BalanceStatement>();		
		list.add(bs);
		//完成企业财务数据录入
		EnterpriseFinancialData efd=new EnterpriseFinancialData();
		efd.setEnterpriseRegistrationNumber(enterpriseRegistrationNumber);
		efd.setBalanceStatements(list);	
		
		return dataDao.saveBalanceStatement(efd);
	}
	
	/**
	 * 插入现金流量表
	 * @param request
	 * @return
	 */
	public ResultModel saveCashFlowStatement(HttpServletRequest request){
		
		String enterpriseRegistrationNumber=request.getParameter("enterpriseRegistrationNumber");
		if(enterpriseRegistrationNumber==null || enterpriseRegistrationNumber.equals("")){
			return ResultModel.failModel("注册号为空");
		}
		String year=request.getParameter("year");
		//获得content
		Map map=CashFlowConstant.createMap(request);
		//生成资产负债表
		CashFlowStatement cs=new CashFlowStatement();	
		cs.setDate(FormatDateUtil.formatToMongoDate(year));
		cs.setContent(map);
		//加入list
		List<CashFlowStatement> list=new ArrayList<CashFlowStatement>();		
		list.add(cs);
		//完成企业财务数据录入
		EnterpriseFinancialData efd=new EnterpriseFinancialData();
		efd.setEnterpriseRegistrationNumber(enterpriseRegistrationNumber);
		efd.setCashFlowStatements(list);
				
		return dataDao.saveCashFlowStatement(efd);
		
	}
	
	/**
	 * 插入利润表
	 * @param request
	 * @return
	 */
	public ResultModel saveProfitStatement(HttpServletRequest request){
		
		String enterpriseRegistrationNumber=request.getParameter("enterpriseRegistrationNumber");
		if(enterpriseRegistrationNumber==null || enterpriseRegistrationNumber.equals("")){
			return ResultModel.failModel("注册号为空");
		}
		String year=request.getParameter("year");
		//获得content
		Map map=ProfitConstant.createMap(request);
		//生成资产负债表
		ProfitStatement ps=new ProfitStatement();	
		ps.setDate(FormatDateUtil.formatToMongoDate(year));
		ps.setContent(map);
		//加入list
		List<ProfitStatement> list=new ArrayList<ProfitStatement>();		
		list.add(ps);
		//完成企业财务数据录入
		EnterpriseFinancialData efd=new EnterpriseFinancialData();
		efd.setEnterpriseRegistrationNumber(enterpriseRegistrationNumber);
		efd.setProfitStatements(list);
			
		return dataDao.saveProfitStatement(efd);
	}

	/**
	 * 更新资产负债表
	 * @param request
	 * @return
	 */
	public ResultModel updateBalanceStatement(HttpServletRequest request){
		
		String enterpriseRegistrationNumber=request.getParameter("enterpriseRegistrationNumber");
		if(enterpriseRegistrationNumber==null || enterpriseRegistrationNumber.equals("")){
			return ResultModel.failModel("注册号为空");
		}
		String year=request.getParameter("year");
		
		//获得content
		Map map=BalanceConstant.createMap(request);
		//生成资产负债表
		BalanceStatement bs=new BalanceStatement();	
		bs.setDate(FormatDateUtil.formatToMongoDate(year));
		bs.setContent(map);
		//加入list
		List<BalanceStatement> list=new ArrayList<BalanceStatement>();		
		list.add(bs);
		//完成企业财务数据录入
		EnterpriseFinancialData efd=new EnterpriseFinancialData();
		efd.setEnterpriseRegistrationNumber(enterpriseRegistrationNumber);
		efd.setBalanceStatements(list);
		
		dataDao.updateBalanceStatement(efd);
		
		return ResultModel.successModel("修改成功");
	}
	
	
	/**
	 * 更新现金流量表
	 * @param request
	 * @return
	 */
	public ResultModel updateCashFlowStatement(HttpServletRequest request){
		
		String enterpriseRegistrationNumber=request.getParameter("enterpriseRegistrationNumber");
		if(enterpriseRegistrationNumber==null || enterpriseRegistrationNumber.equals("")){
			return ResultModel.failModel("注册号为空");
		}
		String year=request.getParameter("year");
		
		//获得content
		Map map=CashFlowConstant.createMap(request);
		//生成资产负债表
		CashFlowStatement cs=new CashFlowStatement();	
		cs.setDate(FormatDateUtil.formatToMongoDate(year));
		cs.setContent(map);
		//加入list
		List<CashFlowStatement> list=new ArrayList<CashFlowStatement>();		
		list.add(cs);
		//完成企业财务数据录入
		EnterpriseFinancialData efd=new EnterpriseFinancialData();
		efd.setEnterpriseRegistrationNumber(enterpriseRegistrationNumber);
		efd.setCashFlowStatements(list);
		
		dataDao.updateCashFlowStatement(efd);
		
		return ResultModel.successModel("修改成功");
	}
	
	/**
	 * 更新利润表
	 * @param request
	 * @return
	 */
	public ResultModel updateProfitStatement(HttpServletRequest request){
		
		String enterpriseRegistrationNumber=request.getParameter("enterpriseRegistrationNumber");
		if(enterpriseRegistrationNumber==null || enterpriseRegistrationNumber.equals("")){
			return ResultModel.failModel("注册号为空");
		}
		String year=request.getParameter("year");
		
		//获得content
		Map map=ProfitConstant.createMap(request);
		//生成资产负债表
		ProfitStatement ps=new ProfitStatement();	
		ps.setDate(FormatDateUtil.formatToMongoDate(year));
		ps.setContent(map);
		//加入list
		List<ProfitStatement> list=new ArrayList<ProfitStatement>();		
		list.add(ps);
		//完成企业财务数据录入
		EnterpriseFinancialData efd=new EnterpriseFinancialData();
		efd.setEnterpriseRegistrationNumber(enterpriseRegistrationNumber);
		efd.setProfitStatements(list);
		
		dataDao.updateProfitStatement(efd);
		
		return ResultModel.successModel("修改成功");
	}
	
	/**
	 * 删除资产负债表
	 * @param request
	 * @return
	 */
	public ResultModel deleteBalanceStatement(HttpServletRequest request){
		
		String enterpriseRegistrationNumber=request.getParameter("enterpriseRegistrationNumber");
		if(enterpriseRegistrationNumber==null || enterpriseRegistrationNumber.equals("")){
			return ResultModel.failModel("注册号为空");
		}
		String year=request.getParameter("year");
		
		//获得content
		//生成资产负债表
		BalanceStatement bs=new BalanceStatement();	
		bs.setDate(FormatDateUtil.formatToMongoDate(year));
		//加入list
		List<BalanceStatement> list=new ArrayList<BalanceStatement>();		
		list.add(bs);
		//完成企业财务数据录入
		EnterpriseFinancialData efd=new EnterpriseFinancialData();
		efd.setEnterpriseRegistrationNumber(enterpriseRegistrationNumber);
		efd.setBalanceStatements(list);
		
		dataDao.deleteBalanceStatement(efd);
		
		return ResultModel.successModel("删除成功");
	}
	
	
	/**
	 * 删除现金流量表
	 * @param request
	 * @return
	 */
	public ResultModel deleteCashFlowStatement(HttpServletRequest request){
		
		String enterpriseRegistrationNumber=request.getParameter("enterpriseRegistrationNumber");
		if(enterpriseRegistrationNumber==null || enterpriseRegistrationNumber.equals("")){
			return ResultModel.failModel("注册号为空");
		}
		String year=request.getParameter("year");
		
		//获得content
		//生成资产负债表
		CashFlowStatement cs=new CashFlowStatement();		
		cs.setDate(FormatDateUtil.formatToMongoDate(year));
		//加入list
		List<CashFlowStatement> list=new ArrayList<CashFlowStatement>();		
		list.add(cs);
		//完成企业财务数据录入
		EnterpriseFinancialData efd=new EnterpriseFinancialData();
		efd.setEnterpriseRegistrationNumber(enterpriseRegistrationNumber);
		efd.setCashFlowStatements(list);
		
		dataDao.deleteCashFlowStatement(efd);
		
		return ResultModel.successModel("删除成功");
	}
	
	
	/**
	 * 删除利润表
	 * @param request
	 * @return
	 */
	public ResultModel deleteProfitStatement(HttpServletRequest request){
		
		String enterpriseRegistrationNumber=request.getParameter("enterpriseRegistrationNumber");
		if(enterpriseRegistrationNumber==null || enterpriseRegistrationNumber.equals("")){
			return ResultModel.failModel("注册号为空");
		}
		String year=request.getParameter("year");
		
		//获得content
		//生成资产负债表
		ProfitStatement ps=new ProfitStatement();		
		ps.setDate(FormatDateUtil.formatToMongoDate(year));
		//加入list
		List<ProfitStatement> list=new ArrayList<ProfitStatement>();		
		list.add(ps);
		//完成企业财务数据录入
		EnterpriseFinancialData efd=new EnterpriseFinancialData();
		efd.setEnterpriseRegistrationNumber(enterpriseRegistrationNumber);
		efd.setProfitStatements(list);
		
		dataDao.deleteProfitStatement(efd);
		
		return ResultModel.successModel("删除成功");
	}
	
	/**
	 * 查找
	 * @param request
	 * @return
	 */
	public ResultModel findByEnterpriseFinancialData(HttpServletRequest request){
		String enterpriseRegistrationNumber=request.getParameter("enterpriseRegistrationNumber");
		if(enterpriseRegistrationNumber==null || enterpriseRegistrationNumber.equals("")){
			return ResultModel.failModel("注册号为空");
		}
		String statement=request.getParameter("statement");
		
		EnterpriseFinancialData efd=new EnterpriseFinancialData();
		efd.setEnterpriseRegistrationNumber(enterpriseRegistrationNumber);
		//如果没有选择表的类型，则根据注册号进行查找
		if(statement==null || statement.equals("") || statement.equals("全部")){
			efd=dataDao.find(efd);		
			return ResultModel.successModel(efd);
		}	
		efd=dataDao.findByStatementAndNum(efd, statement);
		return ResultModel.successModel(efd);
	}
	
	
	
	/**
	 * 查找财务数据
	 * @param request
	 * @return
	 */
	public ResultModel findFinancialStatement(HttpServletRequest request){
		String enterpriseRegistrationNumber=request.getParameter("enterpriseRegistrationNumber");
		if(enterpriseRegistrationNumber==null || enterpriseRegistrationNumber.equals("")){
			return ResultModel.failModel("注册号为空");
		}
		if(request.getParameter("year")==null || request.getParameter("year").equals("")){
			return ResultModel.failModel("年份为空");
		}
		String year=request.getParameter("year");
		
		String statement=request.getParameter("statement");
		if(statement==null || statement.equals("")){
			return ResultModel.failModel("请选择需要查询的表");
		}
		
		EnterpriseFinancialData efd=new EnterpriseFinancialData();
		efd.setEnterpriseRegistrationNumber(enterpriseRegistrationNumber);
		if(statement.equals("资产负债表")){
			BalanceStatement bs=new BalanceStatement();	
			bs.setDate(FormatDateUtil.formatToMongoDate(year));			
			//加入list
			List<BalanceStatement> list=new ArrayList<BalanceStatement>();		
			list.add(bs);
			efd.setBalanceStatements(list);
			efd=dataDao.findByYearAndNum(efd,"资产负债表");
			return ResultModel.successModel(efd);
		} 
		if(statement.equals("现金流量表")){
			CashFlowStatement cs=new CashFlowStatement();	
			cs.setDate(FormatDateUtil.formatToMongoDate(year));
			//加入list
			List<CashFlowStatement> list=new ArrayList<CashFlowStatement>();		
			list.add(cs);
			efd.setCashFlowStatements(list);
			efd=dataDao.findByYearAndNum(efd,"现金流量表");
			return ResultModel.successModel(efd);
		}
		if(statement.equals("利润表")){
			ProfitStatement ps=new ProfitStatement();	
			ps.setDate(FormatDateUtil.formatToMongoDate(year));
			//加入list
			List<ProfitStatement> list=new ArrayList<ProfitStatement>();		
			list.add(ps);
			efd.setProfitStatements(list);
			efd=dataDao.findByYearAndNum(efd,"利润表");
			return ResultModel.successModel(efd);
		}
			
		return ResultModel.failModel("数据为空，查找失败");
	}
	
	
	/**
	 * 处理参数
	 * @param request
	 * @return
	 */
	public EnterpriseFinancialData resloveParamerter(HttpServletRequest request){
		EnterpriseFinancialData efd=new EnterpriseFinancialData();
		
		Enumeration<String> parameter =request.getParameterNames();
				
		while(parameter.hasMoreElements()){
			String p=parameter.nextElement();
		
			
//			//三级  自定义标识_父级_名字
//			String[] part=p.split("_");
//			if(part[0].equals(DefineType.BASIC)){
//				
//			}else if(part[0].equals(DefineType.NEW_ADD)){
//				
//			}
		}
		
	
		
		return efd;
	}
	
}
