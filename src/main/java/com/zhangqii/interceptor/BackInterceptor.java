package com.zhangqii.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class BackInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		HttpSession session=arg0.getSession();
		if (session!=null&&session.getAttribute("user")!=null){
			return true;
		}else if (arg0.getMethod().trim().toLowerCase().equals("get")&&!arg0.getRequestURI().contains("back")){
			/*
			* 这是放行title say下面
			* */
			return true;
		}else if (arg0.getRequestURI().trim().substring(1,8).equals("message")&&
				(arg0.getMethod().trim().toLowerCase().equals("get")||
				  arg0.getMethod().trim().toLowerCase().equals("post"))
				){
			return true;
		}
		else{
			arg1.sendRedirect("/login");
			return false;
		}
	}

}
