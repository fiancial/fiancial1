package com.xyy.springmvc.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.xyy.springmvc.mybatis.beans.RightInfo;
import com.xyy.springmvc.mybatis.beans.RoleInfo;
 

/**
 * 
 * @概述：角色管理持久化层对象。
 * @author 陈建焜
 * @时间：2011-5-13 上午10:58:21
 */

public interface RoleDao

{

    /**
     * 根据角色类型参数，获取所有角色。
     * 
     * @param roleType 1：交易系统类型角色 2：管理系统类型角色 3：运作团队角色。
     * @return
     */
    public List<RoleInfo> findAllRoleByType(int type);
    
    /**
     * 根据角色类型参数，获取所有角色。
     * 
     * @param roleType 1：交易系统类型角色 2：管理系统类型角色 3：运作团队角色。
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<RoleInfo> findUserRoles(long uid);

    /**
     * 根据角色Id获取角色信息。
     * 
     * @param roleId
     * @return
     */
    @SuppressWarnings("unchecked")
    public RoleInfo findRoleById(Long roleId);

    /**
     * 根据角色id获取所有的下级角色。
     * 
     * @param parentId
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<RoleInfo> findRolesByParentId(Long parentId);
    //根据角色id获取对应状态的所有下级角色。
 /*   @SuppressWarnings("unchecked")
    public List<RoleInfo> findRolesByParentId(Long parentId,Long roleState);*/

    /**
     * 根据角色id获取角色拥有的权限。
     * 
     * @param roleId
     * @return
     */
    public List<RightInfo> findRightListByRoleId(String roleId);

    /**
     * 修改角色基本属性信息。
     * 
     * @param
     * @return
     */
    public void updRole(RoleInfo roleInfo);
    /**
     * 删除角色基本信息
     * 
     * @param
     * @return
     */
    public void delRoleById(Long roleId);

    /**
     * 新增角色。
     * 
     * @param
     * @return
     */
    public void addRole(RoleInfo roleInfo);

    /**
     * 获取序列
     * 
     * @return
     */
    public Long getSqe();

    /**
     * 根据角色名获取角色信息
     * 
     * @param parentId
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<RoleInfo> findRolesByName(RoleInfo role);
    
    /**
     * 根据角色名获取角色信息
     * 
     * @param parentId
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<RoleInfo> findRolesByZHName(RoleInfo role);
    
    /**
     * 根据权限ID获取角色信息
     * 
     * @param parentId
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<RoleInfo> selectRightRole(Map<String, Object> param);
    
    
    
    /**
     * 删除用户的角色。
     * 
     * @param userId
     * @return
     */
    public void delUserRole(long uid);
    
   /**
    * 
   * @Title: findAllrole 
   * @Description: 返回所有角色
   * @return    参数 
   * List<RoleInfo>  返回类型 
   * @throws
    */
    public List<RoleInfo> findAllRole();
    public List<RoleInfo> findAllRole(RoleInfo roleinfo);

    /**
     * 
    * @Title: updateRole 
    * @Description: 修改角色
    * @param roleinfo    参数 
    * void  返回类型 
    * @throws
     */
    public void updateRole(RoleInfo roleinfo);
    
    /**
     * 
    * @Title: changeRoleState 
    * @Description: 改变角色的状态（可用/停用）
    * @param roleinfo    参数 
    * void  返回类型 
    * @throws
     */
    public void changeRoleState(RoleInfo roleinfo);
}
