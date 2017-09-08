package com.xyy.springmvc.mybatis.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xyy.springmvc.mybatis.beans.InnerUser;
import com.xyy.springmvc.mybatis.beans.RoleInfo;
import com.xyy.springmvc.mybatis.utils.PageBean;
 


/**
 * 用户佣金设置
 * @author Administrator
 *
 */
public interface InnerUserService {
	/**
	 * 用户登录
	 * @param loginName
	 * @param pwd
	 * @return
	 */
	public InnerUser doLogin(String loginName,String pwd);
	
	/**
	 * 新增内部用户
	 * */
	public int addInnerUser(InnerUser innerUser, List<Long> roleids);
	
	/**
	 * 修改内部用户
	 * @param param
	 */
	public void updInnerUser(Map<String,Object> param);
	

    

	/**
	 * 根据条件查询所有相关的内部用户
	 * */
	public List<InnerUser> findAllInnerUserList(HashMap<String, Object> param, PageBean pageBean);

    public int updInnerUser(InnerUser innerUser);

    public InnerUser getInnerUserById(long innerUserId);

    public List<InnerUser> findInnerUserByLoginName(InnerUser innerUser);

    public List<InnerUser> checkLoginName(InnerUser innerUser);



    /**
	* @Title: getUserRole 
	* @Description: 取得用户角色
	* @param @param uid
	* @param @return    参数 
	* @return List<RoleInfo>    返回类型 
	* @throws
	 */
	public List<RoleInfo> getUserRole(long uid);
	
	/**
	 * 给用户分配角色，取消以前该用户分配的角色
	 */
	public void assignRole(Long innerUserId,Long roleId[]);
}
