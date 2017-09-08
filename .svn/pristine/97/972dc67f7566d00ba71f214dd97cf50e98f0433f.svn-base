package com.xyy.springmvc.mybatis.mapper;

import java.util.List;
import java.util.Map; 

import com.xyy.springmvc.mybatis.beans.RightInfo;

/**
 * 
 * @概述：权限管理持久化层对象
 * @author 陈建焜
 * @时间：2011-5-11 下午06:31:56
 */

public interface RightDao{
    /**
     * 增加权限<br/>
     * 
     * @param
     * @return
     */
    public void addRight(RightInfo rightInfo);

    /**
     * 删除权限
     * 
     * @param
     * @return
     */
    public void delRightById(Long rightId);

    /**
     * 修改权限
     * 
     * @param
     * @return
     */
    public void updRightInfo(RightInfo rightInfo);

    /**
     * 查询权限
     * 
     * @param
     * @return
     */
    public RightInfo findRightById(Long rightId);

    /**
     * 根据权限的id获取权限的直接下级权限列表。
     * 
     * @param rightId
     * @return
     */
    public List<RightInfo> findAllRightByParentId(Map<String, Object> param);

    /**
     * 根据权限类型获取所有的权限。
     * 
     * @param rightType 为权限类型。1：交易系统类型 2：管理系统类型
     * @return
     */
    public List<RightInfo> findAllRight(int rightType);

    /**
     * 获取序列
     * 
     * @return
     */
    public Long getSqe();

    /**
     * 根据权限码查找权限列表。
     * 
     * @param rightInfo
     * @return
     */
    public List<RightInfo> findAllRightByCode(RightInfo rightInfo);

    /**
     * 根据权限名查找权限列表。
     * 
     * @param rightInfo
     * @return
     */
    public List<RightInfo> findAllRightByName(RightInfo rightInfo);
    
    /**
     * 根据权限id获取权限的所有下级信息
     * 
     * @param parentId
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<RightInfo> findRolesByIdForAllSubordinate(Long rightId);

    /**
     * 根据角色的id获取权限的直接下级权限列表。
     * 
     * @param rightId
     * @return
     */
    public List<RightInfo> findRightsByRole(Long roleId);
    
    /**
     * 
    * @Title: findAllRightInfo 
    * @Description: 返回所有权限信息
    * @return    参数 
    * List<RightInfo>  返回类型 
    * @throws
     */
    public List<RightInfo> findAllRightInfo();
    
    /**
     * 
    * @Title: insertRightInfo 
    * @Description: 添加权限信息     参数 
    * void  返回类型 
    * @throws
     */
    public void insertRightInfo();
    
    /**
     * 
    * @Title: updateRightInfo 
    * @Description: 修改权限信息     参数 
    * void  返回类型 
    * @throws
     */
    public void updateRightInfo();
    
    /**
     * 
    * @Title: deleteRightInfo 
    * @Description: 删除权限     参数 
    * void  返回类型 
    * @throws
     */
    public void deleteRightInfo();
   
}
