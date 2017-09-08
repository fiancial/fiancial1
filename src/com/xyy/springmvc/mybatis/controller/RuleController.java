package com.xyy.springmvc.mybatis.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyy.springmvc.mybatis.beans.Rulegrop;
import com.xyy.springmvc.mybatis.beans.Ruleinfo;
import com.xyy.springmvc.mybatis.services.IRulegropService;
import com.xyy.springmvc.mybatis.services.IRuleinfoService;
import com.xyy.springmvc.mybatis.utils.DWZJsonResponseResult;
import com.xyy.springmvc.mybatis.utils.PageBean;
 

@Controller
@RequestMapping("Rule")
public class RuleController extends BaseController {
	
	@Autowired
	public IRulegropService rulegropService;
	
	@Autowired
	public IRuleinfoService ruleinfoService;
	
	public PageBean pageBean = new PageBean();
	
	/**
	 * 
	* @Title: findRule 
	* @Description: 分页查询所有的规则组信息
	* @param rulegrop
	* @param pageNum
	* @param request
	* @param response
	* @return    参数 
	* String  返回类型 
	* @throws
	 */
	@RequestMapping("/findRule")
	public String findRule(@ModelAttribute("Rulegrop") Rulegrop rulegrop,Integer pageNum ,HttpServletRequest request,HttpServletResponse response){	
		
		if(rulegrop.getRgStatus() != null){
			if(rulegrop.getRgStatus() == "请选择" || rulegrop.getRgStatus().equals("请选择")){
				rulegrop.setRgStatus(null);
			}
		}
		Map<String, Object> para = new HashMap<String,Object>();
		para.put("Rulegrop", rulegrop);
		pageBean.setCurrentPage(pageNum);
		List<Rulegrop> list = rulegropService.findRulegpage(para,pageBean);
		//当没有找到数据时给用户一个提示
		String str = null;
		if(list != null){
			str = "1";//当查询到数据时给str变量赋值为1表示有数据，为null表示没有找到数据
		}
		request.setAttribute("list", list);
		request.setAttribute("rulegrop", rulegrop);
		request.setAttribute("str", str);
		request.setAttribute("pageBean", pageBean);
		return toPage("rules", "rulesList");
	}
	
	/**
	 * 
	* @Title: toaddRule 
	* @Description: 跳转到增加规则信息页面 
	* @return    参数 
	* String  返回类型 
	* @throws
	 */
	@RequestMapping("/toaddRule")
	public String toaddRule(HttpServletRequest request,HttpServletResponse response){
		String str = rulegropService.findsq();
		request.setAttribute("sq", str);
		return toPage("rules", "rulesAdd");
	}
	
	/**
	 * 
	* @Title: addRule 
	* @Description: 添加规则信息数据的方法
	* void  返回类型 
	* @throws
	 */
	@RequestMapping("/addRule")
	public void addRule(@ModelAttribute("rulegrop")Rulegrop rulegrop,HttpServletRequest request,HttpServletResponse response){
		try {
			rulegropService.addRule(rulegrop);
			DWZJsonResponseResult json = DWZJsonResponseResult.initSuccess();
			json.setNavTabId("rulesList");
			jsonToPage(json.toJSONString(), response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* @Title: toupdateRule 
	* @Description: 跳转到修改规则信息页面 
	* void  返回类型 
	* @throws
	 */
	@RequestMapping("/toupdateRule")
	public String toupdateRule(String rulegrop,HttpServletRequest request,HttpServletResponse response){
		try {
			Rulegrop rus = new Rulegrop();
			rus.setRgGroupNo(rulegrop);
			Map<String, Object> para = new HashMap<String,Object>();
			para.put("Rulegrop", rus);
			List<Rulegrop> list = rulegropService.findRuleg(para);
			request.setAttribute("rulegrop", list.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toPage("rules", "rulesUP");
	}
	
	/**
	 * 
	* @Title: updateRule 
	* @Description: 修改规则信息数据的方法
	* void  返回类型 
	* @throws
	 */
	@RequestMapping("/updateRule")
	public void updateRule(Rulegrop rulegrop,HttpServletRequest request,HttpServletResponse response){
		try {
			rulegropService.updateRule(rulegrop);
			DWZJsonResponseResult json = DWZJsonResponseResult.initSuccess();
			json.setNavTabId("rulesList");
			jsonToPage(json.toJSONString(), response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* @Title: delRuleg 
	* @Description: 删除规则信息的方法
	* @param rulegrop
	* @param request
	* @param response    参数 
	* void  返回类型 
	* @throws
	 */
	@RequestMapping("/delRuleg")
	public void delRuleg(String rulegrop,HttpServletRequest request,HttpServletResponse response){
		try {
			DWZJsonResponseResult json = DWZJsonResponseResult.initSuccess();
			Map<String, Object> params = new HashMap<String,Object>();
			Ruleinfo ruleinfo = new Ruleinfo();
			ruleinfo.setRiRuleGrpNo(rulegrop);
			params.put("ruleinfo",ruleinfo);
			List<Ruleinfo> list =  ruleinfoService.findRuleinfo(params);
			if(list.size() == 0){
				Map<String, Object> param = new HashMap<String,Object>();
				param.put("rgGroupNo", rulegrop);
				rulegropService.delRuleg(param);
			}
			json.setTime(list.size());
			json.setNavTabId("rulesList");
			jsonToPage(json.toJSONString(), response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
