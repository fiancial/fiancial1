package com.xyy.springmvc.mybatis.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyy.springmvc.mybatis.services.SystemUserService;
import com.xyy.springmvc.mybatis.utils.PageBean;
import com.xyy.springmvc.mybatis.beans.SystemUser;
import com.xyy.springmvc.mybatis.mapper.*;

/**
* @ClassName: SystemUserServiceImpl 
* @Description: 系统用户操作实体类
* @author lvjian
* @date 2016年10月24日 下午14:34:56 
*/
@Service
public class SystemUserServiceImpl implements SystemUserService{

	@Autowired
	private SystemUserDao systemUserDao;
	
	/**
	 * @Title: addSystemUser 新增系统用户
	 * @param systemUser 新增的系统用户对象
	 * void 返回类型
	 * @throws
	 */
	@Override
	public void addSystemUser(SystemUser systemUser) {
		systemUserDao.addSystemUser(systemUser);
	}

	/**
	 * @Title: delSystemUser 删除系统用户
	 * @param param 按条件删除
	 * void 返回类型
	 * @throws
	 */
	@Override
	public void delSystemUser(Map<String, Object> param) {
		systemUserDao.delSystemUser(param);
	}

	/**
	 * @Title: updSystemUser 修改系统用户
	 * @param systemUser 
	 * void 返回类型
	 * @throws
	 */
	@Override
	public void updSystemUser(SystemUser systemUser) {
		systemUserDao.updSystemUser(systemUser);
	}

	/**
	 * @Title: findSystemUser
	 * @Description: 按条件返回系统用户信息
	 * @param param 查询条件
	 * @return List<SystemUser> 返回类型 
	 * @throws
	 */
	@Override
	public List<SystemUser> findSystemUser(Map<String, Object> param) {
		return systemUserDao.findSystemUser(param);
	}

	/**
	 * @Title: findSystemUserPage
	 * @Description: 按条件返回系统用户信息 分页
	 * @param param  查询条件
	 * @return List<SystemUser> 返回类型 
	 * @throws
	 */
	@Override
	public List<SystemUser> findSystemUserPage(Map<String, Object> param,
			PageBean pageBean) {
		pageBean.initMap(param);
		int total = systemUserDao.countSystemNums(param);
		if(total>0){
			pageBean.setTotalRows(systemUserDao.countSystemNums(param));
			pageBean.repaginate();
			return systemUserDao.findSystemUserPage(param);
		}
		
		return new ArrayList<>();
	}

}
