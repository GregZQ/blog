package com.zhangqii.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Value("${YONGHU}")
	private String USERNAME;
	
	@Value("${MIMA}")
	private String PASSWORD;
	@RequestMapping("/login")
	public String login(){
		return "forward:/WEB-INF/login.jsp";
	}
	
	@RequestMapping("/tologin")
	public String toLogin(HttpServletRequest request,String username,String password){
		if (username!=null&&username.equals(USERNAME)&&
			PASSWORD!=null&&password.equals(PASSWORD)){
			request.getSession().setAttribute("user", username);
			
			return "redirect:back/back";
		}else{
			return "redirect:/";
		}
	}
}
