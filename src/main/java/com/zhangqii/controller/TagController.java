package com.zhangqii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "",method = RequestMethod.POST)
	public String addTag(TTag tTag){
		tTag.setTcount(0);
		this.tagSerivce.addTag(tTag);
		return "redirect:/back/tag";
		
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseBody  public String deleteById(@PathVariable(value = "id") int tid){
		System.out.println(tid);
		this.tagSerivce.delete(tid);
		return "删除成功";
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	@ResponseBody public String updateById(@PathVariable Integer id, TTag tTag){
		tTag.setTid(id);
		this.tagSerivce.updateById(tTag);
		return "更名成功";
	}
	
}
