package com.runrong.managecenter.business.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.runrong.managecenter.business.model.User;
import com.runrong.managecenter.common.base.BaseDao;
/**
 * 用户持久层
 * @author yanyimin
 *
 */
@Repository
public class UserDao extends BaseDao{
	
	/** 添加用户
	 * @param username
	 * @param password
	 * @return
	 */
	public int addUser(User user){
		String sql="insert managecenter.user (id,username,password,realname,jointime) values (:uuid,:username,:password,:realname,:joinTime)";
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		SqlParameterSource sps = new BeanPropertySqlParameterSource(user);
		namedParameterJdbcTemplate.update(sql, sps, keyholder);
		
       return keyholder.getKey().intValue();
	}
	
	/**
	 * 修改用户
	 * @param username
	 * @param password
	 * @return
	 */
	public void updateUser(User user){	
		StringBuffer sql=new StringBuffer("update managecenter.user set id=:uuid");
		if(user.getPassword()!=null && !user.getPassword().equals("")){
			sql.append(" ,password=:password");
		}
		if(user.getRealname()!=null){
			sql.append(" ,realname=:realname");
		}
		sql.append(" where id=:uuid");
			
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);  
		namedParameterJdbcTemplate.update(sql.toString(), paramSource);
		
//		StringBuffer sql=new StringBuffer("update managecenter.user set id=?");
//		if(user.getPassword()!=null && !user.getPassword().equals("")){
//			sql.append(" ,password=?");
//		}
//		if(user.getRealname()!=null && !user.getRealname().equals("")){
//			sql.append(" ,realname=?");
//		}
//		sql.append(" where id=?");
//		if(user.getPassword()!=null && !user.getPassword().equals("") && user.getRealname()!=null && !user.getRealname().equals("")){
//			jdbcTemplate.update(sql.toString(), user.getUuid(),user.getPassword(),user.getRealname(),user.getUuid());
//			return;
//		}
//		if(user.getPassword()!=null && !user.getPassword().equals("") ){
//			jdbcTemplate.update(sql.toString(), user.getUuid(),user.getPassword(),user.getUuid());
//			return;
//		}
//		if(user.getRealname()!=null && !user.getRealname().equals("")){
//			
//			String ss="update managecenter.user set realname=? where id=?";
//			
//			System.out.println(ss);
//			System.out.println(user.getRealname());
//			jdbcTemplate.update(ss,user.getRealname(),user.getUuid());
//			return;
//		}
	}
	
	/**
	 * 查找用户
	 * @param username
	 * @param password
	 * @return
	 */
	public List getUser(User user){
		
		StringBuffer sql=new StringBuffer("select id,username,realname,jointime from managecenter.user where 1=1");		
		if(user.getUuid()!=null){
			sql.append(" and id=:uuid");
		}
		if(user.getUsername()!=null){
			sql.append(" and username=:username");
		}
		if(user.getRealname()!=null){
			sql.append(" and realname=:realname");
		}
		if(user.getJoinTime()!=null){
			sql.append(" and jointime=:joinTime");
		}
		
//		sql.append(" limit :start,:pageSize");		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);  
		List list=namedParameterJdbcTemplate.queryForList(sql.toString(), paramSource);
		
//		String countSql="select count(1) as count from managecenter.user";
//		int count=namedParameterJdbcTemplate.queryForInt(countSql, paramSource);
//		Map map=new HashMap();
//		map.put("count", count);
//		list.add(map);
		return list;
	}
	
	/**
	 * 删除用户
	 * @param username
	 * @param password
	 * @return
	 */
	public void deleteUser(User user){
		String sql="delete from managecenter.user where id=:uuid";
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);  
		namedParameterJdbcTemplate.update(sql, paramSource);
		
	}
}
