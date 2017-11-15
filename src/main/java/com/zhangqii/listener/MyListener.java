package com.zhangqii.listener;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.zhangqii.utils.DateUtils;
import com.zhangqii.utils.JedisUtils;

import redis.clients.jedis.Jedis;

public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		/**
		 * 初始化redis各项
		 */
		Jedis jedis=JedisUtils.getJedis();

		if (!jedis.exists("AllIp")){
			jedis.sadd("AllIp","1");
		}

		if (jedis.get("AllCount")==null){
			jedis.set("AllCount", 0+"");
		}

		if(!jedis.exists("DayIp")){
			jedis.sadd("DayIp",DateUtils.CurrentDay());
		}
		if (jedis.get("DayCount")==null){
			jedis.set("DayCount","0");
		}
	}

}
