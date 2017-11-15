package com.zhangqii.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


@Component
public class JedisUtils {
	private static final JedisPool POOL;
	private  static String host="localhost";
	private  static  String password="Zhangqi123*";


	static{
		JedisPoolConfig config=new JedisPoolConfig();
		config.setMaxTotal(50);
		config.setMaxIdle(10);
		POOL=new JedisPool(config,host,6379);
	}
	public static Jedis getJedis(){
		Jedis jedis= POOL.getResource();
		jedis.auth(password);
		return jedis;
	}
}
