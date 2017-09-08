package com.xyy.springmvc.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyy.springmvc.mybatis.beans.SystemUser;
import com.xyy.springmvc.mybatis.services.SystemUserService;
import com.xyy.springmvc.mybatis.utils.DWZJsonResponseResult;
import com.xyy.springmvc.mybatis.utils.PageBean;
 

/**
* @ClassName: SystemUserController 
* @Description: 系统用户控制层
* @author lvjian
* @date 2016年10月24日 下午15:10:56 
*/
@Controller
@RequestMapping("systemUser")
public class SystemUserController extends BaseController {
	private  static Logger logger = Logger.getLogger(SystemUserController.class.getName());
	
	@Autowired
	private SystemUserService systemUserService;
	
	/**
	 * @Title:  findSystemUserPage
	 * @Description: 按条件分页查询计分卡
	 * @param request
	 * String  返回类型 
	 * @throws
	 */
	@RequestMapping("/systemUserlist")
	public String findSystemUser(int pageNum,String userName,HttpServletRequest request) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userName", userName);
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(pageNum);
		try {
			List<SystemUser> systemUser = systemUserService.findSystemUserPage(param, pageBean);
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("systemUser", systemUser);
		} catch (Exception e) {
			logger.error("系统用户查询错误", e);
		}
		return toPage("systemUser", "systemUserlist");
	}
	
	/**
	 * @Title:toAddSystemPage
	 * @Description:点击添加跳转到增加页面
	 * @param request
	 * String 返回类型 
	 * @throws
	 */
	@RequestMapping("/toAddSystemPage")
	public String toAddSystemPage(HttpServletRequest request){
		return toPage("systemUser","systemUserlistAdd");
	}
	
	/**
	 * @Title:addSystemUser
	 * @Description:添加系统用户
	 * @param systemUser
	 * @param request
	 * @param response
	 * void 返回类型 
	 * @throws
	 */
	@RequestMapping("/toSystemUserlistAdd")
	public void addSystemUser(@ModelAttribute("systemUser")SystemUser systemUser,
			HttpServletRequest request,HttpServletResponse response){
		systemUserService.addSystemUser(systemUser);
		DWZJsonResponseResult json = DWZJsonResponseResult.initSuccess();
		json.setMessage("新增成功");
		json.setNavTabId("systemUserlist");
		jsonToPage(json.toJSONString(),response);
	}
	
	/**
	 * @Title:delSystemUser
	 * @Description:删除系统用户
	 * @param id
	 * @param response
	 * void 返回类型 
	 * @throws
	 */
	@RequestMapping("/delSystemUser")
	public void delSystemUser(Long id,HttpServletResponse response){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", id);
		systemUserService.delSystemUser(param);
	}
	
	/**
	 * @Title:  toUpdSystemUserPage
	 * @Description: 跳转到修改页面
	 * @param pageNum
	 * @param id
	 * @param request
	 * String  返回类型 
	 * @throws
	 */
	@RequestMapping("/toUpdSystemUserPage")
	public String toUpdSystemUserPage(int pageNum,String id,HttpServletRequest request){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", id);
		List<SystemUser>  systemUser = systemUserService.findSystemUser(param);
		request.setAttribute("systemUser", systemUser.get(0));
		request.setAttribute("pageNum", pageNum);
		return toPage("systemUser","systemUserlistUpd");
	}
	
	/**
	 * @Title:  updSystemUser
	 * @Description: 修改系统用户
	 * @param systemUser
	 * @param request
	 * @param response
	 * void  返回类型 
	 * @throws
	 */
	@RequestMapping("/updSystemUser")
	public void updSystemUser(@ModelAttribute("systemUser")SystemUser systemUser,
				HttpServletRequest request,HttpServletResponse response){
		 //System.out.println(scoreCard);
		 systemUserService.updSystemUser(systemUser);
		 DWZJsonResponseResult json = DWZJsonResponseResult.initSuccess();
		 json.setMessage("修改成功");
		 json.setNavTabId("systemUserlist");
		 jsonToPage(json.toJSONString(),response);
	}
	
	/** 
	 * @Title: toCheckSystemUser 
	 * @Description: 点击查看用户信息 
	 * @param id  
	 * @param request
	 * @return    参数 
	 * String 返回类型 
	 * @throws 
	 */
	@RequestMapping("/toCheckSystemUser")
	public String tocheckSystemUser(HttpServletRequest request,Long id){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", id);
		try {
			List<SystemUser>  systemUser = systemUserService.findSystemUser(param);
			SystemUser su = systemUser.get(0);
			request.setAttribute("su", su);
		} catch (Exception e) {
			logger.error("用户查看失败", e);
		}
		return toPage("systemUser","systemUserlistFind");
	}
	
}












