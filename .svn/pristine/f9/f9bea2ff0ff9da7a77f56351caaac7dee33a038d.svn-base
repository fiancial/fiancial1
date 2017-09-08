package com.xyy.springmvc.mybatis.services;

import java.util.List;

import com.xyy.springmvc.mybatis.beans.RightInfo;


public interface IRightService {

	/**
	* @Title: findRightsByRole 
	* @Description: 获取角色的权限
	* @param @param roleId
	* @param @return    参数 
	* @return List<RightInfo>    返回类型 
	* @throws
	 */
	public List<RightInfo> findRightsByRole(Long roleId);
	
	  /**
	    * @Title: getAuthTree 
	    * @Description: 取得权限树
	    * @param @return    参数 
	    * @return String    返回类型 
	    * @throws
	     */
	public String getAuthTree(long type);
	  
	  /**
	   * 
	  * @Title: findAllRightInfo 
	  * @Description: 返回所有权限信息
	  * @return    参数 
	  * List<RightInfo>  返回类型 
	  * @throws
	   */
	List<RightInfo> findAllRightInfo();
	  /**
	   * 
	  * @Title: initAuthsTree 
	  * @Description: 返回权限树
	  * @param superId
	  * @param sb
	  * @param type    参数 
	  * void  返回类型 
	  * @throws
	   */
	public void initAuthsTree(long superId, StringBuffer sb, long type);
	
	/**
	 * 
	* @Title: rightAdd 
	* @Description: 添加权限
	* @param rightinfo    参数 
	* void  返回类型 
	* @throws
	 */
	public void rightAdd(RightInfo rightinfo);
	
    /**
     * 
    * @Title: changeRoleRight 
    * @Description: 将某权限重新赋予给角色
    * @param roleId
    * @param rightId    参数 
    * void  返回类型 
    * @throws
     */
    public void changeRoleRight(long roleId[],long rightId);

}
