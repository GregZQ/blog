package com.zhangqii.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhangqii.pojo.Page;
import com.zhangqii.pojo.TTag;
import com.zhangqii.pojo.TTitle;
import com.zhangqii.pojo.TitleAndTag;
import com.zhangqii.service.TagSerivce;
import com.zhangqii.service.TitleService;

@Controller
public class IndexController {

	@Autowired
	private TitleService titleService;
	@Autowired
	private TagSerivce tagService;
	@Value("${INDEX_TITLE}")
	private Integer INDEX_TITLE;
	@RequestMapping("/index")
	public String index(Model model){
		//查询前INDEX_TITLE篇文章，在主页显示
		List<TitleAndTag>titleList=titleService.findTitleAndTagLimit(new Page(1, INDEX_TITLE, true));
		
		//查询前八篇文章在首页侧栏显示
		List<TTitle> countList=this.titleService.findByCountLimit(new Page(1, INDEX_TITLE,true));
		
		//查询全部标签
		List<TTag> tagList=this.tagService.findAllTag();
		model.addAttribute("titleList", titleList);
		model.addAttribute("countList",countList);
		model.addAttribute("tagList",tagList);
		return "head/index";
	}
}
