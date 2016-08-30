package com.runrong.managecenter.business.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.runrong.managecenter.business.model.AdminGroup;
import com.runrong.managecenter.common.base.BaseDao;

/**
 * 管理组持久层
 * @author yanyimin
 *
 */
@Repository
public class AdminGroupDao extends BaseDao{
	
	/**
	 * 给管理员组添加权限
	 * @param adminGroup
	 * @param permission
	 */
	//应该是批量插入
	public int[] addPermissionToAdminGroup(List<Object[]> batch){
//		String sql="insert into managecenter.admin_group_permissions (admin_group_id,permissions_id) select ?,? from "
//				+ "dual where not exists (select admin_group_id from managecenter.admin_group_permissions where admin_group_id=? and permissions_id=?) limit 1";
		String sql="insert into managecenter.admin_group_permissions (admin_group_id,permissions_id) values (?,?)";
		
		int[] updateCounts=jdbcTemplate.batchUpdate(sql,batch);
		return updateCounts;
	}
	
	/**
	 * 根据id查询管理组权限
	 * @param adminGroup
	 * @return
	 */
	public List<Map> getAdminGroupPermissionById(AdminGroup adminGroup){
		String sql="select managecenter.admin_group_permissions.id ,admin_group_id,permissions_id,permission,permission_name,parent,"
				+ "parent_name from managecenter.admin_group_permissions inner join managecenter.permissions on admin_group_permissions.permissions_id=permissions.id where admin_group_id=?";
		List<Map> list=jdbcTemplate.query(sql, new RowMapper<Map>(){

			@Override
			public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map<String,Object> map=new HashMap<String, Object>();
				map.put("id", rs.getString("id"));
				map.put("adminGroupId", rs.getString("admin_group_id"));
				map.put("permissionsId", rs.getString("permissions_id"));				
				map.put("permission", rs.getString("permission"));
				map.put("permissionName", rs.getString("permission_name"));
				map.put("parent", rs.getString("parent"));
				map.put("parentName", rs.getString("parent_name"));
				return map;
			}
			
		}, adminGroup.getId());		
		return list;
	}
	
	/**
	 * 去掉管理组的权限
	 * @param params
	 */
	public void removeAdminGroupPermission(HashSet<String> params,String id){
		StringBuffer sql=new StringBuffer("delete from managecenter.admin_group_permissions where admin_group_id =?  ");
		if(params.size()>0){
			sql.append("and permissions_id in(");
			for(String param:params){			
				sql.append(param+","); 
				} 
			sql.append("0)"); 
		}else{
			return;
		}
		jdbcTemplate.update(sql.toString(),id);
		
		//频繁进行删除操作并不可取
		//应该将type设置为1来取代删除操作
		
//		String sql="update managecenter.admin_group_permissions set type=1 where admin_group_id=? and permissions_id=?";
//		int[] updateCounts=jdbcTemplate.batchUpdate(sql,batch);
//		return updateCounts;
	}
	
	/**
	 * 获得管理组
	 * @return
	 */
	public List getAdminGroup(AdminGroup adminGroup){
		String sql="select * from managecenter.admin_group where 1=1";
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(adminGroup);  
		List list=namedParameterJdbcTemplate.queryForList(sql.toString(), paramSource);
		
		return list;
	}
	
	/**
	 * 添加管理组
	 * @return
	 */
	public void addAdminGroup(AdminGroup adminGroup){
		String sql="insert into managecenter.admin_group (name) values (:name)";
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(adminGroup);  
		namedParameterJdbcTemplate.update(sql.toString(), paramSource);
		
	}
	
	/**
	 * 修改管理组
	 * @return
	 */
	public void updateAdminGroup(AdminGroup adminGroup){
		String sql="update managecenter.admin_group set name=:name where id=:id";
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(adminGroup);  
		namedParameterJdbcTemplate.update(sql.toString(), paramSource);
		
	}
	
	/**
	 * 删除管理组
	 * @return
	 */
	public void deleteAdminGroup(AdminGroup adminGroup){
		String sql="delete from managecenter.admin_group where id=:id";
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(adminGroup);  
		namedParameterJdbcTemplate.update(sql.toString(), paramSource);
		
	}
}
