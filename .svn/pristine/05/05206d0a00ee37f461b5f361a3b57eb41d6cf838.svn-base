package com.xyy.springmvc.mybatis.beans;


/**
 * 
 * @概述：角色实体
 * @author 陈建焜
 * @时间：2011-5-12 下午03:49:54
 */
public class RoleInfo {
	
	@Override
	public String toString() {
		return "RoleInfo [roleId=" + roleId + ", roleName=" + roleName
				+ ", parentId=" + parentId + ", roleType=" + roleType
				+ ", roleDesc=" + roleDesc + ", distribution=" + distribution
				+ ", roleState=" + roleState + ", parentName=" + parentName
				+ "]";
	}

	private static final long serialVersionUID = 1L;
    private Long roleId;// 角色id。
    /** 角色名称 */

    private String roleName;// 角色名称。
    private Long parentId;// 父id。
    private Integer roleType;// 1 操盘系统 2：数据中心 3：管理中心。
    private String roleDesc;// 角色说明
    private int distribution;
    private Long roleState;//角色状态：1.启用，2.停用
    private String parentName;//父名称
    public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    public Integer getRoleType(){
    	return roleType;
    }
    
    public String getRoleTypeString() {
    	String s ="";
    	if(roleType == 1 )
    		s += "操盘系统";
    	if(roleType == 2 )
    		s += "数据中心";
    	if(roleType == 3 )
        	s += "管理中心";
        return s;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

	public int getDistribution() {
		return distribution;
	}

	public void setDistribution(int distribution) {
		this.distribution = distribution;
	}
	
	public void setRoleState(Long roleState) {
	    this.roleState = roleState;
	}

	public Long getRoleState() {
	    return roleState;
	}
	
	public String getRoleStateString(){
		String s= "";
		if(roleState == 1L)
			s += "停用";
		if(roleState == 2L)
			s += "启用";
		return s;
	}
}
