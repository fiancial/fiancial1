package com.xyy.springmvc.mybatis.services.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyy.springmvc.mybatis.beans.RightInfo;
import com.xyy.springmvc.mybatis.beans.RoleRight;
import com.xyy.springmvc.mybatis.mapper.RightDao;
import com.xyy.springmvc.mybatis.mapper.RoleRightDao;
import com.xyy.springmvc.mybatis.services.IRightService;
 
@Service("rightservice")
public class RightServiceImpl implements IRightService{


	@Autowired
	private RightDao rightDao;// 数据授权、操盘授权dao。
	@Autowired
	private RoleRightDao roleRightDao;
	/**
	* @Title: findRightsByRole 
	* @Description: 获取角色的权限
	* @param @param roleId
	* @param @return    参数 
	* @return List<RightInfo>    返回类型 
	* @throws
	 */
	public List<RightInfo> findRightsByRole(Long roleId){
		return rightDao.findRightsByRole(roleId);
	}
	
	/**
     * 
     * 权限树
     * 〈功能详细描述〉
     * 
     */
    public void initAuthsTree(long superId, StringBuffer sb, long type){
    	Map<String, Object> param = new HashMap<>();
    	param.put("rightId", superId);
    	param.put("rightType", type);
        List<RightInfo> alist = rightDao.findAllRightByParentId(param);
        for(RightInfo auth : alist){
        	param.put("rightId", auth.getRightId());
            List<RightInfo> olist = rightDao.findAllRightByParentId(param);
            if(olist.size()>0){
                sb.append("<li>");
                sb.append("<a onclick='findRole("+ auth.getRightId()+",this)' &type="+type +"' target='ajax' rel='authJbsxBox' tname='authName' >"+auth.getRightName()+"</a>");
                sb.append("<ul>");
                initAuthsTree(auth.getRightId(), sb, type);
                sb.append("</ul>");
                sb.append("</li>");
            } else{
                sb.append("<li>");
                sb.append("<a onclick='findRole("+ auth.getRightId()+",this)' &type="+type +"' target='ajax' rel='authJbsxBox' tname='authName' >"+auth.getRightName()+"</a>");
                sb.append("</li>");
                initAuthsTree(auth.getRightId(), sb, type);
            }
        }
    }
    
    /**
    * @Title: getAuthTree 
    * @Description: 取得权限树
    * @param @return    参数 
    * @return String    返回类型 
    * @throws
     */
    public String getAuthTree(long type){
    	StringBuffer sb = new StringBuffer();
		initAuthsTree(0, sb, type); 
		return sb.toString();
    }

	/**
	 *  返回所有权限信息
	 */
	@Override
	public List<RightInfo> findAllRightInfo() {	
		return  rightDao.findAllRightInfo();
	}
	/**
	 * 
	* @Title: rightAdd 
	* @Description: 增加权限
	* @param rightinfo    参数 
	* void  返回类型 
	* @throws
	 */
	public void rightAdd(RightInfo rightinfo){
		rightDao.addRight(rightinfo);
	}
	
	public void changeRoleRight(long roleId[],long rightId)
	{
		Map<String,Object> param= new HashMap<>();
		param.put("rightId", rightId);
		List<RoleRight> formerRoleRight =roleRightDao.findRoleRightByRightId(param);
		List<RoleRight> roleRightList =new ArrayList<>();
		for(int i = 0; i<roleId.length; i++ )
		{
			roleRightList.add(new RoleRight(roleId[i],rightId));
		}
		try{
		    for(RoleRight r: roleRightList)
		    {
		    	if(false==formerRoleRight.contains(r))
		    	{
		    		roleRightDao.addBatchRoleRight(r);
		    	}	    	
		    }
		}catch(NullPointerException e){	
		}
		
		try{
		    List<RoleRight> wantToDelete =new ArrayList<>();
		    for(RoleRight r: formerRoleRight)
		    {
		    	if(false==roleRightList.contains(r))
		    	{
		    		wantToDelete.add(r);
		    	}
		    }
		    roleRightDao.deleteBatchRoleRight(wantToDelete);
		}catch(NullPointerException e){
		}
	}
}
