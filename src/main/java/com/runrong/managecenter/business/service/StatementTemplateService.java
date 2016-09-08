package com.runrong.managecenter.business.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.runrong.managecenter.business.dao.StatementTemplateDao;
import com.runrong.managecenter.business.model.StatementTemplate;
import com.runrong.managecenter.business.model.datacollection.EnterpriseFinancialData;
import com.runrong.managecenter.common.base.ResultModel;
import com.runrong.managecenter.common.util.AssignListHelper;
import com.runrong.managecenter.config.StatementConfig;

/**
 * 报表模板处理层
 * @author yanyimin
 *
 */
@Service
public class StatementTemplateService {
	@Autowired
	StatementTemplateDao statementTemplateDao;
	
	/**
	 * 获取模板
	 * @param request
	 * @return
	 */
	public ResultModel getStatementTemplate(HttpServletRequest request){
		String id=request.getParameter("id")==null?"0":request.getParameter("id");
		String type=request.getParameter("type");		
		int adminId=(int) request.getSession().getAttribute("admin_id");
		String name=request.getParameter("name");
		String selected=request.getParameter("selected")==null?"0":request.getParameter("selected");
		
		StatementTemplate statementTemplate=new StatementTemplate();
		statementTemplate.setId(Integer.valueOf(id));
		statementTemplate.setAdminId(adminId);
		statementTemplate.setType(type);
		statementTemplate.setName(name);
		statementTemplate.setSelected(Integer.valueOf(selected));
		
		List list=statementTemplateDao.getStatementTemplate(statementTemplate);
		return ResultModel.successModel(list);
	}
	
	/**
	 * 更新模板
	 * @param request
	 * @return
	 */
	public ResultModel updateStatementTemplate(HttpServletRequest request){
		String id="";
		if(request.getParameter("id")==null || request.getParameter("id").equals("") ){
			return ResultModel.failModel("参数错误");
		}
		id=request.getParameter("id");
		
		String template=request.getParameter("template");
		String name=request.getParameter("name");
		String selected=request.getParameter("selected")==null?"0":request.getParameter("selected");
		
		StatementTemplate statementTemplate=new StatementTemplate();
		statementTemplate.setId(Integer.valueOf(id));
		statementTemplate.setTemplate(template);
		statementTemplate.setName(name);
		statementTemplate.setSelected(Integer.valueOf(selected));
		
		statementTemplateDao.updateStatementTemplate(statementTemplate);
		return ResultModel.successModel("修改成功");
	}
	
	/**
	 * 添加模板
	 * @param request
	 * @return
	 */
	public ResultModel addStatementTemplate(HttpServletRequest request){
		
		if(request.getParameter("type")==null || request.getParameter("type").equals("") || request.getParameter("template")==null || 
				request.getParameter("template").equals("") || request.getParameter("name")==null || request.getParameter("name").equals("")){
			return ResultModel.failModel("参数错误");
		}

		int adminId= (int) request.getSession().getAttribute("admin_id");		
		String template=request.getParameter("template");
		String type=request.getParameter("type");
		String name=request.getParameter("name");
		String selected=request.getParameter("selected")==null?"0":request.getParameter("selected"); 
		
		StatementTemplate statementTemplate=new StatementTemplate();
		statementTemplate.setAdminId(adminId);
		statementTemplate.setTemplate(template);
		statementTemplate.setType(type);
		statementTemplate.setName(name);
		statementTemplate.setSelected(Integer.valueOf(selected));
		
		statementTemplateDao.addStatementTemplate(statementTemplate);
		return ResultModel.successModel("添加成功");
	}
	
	/**
	 * 删除模板
	 * @param request
	 * @return
	 */
	public ResultModel deleteStatementTemplate(HttpServletRequest request){
		String id="";
		if(request.getParameter("id")==null || request.getParameter("id").equals("")){
			return ResultModel.failModel("参数错误");
		}
		id=request.getParameter("id");

	
		StatementTemplate statementTemplate=new StatementTemplate();
		statementTemplate.setId(Integer.valueOf(id));
	
		statementTemplateDao.deleteStatementTemplate(statementTemplate);
		return ResultModel.successModel("删除成功");
	}
	
