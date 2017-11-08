package com.zhangqii.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhangqii.pojo.Page;
import com.zhangqii.pojo.PageBean;
import com.zhangqii.pojo.TMessage;
import com.zhangqii.pojo.TMsay;
import com.zhangqii.pojo.TTag;
import com.zhangqii.pojo.TTitle;
import com.zhangqii.service.MessageService;
import com.zhangqii.service.SayService;
import com.zhangqii.service.TagSerivce;
import com.zhangqii.service.TitleService;
import com.zhangqii.utils.PageUtils;


@Controller
@RequestMapping("/back")
public class BackController {
	@Autowired
	private TagSerivce tagSerivce;
	@Autowired
	private TitleService titleService;
	
	@Autowired
	private SayService sayService;
	
	@Autowired
	private MessageService messageService;
	/**
	 * 后台文章的列出,需要四个参数
	 * 有一个status类型，1为发布
	 *                  0为草稿
	 *       type   1为原创
	 *              0为转载
	 *       tag   文章标签
	 *
	 */
	@RequestMapping("/back")
	public String back(HttpServletRequest request,Model model){
		//获取文章的状态，1发布，0草稿
		String stat="1";
		if (request.getParameter("status")!=null){
			stat=request.getParameter("status");
		}
		Boolean status=Integer.valueOf(stat)==1?true:false;
		Integer count=this.titleService.findByStatusCount(status);
		//获取文章类型 1原创 0转载
		String typ="1";
		if (request.getParameter("type")!=null){
			typ=request.getParameter("type");
		}
		Boolean type=Integer.valueOf(typ)==1?true:false;
		//获取文章所属标签
		String ttag=request.getParameter("tag");
		if (ttag==null||ttag.equals("0")||ttag.trim().equals("")){
			ttag=null;
		}
		//获取当前页数
		String current=request.getParameter("currentPage");
		Integer currentPage=1;
		if (current!=null&&!current.equals("")&&!current.trim().equals("")){
			currentPage=Integer.valueOf(current);
		}
		//获取文章列表
		List<TTitle> list=this.titleService.findByStatusLimit(new Page(currentPage, 10,status,type,ttag));
		PageBean pageBean=PageUtils.getPageUtils(list, count, currentPage, 10);
		model.addAttribute("pageBean",pageBean); 
		//查询全部标签
		List<TTag> tagList=this.tagSerivce.findAllTag();
		model.addAttribute("tagList",tagList);
		//把文章条件回显
		model.addAttribute("tag", ttag);
		model.addAttribute("status",stat);
		model.addAttribute("type", typ);
		return "back/back";
	}

	@RequestMapping("/titleedit")
	public String edit(Model model){
		//获取标签列表
		List<TTag>tagList=this.tagSerivce.findAllTag();
		model.addAttribute("tagList", tagList);
		return "back/edit";
	}
	@RequestMapping("/sayedit")
	public String mysay(){
		return "back/sayeditor";
	}
	//到文章标签页面
	@RequestMapping("/tagedit")
	public String ttag(Model model,HttpServletRequest request){
		//得到当前第几页
		String val=request.getParameter("currentPage");
		int currentPage=1;
		if (val!=null&&!val.equals("")){
			currentPage=Integer.valueOf(val);
		}
		
		int Count=tagSerivce.findTTagCount();
		
		//��ѯÿһ��
		
		/**
		 * 分页查询
		 */
		List<TTag>list=this.tagSerivce.findByLimit(new Page(currentPage,10));
		PageBean<TTag> pageBean=PageUtils.getPageUtils(list, Count, currentPage, 10);
		
		model.addAttribute("pageBean", pageBean);
		return "back/tag";
	}
	/**
	 * 查询说的
	 */
	@RequestMapping("/mysay")
	public String mySay(HttpServletRequest request,Model model){

		/**
		 * 查询当前第几页
		 */
		int count=sayService.findAllCount();
		int currentPage=1;
		
		String curr=request.getParameter("currentPage");
		if (curr!=null&&!curr.trim().equals("")){
			currentPage=Integer.valueOf(curr);
		}
		List<TMsay> list=this.sayService.findMySayByLimit(new Page(currentPage, 10));
		
		PageBean pageBean=PageUtils.getPageUtils(list, count, currentPage, 10);
		model.addAttribute("pageBean",pageBean);
		return "/back/mysay";
	}
	/**
	 * 查询当前留言
	 */
	@RequestMapping("/message")
	public String messageList(HttpServletRequest request,Model model){
		/**
		 * 
		 */
		String current=request.getParameter("currentPage");
		Integer currentPage=1;
		if (current!=null&&!current.trim().equals("")){
			currentPage=Integer.valueOf(current);
		}
		Integer allCount=messageService.findAllCount();
		
		model.addAttribute("allCount", allCount);
		List<TMessage> messageList=this.messageService.findByLimit(new Page(currentPage, 10));
		PageBean pageBean=PageUtils.getPageUtils(messageList, allCount, currentPage, 10);
		model.addAttribute("pageBean", pageBean);
		return "back/messagelist";
		
	}
}
