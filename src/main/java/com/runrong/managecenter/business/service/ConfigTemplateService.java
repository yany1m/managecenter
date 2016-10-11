package com.runrong.managecenter.business.service;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.runrong.managecenter.business.dao.ConfigTemplateDao;
import com.runrong.managecenter.business.model.ConfigTemplate;
import com.runrong.managecenter.common.base.ResultModel;
import com.runrong.managecenter.config.QyCreditConfig;
/**
 * 配置模板逻辑层
 * @author yanyimin
 *
 */
@Service
public class ConfigTemplateService {

	@Autowired
	ConfigTemplateDao configTemplateDao;
	
	/**
	 * 添加企业评分配置
	 * @param request
	 * @return
	 */
	public ResultModel addQyCreditConfig(HttpServletRequest request){
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String describe = request.getParameter("describe");
		String lastVersion = request.getParameter("lastVersion");

		
		if(name==null || name.equals("") || content==null || content.equals("") || describe==null || describe.equals("") || lastVersion==null || lastVersion.equals("")){
			return ResultModel.failModel("参数为空");
		}
		Date timeStamp=new Date();
		
		ConfigTemplate configTemplate=new ConfigTemplate();
		configTemplate.setName(name);
		configTemplate.setContent((Map) ( JSON.parse(content)));
		configTemplate.setDescribe(describe);
		configTemplate.setTimeStamp(timeStamp);
		configTemplate.setLastVersion(lastVersion);
		configTemplate.setAdmin((String)request.getSession().getAttribute("username"));
		
		configTemplateDao.addQyCreditConfig(configTemplate);
		return ResultModel.successModel("添加成功");
	}
	
	/**
	 * 获取企业评分配置
	 * @param request
	 * @return
	 */
	public ResultModel getAllQyCreditConfig(HttpServletRequest request){
		List<ConfigTemplate> list = configTemplateDao.getAllQyCreditConfig();
		if(list.size()<=0){
			return ResultModel.failModel("获取失败");
		}
		return ResultModel.successModel(list);
	}
	
	
	/**
	 * 根据mongodb的id获取企业评分配置
	 * @param request
	 * @return
	 */
	public ResultModel getQyCreditConfigById(HttpServletRequest request){
		String uuid = request.getParameter("uuid");
		
		ConfigTemplate configTemplate = new ConfigTemplate();
		configTemplate.setUuid(uuid);
		
		if(uuid==null || uuid.equals("")){
			configTemplate.setContent(QyCreditConfig.qyCreditConfigMap);
			configTemplate.setName("版本1.0");
			return ResultModel.successModel(configTemplate);
		}
		
		configTemplate = configTemplateDao.getQyCreditConfigById(configTemplate);
		
		return ResultModel.successModel(configTemplate);
	}
	
		
	/**
	 * 删除企业评分配置
	 * @param configTemplate
	 * @return
	 */
	public ResultModel deleteQyCreditConfigById(HttpServletRequest request){
		String uuid = request.getParameter("uuid");
		
		ConfigTemplate configTemplate = new ConfigTemplate();
		configTemplate.setUuid(uuid);
		
		if(uuid==null || uuid.equals("")){			
			return ResultModel.successModel("id为空");
		}
		configTemplateDao.deleteQyCreditConfigById(configTemplate);
		return ResultModel.successModel("删除成功");
	}
	
	/**
	 * 选中的企业评分配置
	 * @param configTemplate
	 * @return
	 */
	public ResultModel selectQyCreditConfig(HttpServletRequest request){
		String uuid = request.getParameter("uuid");
		
		ConfigTemplate configTemplate = new ConfigTemplate();
		configTemplate.setUuid(uuid);
		
		if(uuid==null || uuid.equals("")){			
			return ResultModel.successModel("id为空");
		}
		configTemplateDao.selectQyCreditConfig(configTemplate);
		return ResultModel.successModel("已选中");
	}
}
