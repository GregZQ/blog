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
	     * 每次启动服务器，先观察当前的是否有这些字段，如果没有就添加。
	     * 得到当前jedis客户端
	     */
		Jedis jedis=JedisUtils.getJedis();
		/**
		 * 判断当前是否有AllIp这个字段，如果没有，先添加
		 */
		if (!jedis.exists("AllIp")){
			jedis.sadd("AllIp","1");
		}
		/**
		 * 其次判断是否有AllCount字段，如果没有，添加
		 */
		if (jedis.get("AllCount")==null){
			jedis.set("AllCount", 0+"");
		}
		/**
		 * 判断是否有DayIp字段，没有的话添加
		 * ，判断是否有DayCount，没有的话添加
		 */
		if(!jedis.exists("DayIp")){
			jedis.sadd("DayIp",DateUtils.CurrentDay());
		}
		if (jedis.get("DayCount")==null){
			jedis.set("DayCount","0");
		}
	}

}
