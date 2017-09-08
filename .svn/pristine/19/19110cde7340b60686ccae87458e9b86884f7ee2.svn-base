package com.xyy.springmvc.mybatis.mapper;

import java.util.List;

import com.xyy.springmvc.mybatis.beans.UserRole;
 

/**
 * 
 * @概述：用户角色Dao，内部用户和外部用户公用。
 * @author 陈建焜
 * @时间：2011-5-16 下午02:08:59
 */

public interface UserRoleDao
{
    /**
     * 设置用户的角色。
     * 
     * @param userRoleList
     */
    public void addUserRole(UserRole userRole);
    /**
     * 
     * @Title: findUserRolesByUId 
     * @Description: 通过用户id获取用户角色关系
     * @param userId    参数 
     * List<UserRole>  返回类型 
     * @throws
     */
    public List<UserRole> findUserRolesByUId(long userId);

    /**
     * @获取用户的角色
     * @param outsideUserList
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<UserRole> findUserRoles(long userRole);

    /**
     * 删除用户的角色。
     * 
     * @param userId
     * @return
     */
    public void delUserRole(UserRole userRole);

    /**
     * 根据角色id删除所有用户拥有的该角色。
     * 
     * @param roleId
     * @return
     */
    public void delUserRoleByRId(final Long roleId);
    /**
     * 
     * @Title: delUserRoleByUId 
     * @Description: 根据用户id删除该用户所有角色
     * @param userId    参数 
     * void  返回类型 
     * @throws
     */
    public void delUserRoleByUId(final Long userId);
    /**
     * @Title: addBatchUserRole 
     * @Description: 批量新增用户角色
     * @param @param urls    参数 
     * @return void    返回类型 
     * @throws
      */
     public void addBatchUserRole(final List<UserRole> urls);
}
