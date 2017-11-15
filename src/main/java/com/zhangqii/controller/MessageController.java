package com.zhangqii.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhangqii.annocation.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import com.zhangqii.pojo.Page;
import com.zhangqii.pojo.PageBean;
import com.zhangqii.pojo.TMessage;
import com.zhangqii.pojo.TTag;
import com.zhangqii.pojo.TTitle;
import com.zhangqii.service.MessageService;
import com.zhangqii.service.TagSerivce;
import com.zhangqii.service.TitleService;
import com.zhangqii.utils.PageUtils;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Value("${MESSAGE_COUNT}")
	private String MESSAGE_COUNT;
	@Autowired
	private TitleService titleService;
	@Autowired
	private TagSerivce tagService;
	@Autowired
	private MessageService messageService;
	/**
	 * 获取前八篇文章，
	 * 查询所有标签
	 * 查询留言总数
	 * 查询最近的十条留言显示
	 */
	@RequestMapping(value = "",method = RequestMethod.GET)
	@Token(save = true)
	public String getSays(HttpServletRequest request,Model model){
		//查询热门的八篇文章
		List<TTitle> countList=this.titleService.findByCountLimit(new Page(1, 8,true));
		
		//查询全部标签
		List<TTag> tagList=this.tagService.findAllTag();
		model.addAttribute("countList",countList);
		model.addAttribute("tagList",tagList);
		
		//查询当前页数

		Integer currentPage=PageUtils.getPageNumber(request.getParameter("currentPage"));

		Integer allCount=messageService.findAllCount();
		
		model.addAttribute("allCount", allCount);
		List<TMessage> messageList=this.messageService.findByLimit(new Page(currentPage,Integer.valueOf(MESSAGE_COUNT )));
		PageBean pageBean=PageUtils.getPageUtils(messageList, allCount, currentPage, Integer.valueOf(MESSAGE_COUNT));
		model.addAttribute("pageBean", pageBean);
		return "head/message";
	}
	@RequestMapping(value = "",method = RequestMethod.POST)
	@Token(remove = true)
	public String addSay(TMessage message,Model model){
		/**
		 * 通过正则匹配添加文章
		 */
		message.setMurl(message.getMurl().replaceAll("(http://)|(https://)",""));
		message.setMcon(HtmlUtils.htmlEscape(message.getMcon()));
		message.setMname(HtmlUtils.htmlEscape(message.getMname()));
		message.setMurl(HtmlUtils.htmlEscape(message.getMurl()));
		message.setMtime(new Date());
		this.messageService.add(message);
		return "redirect:/message";
	}
	/*
	* 根据ID删除文章
	* */
	@RequestMapping(value = "/{mid}",method = RequestMethod.DELETE)
	@ResponseBody public String delete(@PathVariable Integer mid){
		this.messageService.deleteById(mid);
		return "删除成功";
	}
}
