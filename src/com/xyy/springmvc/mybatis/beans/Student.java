package com.xyy.springmvc.mybatis.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * @ClassName: Student 
 * @Description: 学生�?
 *
 */
public class Student {
	
	private Integer id;//学生编号
	
	private String stuName;//姓名
	
	private String password;//密码
	
	private Integer age;//年龄
	
	private Integer sex;//性别
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dt;

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", password="
				+ password + ", age=" + age + ", sex=" + sex + ", dt=" + dt
				+ "]";
	}

	 

}
