package com.xyy.springmvc.mybatis.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyy.springmvc.mybatis.beans.InnerUser;
import com.xyy.springmvc.mybatis.services.InnerUserService;
import com.xyy.springmvc.mybatis.services.impl.RightCache;
import com.xyy.springmvc.mybatis.utils.CpsysUtil;
import com.xyy.springmvc.mybatis.utils.JsonResponseResult;
import com.xyy.springmvc.mybatis.utils.SysConstant;
 

/**
 * 用户登录 
 * 
 * @author   2011-5-10
 */
@Controller
@RequestMapping("login")
public class LoginController extends BaseController {
	private static Logger logger = Logger.getLogger(LoginController.class
			.getName());

	@Autowired
	private InnerUserService innerUserServ;
	@Autowired
	private RightCache rightCache;

	/**
	 * 用户登录
	 * 
	 * @return
	 * @throws Exception
	 * ${ctx}/login/doLogin.do
	 */
//hessian
	@RequestMapping("/doLogin")
	public String doLogin(String yzmbox,
			@ModelAttribute("innUser") InnerUser innUser,
			HttpServletRequest request, HttpServletResponse response) {
		String userid = innUser.getLoginName();
		String password = innUser.getUserPwd();
		JsonResponseResult json = JsonResponseResult.createSuccess();
		String loginMsg;
		if (StringUtils.isEmpty(yzmbox)
				|| request.getSession().getAttribute("yzmbox") == null) {
			loginMsg = "验证码不能为空！";
			json = JsonResponseResult.createFalied(loginMsg);

			String jsonResult = json.toJSONString();
			jsonToPage(jsonResult, response);
			return null;
		}
		if (!yzmbox.equalsIgnoreCase(request.getSession()
				.getAttribute("yzmbox").toString())) {
			loginMsg = "验证码不正确！";
			json = JsonResponseResult.createFalied(loginMsg);
			String jsonResult = json.toJSONString();
			jsonToPage(jsonResult, response);
			return null;
		}

		userid = userid.trim();
		password = password.trim();

		InnerUser user = new InnerUser();
		user = innerUserServ.doLogin(userid,
				CpsysUtil.getMD5Str(CpsysUtil.getFromBASE64(password)));
		if (user == null) {
			loginMsg = "用户名或密码错误";
			json = JsonResponseResult.createFalied(loginMsg);
			String jsonResult = json.toJSONString();
			jsonToPage(jsonResult, response);
			return null;
		}
		user.setUserUTC("GMT+8");// 操盘登录强制GMT+8

		request.getSession().setAttribute(SysConstant.USER_SESSION, user);

		json = JsonResponseResult.createSuccess();
		String jsonResult = json.toJSONString();
		jsonToPage(jsonResult, response);
		return null;
	}

	@RequestMapping("/main")
	public String main(HttpSession httpSession) {
		InnerUser user = (InnerUser) httpSession
				.getAttribute(SysConstant.USER_SESSION);
		String rightCode = rightCache.getUserRightStr(user.getInnerUserId());
		user.setRightCode(rightCode);
		httpSession.setAttribute(SysConstant.USER_SESSION, user);
		// return toContentView("main", "index");
		return super.toPage("main", "index");
	}

	@RequestMapping("/loginout")
	public String loginout(HttpServletRequest req,HttpServletResponse rep)   {
		HttpSession session =  req.getSession();
		if (session != null) {
			session.invalidate(); 
			try {
				rep.sendRedirect(req.getContextPath()+"/login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// super.jsonResult = "{\"returncode\":0}";
		return null;
	}
}