	/**
	 * 获得资产负债表被选中的模板
	 * @param request
	 * @param map
	 * @return
	 */
	public ResultModel getBalanceStatementTemplateSelected(HttpServletRequest request,ModelMap map,String url,List statementlist){
		StatementTemplate st=new StatementTemplate();
		st.setType("资产负债表");
		st.setAdminId((int) request.getSession().getAttribute("admin_id"));
		List list=(List) statementTemplateDao.getStatementTemplate(st);
		
		for(Object o:list){
			Map maps=(Map) o;	
			if((int)maps.get("selected")==1){
				map.put("type", "资产负债表");
				map.put("statementTemplate", list);
				map.put("head", ( (Map) JSON.parseObject((String) maps.get("template")).get("head")).get("names"));

				EnterpriseFinancialData efd=(EnterpriseFinancialData) map.get("EnterpriseFinancialData");
				statementlist=(List<Map>) ((Map) JSON.parseObject((String) maps.get("template")).get("body")).get("rows");
				if(efd!=null){
					map.put("balancestatementList",AssignListHelper.assignBalanceStatementList(efd,statementlist));
				}else{
					map.put("balancestatementList", statementlist);			
				}			
				return ResultModel.successModel(new ModelAndView(url));
			}
		}
		map.put("type", "资产负债表");
		map.put("statementTemplate", list);
		map.put("head", (List<String>)( (Map) StatementConfig.balanceStatementMap.get("head")).get("names"));
		map.put("balancestatementList", statementlist);			
		return ResultModel.successModel(new ModelAndView(url));
	}
	
	/**
	 * 获得现金流量表被选中的模板
	 * @param request
	 * @param map
	 * @return
	 */
	public ResultModel getCashflowStatementTemplateSelected(HttpServletRequest request,ModelMap map,String url,List statementlist){
		StatementTemplate st=new StatementTemplate();
		st.setType("现金流量表");
		st.setAdminId((int) request.getSession().getAttribute("admin_id"));
		List list=(List) statementTemplateDao.getStatementTemplate(st);
		
		for(Object o:list){
			Map maps=(Map) o;	
			if((int)maps.get("selected")==1){
				map.put("type", "现金流量表");
				map.put("statementTemplate", list);
				map.put("head", ( (Map) JSON.parseObject((String) maps.get("template")).get("head")).get("names"));

				EnterpriseFinancialData efd=(EnterpriseFinancialData) map.get("EnterpriseFinancialData");
				statementlist=(List<Map>) ((Map) JSON.parseObject((String) maps.get("template")).get("body")).get("rows");
				if(efd!=null){
					map.put("cashflowStatementList",AssignListHelper.assignCashflowStatementList(efd,statementlist));
				}else{
					map.put("cashflowStatementList", statementlist);			
				}
				return ResultModel.successModel(new ModelAndView(url));
			}
		}
		map.put("type", "现金流量表");
		map.put("statementTemplate", list);
		map.put("head", (List<String>)( (Map) StatementConfig.cashflowStatementMap.get("head")).get("names"));
		map.put("cashflowStatementList", statementlist);				
		return ResultModel.successModel(new ModelAndView(url));
	}
	
	/**
	 * 获得利润表被选中的模板
	 * @param request
	 * @param map
	 * @return
	 */
	public ResultModel getProfitStatementTemplateSelected(HttpServletRequest request,ModelMap map,String url,List statementlist){
		StatementTemplate st=new StatementTemplate();
		st.setType("利润表");
		st.setAdminId((int) request.getSession().getAttribute("admin_id"));
		List list=(List) statementTemplateDao.getStatementTemplate(st);
		
		for(Object o:list){
			Map maps=(Map) o;	
			if((int)maps.get("selected")==1){
				map.put("type", "利润表");
				map.put("statementTemplate", list);
				map.put("head", ( (Map) JSON.parseObject((String) maps.get("template")).get("head")).get("names"));
				
				EnterpriseFinancialData efd=(EnterpriseFinancialData) map.get("EnterpriseFinancialData");
				statementlist=(List<Map>) ((Map) JSON.parseObject((String) maps.get("template")).get("body")).get("rows");
				if(efd!=null){
					map.put("profitStatementList",AssignListHelper.assignProfitStatementList(efd,statementlist));
				}else{
					map.put("profitStatementList", statementlist);			
				}
				return ResultModel.successModel(new ModelAndView(url));
			}
		}
		map.put("type", "利润表");
		map.put("statementTemplate", list);
		map.put("head", (List<String>)( (Map) StatementConfig.profitStatementMap.get("head")).get("names"));
		map.put("profitStatementList", statementlist);			
		return ResultModel.successModel(new ModelAndView(url));
	}
	
	/**
	 * 更新被选中的报表模板
	 * @param request
	 * @return
	 */
	public ResultModel updateStatementTemplateSelected(HttpServletRequest request){
		String id=request.getParameter("id");
		String type=request.getParameter("type");
		
		//先将该type中被选中的模板selected更新为0
		StatementTemplate statementTemplate=new StatementTemplate();
		statementTemplate.setAdminId((int)request.getSession().getAttribute("admin_id"));
		statementTemplate.setType(type);
		
		statementTemplateDao.updateStatementTemplateSelected(statementTemplate);
		
		//更新被选中的模板
		statementTemplate=new StatementTemplate();
		statementTemplate.setSelected(1);
		statementTemplate.setId(Integer.valueOf(id));
		statementTemplateDao.updateStatementTemplate(statementTemplate);
		return ResultModel.successModel();
	}
	
}
