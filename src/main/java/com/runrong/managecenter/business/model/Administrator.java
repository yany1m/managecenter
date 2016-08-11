package com.runrong.managecenter.business.model;

import java.util.Date;

import com.runrong.managecenter.common.base.BaseModel;

/**
 * 管理员账号
 * @author yanyimin
 *
 */
public class Administrator extends BaseModel{
	//自增id
	private Integer uuid;
	//管理组id 默认为0即无组分配
	private Integer adminGroupid=0;
	//账号
	private String username;
	//密码
	private String password;
	//类型默认为普通管理员
	private Integer type=1;
	//加入时间
	private Date joinTime;
	
	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getUuid() {
		return uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public Integer getAdminGroupid() {
		return adminGroupid;
	}

	public void setAdminGroupid(Integer adminGroupid) {
		this.adminGroupid = adminGroupid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
