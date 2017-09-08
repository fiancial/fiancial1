/**   
* @Title: RoleController.java 
* @Package com.sgfm.p2p.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 谢奇
* @date 2016年11月17日 下午4:54:04 
* @version V1.0   
*/
package com.xyy.springmvc.mybatis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyy.springmvc.mybatis.beans.RoleInfo;
import com.xyy.springmvc.mybatis.beans.RoleRight;
import com.xyy.springmvc.mybatis.services.RoleService;
import com.xyy.springmvc.mybatis.utils.DWZJsonResponseResult;
 

/** 
 * @ClassName: RoleController 
 * @Description: 角色操作的控制层
 * @author xieqi
 * @date 2016年11月17日 下午4:54:04 
 *  
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	private static Logger logger = Logger.getLogger(RoleController.class.getName());
	@Autowired
	private RoleService roleservice; 
	
	@RequestMapping("/roleList")
	public  String  roleList(RoleInfo roleinfo,HttpServletRequest request)
	{
		List<RoleInfo> rolelist = roleservice.findAllRole(roleinfo);
		request.setAttribute("roleList",rolelist);
		return toPage("role","roleList");
	}	
	
	/**
	 * 
	* @Title: toRoleAddPage 
	* @Description: 返回添加角色的页面 
	* @param request
	* @return    参数 
	* String  返回类型 
	* @throws
	 */
	@RequestMapping("/toRoleAddPage")
	public  String  toRoleAddPage(HttpServletRequest request)
	{
		List<RoleInfo> rolelist2 = roleservice.findAllRole();
		request.setAttribute("roleList2",rolelist2); 
		return toPage("role","roleAdd");
	}
	/**
	 * 
	* @Title: roleAdd 
	* @Description: 新增角色
	* @param roleInfo
	* @param request
	* @param response    参数 
	* void  返回类型 
	* @throws
	 */
	@RequestMapping("/roleAdd")
	public  void  roleAdd(RoleInfo roleInfo,HttpServletRequest request,HttpServletResponse response)
	{
		roleservice.addRole(roleInfo);
		DWZJsonResponseResult json = DWZJsonResponseResult.initSuccess();
		json.setNavTabId("roleList");
		jsonToPage(json.toJSONString(),response);
	}
	/**
	 * 
	* @Title: toRoleUpdatePage 
	* @Description: 跳转到角色修改的页面
	* @param id
	* @param request
	* @return    参数 
	* String  返回类型 
	* @throws
	 */
	@RequestMapping("/toRoleUpdatePage")
	public  String  toRoleUpdatePage(long id,HttpServletRequest request)
	{
		
		
		RoleInfo role = roleservice.findRoleById(id);
		request.setAttribute("role", role);
		
		RoleInfo r = new RoleInfo();
		r.setRoleState(1L);
		request.setAttribute("roleList",roleservice.findAllRole(r));
		
		return toPage("role","roleUpdate");
	}
	/**
	 * 
	* @Title: roleUpdate 
	* @Description: 修改角色信息
	* @param roleInfo
	* @param request
	* @param response    参数 
	* void  返回类型 
	* @throws
	 */
	@RequestMapping("/roleUpdate")
	public  void  roleUpdate(RoleInfo roleInfo,HttpServletRequest request,HttpServletResponse response)
	{
		roleservice.updateRole(roleInfo);
		DWZJsonResponseResult json = DWZJsonResponseResult.initSuccess();
		json.setNavTabId("roleList");
		jsonToPage(json.toJSONString(),response);
	}
	
	/**
	 * 
	* @Title: changeRoleState 
	* @Description: 切换角色状态（可用/停用）    参数 
	* void  返回类型 
	* @throws
	 */
	@RequestMapping("/changeRoleState")
	public  void   changeRoleState(RoleInfo roleInfo,HttpServletRequest request,HttpServletResponse response)
	{
		//sta; 0:未使用; 1:使用中;
		Integer sta=0;
		
		/*List<FlowNode> nodelist = templateDao.findnodes(null);
		for(FlowNode node:nodelist)
		{
			Long i = new Long(node.getRoleId());
			if(i==roleInfo.getRoleId())
			{
				sta=1;
				break;
			}
		}*/
		
		if(sta==0)
		{	
			roleservice.changeRoleState(roleInfo);
		}
		DWZJsonResponseResult json = DWZJsonResponseResult.initSuccess();
		json.addData(sta);
		jsonToPage(json.toJSONString(),response);
	}
	
	/**
	 * 
	* @Title: chooseright 
	* @Description: 返回可多选的权限树
	* @param roleinfo
	* @param request
	* @return    参数 
	* String  返回类型 
	* @throws
	 */
	@RequestMapping("/chooseright")
	public  String chooseright(RoleInfo roleinfo,HttpServletRequest request)
	{
		StringBuffer sb1 =new StringBuffer();
		roleservice.chooseRightTree(0, sb1, 1, roleinfo.getRoleId());
		request.setAttribute("chooseRightTree1", sb1);
		
		StringBuffer sb2 =new StringBuffer();
		roleservice.chooseRightTree(0, sb2, 2, roleinfo.getRoleId());
		request.setAttribute("chooseRightTree2", sb2);
		
		StringBuffer sb3 =new StringBuffer();
		roleservice.chooseRightTree(0, sb3, 3, roleinfo.getRoleId());
		request.setAttribute("chooseRightTree3", sb3);
		
		StringBuffer sb4 =new StringBuffer();
		roleservice.chooseRightTree(0, sb4, 4, roleinfo.getRoleId());
		request.setAttribute("chooseRightTree4", sb4);
		
		request.setAttribute("roleInfo",roleinfo);
		return toPage("right","rightTreeChoose");
	}
	/**
	 * 
	* @Title: changeRoleRight 
	* @Description: 赋给角色新的 角色权限关系；由rolelist 分配权限 跳转过来；
	* @param rightId
	* @param roleIds
	* @param request
	* @param response    参数 
	* void  返回类型 
	* @throws
	 */ 
	@RequestMapping("/changeRoleRight")
	public  void changeRoleRight(long rightId[],long roleIds,HttpServletRequest request,HttpServletResponse response)
	{
		
		if(rightId[0]!=0)
		{
			List<RoleRight> roleRightList = new ArrayList<>();
			for(long r:rightId)
			{
				roleRightList.add(new RoleRight(roleIds,r));			
			}
			roleservice.changeRoleRight(roleRightList, roleIds);
		}
		else
		{
			roleservice.delRoleRightByRId(roleIds);
		}
		DWZJsonResponseResult json = DWZJsonResponseResult.initSuccess();
		json.setNavTabId("roleList");
		jsonToPage(json.toJSONString(),response);
	}
	/**
	 * 
	* @Title: chooseRoleTree 
	* @Description: 显示可以选择的角色树
	* void  返回类型 
	* @throws
	 */
	@RequestMapping("/chooseRoleTree")
	public void chooseRoleTree(HttpServletRequest request)
	{
		StringBuffer rolesb =new StringBuffer();
		roleservice.roleTree(rolesb, -1);
		request.setAttribute("roleTree", rolesb);
	}
}
