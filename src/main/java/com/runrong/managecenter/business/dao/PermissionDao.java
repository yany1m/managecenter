package com.runrong.managecenter.business.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.runrong.managecenter.business.model.AdminGroup;
import com.runrong.managecenter.business.model.Administrator;
import com.runrong.managecenter.business.model.Permission;
import com.runrong.managecenter.common.base.BaseDao;

/**
 * 权限持久层
 * @author yanyimin
 *
 */
@Repository
public class PermissionDao extends BaseDao{
	
	/**
	 * 查找权限
	 * @param permission
	 * @return list 权限集合
	 */
	public List getPermission(Permission permission){
		StringBuffer sql=new StringBuffer("select * from managecenter.permissions where 1=1");
		if(permission.getId()!=null){
			sql.append(" ,id =:id");
		}
		if(permission.getParentName()!=null){
			sql.append(" ,parent_name =:parentName");
		}
		if(permission.getParent()!=null){
			sql.append(" ,parent =:parent");
		}
		if(permission.getPermissionName()!=null){
			sql.append(" ,permission_name =:permissionName");
		}
		if(permission.getPermission()!=null){
			sql.append(" ,permission =:permission");
		}
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(permission);  
		List list=namedParameterJdbcTemplate.queryForList(sql.toString(), paramSource);
		return list;
	}
	
	/**
	 * 添加权限
	 * @param permission
	 * @return
	 */
	public int addPermission(Permission permission){
		String sql="insert into managecenter.permissions (permission,permission_name,parent,parent_name) values (:permission,:permissionName,:parent,:parentName)";
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		SqlParameterSource sps = new BeanPropertySqlParameterSource(permission);
		namedParameterJdbcTemplate.update(sql, sps, keyholder);
		
        return keyholder.getKey().intValue();
	}
	
	/**
	 * 更新权限
	 * @param permission
	 */
	public void updatePermission(Permission permission){
		StringBuffer sql=new StringBuffer("update managecenter.permissions set id=:id ");
		if(permission.getParentName()!=null){
			sql.append(" ,parent_name =:parentName");
		}
		if(permission.getParent()!=null){
			sql.append(" ,parent =:parent");
		}
		if(permission.getPermissionName()!=null){
			sql.append(" ,permission_name =:permissionName");
		}
		if(permission.getPermission()!=null){
			sql.append(" ,permission =:permission");
		}
		sql.append(" where id=:id");
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(permission);  	
		namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}
	
	/**
	 * 删除权限
	 * @param permission
	 */
	public void deletePermission(Permission permission){
		String sql="delete from managecenter.permissions where id=:id";
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(permission);  
		namedParameterJdbcTemplate.update(sql, paramSource);
		
	}
	
	
}
