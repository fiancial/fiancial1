package com.xyy.springmvc.mybatis.beans;

/**
 * 
 * @概述：用户角色实体 内部用户角色实体和外部用户角色实体为同一个实体。
 * @author 陈建焜
 * @时间：2011-5-10
 */
public class UserRole
{
    @Override
	public String toString() {
		return "UserRole [userId=" + userId + ", userType=" + userType
				+ ", roleId=" + roleId + "]";
	}
	private Long userId; // 用户Id。
    private Integer userType; // 用户类型 1外部用户，2 内部用户
    private Long roleId; // 角色id
    
    public UserRole()
    {
    	super();
    }
    public UserRole(Long userId,Long roleId,Integer userType)
    {
    	super();
    	this.userId=userId;
    	this.roleId=roleId;
    	this.userType=userType;
    }
 
    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Integer getUserType()
    {
        return userType;
    }

    public void setUserType(Integer userType)
    {
        this.userType = userType;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }
    public boolean equals(Object object)
    {
    	UserRole ur =(UserRole)object;
    	if(this.roleId==ur.getRoleId()&&this.userId==ur.getUserId()&&this.userType==ur.getUserType())
    	{
    		return true;
    	}
    	return false;
    }
}
