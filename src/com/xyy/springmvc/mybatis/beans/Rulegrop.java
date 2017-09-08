package com.xyy.springmvc.mybatis.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
* @ClassName: Rulegrop 
* @Description: 基础规则组实体类
* @author klj
* @date 2016年11月1日 下午3:56:22 
*
*/
public class Rulegrop {
	
	private String rgGroupNo; //规则组编号
	private String rgDesc;    //描述
	private String rgStatus;  //状态
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")	
	private Date rgMtnDate;   //维护日期
	private String rgOprId;   //维护操作人员
	private Integer coun;     //纪录有多少条数据
	
	private String dates;
	
	public String getRgGroupNo() {
		return rgGroupNo;
	}

	public void setRgGroupNo(String rgGroupNo) {
		this.rgGroupNo = rgGroupNo;
	}


	public String getRgDesc() {
		return rgDesc;
	}


	public void setRgDesc(String rgDesc) {
		this.rgDesc = rgDesc;
	}


	public String getRgStatus() {
		return rgStatus;
	}


	public void setRgStatus(String rgStatus) {
		this.rgStatus = rgStatus;
	}


	public Date getRgMtnDate() {
		return rgMtnDate;
	}


	public void setRgMtnDate(Date rgMtnDate) {
		this.rgMtnDate = rgMtnDate;
	}


	public String getRgOprId() {
		return rgOprId;
	}


	public void setRgOprId(String rgOprId) {
		this.rgOprId = rgOprId;
	}


	public Integer getCoun() {
		return coun;
	}


	public void setCoun(Integer coun) {
		this.coun = coun;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Override
	public String toString() {
		return "Rulegrop [rgGroupNo=" + rgGroupNo + ", rgDesc=" + rgDesc
				+ ", rgStatus=" + rgStatus + ", rgMtnDate=" + rgMtnDate
				+ ", rgOprId=" + rgOprId + ", coun=" + coun + ", dates="
				+ dates + "]";
	}

}
