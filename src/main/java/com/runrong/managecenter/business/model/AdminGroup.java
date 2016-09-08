package com.runrong.managecenter.business.model;
/**
 * 管理组
 * @author yanyimin
 *
 */
public class AdminGroup {
	//自增id
	private int id;
	//组名
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//权限是否被选中
	private int type;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
