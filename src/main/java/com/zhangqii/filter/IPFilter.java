package com.zhangqii.filter;

import com.zhangqii.utils.DateUtils;
import com.zhangqii.utils.JedisUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.*;
import java.io.IOException;

public class IPFilter implements Filter {

	private ServletContext servletContext;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		servletContext=arg0.getServletContext();
		/**
		 * 统计网站访问量
		 */
		
		String ip=arg0.getRemoteAddr();
		Jedis jedis=JedisUtils.getJedis();
		Integer AllCount=Integer.valueOf(jedis.get("AllCount"));
		
		Integer DayCount=Integer.valueOf(jedis.get("DayCount"));
		
		
		if(!jedis.sismember("AllIp", ip)){
			jedis.sadd("AllIp", ip);
			AllCount+=1;
			jedis.set("AllCount",AllCount+"");
		}
		/**
		 * 查看日访问量
		 */
		String date=DateUtils.CurrentDay();
		if (!jedis.sismember("DayIp",date)){
			jedis.del("DayIp");
			jedis.sadd("DayIp", date);
			jedis.sadd("DayIp", ip);
			DayCount=1;
			jedis.set("DayCount",DayCount+"");
		}else{
			
			if (!jedis.sismember("DayIp",ip)){
				jedis.sadd("DayIp",ip);
				DayCount+=1;
				jedis.incr("DayCount");
			}
		}
		jedis.close();
		servletContext.setAttribute("AllCount",AllCount);
		servletContext.setAttribute("DayCount", DayCount);
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
