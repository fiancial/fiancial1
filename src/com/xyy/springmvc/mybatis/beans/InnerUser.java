package com.xyy.springmvc.mybatis.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



/**
 * 内部用户
 * 
 * @author 
 * @2013-6-14
 */
public class InnerUser{
	//private Integer userId;// 用户编号
	private String userUTC="GMT+8";
	private Long innerUserId;// 用户编号
    private String loginName;// 用户登录名
    private String userName;// 用户名称
    private Integer sex;// 用户性别 1：男，2：女
    private Integer certificateType;// 证件类型 0：身份证；1：工作证 ；2：其他证件
    private String certificateNo;// 证件编号
    private String concatPhone;// 联系电话
    private String emergencyConcatName;// 紧急联系人
    private String emergencyConcatPhone;// 紧急联系电话
    private Integer userType;// 用户类型
    private Integer status;// 用户状态 1.正常 2.删除
    private String userPwd;// 用户密码
    private Date createDate;//创建时间
    private Date loginDate;//登陆时间
    private Integer boundSys;//绑定登陆系统：0(所有系统),1(操盘),2(数据中心)
    private Integer loginStatus;// 登录状态 1：已登录 0：未登录
    private Double canbet;// 是否可在第三方下注,0-否,1-是
    private int nums;//    
    public String rightCode;//
    
	public Long getInnerUserId()
    {
        return innerUserId;
    }

    public Integer getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(Integer loginstatus) {
		this.loginStatus = loginstatus;
	}

	public Double getCanbet() {
		return canbet;
	}

	public void setCanbet(Double canbet) {
		this.canbet = canbet;
	}

	public void setInnerUserId(Long innerUserId)
    {
        this.innerUserId = innerUserId;
    }

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getCertificateNo()
    {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo)
    {
        this.certificateNo = certificateNo;
    }

    public String getConcatPhone()
    {
        return concatPhone;
    }

    public void setConcatPhone(String concatPhone)
    {
        this.concatPhone = concatPhone;
    }

    public String getEmergencyConcatName()
    {
        return emergencyConcatName;
    }

    public void setEmergencyConcatName(String emergencyConcatName)
    {
        this.emergencyConcatName = emergencyConcatName;
    }

    public String getEmergencyConcatPhone()
    {
        return emergencyConcatPhone;
    }

    public void setEmergencyConcatPhone(String emergencyConcatPhone)
    {
        this.emergencyConcatPhone = emergencyConcatPhone;
    }

    public String getUserPwd()
    {
        return userPwd;
    }

    public void setUserPwd(String userPwd)
    {
        this.userPwd = userPwd;
    }
    
    public String getSexStr()
    {
    	return sex==1?"男":"女";
    }
    
    public Integer getSex()
    {
        return sex;
    }

    public void setSex(Integer sex)
    {
        this.sex = sex;
    }

    public Integer getCertificateType()
    {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType)
    {
        this.certificateType = certificateType;
    }

    public Integer getUserType()
    {
        return userType;
    }

    public void setUserType(Integer userType)
    {
        this.userType = userType;
    }

    public String getStatusStr()
    {
    	return status==1?"停用":"启用";
    }
    
    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }
	
	public String getUserUTC() {
		return userUTC;
	}
	public void setUserUTC(String userUTC) {
		this.userUTC = userUTC;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}
	
	public String getBoundSysStr() 
	{
		if(boundSys==0){return "所有系统";}
		else{return boundSys==1?"操盘":"数据中心";}
	}
	public Integer getBoundSys() {
		return boundSys;
	}

	public void setBoundSys(Integer boundsys) {
		this.boundSys = boundsys;
	}

	public String getCreateDateStr()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  		 
		String str=sdf.format(this.createDate);  		
 		return str;
		
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getRightCode() {
		return rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}
	
}
