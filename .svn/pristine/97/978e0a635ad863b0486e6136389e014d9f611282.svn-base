package com.xyy.springmvc.mybatis.services;

import java.util.List;
import java.util.Map; 

import com.xyy.springmvc.mybatis.beans.SystemUser;
import com.xyy.springmvc.mybatis.utils.PageBean;

/**
* @ClassName: SystemUserService 
* @Description: 系统用户操作
* @author lvjian
* @date 2016年10月24日 下午14:29:56 
*/
public interface SystemUserService {

	/**
	 * @Title: addSystemUser  
	 * @param systemUser 新增的系统用户
	 * void  返回类型 
	 * @throws
	 */
	void addSystemUser(SystemUser systemUser);
	
	/**
	 * @Title:  delSystemUser
	 * @param param 按照此条件删除系统用户
	 * void 返回类型 
	 * @throws
	 */
	void delSystemUser(Map<String,Object> param);
	
	/**
	 * @Title:  updSystemUser
	 * @param systemUser 需要修改的系统用户
	 * void 返回类型 
	 * @throws
	 */
	void updSystemUser(SystemUser systemUser);
	
	/**
	 * @Title:  findSystemUser
	 * @Description: 查看所选择的系统用户信息
	 * @param param 查询条件
	 * @return List<systemUser> 返回类型  系统用户列表 
	 * @throws
	 */
	List<SystemUser> findSystemUser(Map<String,Object> param);
	
	/**
	 * @Title:  findSystemUserPage
	 * @Description: 查询与输入条件相符的系统用户信息 分页
	 * @param param 查询条件
	 * @return List<systemUser> 返回类型  系统用户列表 
	 * @throws
	 */
	List<SystemUser> findSystemUserPage(Map<String,Object> param, PageBean pageBean);
}
