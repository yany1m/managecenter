package com.runrong.managecenter.business.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runrong.managecenter.business.cache.PermissionCache;
import com.runrong.managecenter.business.dao.AdminGroupDao;
import com.runrong.managecenter.business.model.AdminGroup;
import com.runrong.managecenter.common.base.ResultModel;

/**
 * 管理组处理层
 * @author yanyimin
 *
 */
@Service
public class AdminGroupService {
	@Autowired
	AdminGroupDao adminGroupDao;
	@Autowired
	PermissionCache permissionCache;
	@Autowired
	AdminService adminService;
	
	/**
	 * 查询管理组
	 * @param request
	 * @return
	 */
	public ResultModel getAdminGroup(HttpServletRequest request){
		
		AdminGroup adminGroup=new AdminGroup();
		
		List list=adminGroupDao.getAdminGroup(adminGroup);
		return ResultModel.successModel(list);
	}
	
	/**
	 * 更新管理组
	 * @param request
	 * @return
	 */
	public ResultModel updateAdminGroup(HttpServletRequest request){
		AdminGroup adminGroup=new AdminGroup();
		String id=request.getParameter("id");
		if(id==null || id.equals("")){
			return ResultModel.failModel("参数有误");
		}
		String name=request.getParameter("name");
		if(name==null || name.equals("")){
			return ResultModel.failModel("参数有误");
		}
		
		adminGroup.setId(Integer.valueOf(id));
		adminGroup.setName(name);
		adminGroupDao.updateAdminGroup(adminGroup);
		return ResultModel.successModel("更新成功");
	}
	
	/**
	 * 添加管理组
	 * @param request
	 * @return
	 */
	public ResultModel addAdminGroup(HttpServletRequest request){
		AdminGroup adminGroup=new AdminGroup();
		String name=request.getParameter("name");
		if(name==null || name.equals("")){
			return ResultModel.failModel("参数有误");
		}
		
		adminGroup.setName(name);
		adminGroupDao.addAdminGroup(adminGroup);
		return ResultModel.successModel("添加成功");
	}
	
	/**
	 * 删除管理组
	 * @param request
	 * @return
	 */
	public ResultModel deleteAdminGroup(HttpServletRequest request){
		AdminGroup adminGroup=new AdminGroup();
		String id=request.getParameter("id");
		if(id==null || id.equals("")){
			return ResultModel.failModel("参数有误");
		}
		
		adminGroup.setId(Integer.valueOf(id));
		adminGroupDao.deleteAdminGroup(adminGroup);
		return ResultModel.successModel("删除成功");
	}
	
	/**
	 * 根据管理组Id查询管理组所有权限
	 * @param request
	 * @return
	 */
	public ResultModel getAdminGroupPermissionById(HttpServletRequest request){
		AdminGroup adminGroup=new AdminGroup();
		String id=request.getParameter("id");
		if(id==null || id.equals("")){
			return ResultModel.failModel("参数有误");
		}
		adminGroup.setId(Integer.valueOf(id));
		List list=adminGroupDao.getAdminGroupPermissionById(adminGroup);
		
		return ResultModel.successModel(list);
	}
	
	/**
	 * 更新管理组权限
	 * @param request
	 * @return
	 */
	public ResultModel updateAdminGroupPermission(HttpServletRequest request){
		AdminGroup adminGroup=new AdminGroup();
		List<Object[]> batch=new ArrayList<Object[]>();			
		HashSet<String> set=new HashSet<String>();
		
		String id=request.getParameter("id");
		if(id==null || id.equals("")){
			return ResultModel.failModel("参数有误");
		}
		
		adminGroup.setId(Integer.valueOf(id));
		List<Map> list=adminGroupDao.getAdminGroupPermissionById(adminGroup);
		for(Map map:list){
			set.add((String) map.get("permissionsId"));
		}
				
		String[] permissionIds=request.getParameterValues("checkboxes");
		if(permissionIds!=null && permissionIds.length>0){
			for(String permissionId:permissionIds){	
			
				if(set.contains(permissionId)){
					set.remove(permissionId);					
					continue;
				}
				Object[] values = new Object[] {
							id,
							permissionId};
//							id,
//							permissionId};				
				      batch.add(values);
			}
		}
		
		adminGroupDao.removeAdminGroupPermission(set,id);
		int[] updateCounts=adminGroupDao.addPermissionToAdminGroup(batch);
		
		//每次更新后都需要存入缓存中	
		permissionCache.put(String.valueOf(request.getSession().getAttribute("admin_id")), adminService.getAdminPermission((int) request.getSession().getAttribute("admin_id")));
	
		return ResultModel.successModel("修改成功");		
	}
	
	
}
