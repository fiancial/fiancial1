package com.xyy.springmvc.mybatis.services;

import com.xyy.springmvc.mybatis.beans.Ruleitem;
 

/**
 * 
* @ClassName: ISRuleitemService
* @Description: 基础规则项Service
* @author klj
* @date 2016年11月12日 下午5:03:25 
*
 */
public interface IRuleitemService {
	/**
	 * 
	* @Title: addRuleitem 
	* @Description: 添加基础规则项数据方法
	* @param ruleitem
	* @return    参数 
	* int  返回类型 
	* @throws
	 */
	int addRuleitem(Ruleitem ruleitem);
}
