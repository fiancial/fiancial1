package com.xyy.springmvc.mybatis.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyy.springmvc.mybatis.beans.RightInfo;
import com.xyy.springmvc.mybatis.beans.RoleRight;
import com.xyy.springmvc.mybatis.beans.UserRole;
import com.xyy.springmvc.mybatis.mapper.RightDao;
import com.xyy.springmvc.mybatis.mapper.RoleRightDao;
import com.xyy.springmvc.mybatis.mapper.UserRoleDao;
 

/**
* @ClassName: RightCache 
* @Description: 权限缓存集合
* @author chenjk
* @date 2014-11-12 下午3:11:48 
*
 */
@Service
public class RightCache {
	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(RightCache.class);

	
	/**
	 * 权限集合
	 * key:交易项id
	 * value:交易项对象
	 */
	public Map<Long, RightInfo> rightInfoMap = new HashMap<Long, RightInfo>();
	
	/**
	 * 权限集合
	 * key:权限路径
	 * value:权限对象
	 */
	public Map<String, RightInfo> rightInfoUrlMap = new HashMap<String, RightInfo>();

	/**
	 * 角色权限集合
	 * key:交易项id
	 * value:交易项对象
	 */
	public List<RoleRight> roleRights = new ArrayList<RoleRight>();
	
	/**
	 * 用户角色集合
	 * key:交易项id
	 * value:交易项对象
	 */
	public List<UserRole> userRoles = new ArrayList<UserRole>();

	@Autowired
	private RightDao rightDao;
	
	@Autowired
	private RoleRightDao roleRightDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	/**
	* @Title: initCache 
	* @Description: 初始化权限
	* @param     参数 
	* @return void    返回类型 
	* @throws
	 */
	public void initCache(){
		List<RightInfo> rlist = rightDao.findAllRight(-1);
		Map<String, Object> param = new HashMap<>();
    	param.put("roleId", -1);
    	//param.put("roleType", type);
		for(RightInfo ri : rlist){
			rightInfoMap.put(ri.getRightId(), ri);
			rightInfoUrlMap.put(ri.getAccessPath(), ri);
		}
		
		roleRights = roleRightDao.findRightListByRoleId(param);
		
		userRoles = userRoleDao.findUserRolesByUId(-1);
	}
	
	/**
	* @Title: getUserRight 
	* @Description: 取得用户所有权限
	* @param @param uid
	* @param @return    参数 
	* @return List<RightInfo>    返回类型 
	* @throws
	 */
	public List<RightInfo> getUserRights(long uid){
		List<RightInfo> res = new ArrayList<RightInfo>();
		Map<Long, Long> urmap= new HashMap<Long, Long>();
		for(UserRole ur : userRoles){
			if(ur.getUserId() == uid){
				urmap.put(ur.getRoleId(), ur.getRoleId());
			}
		}
		
		for(RoleRight rr : roleRights){
			if(urmap.containsKey(rr.getRoleId())){
				res.add(rightInfoMap.get(rr.getRightId()));
			}
		}
		return res;
	}
	
	/**
	* @Title: getUserRightsUrl 
	* @Description: 取得用户所有权限路径
	* @param @param uid
	* @param @return    参数 
	* @return List<RightInfo>    返回类型 
	* @throws
	 */
	public Map<String, RightInfo> getUserRightsUrl(long uid){
		Map<String, RightInfo> rightInfoUrlMap = new HashMap<String, RightInfo>();
		Map<Long, Long> urmap= new HashMap<Long, Long>();
		for(UserRole ur : userRoles){
			if(ur.getUserId() == uid){
				urmap.put(ur.getRoleId(), ur.getRoleId());
			}
		}
		
		for(RoleRight rr : roleRights){
			if(urmap.containsKey(rr.getRoleId())){
				RightInfo ri = rightInfoMap.get(rr.getRightId());
				if(ri != null){
					rightInfoUrlMap.put(ri.getAccessPath() ,ri);
				}
			}
		}
		return rightInfoUrlMap;
	}
	
	/**
	* @Title: getUserRight 
	* @Description: 取得用户所有权限
	* @param @param uid
	* @param @return    参数 
	* @return List<RightInfo>    返回类型 
	* @throws
	 */
	public String getUserRightStr(long uid){
		if(uid == 1){
			return "all";
		}
		StringBuffer sb = new StringBuffer();
		Map<Long, Long> urmap= new HashMap<Long, Long>();
		for(UserRole ur : userRoles){
			if(ur.getUserId() == uid){
				urmap.put(ur.getRoleId(), ur.getRoleId());
			}
		}
		
		for(RoleRight rr : roleRights){
			if(urmap.containsKey(rr.getRoleId())){
				RightInfo ri = rightInfoMap.get(rr.getRightId());
				if(ri != null){
					sb.append('|').append(ri.getRightCode()).append('|');
				}
				
			}
		}
		return sb.toString();
	}
	
	/**
	* @Title: validateRight 
	* @Description: 权限验证
	* @param @param url
	* @param @param uid
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean validateRight(String url, long uid){
		if(!rightInfoUrlMap.containsKey(url)){ //不需要拦截的路径
			return true;
		}
		Map<String, RightInfo> rmap = getUserRightsUrl(uid);
		if(rmap.containsKey(url)){
			return true;
		}
		return false;
	}
}
