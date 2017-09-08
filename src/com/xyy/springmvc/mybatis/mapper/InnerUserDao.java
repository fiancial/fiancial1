package com.xyy.springmvc.mybatis.mapper;

import java.util.List;
import java.util.Map;
 

import com.xyy.springmvc.mybatis.beans.InnerUser;
 

/**
 * 内部用户管理持久层。
 * 
 * @author liuchong
 *@date 2011/5/30
 */

public interface InnerUserDao
{
    /**
     * 内部用户新增
     */
    public int addInnerUser(InnerUser innerUser);

    /***
     * 删除内部用户，系统采取逻辑删除还是物理删除，需要定版（这里考虑提供批量删除批量删除的权限太大，具有危险性），
     */
    public int delInnerUser(long innerUserId);

    /**
     * 根据条件查询所有相关的内部用户
     */
    public List<InnerUser> findAllInnerUserList(Map<String, Object> param);
    /*
     * 根据条件查询用户数量
     */
    public int countInnerUser(Map<String, Object> param);

    /**
     * 根据用户ID获取该用户信息。
     */
    public InnerUser getInnerUserById(long innerUserId);

    /** 获取内部用户序列号 */
    public long getInnerUserSeq();

    /** 获取序列号 */
    public int getInnerUserThirdPartySeq();

    /**
     * 修改内部用户信息资料. 包括设计内部用户的启用状态为：启用/停用
     */
    public int updInnerUser(InnerUser innerUser);

    /**
     * 根据用户登录名获取该用户信息。
     * 
     * @param innerUser
     * @return
     */
    public List<InnerUser> findInnerUserByLoginName(InnerUser innerUser);


    /**
     * 验证输入的会员账户是否为外部用户
     */
    public int checkUserInfoThirdParty(String loginName);

    /**
     * 删除指定的会员账户
     */
    public int delThirdPartyById(Long tpId);
    
   

    /**
     * 删除当前内部用户下所有会员数据
     * */
    public int delAllDict(Long innerUserId);

}
