package com.xyy.springmvc.mybatis.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyy.springmvc.mybatis.beans.RightInfo;
import com.xyy.springmvc.mybatis.beans.RoleRight;
import com.xyy.springmvc.mybatis.mapper.RightDao;
import com.xyy.springmvc.mybatis.mapper.RoleRightDao;
import com.xyy.springmvc.mybatis.services.IRightService;
import com.xyy.springmvc.mybatis.services.RoleService;
import com.xyy.springmvc.mybatis.utils.DWZJsonResponseResult;
 
/**
 * 
* @ClassName: RightController 
* @Description: 权限操作的控制层
* @author 谢奇
* @date 2016年11月5日 下午5:20:19 
*
 */
@Controller
@RequestMapping("right")
public class RightController extends BaseController{
	

	@Autowired
	private IRightService rightservice;
	@Autowired
	private RoleService roleservice;
	@Autowired
	private RightDao rightDao;
	@Autowired
	private RoleRightDao roleRightDao;
	/**
	 * 
	* @Title: toRightPage 
	* @Description:  返回权限树页面
	* @param rightinfo
	* @param request
	* @return    参数 
	* String  返回类型 
	* @throws
	 */
	@RequestMapping("/rightTree")
	public String toRightPage(RightInfo rightinfo,HttpServletRequest request)
	{
		StringBuffer sb = new StringBuffer();
		rightservice.initAuthsTree(0, sb, 1);
		request.setAttribute("strRigTree", sb);
		
		StringBuffer sb2 = new StringBuffer();
		rightservice.initAuthsTree(0, sb2, 2);
		request.setAttribute("strRigTree2", sb2);
		
		StringBuffer sb3 = new StringBuffer();
		rightservice.initAuthsTree(0, sb3, 3);
		request.setAttribute("strRigTree3", sb3);
		
		StringBuffer sb4 = new StringBuffer();
		rightservice.initAuthsTree(0, sb4, 4);
		request.setAttribute("strRigTree4", sb4);
		
		StringBuffer rolesb =new StringBuffer();
		roleservice.roleTree(rolesb, -1L);
		request.setAttribute("roleTree", rolesb);
		
		return toPage("right","rightTree");
	}
	
	/**
	 * 
	* @Title: toRightAddPage 
	* @Description: 跳转到添加权限的页面
	* @return    参数 
	* String  返回类型 
	* @throws
	 */
	@RequestMapping("/toRightAddPage")
	public String toRightAddPage()
	{
		return toPage("right","rightAdd");
	}
	
	@RequestMapping("/rightAdd")
	public void rightAdd(RightInfo rightinfo,HttpServletRequest request,HttpServletResponse response)
	{
			rightservice.rightAdd(rightinfo);
			DWZJsonResponseResult json = DWZJsonResponseResult.initSuccess();
			json.addDataAll(null);
			json.setNavTabId("rightTree");
			jsonToPage(json.toJSONString(),response);
	}
	/**
	 * 
	* @Title: belongToRole 
	* @Description: 找到权限从属的角色     参数 
	* void  返回类型 
	* @throws
	 */
	@RequestMapping("/belongToRole")
	public void  belongToRole(long rightId,HttpServletResponse response)
	{
		Map<String,Object> rigId = new HashMap<>();
		rigId.put("rightId", rightId);
		List<RoleRight> param = roleRightDao.findRoleRightByRightId(rigId);
		DWZJsonResponseResult json = DWZJsonResponseResult.initSuccess();
		json.addDataAll(param);
		jsonToPage(json.toJSONString(),response);
	}
	/**
	 * 
	* @Title: changeRoleRight 
	* @Description: 将权限重新分配给角色     参数 
	* void  返回类型 
	* @throws
	 */
	@RequestMapping("/changeRoleRight")
	public void  changeRoleRight(long roleId[],long rightId,HttpServletResponse response)
	{
		rightservice.changeRoleRight(roleId,rightId);
		DWZJsonResponseResult json = DWZJsonResponseResult.initSuccess();
		jsonToPage(json.toJSONString(),response);
	}
}
