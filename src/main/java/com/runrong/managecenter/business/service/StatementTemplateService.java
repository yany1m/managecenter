package com.runrong.managecenter.business.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.runrong.managecenter.business.cache.SelectdStatementTemplateCache;
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
	
	@Autowired
	SelectdStatementTemplateCache selectdStatementTemplateCache;
	
	/**
	 * 获取模板
	 * @param request
	 * @return
	 */
	public ResultModel getStatementTemplate(HttpServletRequest request){
		String id=request.getParameter("id")==null?"0":request.getParameter("id");
		String type=request.getParameter("type");		
		String name=request.getParameter("name");	
		
		StatementTemplate statementTemplate=new StatementTemplate();
		statementTemplate.setId(Integer.valueOf(id));
		statementTemplate.setType(type);
		statementTemplate.setName(name);
		
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
		
		StatementTemplate statementTemplate=new StatementTemplate();
		statementTemplate.setId(Integer.valueOf(id));
		statementTemplate.setTemplate(template);
		statementTemplate.setName(name);
		statementTemplate.setEditor((int)request.getSession().getAttribute("admin_id"));
		
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
		
		StatementTemplate statementTemplate=new StatementTemplate();
		statementTemplate.setAdminId(adminId);
		statementTemplate.setTemplate(template);
		statementTemplate.setType(type);
		statementTemplate.setName(name);
		statementTemplate.setEditor((int)request.getSession().getAttribute("admin_id"));
		
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
	public ResultModel getBalanceStatementTemplateSelected(HttpServletRequest request,ModelMap map,String url,List statementlist,String type){
		EnterpriseFinancialData efd=(EnterpriseFinancialData) map.get("EnterpriseFinancialData");
		Integer id=0;
		if(efd==null){
			String adminId=(int)request.getSession().getAttribute("admin_id")+type;
			if(selectdStatementTemplateCache.get(adminId)!=null){
				id=selectdStatementTemplateCache.get(adminId);
			}
		}else{
			try{
				id=efd.getBalanceStatements().get(0).getTemplateId();
			}catch(NullPointerException e){
				id=0;
			}
		}
		
		StatementTemplate st=new StatementTemplate();
		st.setType(type);
		List list=(List) statementTemplateDao.getStatementTemplate(st);
		
		map.put("id", id);
		map.put("type", type);
		map.put("statementTemplate", list);
		
		for(Object o:list){
			Map maps=(Map) o;	
			if((int)maps.get("id")==id){
				
				map.put("head", ( (Map) JSON.parseObject((String) maps.get("template")).get("head")).get("names"));			
				statementlist=(List<Map>) ((Map) JSON.parseObject((String) maps.get("template")).get("body")).get("rows");											
				if(efd!=null){
					map.put("balancestatementList",AssignListHelper.assignCashflowStatementList(efd,statementlist));
				}else{
					map.put("balancestatementList", statementlist);			
				}
				return ResultModel.successModel(new ModelAndView(url));
			}
		}
				
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
	public ResultModel getCashflowStatementTemplateSelected(HttpServletRequest request,ModelMap map,String url,List statementlist,String type){
		EnterpriseFinancialData efd=(EnterpriseFinancialData) map.get("EnterpriseFinancialData");
		Integer id=0;
		if(efd==null){
			String adminId=(int)request.getSession().getAttribute("admin_id")+type;
			if(selectdStatementTemplateCache.get(adminId)!=null){
				id=selectdStatementTemplateCache.get(adminId);
			}
		}else{
			try{
				id=efd.getCashFlowStatements().get(0).getTemplateId();
			}catch(NullPointerException e){
				id=0;
			}
		}
		StatementTemplate st=new StatementTemplate();
		st.setType(type);
		List list=(List) statementTemplateDao.getStatementTemplate(st);
		
		map.put("id", id);
		map.put("type", type);
		map.put("statementTemplate", list);
		
		for(Object o:list){
			Map maps=(Map) o;	
			if((int)maps.get("id")==id){
				
				map.put("head", ( (Map) JSON.parseObject((String) maps.get("template")).get("head")).get("names"));				
				statementlist=(List<Map>) ((Map) JSON.parseObject((String) maps.get("template")).get("body")).get("rows");
				if(efd!=null){
					map.put("cashflowStatementList",AssignListHelper.assignCashflowStatementList(efd,statementlist));
				}else{
					map.put("cashflowStatementList", statementlist);			
				}
				return ResultModel.successModel(new ModelAndView(url));
			}
		}

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
	public ResultModel getProfitStatementTemplateSelected(HttpServletRequest request,ModelMap map,String url,List statementlist,String type){
		EnterpriseFinancialData efd=(EnterpriseFinancialData) map.get("EnterpriseFinancialData");
		Integer id=0;
		if(efd==null){	
			String adminId=(int)request.getSession().getAttribute("admin_id")+type;
			if(selectdStatementTemplateCache.get(adminId)!=null){
				id=selectdStatementTemplateCache.get(adminId);
			}
		}else{
			try{
				id=efd.getProfitStatements().get(0).getTemplateId();
			}catch(NullPointerException e){
				id=0;
			}
		}
		
		StatementTemplate st=new StatementTemplate();
		st.setType(type);
		List list=(List) statementTemplateDao.getStatementTemplate(st);
		
		map.put("id", id);
		map.put("type", type);
		map.put("statementTemplate", list);
		
		for(Object o:list){
			Map maps=(Map) o;	
			if((int)maps.get("id")==id){
				
				map.put("head", ( (Map) JSON.parseObject((String) maps.get("template")).get("head")).get("names"));				
				statementlist=(List<Map>) ((Map) JSON.parseObject((String) maps.get("template")).get("body")).get("rows");
				if(efd!=null){
					map.put("profitStatementList",AssignListHelper.assignProfitStatementList(efd,statementlist));
				}else{
					map.put("profitStatementList", statementlist);			
				}
				return ResultModel.successModel(new ModelAndView(url));
			}
		}

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
		String adminId=(int)request.getSession().getAttribute("admin_id")+type;
		//先找到此模板
		StatementTemplate statementTemplate=new StatementTemplate();
		statementTemplate.setId(Integer.valueOf(id));
		statementTemplate.setType(type);
		
		List list=statementTemplateDao.getStatementTemplate(statementTemplate);
		
		//将被选中的模板放入缓存中
		selectdStatementTemplateCache.put(adminId, (Integer)((Map) list.get(0)).get("id"));;
		return ResultModel.successModel();
	}
	
}
