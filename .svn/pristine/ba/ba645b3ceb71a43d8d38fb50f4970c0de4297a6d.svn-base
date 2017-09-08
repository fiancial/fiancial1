package com.xyy.springmvc.mybatis.beans;


/**
 * 
 * @概述：角色权限实体。
 * @author 陈建焜
 * @时间：2011-5-13 下午03:07:10
 */
public class RoleRight
{
    @Override
	public String toString() {
		return "RoleRight [roleId=" + roleId + ", rightId=" + rightId + "]";
	}
	private Long roleId;// 角色id。
    private Long rightId;// 权限id。
    
    public  RoleRight()
    {
    	
    }
    public  RoleRight(long roleId,long rightId)
    {
    	this.roleId = roleId;
    	this.rightId = rightId;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public Long getRightId()
    {
        return rightId;
    }

    public void setRightId(Long rightId)
    {
        this.rightId = rightId;
    }
    public boolean equals(RoleRight roleRight)
    {
    	boolean x = false;
    	if(this.roleId == roleRight.getRoleId() && this.rightId == roleRight.getRightId())
    	{x = true;}
    	return x;    	
    }

}
