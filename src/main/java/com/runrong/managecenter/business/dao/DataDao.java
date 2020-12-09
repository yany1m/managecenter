package com.runrong.managecenter.business.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.QueryBuilder;
import com.runrong.managecenter.business.model.datacollection.BalanceStatement;
import com.runrong.managecenter.business.model.datacollection.CashFlowStatement;
import com.runrong.managecenter.business.model.datacollection.EnterpriseFinancialData;
import com.runrong.managecenter.business.model.datacollection.ProfitStatement;
import com.runrong.managecenter.common.base.ResultModel;
import com.runrong.managecenter.common.dictionary.Constant;
import com.runrong.managecenter.common.util.JsonUtil;

/**
 * 数据持久层
 * @author yanyimin
 *
 */
@Repository
public class DataDao {

	@Autowired
	MongoTemplate mongoTemplate;
	
	/**
	 * 插入资产负债表
	 * @param efd
	 */
	public ResultModel saveBalanceStatement(EnterpriseFinancialData efd){  
		if(find(efd)!=null ){
			if(findByYearAndNum(efd,Constant.BALANCE_STATEMENT).getBalanceStatements()==null){
				Query query = Query.query(Criteria.where("enterpriseRegistrationNumber").is(efd.getEnterpriseRegistrationNumber()));	
				Update update = new Update();						
				update.pushAll("balanceStatements", efd.getBalanceStatements().toArray());
				mongoTemplate.upsert(query, update, EnterpriseFinancialData.class); 
				return ResultModel.successModel("添加成功");
			}
			return ResultModel.failModel("时间重复");
		}
		mongoTemplate.save(efd);  
		return ResultModel.successModel("新企业添加成功");      
	}  
	
	/**
	 * 插入现金流量表
	 * @param efd
	 */
	public ResultModel saveCashFlowStatement(EnterpriseFinancialData efd){  
		if(find(efd)!=null ){
			if(findByYearAndNum(efd,Constant.CASHFLOW_STATEMENT).getCashFlowStatements()==null){
				Query query = Query.query(Criteria.where("enterpriseRegistrationNumber").is(efd.getEnterpriseRegistrationNumber()));	
				Update update = new Update();						
				update.pushAll("cashFlowStatements", efd.getCashFlowStatements().toArray());
				mongoTemplate.upsert(query, update, EnterpriseFinancialData.class); 
				return ResultModel.successModel("添加成功");
			}
			return ResultModel.failModel("时间重复");
		}
		mongoTemplate.save(efd);  
		return ResultModel.successModel("新企业添加成功");      
	}  
	
	/**
	 * 插入利润表
	 * @param efd
	 */
	public ResultModel saveProfitStatement(EnterpriseFinancialData efd){  
		if(find(efd)!=null ){
			if(findByYearAndNum(efd,Constant.PROFIT_STATEMENT).getProfitStatements()==null){				
				Query query = Query.query(Criteria.where("enterpriseRegistrationNumber").is(efd.getEnterpriseRegistrationNumber()));	
				Update update = new Update();						
				update.pushAll("profitStatements", efd.getProfitStatements().toArray());
				mongoTemplate.upsert(query, update, EnterpriseFinancialData.class); 
				return ResultModel.successModel("添加成功");
			}
			return ResultModel.failModel("时间重复");
		}
		mongoTemplate.save(efd);  
		return ResultModel.successModel("新企业添加成功");         
	}  
	
	/**
	 * 更新资产负债表
	 * @param efd
	 */
	public void updateBalanceStatement(EnterpriseFinancialData efd){	
		deleteBalanceStatement(efd);
		saveBalanceStatement(efd);
	}
	
	
	/**
	 * 更新现金流量表
	 * @param efd
	 */
	public void updateCashFlowStatement(EnterpriseFinancialData efd){	
		deleteCashFlowStatement(efd);
		saveCashFlowStatement(efd);
	}
	
	
	/**
	 * 更新利润表
	 * @param efd
	 */
	public void updateProfitStatement(EnterpriseFinancialData efd){	
//		ProfitStatement ps=(ProfitStatement) efd.getProfitStatements().get(0);
//		Query query = Query.query(Criteria.where("enterpriseRegistrationNumber").is(efd.getEnterpriseRegistrationNumber())
//                .and("profitStatements.date").is(ps.getDate()));
//        Update update = new Update();
//        update.set("profitStatements", efd.getProfitStatements());
//        mongoTemplate.updateFirst(query, update, EnterpriseFinancialData.class);
		
		//spring的mongodbTemplate真是不好用
		//update.setOnInsert("profitStatements", efd.getProfitStatements());这样在更新的时候会把其它的覆盖掉
		//插入数组的元素efd.getProfitStatements()。get(0)时一直报java.lang.IllegalArgumentException的错误
		//运用(profitStatements.$)也没有反应
		//只能用先删除，再插入的方法暂时代替实现更新-_-///
				
		deleteProfitStatement(efd);
		saveProfitStatement(efd);
	}
	
