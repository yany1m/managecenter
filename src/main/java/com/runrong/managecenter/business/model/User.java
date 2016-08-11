package com.runrong.managecenter.business.model;

import java.util.Date;

import com.runrong.managecenter.common.base.BaseModel;

/**
 * 用户账号
 * @author yanyimin
 *
 */
public class User extends BaseModel{
	
	//自增id
	private Integer uuid;
	//用户名
	private String username;
	//密码
	private String password;
	//真实姓名
	private String realname;
	//加入时间
	private Date joinTime;
	
	
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
