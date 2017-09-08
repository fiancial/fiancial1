package com.xyy.springmvc.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController extends BaseController {

	@RequestMapping("/upload")
	public String upload(){
		return super.toPage("test", "upload");
		
	}
}
