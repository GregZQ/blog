package com.zhangqii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangqii.pojo.TTag;
import com.zhangqii.service.TagSerivce;

/**
 * 标签模块
 */
@RequestMapping("/tag")
@Controller
public class TagController {

	@Autowired
	private TagSerivce tagSerivce;
	
	@RequestMapping("/addtag")
	public String addTag(TTag tTag){
		tTag.setTcount(0);
		this.tagSerivce.addTag(tTag);
		return "redirect:/back/tagedit";
		
	}
	
	@RequestMapping("/delete")
	public String deleteById(int tid){
		this.tagSerivce.delete(tid);
		return "redirect:/back/tagedit";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateById(TTag tTag){
		this.tagSerivce.updateById(tTag);
		return "success";
	}
	
}
