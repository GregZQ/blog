package com.zhangqii.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
	private static final JedisPool POOL;
	static{
		JedisPoolConfig config=new JedisPoolConfig();
		config.setMaxTotal(50);
		config.setMaxIdle(10);
		POOL=new JedisPool(config,"47.94.18.185",6379);
	}
	public static Jedis getJedis(){
		Jedis jedis= POOL.getResource();
		jedis.auth("Zhangqi123*");
		return jedis;
	}
}
