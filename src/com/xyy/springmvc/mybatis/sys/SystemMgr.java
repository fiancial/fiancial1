package com.xyy.springmvc.mybatis.sys;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xyy.springmvc.mybatis.services.impl.RightCache;
 

/**
 * 系统启动和销毁的支撑类
 * 
 * @author jerry
 */
@Component
public class SystemMgr {	
	private static Log logger = LogFactory.getLog(SystemMgr.class);

	 
	 
	 
    
   

    @Autowired
    private RightCache rightCache;
	/**
	 * 交易系统初始化加载的配置或者初始化的数据
	 */
	@PostConstruct
	public void init() {
		initDatas();
		initTask();
	}

	
	
	/**
	 * 初始化的数据
	 */
	private void initDatas() {			 

		rightCache.initCache();
	}


	/**
	 * 定时任务启动
	 */
	private void initTask() {
		
	}
	
	 
}
