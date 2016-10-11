package com.runrong.managecenter.business.model;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 配置模板
 * @author yanyimin
 *
 */
@Document(collection="configTemplate")
public class ConfigTemplate {
	@Id
	//mongodb自建id
	private String uuid;
	//时间戳
	private Date timeStamp;
	//选中标记,默认0为未选中
	private int selected = 0;
	//配置内容
	private Map content;
	//描述
	private String describe;
	//创建人
	private String admin;
	//名称
	private String name;
	//前置版本
	private String lastVersion;
	
	public String getLastVersion() {
		return lastVersion;
	}
	public void setLastVersion(String lastVersion) {
		this.lastVersion = lastVersion;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getSelected() {
		return selected;
	}
	public void setSelected(int selected) {
		this.selected = selected;
	}
	public Map getContent() {
		return content;
	}
	public void setContent(Map content) {
		this.content = content;
	} 
	
	
}
