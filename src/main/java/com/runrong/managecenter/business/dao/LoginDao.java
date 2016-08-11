package com.runrong.managecenter.business.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.runrong.managecenter.business.model.Administrator;
import com.runrong.managecenter.common.base.BaseDao;
/**
 * 登陆持久层
 * @author yanyimin
 *
 */
@Repository
public class LoginDao extends BaseDao{
	
	/**
	 * 登录，获取账号信息
	 * @param account
	 * @param passWord
	 * @return
	 */
	public List login(String username,String password){
		
		String sql="select * from managecenter.admin where username=? and password=?";
		
		List list=jdbcTemplate.query(sql,new RowMapper<Administrator>(){

			@Override
			public Administrator mapRow(ResultSet rs, int rowNum) throws SQLException{
				Administrator admin=new Administrator();
				admin.setUuid(rs.getInt("id"));
				admin.setAdminGroupid(rs.getInt("admin_group_id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setType(rs.getInt("type"));
				return admin;
			}
			
		},username,password);
				
		return list;
	}
}
