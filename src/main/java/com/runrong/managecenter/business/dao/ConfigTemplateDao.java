package com.runrong.managecenter.business.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.runrong.managecenter.business.model.ConfigTemplate;
import com.runrong.managecenter.business.model.datacollection.EnterpriseFinancialData;

/**
 * 配置模板
 * @author yanyimin
 *
 */
@Repository
public class ConfigTemplateDao {
	@Autowired
	MongoTemplate mongoTemplate;
	
	/**
	 * 添加企业评分配置
	 * @param ct
	 */
	public void addQyCreditConfig(ConfigTemplate configTemplate){	
		mongoTemplate.save(configTemplate);
	}
	
	/**
	 * 获取所有企业评分配置
	 * @return
	 */
	public List getAllQyCreditConfig(){
		List<ConfigTemplate> list= mongoTemplate.findAll(ConfigTemplate.class);
		return list;
	}
	
	/**
	 * 根据mongodb的id获取企业评分配置
	 * @param configTemplate
	 * @return
	 */
	public ConfigTemplate getQyCreditConfigById(ConfigTemplate configTemplate){
		configTemplate=mongoTemplate.findOne(new Query(Criteria.where("_id").is(configTemplate.getUuid())), ConfigTemplate.class);
		return configTemplate;
	}
	
	/**
	 * 更新企业评分配置
	 * @param configTemplate
	 */
	public void updateQyCreditConfigById(ConfigTemplate configTemplate){
		
	}
	
	/**
	 * 删除企业评分配置
	 * @param configTemplate
	 */
	public void deleteQyCreditConfigById(ConfigTemplate configTemplate){
		mongoTemplate.remove(new Query(Criteria.where("_id").is(configTemplate.getUuid())), ConfigTemplate.class);
	}
	
	/**
	 * 选中的企业评分配置
	 * @param configTemplate
	 */
	public void selectQyCreditConfig(ConfigTemplate configTemplate){
		//先将原本选中的selected项更新为0
		Update update = new Update();
		update.set("selected",0);
		mongoTemplate.updateFirst(new Query(Criteria.where("selected").is(1)), update, ConfigTemplate.class);
		//再更新此次被选中的配置模板
		update.set("selected",1);
		mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(configTemplate.getUuid())), update, ConfigTemplate.class);
	}
}
