package com.runrong.managecenter.business.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.runrong.managecenter.business.model.Administrator;
import com.runrong.managecenter.business.model.StatementTemplate;
import com.runrong.managecenter.common.base.BaseDao;

/**
 * 报表模板持久层
 * @author yanyimin
 *
 */
@Repository
public class StatementTemplateDao extends BaseDao{
	
	/**
	 * 查询模板
	 * @param statementTemplate
	 * @return
	 */
	public List getStatementTemplate(StatementTemplate statementTemplate){
		StringBuffer sql=new StringBuffer("select managecenter.statement_template.id,admin_id,template,managecenter.statement_template.type,name,editor,managecenter.admin.username,a.username as editor_name from managecenter.statement_template join "
				+ "managecenter.admin on managecenter.statement_template.admin_id=managecenter.admin.id join managecenter.admin as a on managecenter.statement_template.editor=a.id where 1=1");	
		if(statementTemplate.getId()!=null && !statementTemplate.getId().equals("")){			
			sql.append(" and managecenter.statement_template.id=:id");
		}
		if(statementTemplate.getAdminId()!=0){
			sql.append(" and admin_id=:adminId");
		}
		if(statementTemplate.getType()!=null && !statementTemplate.getType().equals("")){
			sql.append(" and managecenter.statement_template.type=:type");
		}
		if(statementTemplate.getName()!=null && !statementTemplate.getName().equals("")){
			sql.append(" and name=:name");
		}
			
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(statementTemplate);  
		List list=namedParameterJdbcTemplate.queryForList(sql.toString(), paramSource);
		return list;
	}
	
	/**
	 * 添加模板
	 * @param statementTemplate	 
	 * @return
	 */
	public int addStatementTemplate(StatementTemplate statementTemplate){
		String sql="insert into managecenter.statement_template (id,admin_id,template,type,name,editor) values (:id,:adminId,:template,:type,:name,:editor)";
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		SqlParameterSource sps = new BeanPropertySqlParameterSource(statementTemplate);
		namedParameterJdbcTemplate.update(sql, sps, keyholder);
		
        return keyholder.getKey().intValue();
	}
	
	/**
	 * 修改模板
	 * @param statementTemplate
	 * @return
	 */
	public void updateStatementTemplate(StatementTemplate statementTemplate){
		StringBuffer sql=new StringBuffer("update managecenter.statement_template set id=:id,editor=:editor");
		if(statementTemplate.getTemplate()!=null && !statementTemplate.getTemplate().equals("")){
			sql.append(",template=:template");
		}	
		if(statementTemplate.getName()!=null && !statementTemplate.getName().equals("")){
			sql.append(",name=:name");
		}
		sql.append(" where id=:id");
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(statementTemplate);  	
		namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}
	
//	/**
//	 * 修改被选中的模板
//	 * @param statementTemplate
//	 * @return
//	 */
//	public void updateStatementTemplateSelected(StatementTemplate statementTemplate){
//		StringBuffer sql=new StringBuffer("update managecenter.statement_template set selected=0 where admin_id=:adminId and type=:type and selected=1");
//	
//		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(statementTemplate);  	
//		namedParameterJdbcTemplate.update(sql.toString(), paramSource);
//	}
	
	/**
	 * 删除模板
	 * @param username
	 * @param password
	 * @return
	 */
	public void deleteStatementTemplate(StatementTemplate statementTemplate){
		String sql="delete from managecenter.statement_template where id=:id";
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(statementTemplate);  
		namedParameterJdbcTemplate.update(sql, paramSource);
		
	}
}
