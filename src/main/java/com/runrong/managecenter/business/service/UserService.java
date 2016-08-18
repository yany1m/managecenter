package com.runrong.managecenter.business.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.runrong.managecenter.business.dao.UserDao;
import com.runrong.managecenter.business.model.User;
import com.runrong.managecenter.common.base.ResultModel;
import com.runrong.managecenter.common.dictionary.Constant;
import com.runrong.managecenter.common.encrypt.MD5;
/**
 * 用户处理层
 * @author yanyimin
 *
 */
@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	/**
	 * 添加用户
	 * @param request
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public ResultModel addUser(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		User user=new User();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String realname=request.getParameter("realname");
		if(username==null || password==null || realname==null || username.equals("") || password.equals("") || realname.equals("")){
			return ResultModel.failModel("参数为空");
		}
		if(checkUsernameIsRepeat(username)){
			return ResultModel.failModel("用户名重复");
		}
		password=MD5.encoderByMd5Salt(password, username);
		
		user.setUsername(username);
		user.setPassword(password);
		user.setRealname(realname);
		user.setJoinTime(new Date());
		int id=userDao.addUser(user);
	
		return ResultModel.successModel("添加成功");
	}
	
	/**
	 * 修改用户
	 * @param request
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public ResultModel updateUser(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		User user=new User();
		if(request.getParameter("id")==null){
			return ResultModel.failModel("参数为空");
		}
		
		Integer id=Integer.valueOf(request.getParameter("id"));	
		String password=request.getParameter("password");
		String realname=request.getParameter("realname");
		String username=request.getParameter("username");
		
		if(password==null && realname==null){
			return ResultModel.failModel("参数为空");
		}
		user.setUuid(id);		
		user.setPassword(MD5.encoderByMd5Salt(password, username));
		user.setRealname(realname);
				
		userDao.updateUser(user);
	
		return ResultModel.successModel("修改成功");
	}
	
	/**
	 * 删除用户
	 * @param request
	 * @return
	 */
	public ResultModel deleteUser(HttpServletRequest request) {
		User user=new User();
		if(request.getParameter("id")==null){
			return ResultModel.failModel("参数为空");
		}
		
		Integer id=Integer.valueOf(request.getParameter("id"));	
		
		user.setUuid(id);
		
		userDao.deleteUser(user);
	
		return ResultModel.successModel("删除成功");
	}
	
	/**
	 * 查找用户
	 * @param request
	 * @return
	 * @throws ParseException 
	 */
	public ResultModel getUser(HttpServletRequest request) throws ParseException {
		User user=new User();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		Integer id=request.getParameter("id")==null?null:Integer.valueOf(request.getParameter("id"));	
		String username=request.getParameter("username");
		String realname=request.getParameter("realname");
		Integer pageNum=request.getParameter("pageNum")==null?Constant.PAGE_NUM:Integer.valueOf(request.getParameter("pageNum"));;
		Integer pageSize=request.getParameter("pageSize")==null?Constant.PAGE_SIZE:Integer.valueOf(request.getParameter("pageSize"));;
		Date jointime=request.getParameter("joinTime")==null?null:sdf.parse(request.getParameter("joinTime"));
		
		user.setUuid(id);
		user.setUsername(username);
		user.setRealname(realname);
		user.setPageNum(pageNum);
		user.setPageSize(pageSize);
		user.setStart(pageSize, pageNum);
		user.setJoinTime(jointime);
		
		List list=userDao.getUser(user);
	
		return ResultModel.successModel(list);
	}
	
	/**
	 * 检查用户名是否重复
	 * @param username
	 * @return
	 */
	public boolean checkUsernameIsRepeat(String username){
		
		User user=new User();
		user.setUsername(username);
		List list=userDao.getUser(user);
		if(list==null || list.size()==0){
			return false;
		}
		return true;
	}
}
