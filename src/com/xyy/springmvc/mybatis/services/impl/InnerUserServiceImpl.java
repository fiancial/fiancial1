package com.xyy.springmvc.mybatis.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyy.springmvc.mybatis.beans.InnerUser;
import com.xyy.springmvc.mybatis.beans.RoleInfo;
import com.xyy.springmvc.mybatis.beans.UserRole;
import com.xyy.springmvc.mybatis.mapper.InnerUserDao;
import com.xyy.springmvc.mybatis.mapper.RoleDao;
import com.xyy.springmvc.mybatis.mapper.UserRoleDao;
import com.xyy.springmvc.mybatis.services.InnerUserService;
import com.xyy.springmvc.mybatis.utils.CpsysUtil;
import com.xyy.springmvc.mybatis.utils.PageBean;
 

@Service("innerUserServ")
public class InnerUserServiceImpl implements InnerUserService {
	private Logger logger = Logger.getLogger(InnerUserServiceImpl.class);

	@Autowired
	private InnerUserDao innerUserDao;
	@Autowired
	private RoleDao roleDao;// 数据授权、操盘授权dao。
	@Autowired
	private UserRoleDao userRoleDao;
	@Override
	public InnerUser doLogin(String loginName, String pwd) {
		/*
		 * InnerUser user = findUserByLoginName(loginName); if(user==null){
		 * return null; } if(!pwd.equals(user.getPassword())){ return null; }
		 * //只允许代理登陆 if(user.getUserClass() == null ||
		 * user.getUserClass().equals("") || user.getUserClass().equals("301")){
		 * return null; }
		 */
		/*InnerUser user = new InnerUser();
		user.setInnerUserId(1L);
		user.setLoginName(loginName);
		user.setUserName(loginName);*/
		
		InnerUser user = new InnerUser();
		user.setLoginName(loginName);
		List<InnerUser> us = findInnerUserByLoginName(user);
		if(!us.isEmpty()/* && us.get(0).getUserPwd().equals(pwd)*/){
			user = us.get(0);
			user.setUserUTC("GMT+8");
			return user;
		}
		return null;
	}

	@Override
	public void updInnerUser(Map<String, Object> param) {
		// TODO Auto-generated method stub

	}

	/**
	 * 新增内部用户
	 * */
	public int addInnerUser(InnerUser innerUser, List<Long> roleids) {
		List<InnerUser> list = innerUserDao.findInnerUserByLoginName(innerUser);
		if (list.size() > 0) {
			return 0;
		}
		//设置userid
		long seq = innerUserDao.getInnerUserSeq();
		innerUser.setInnerUserId(seq);
		//把密码加密后替换原来密码
		String passWord = innerUser.getUserPwd();
		passWord = CpsysUtil.getMD5Str(passWord);
		innerUser.setUserPwd(passWord);
		//添加用户
		int ret = innerUserDao.addInnerUser(innerUser);
		//roleDao.delUserRole(seq);
		//赋予用户相应的角色
		UserRole ur = new UserRole();
		for (long rid : roleids) {
			ur.setRoleId(rid);
			ur.setUserId(seq);
			ur.setUserType(1);
			userRoleDao.addUserRole(ur);			
		}
		return ret;
	}

	/**
	 * @Title: getUserRole
	 * @Description: 取得用户角色
	 * @param @param uid
	 * @param @return 参数
	 * @return List<RoleInfo> 返回类型
	 * @throws
	 */
	public List<RoleInfo> getUserRole(long uid) {
		return roleDao.findUserRoles(uid);
	}

	/**
	 * 根据条件查询所有相关的内部用户
	 * */
	public List<InnerUser> findAllInnerUserList(HashMap<String, Object> param, PageBean pageBean) {
		pageBean.initMap(param);
		List<InnerUser> list = innerUserDao.findAllInnerUserList(param);
		if (!list.isEmpty()) {
			pageBean.setTotalRows(list.get(0).getNums());
			pageBean.repaginate();
		}
		return list;
	}

	/**
	 * 修改内部用户信息资料. 包括设计内部用户的启用状态为：启用/停用
	 * */
	public int updInnerUser(InnerUser innerUser) {
		String passWord = innerUser.getUserPwd();
		if (StringUtils.isNotEmpty(passWord)) {
			passWord = CpsysUtil.getMD5Str(passWord);
			innerUser.setUserPwd(passWord);
		}

		int updInnerUser = innerUserDao.updInnerUser(innerUser);

		return updInnerUser;
	}

	public InnerUser getInnerUserById(long innerUserId) {
		return innerUserDao.getInnerUserById(innerUserId);
	}

	/**
	 * 根据登录名获取用户
	 */
	public List<InnerUser> findInnerUserByLoginName(InnerUser innerUser) {
		return innerUserDao.findInnerUserByLoginName(innerUser);

	}

	/**
	 * 检测登录名是否在系统中存在。
	 * 
	 * @return
	 */
	public List<InnerUser> checkLoginName(InnerUser innerUser) {
		return innerUserDao.findInnerUserByLoginName(innerUser);

	}
	/**
	 * 给用户分配角色，取消以前该用户分配的角色
	 */
	public void assignRole(Long innerUserId,Long roleId[])
	{
		List<UserRole> former = userRoleDao.findUserRolesByUId(innerUserId);
		List<UserRole> urlist = new ArrayList<>();
		if(roleId.length>0)
		{
			for(Long rid:roleId)
			{
				urlist.add(new UserRole(innerUserId,rid,1));
			}
		}
		//以前的，不包含于现在的，删除
		for(UserRole ur:former)
		{
			if(!urlist.contains(ur))
			{
				userRoleDao.delUserRole(ur);
			}
		}
		//现在的，不包含于以前的，增加
		for(UserRole ur:urlist)
		{
			if(!former.contains(ur))
			{
				userRoleDao.addUserRole(ur);
			}
		}
	}
}
