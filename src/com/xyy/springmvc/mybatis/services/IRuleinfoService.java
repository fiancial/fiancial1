package com.xyy.springmvc.mybatis.services;

import java.util.List;
import java.util.Map;

import com.xyy.springmvc.mybatis.beans.Ruleinfo;
import com.xyy.springmvc.mybatis.utils.PageBean;


public interface IRuleinfoService {
	
	/**
	 * 
	* @Title: findRuleinfo 
	* @Description:  分页查询所有的规则组信息
	* @param param
	* @return    参数 
	* List<Rulegrop>  返回类型 
	* @throws
	 */
	List<Ruleinfo> findRuleinfopage(Map<String, Object> param,PageBean pageBean);
	
	/**
	 * 
	* @Title: findRuleinfo 
	* @Description:  查询所有的规则组信息
	* @param param
	* @return    参数 
	* List<Rulegrop>  返回类型 
	* @throws
	 */
	List<Ruleinfo> findRuleinfo(Map<String, Object> param);
	
	
	/**
	 * 
	* @Title: delRuleinfo 
	* @Description: 删除基础规则组数据
	* @param param
	* @return    参数 
	* int  返回类型 
	* @throws
	 */
	int delRuleinfo(Map<String, Object> param);
	
	/**
	 * 
	* @Title: findsq 
	* @Description: 自动生成编号 
	* @return    参数 
	* String  返回类型 
	* @throws
	 */
	//String findsq();
	
	/**
	 * 
	* @Title: addRule 
	* @Description: 添加规则信息的方法
	* @param rulegrop
	* @return    参数 
	* int  返回类型 
	* @throws
	 */
	int addRuleinfo(Ruleinfo ruleinfo);
	
	/**
	 * 
	* @Title: updateRule 
	* @Description: 修改规则组信息方法
	* @return    参数 
	* int  返回类型 
	* @throws
	 */
	//int updateRule(Rulegrop rulegrop);
}