	/**
	 * 删除资产负债表
	 * @param efd
	 */
	public void deleteBalanceStatement(EnterpriseFinancialData efd){
		BasicDBObject fieldsObject=new BasicDBObject();
		BalanceStatement bs=(BalanceStatement) efd.getBalanceStatements().get(0);
		Query query = Query.query(Criteria.where("enterpriseRegistrationNumber").is(efd.getEnterpriseRegistrationNumber()));
		Update update = new Update();	
		fieldsObject.put("date", bs.getDate());
		update.pull("balanceStatements", fieldsObject);	
		mongoTemplate.upsert(query, update, EnterpriseFinancialData.class);
	}
	
	
	/**
	 * 删除现金流量表
	 * @param efd
	 */
	public void deleteCashFlowStatement(EnterpriseFinancialData efd){
		BasicDBObject fieldsObject=new BasicDBObject();
		CashFlowStatement cs=(CashFlowStatement) efd.getCashFlowStatements().get(0);
		Query query = Query.query(Criteria.where("enterpriseRegistrationNumber").is(efd.getEnterpriseRegistrationNumber()));
		Update update = new Update();	
		fieldsObject.put("date", cs.getDate());
		update.pull("cashFlowStatements", fieldsObject);	
		mongoTemplate.upsert(query, update, EnterpriseFinancialData.class);
	}
	
	
	/**
	 * 删除现金流量表
	 * @param efd
	 */
	public void deleteProfitStatement(EnterpriseFinancialData efd){
		BasicDBObject fieldsObject=new BasicDBObject();
		ProfitStatement ps=(ProfitStatement) efd.getProfitStatements().get(0);
		Query query = Query.query(Criteria.where("enterpriseRegistrationNumber").is(efd.getEnterpriseRegistrationNumber()));
		Update update = new Update();	
		fieldsObject.put("date", ps.getDate());
		update.pull("profitStatements", fieldsObject);	
		mongoTemplate.upsert(query, update, EnterpriseFinancialData.class);
	}
	
	
	/**
	 * 根据注册号查找
	 * @param efd
	 */
	public EnterpriseFinancialData find(EnterpriseFinancialData efd){   	
		efd=mongoTemplate.findOne(new Query(Criteria.where("enterpriseRegistrationNumber").is(efd.getEnterpriseRegistrationNumber())), EnterpriseFinancialData.class);  	
		return efd;
	}  
	
	/**
	 * 根据注册号和表名来查找
	 * @param efd
	 */
	public EnterpriseFinancialData findByStatementAndNum(EnterpriseFinancialData efd,String type){   	
		BasicDBObject fieldsObject=new BasicDBObject(); 
		BalanceStatement bs=null;
		CashFlowStatement cs=null;
		ProfitStatement ps=null;
		if(efd.getBalanceStatements()!=null && efd.getBalanceStatements().size()!=0){
			bs=(BalanceStatement) efd.getBalanceStatements().get(0);
		}else if(efd.getCashFlowStatements()!=null && efd.getCashFlowStatements().size()!=0){
			cs=(CashFlowStatement)efd.getCashFlowStatements().get(0);
		}else if(efd.getProfitStatements()!=null && efd.getProfitStatements().size()!=0){
			ps=(ProfitStatement)efd.getProfitStatements().get(0);
		}		
		
		if(type.equals(Constant.BALANCE_STATEMENT)){			
			fieldsObject.put("balanceStatements",1); 
		}
		if(type.equals(Constant.CASHFLOW_STATEMENT)){
			fieldsObject.put("cashFlowStatements",1); 
		}
		if(type.equals(Constant.PROFIT_STATEMENT)){
			fieldsObject.put("profitStatements",1); 
		}
		
		QueryBuilder queryBuilder = new QueryBuilder();   
		queryBuilder.and(new BasicDBObject("enterpriseRegistrationNumber", efd.getEnterpriseRegistrationNumber()));   
				
		fieldsObject.put("enterpriseRegistrationNumber", 1);  	
		
		Query query=new BasicQuery(queryBuilder.get(),fieldsObject);  
		efd=(EnterpriseFinancialData) mongoTemplate.findOne(query, EnterpriseFinancialData.class);  	
		
		return efd;
	}  
	
