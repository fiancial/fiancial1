package com.xyy.springmvc.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyy.springmvc.mybatis.beans.Rulegrop;
import com.xyy.springmvc.mybatis.beans.Ruleinfo;
import com.xyy.springmvc.mybatis.beans.Ruleitem;
import com.xyy.springmvc.mybatis.beans.RuleitemModel;
import com.xyy.springmvc.mybatis.services.IRulegropService;
import com.xyy.springmvc.mybatis.services.IRuleinfoService;
import com.xyy.springmvc.mybatis.services.IRuleitemService;
import com.xyy.springmvc.mybatis.utils.DWZJsonResponseResult;
import com.xyy.springmvc.mybatis.utils.PageBean;
 

//@Controller
//@RequestMapping("roleInfo")
public class RoleInfoController extends BaseController{
	
	
	@Autowired
	public IRuleinfoService ruleinfoService; //规则信息
	
	@Autowired
	public IRulegropService rulegropService; //规则组信息
	
	@Autowired
	public IRuleitemService ruleitemService;//基础规则项信息
	
	public PageBean pageBean = new PageBean();
	/**
	 * 
	* @Title: RoleInfolist 
	* @Description: 跳转到规则明细浏览页面
	* @param id
	* @param request 
	* @param response
	* @return    参数 
	* String  返回类型 
	* @throws
	 */
	@RequestMapping("/RoleInfolist")
	public String RoleInfolist(Ruleinfo ruleinfo,String id,Integer pageNum ,HttpServletRequest request,HttpServletResponse response){
		try {
			//判断RiAction状态是否为请选择是的话将RiAction的值改为null
			if(ruleinfo.getRiAction() != null){
				if(ruleinfo.getRiAction() ==  "请选择" || ruleinfo.getRiAction().equals( "请选择")){
					ruleinfo.setRiAction(null);
				}
			}
			Map<String, Object> para = new HashMap<String, Object>();
			ruleinfo.setRiRuleGrpNo(id);
			para.put("ruleinfo", ruleinfo);
			pageBean.setCurrentPage(pageNum);
			List<Ruleinfo> listro = ruleinfoService.findRuleinfopage(para,pageBean);
			//当没有找到数据时给用户一个提示
			String str = null;
			if(listro != null){
				str = "1";//当查询到数据时给str变量赋值为1表示有数据，为null表示没有找到数据
			}
			request.setAttribute("listro", listro);
			request.setAttribute("ruleinfo", ruleinfo);
			request.setAttribute("str",str);
			request.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toPage("rules", "ruleinfoList");
	}
	
	/**
	 * 
	* @Title: delRuleinfo 
	* @Description: 删除规则信息数据
	* @param id
	* @param request
	* @param response    参数 
	* void  返回类型 
	* @throws
	 */
	@RequestMapping("/delrole")
	public void delRuleinfo(String id,HttpServletRequest request,HttpServletResponse response){
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("riRuleNo",id);
			ruleinfoService.delRuleinfo(param);
			DWZJsonResponseResult json = DWZJsonResponseResult.initSuccess();
			json.setNavTabId("ruleinfoList");
			jsonToPage(json.toJSONString(), response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* @Title: tofindRuleinfo 
	* @Description: 跳转到维护规则明细页面
	* @param id
	* @param request
	* @param response
	* @return    参数 
	* String  返回类型 
	* @throws
	 */
	@RequestMapping("/tofindRuleinfo")
	public String tofindRuleinfo(String id,HttpServletRequest request,HttpServletResponse response){
		//规则信息
		Map<String, Object> paraA = new HashMap<String, Object>();
		//规则组信息
		Map<String, Object> paraB = new HashMap<String, Object>();
		//先获得在页面上传过来的规则编号id
		Ruleinfo ruleinfo = new Ruleinfo();
		ruleinfo.setRiRuleNo(id);
		paraA.put("ruleinfo", ruleinfo);
		//获得规则信息riRuleNo等于从页面传过的id
		List<Ruleinfo> listinfo = ruleinfoService.findRuleinfo(paraA);
		Rulegrop rulegrop = new Rulegrop();
		rulegrop.setRgGroupNo(listinfo.get(0).getRiRuleGrpNo());
		paraB.put("Rulegrop",rulegrop);
		//获得规则组信息 
		List<Rulegrop> listgrop = rulegropService.findRuleg(paraB);
		request.setAttribute("grop", listgrop.get(0));
		return toPage("rules", "infolist");
	}
	
	/**
	 * 
	* @Title: findRuleinfoList 
	* @Description: 按条件查询规则明细
	* @param ruleinfo
	* @param request
	* @param response    参数 
	* void  返回类型 
	* @throws
	 */
	@RequestMapping("/findRuleinfos")
	public String findRuleinfoList(Ruleinfo ruleinfo,HttpServletRequest request,HttpServletResponse response){
		try {
			Map<String, Object> para = new HashMap<String, Object>();
			para.put("ruleinfo", ruleinfo);
			List<Ruleinfo> listro = ruleinfoService.findRuleinfo(para);
			request.setAttribute("listro",listro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toPage("rules", "ruleinfoList");
	}
	
	/**
	 * 
	* @Title: addRuleitem 
	* @Description: 添加规则信息和规则信息点数据
	* @param rulegrop 基础规则组实体类
	* @param ruleinfo  基础规则信息
	* @param ruleitems  基础规则项Model(list集合类)
	* @param request
	* @param response    参数 
	* void  返回类型 
	* @throws
	 */
	@RequestMapping("/addRuleitem")
	public void addRuleitem(Rulegrop rulegrop, Ruleinfo ruleinfo, RuleitemModel ruleitems, HttpServletRequest request,HttpServletResponse response){
		try {
			ruleinfo.setRiRuleGrpNo(rulegrop.getRgGroupNo());
			ruleinfoService.addRuleinfo(ruleinfo);
			//因为页面会穿多条数据过来所以在后台建一个list的集合类来接收
			if(ruleitems != null){
				//有几条数据就执行几次添加方法
				for(int i = 0; i < ruleitems.getRuleitems().size(); i++) {
					Ruleitem ruleitem = ruleitems.getRuleitems().get(i);
					ruleitem.setRiOprId(rulegrop.getRgGroupNo());
					ruleitemService.addRuleitem(ruleitem);
				}
			}
			DWZJsonResponseResult json = DWZJsonResponseResult.initSuccess();
			json.setCallbackType(null);
			json.setNavTabId("ruleinfoList");
			jsonToPage(json.toJSONString(), response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {		
			
	}
}
