package com.xyy.springmvc.mybatis.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyy.springmvc.mybatis.beans.InnerUser;
import com.xyy.springmvc.mybatis.mapper.InnerUserDao;
import com.xyy.springmvc.mybatis.mapper.UserRoleDao;
import com.xyy.springmvc.mybatis.services.InnerUserService;
import com.xyy.springmvc.mybatis.services.RoleService;
import com.xyy.springmvc.mybatis.utils.DWZJsonResponseResult;
 

@Controller
@RequestMapping("innerUser")
public class InnerUserController extends BaseController{
	@Autowired
	private InnerUserService innerUserService;
	@Autowired
	private RoleService roleservice;
	@Autowired
	private InnerUserDao innerUserDao; 
	@Autowired
	private UserRoleDao userRoleDao;
	
	
	//到用户列表
	/*@RequestMapping("/innUserList")
	public String userList(HttpServletRequest request)
	{
		List<InnerUser> useList = innerUserDao.findAllInnerUserList(null);
		request.setAttribute("innUserList", useList);
		return toPage("innerUser","innerUserList");	
	}*/
	//到添加用户页面
	@RequestMapping("/innUserAddPage")
	public String innUserAddPage(HttpServletRequest request)
	{
		StringBuffer sb = new StringBuffer();
		roleservice.roleTree(sb, -1);
		request.setAttribute("roleTree", sb);
		return toPage("innerUser","innUserAddPage");	
	}
	//到修改用户页面
	@RequestMapping("/innUserUpdPage")
	public String innUserUpdPage(int id,HttpServletRequest request)
	{
		Map<String,Object> param = new HashMap<>();
		param.put("userId", id);
		List<InnerUser> useList=innerUserDao.findAllInnerUserList(param);		
		InnerUser user=useList.get(0);		
		request.setAttribute("user", user);
		return toPage("innerUser","innUserUpdPage");	
	}
	//到用户详情页面
	@RequestMapping("/innUserPage")
	public String innUserPage(int id,HttpServletRequest request)
	{
		Map<String,Object> param = new HashMap<>();
		param.put("userId", id);
		List<InnerUser> useList=innerUserDao.findAllInnerUserList(param);		
		InnerUser user=useList.get(0);		
		request.setAttribute("user", user);
		return toPage("innerUser","innUserPage");	
	}

	//添加新用户
	@RequestMapping("/addInnerUser")
	public void addInnerUser(InnerUser innerUser,long roleId[], HttpServletResponse response)
	{
		List<Long> roleids =new ArrayList<>();
		if(roleId.length>0)
		{
			for(long r:roleId)
			{
				roleids.add(r);
			}
		}
		innerUser.setUserType(1);
		innerUser.setStatus(1);
		innerUser.setLoginStatus(1);
		innerUser.setCreateDate(new Date());
		innerUserService.addInnerUser(innerUser, roleids);
		DWZJsonResponseResult succ = DWZJsonResponseResult.initSuccess();
		succ.setNavTabId("userList");
		jsonToPage(succ.toJSONString(), response);	
	}
	//修改用户
	@RequestMapping("/updInnUser")
	public void updInnUser(InnerUser innerUser, HttpServletResponse response)
	{
		innerUserService.updInnerUser(innerUser);
		DWZJsonResponseResult succ = DWZJsonResponseResult.initSuccess();
		succ.setNavTabId("userList");
		jsonToPage(succ.toJSONString(), response);	
	}
	//修改用户状态（启用/停用）
	@RequestMapping("/changeStatus")
	public void changeStatus(InnerUser innerUser,HttpServletResponse response)
	{
		innerUser.setStatus(innerUser.getStatus()==1?2:1);
		innerUserService.updInnerUser(innerUser);
		DWZJsonResponseResult succ = DWZJsonResponseResult.initSuccess();
		succ.setNavTabId("userList");
		jsonToPage(succ.toJSONString(), response);	
	}
	//检索用户
	@RequestMapping("/innUserList")
	public String searchUser(InnerUser innerUser,HttpServletRequest request)
	{
		Map<String,Object> param = new HashMap<>();
		param.put("userName", innerUser.getUserName());
		param.put("loginName", innerUser.getLoginName());
		List<InnerUser> userList = innerUserDao.findAllInnerUserList(param);
		request.setAttribute("innUserList", userList);			
		return toPage("innerUser","innerUserList");
 	}
	//分配角色页面
	@RequestMapping("/userRolePage")
	public String userRolePage(Long innerUserId,HttpServletRequest request)
	{
		//返回角色树
		StringBuffer sb =new StringBuffer();
		roleservice.roleTreeToUser(sb, -1,innerUserId);
		request.setAttribute("roleTree", sb);
		request.setAttribute("innerUserId", innerUserId);
		return toPage("innerUser","innUserRole");
	} 
	//给用户分配角色，取消该用户之前的角色
	@RequestMapping("/assignRole")
	public void assignRole(Long innerUserId,Long roleId[],HttpServletResponse response)
	{
		innerUserService.assignRole(innerUserId, roleId);
		DWZJsonResponseResult succ = DWZJsonResponseResult.initSuccess();
		succ.setNavTabId("userList");
		jsonToPage(succ.toJSONString(), response);
	}
}
