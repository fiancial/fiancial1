package com.xyy.springmvc.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.xyy.springmvc.mybatis.beans.SystemUser;
 

/**
* @ClassName: SystemUserDao 
* @Description: 系统用户的数据库操作类
* @author lvjian
* @date 2016年10月24日 下午14:26:56 
*/
public interface SystemUserDao {

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
	List<SystemUser> findSystemUserPage(Map<String,Object> param);
	
	/**
	* @Title: countBlackNums 
	* @Description: 按条件统计用户数量
	* @param param 统计条件
	* @return    参数 
	* int  返回用户数量
	* @throws
	 */
	 int countSystemNums(Map<String, Object> param);
}







