package com.zhangqii.controller;



import java.lang.annotation.Target;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhangqii.annocation.Token;
import com.zhangqii.pojo.*;
import com.zhangqii.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhangqii.utils.PageUtils;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/back")
public class BackController {
	@Value("${BACK_COUNT}")
	private String BACK_COUNT;
	@Autowired
	private TagSerivce tagSerivce;
	@Autowired
	private TitleService titleService;
	@Autowired
	private ConService conService;
	@Autowired
	private SayService sayService;
	@Autowired
	private MessageService messageService;
	/**
	 *
	 *
	 * 后台文章的列出,需要四个参数
	 * 有一个status类型，1为发布
	 *                  0为草稿
	 *       type   1为原创
	 *              0为转载
	 *       tag   文章标签
	 *
	 */
	@RequestMapping(value = "/title/{id}",method = RequestMethod.GET)
	public String back( @PathVariable(value = "id") String sta,HttpServletRequest request, Model model){

		 //sta:1表示原创，0表示转载
		Boolean status=Integer.valueOf(sta)==1?true:false;
		//获取文章所属标签
		String ttag=request.getParameter("tag");
		if (ttag==null||ttag.equals("0")||ttag.trim().equals("")){
			ttag=null;
		}
		//获取文章类型 1原创 0转载,默认为原创
		String typ="1";
		if (request.getParameter("type")!=null){
			typ=request.getParameter("type");
		}
		Boolean type=Integer.valueOf(typ)==1?true:false;
		Integer count=this.titleService.findByConditionCount(status,ttag,typ);

		//获取当前页数
		Integer currentPage=PageUtils.getPageNumber(request.getParameter("currentPage"));
		//获取文章列表
		List<TTitle> list=this.titleService.findByStatusLimit(new Page(currentPage, Integer.valueOf(BACK_COUNT),status,type,ttag));
		PageBean pageBean=PageUtils.getPageUtils(list, count, currentPage, Integer.valueOf(BACK_COUNT));
		model.addAttribute("pageBean",pageBean); 
		//查询全部标签
		List<TTag> tagList=this.tagSerivce.findAllTag();
		model.addAttribute("tagList",tagList);
		//把文章条件回显
		model.addAttribute("tag", ttag);
		model.addAttribute("status",sta);
		model.addAttribute("type", typ);
		return "back/title";
	}
	/**
	 * 到文章添加页面
	 * /back/edittitle method:get
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edittitle",method = RequestMethod.GET)
	@Token(save=true)
	public String edit(HttpServletRequest request,Model model){
		//获取标签列表
		List<TTag>tagList=this.tagSerivce.findAllTag();
		model.addAttribute("tagList", tagList);
		model.addAttribute("update","0");
		return "back/titleedit";
	}
	/**
	 *
	 * 到文章编辑页面
	 * /back/edittilte/{id}
	 */
	@RequestMapping(value = "/edittitle/{id}",method = RequestMethod.GET)
	public  String editPage(@PathVariable(value = "id") Integer id,HttpServletRequest request,Model model){
		TTitle title=this.titleService.findById(id);
		model.addAttribute("title",title);
		TCon tcon=this.conService.findById(title.getTid());
		model.addAttribute("tcon",tcon);
		List<TTag> tagList=this.tagSerivce.findAllTag();
		model.addAttribute("tagList", tagList);
		model.addAttribute("update","1");
		return "back/titleedit";
	}
	//到文章标签页面
	@RequestMapping(value = "/tag",method = RequestMethod.GET)
	public String ttag(Model model,HttpServletRequest request){
		//得到当前第几页
		int currentPage=PageUtils.getPageNumber(request.getParameter("currentPage"));
		//查询全部标签数量（以后放在缓存中）
		int Count=tagSerivce.findTTagCount();
		/**
		 * 分页查询
		 */
		List<TTag>list=this.tagSerivce.findByLimit(new Page(currentPage,Integer.valueOf(BACK_COUNT)));
		PageBean<TTag> pageBean=PageUtils.getPageUtils(list, Count, currentPage, Integer.valueOf(BACK_COUNT));
		model.addAttribute("pageBean", pageBean);
		return "back/tag";
	}
	/**
	 * 到闲言碎语列表页面
	 * /
	 */
	@RequestMapping(value = "/say",method = RequestMethod.GET)
	public String mySay(HttpServletRequest request,Model model){

		int currentPage=PageUtils.getPageNumber(
				request.getParameter("currentPage"));
        //后期放在缓存中
		int count=sayService.findAllCount();

		List<TMsay> list=this.sayService.findMySayByLimit(new Page(currentPage, Integer.valueOf(BACK_COUNT)));
		
		PageBean pageBean=PageUtils.getPageUtils(list, count, currentPage, Integer.valueOf(BACK_COUNT));
		model.addAttribute("pageBean",pageBean);
		return "/back/says";
	}

	/**
	 * 到添加闲言碎语页面
	 * @return
	 */
	@RequestMapping("/editsays")
	@Token(save = true)
	public String mysay(){
		return "back/saysedit";
	}
	/**
	 * 查询当前留言
	 * /back/message method:get
	 */
	@RequestMapping(value = "/message",method = RequestMethod.GET)
	public String messageList(HttpServletRequest request,Model model){
		Integer currentPage=PageUtils.getPageNumber(
				request.getParameter("currentPage"));
		Integer count=messageService.findAllCount();
		
		model.addAttribute("allCount", count);
		List<TMessage> messageList=this.messageService.findByLimit(new Page(currentPage, Integer.valueOf(BACK_COUNT)));
		PageBean pageBean=PageUtils.getPageUtils(messageList, count, currentPage, Integer.valueOf(BACK_COUNT));
		model.addAttribute("pageBean", pageBean);
		return "back/message";
	}
}
