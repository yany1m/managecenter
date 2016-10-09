package com.runrong.managecenter.business.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.runrong.managecenter.business.model.Administrator;
import com.runrong.managecenter.common.base.BaseDao;

/**
 * 管理员账号持久层
 * @author yanyimin
 *
 */
@Repository
public class AdminDao extends BaseDao{
	
	/**
	 * 添加管理员
	 * @param username
	 * @param password
	 * @return
	 */
	public int addAdministrator(Administrator admin){
		String sql="insert into managecenter.admin (id,admin_group_id,username,password,type,jointime) values (:uuid,:adminGroupid,:username,:password,:type,:joinTime)";
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		SqlParameterSource sps = new BeanPropertySqlParameterSource(admin);
		namedParameterJdbcTemplate.update(sql, sps, keyholder);
		
        return keyholder.getKey().intValue();
	}
	
	/**
	 * 修改管理员
	 * @param username
	 * @param password
	 * @return
	 */
	public void updateAdministrator(Administrator admin){
		StringBuffer sql=new StringBuffer("update managecenter.admin set id=:uuid ");
		if(admin.getPassword()!=null){
			sql.append(" ,password=:password");
		}
		if(admin.getAdminGroupid()!=null){
			sql.append(",admin_group_id=:adminGroupid");
		}
		sql.append(" where id=:uuid");
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(admin);  	
		namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}
	
	/**
	 * 查找管理员
	 * @param username
	 * @param password
	 * @return
	 */
	public List getAdministrator(Administrator admin){
		StringBuffer sql=new StringBuffer("select managecenter.admin.id,admin_group_id,username,type,jointime,name from managecenter.admin left join managecenter.admin_group on managecenter.admin.admin_group_id=managecenter.admin_group.id where 1=1");		
		if(admin.getUuid()!=null){			
			sql.append(" and managecenter.admin.id=:uuid");
		}
		if(admin.getUsername()!=null){
			sql.append(" and username=:username");
		}
		if(admin.getAdminGroupid()!=null){
			sql.append(" and admin_group_id=:adminGroupid");
		}
		if(admin.getType()!=null){
			sql.append(" and type=:type");
		}
		if(admin.getJoinTime()!=null){
			sql.append(" and jointime=:joinTime");
		}	
//		sql.append(" limit :start,:pageSize");		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(admin);  
		List list=namedParameterJdbcTemplate.queryForList(sql.toString(), paramSource);
		
//		String countSql="select count(1) as count from managecenter.admin";
//		int count=namedParameterJdbcTemplate.queryForInt(countSql, paramSource);
//		Map map=new HashMap();
//		map.put("count", count);
//		list.add(map);
		return list;
	}
	
	/**
	 * 删除管理员
	 * @param username
	 * @param password
	 * @return
	 */
	public void deleteAdministrator(Administrator admin){
		String sql="delete from managecenter.admin where id=:uuid";
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(admin);  
		namedParameterJdbcTemplate.update(sql, paramSource);
		
	}
}
