package com.xyy.springmvc.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.xyy.springmvc.mybatis.beans.RoleRight;
 

/**
 * 
 * @概述：角色权限持久化层对象。此Dao为内部用户和外部用户公用。
 * @author 陈建焜
 * @时间：2011-5-16 上午10:56:11
 */

public interface RoleRightDao
{
    /**
     * 根据角色id获取角色拥有的权限。
     * 
     * @param roleId
     * @return
     */
    public List<RoleRight> findRightListByRoleId(Map<String, Object> param);

    /**
     * 删除角色所拥有的权限。
     * 
     * @param roleId
     * @return
     */
    public void delRoleRight(Long roleId);

    /**
     * 根据权限id删除关联该权限的角色关联数据<br/>
     * 
     * @param rightId
     * @return
     */
    public void delRoleRightByRightId(Long rightId);
    /**
     * 创建角色拥有的权限。
     * 
     * @param roleRightList
     * @return
     */
    
    public void addRoleRight(RoleRight roleRight);
    
    /**
     * 
    * @Title: findRightListByRightId 
    * @Description: 通过权限id找到对应的角色
    * @param param    参数 
    * void  返回类型 
    * @throws
     */
    public void findRightListByRightId(Map<String,Object> param);
    
    /**
     * @Title: addBatchRoleRight 
     * @Description: 批量新增角色的权限
     * @param @param urls    参数 
     * @return void    返回类型 
     * @throws
      */
     public void addBatchRoleRight(RoleRight roleright);
     
     /**
      * 
     * @Title: deleteBatchRoleRight 
     * @Description: 批量删除角色权限
     * @param urls    参数 
     * void  返回类型 
     * @throws
      */
     public void deleteBatchRoleRight(List<RoleRight> urls);
     /**
      * 
     * @Title: delRoleRightByRId 
     * @Description: 通过角色id删除角色所有权限
     * @param roleId    参数 
     * void  返回类型 
     * @throws
      */
     public  void  delRoleRightByRId(long roleId);
     /**
      * 
     * @Title: findRoleRightByRightId 
     * @Description:  通过权限id找到该权限的角色权限关系 
     * @param rightId    参数 
     * void  返回类型 
     * @throws
      */
     public List<RoleRight>  findRoleRightByRightId(Map<String,Object> param);
}
