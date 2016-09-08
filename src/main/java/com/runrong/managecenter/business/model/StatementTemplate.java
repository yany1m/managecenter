package com.runrong.managecenter.business.model;
/**
 * 报表模板
 * @author yanyimin
 *
 */
public class StatementTemplate {

	//自增id
	private int id;
	//管理员id
	private int adminId;
	//模板
	private String template;
	//报表类型
	private String type;
	//名字
	private String name;
	//是否被选中
	private int selected;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSelected() {
		return selected;
	}
	public void setSelected(int selected) {
		this.selected = selected;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
		
}