	/**
	 * 根据时间查找
	 * @param efd
	 */
	public EnterpriseFinancialData findByYear(EnterpriseFinancialData efd,String type){   	
		BalanceStatement bs=null;
		CashFlowStatement cs=null;
		ProfitStatement ps=null;
		if(efd.getBalanceStatements()!=null && efd.getBalanceStatements().size()!=0){
			bs=(BalanceStatement) efd.getBalanceStatements().get(0);
		}
		if(efd.getCashFlowStatements()!=null && efd.getCashFlowStatements().size()!=0){
			cs=(CashFlowStatement)efd.getCashFlowStatements().get(0);
		}
		if(efd.getProfitStatements()!=null && efd.getProfitStatements().size()!=0){
			ps=(ProfitStatement)efd.getProfitStatements().get(0);
		}		
		
		if(type.equals(Constant.BALANCE_STATEMENT)){			
			efd=mongoTemplate.findOne(new Query(Criteria.where("balanceStatements.date").is(bs.getDate())), EnterpriseFinancialData.class);  
		}
		if(type.equals(Constant.CASHFLOW_STATEMENT)){
			efd=mongoTemplate.findOne(new Query(Criteria.where("cashFlowStatements.date").is(cs.getDate())), EnterpriseFinancialData.class);  
		}
		if(type.equals(Constant.PROFIT_STATEMENT)){
			efd=mongoTemplate.findOne(new Query(Criteria.where("profitStatements.date").is(ps.getDate())), EnterpriseFinancialData.class);  
		}
		
			
		return efd;
	}  
	
	/**
	 * 根据注册号和年份查找
	 * @param efd
	 */
	public EnterpriseFinancialData findByYearAndNum(EnterpriseFinancialData efd,String type){
		BasicDBObject fieldsObject=new BasicDBObject(); 
		BalanceStatement bs=null;
		CashFlowStatement cs=null;
		ProfitStatement ps=null;
		if(efd.getBalanceStatements()!=null && efd.getBalanceStatements().size()!=0){
			bs=(BalanceStatement) efd.getBalanceStatements().get(0);
		}else if(efd.getCashFlowStatements()!=null && efd.getCashFlowStatements().size()!=0){
			cs=(CashFlowStatement)efd.getCashFlowStatements().get(0);
		}else if(efd.getProfitStatements()!=null && efd.getProfitStatements().size()!=0){
			ps=(ProfitStatement)efd.getProfitStatements().get(0);
		}		
		
		if(type.equals(Constant.BALANCE_STATEMENT)){			
			fieldsObject.put("balanceStatements",new BasicDBObject("$elemMatch",new BasicDBObject("date",bs.getDate()))); 
		}
		if(type.equals(Constant.CASHFLOW_STATEMENT)){
			fieldsObject.put("cashFlowStatements",new BasicDBObject("$elemMatch",new BasicDBObject("date",cs.getDate()))); 
		}
		if(type.equals(Constant.PROFIT_STATEMENT)){
			fieldsObject.put("profitStatements",new BasicDBObject("$elemMatch",new BasicDBObject("date",ps.getDate()))); 
		}
		
		QueryBuilder queryBuilder = new QueryBuilder();   
		queryBuilder.and(new BasicDBObject("enterpriseRegistrationNumber", efd.getEnterpriseRegistrationNumber()));   
				
		fieldsObject.put("enterpriseRegistrationNumber", 1);  	
		
		Query query=new BasicQuery(queryBuilder.get(),fieldsObject);  		
		efd=(EnterpriseFinancialData) mongoTemplate.findOne(query, EnterpriseFinancialData.class);  	
		
		return efd;
	}  
	
	
}
