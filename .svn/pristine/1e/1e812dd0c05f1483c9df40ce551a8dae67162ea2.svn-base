package com.xyy.springmvc.mybatis.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyy.springmvc.mybatis.beans.Ruleinfo;
import com.xyy.springmvc.mybatis.mapper.*;
import com.xyy.springmvc.mybatis.services.IRuleinfoService;
import com.xyy.springmvc.mybatis.utils.PageBean;
 
@Service("ruleinfoService")
public class RuleinfoServiceImpl implements IRuleinfoService {

	@Autowired
	public RuleinfoDao ruleinfoDao;

	/**
	 * 
	* @Title: findRuleinfo 
	* @Description:  分页查询所有的规则组信息
	* @param param
	* @return    参数 
	* List<Rulegrop>  返回类型 
	* @throws
	 */
	@Override
	public List<Ruleinfo> findRuleinfopage(Map<String, Object> param,PageBean pageBean){
		pageBean.initMap(param);
		int tocount= ruleinfoDao.Rulecount(param);
		pageBean.setTotalRows(tocount);
		if(tocount > 0){
			return ruleinfoDao.findRuleinfopage(param);
		}
		return null;
	}
	
	/**
	 * 
	* @Title: findRuleinfo 
	* @Description: 查询所有基础规则组数据
	* @param param
	* @return    参数 
	* List<Rulegrop>  返回类型 
	* @throws
	 */
	@Override
	public List<Ruleinfo> findRuleinfo(Map<String, Object> param) {
		return ruleinfoDao.findRuleinfo(param);
	}

	/**
	 * 
	* @Title: delRuleinfo 
	* @Description: 删除基础规则组数据
	* @param param
	* @return    参数 
	* int  返回类型 
	* @throws
	 */
	@Override
	public int delRuleinfo(Map<String, Object> param) {
		return ruleinfoDao.delRuleinfo(param);
	}

	/**
	 * 
	* @Title: addRuleinfo 
	* @Description: 添加规则信息的方法
	* @param rulegrop
	* @return    参数 
	* int  返回类型 
	* @throws
	 */
	@Override
	public int addRuleinfo(Ruleinfo ruleinfo) {
		return ruleinfoDao.addRuleinfo(ruleinfo);
	}


	
}
