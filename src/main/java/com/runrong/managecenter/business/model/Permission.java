package com.runrong.managecenter.business.model;
/**
 * 权限
 * @author yanyimin
 *
 */
public class Permission {
	//自增id
	private Integer id;
	//权限（方法名）
	private String permission;
	//权限中文
	private String permissionName;
	//父类（类名）
	private String parent;
	//父类中文名
	private String parentName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
}
