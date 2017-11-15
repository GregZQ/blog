package com.zhangqii.cache;

import com.zhangqii.utils.JedisUtils;
import redis.clients.jedis.Jedis;

/**
 * Created by Jone on 2017-11-12.
 */
public class JedisCache {
    /**
     *
     *统计谋篇文章的访问量
     * @return
     */
    public  static  Integer count(Jedis jedis,String tid){
        String tiCount=jedis.get("titleCount:"+tid);
        Integer value=0;
        if (tiCount!=null){
            value=Integer.valueOf(tiCount);
        }
        return  value;
    }
    /*
    * 向某篇文章添加Ip
    * 返回访问量
    * */
    public static Integer addIpByTitle(Jedis jedis,String ip,String tid){
        Integer value=count(jedis,tid);
        if (value==0){
            jedis.set("titleCount:"+tid,1+"");
            jedis.sadd("titleIp:"+tid,ip);
        }else{
            if (!jedis.sismember("titleIp:"+tid,ip)){
                jedis.sadd("titleIp:"+tid,ip);
                value+=1;
                jedis.set("titleCount:"+tid,value+"");
            }
        }
        return value;
    }
}
