package com.zhangqii.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.stat.TableStat.Mode;
import com.zhangqii.pojo.Page;
import com.zhangqii.pojo.PageBean;
import com.zhangqii.pojo.TMsay;
import com.zhangqii.service.SayService;
import com.zhangqii.utils.PageUtils;

@Controller
@RequestMapping("/say")
public class SayController {

	@Autowired
	private SayService sayService;

	/**
	 * 添加闲话
	 * @param msay
	 * @return
	 */
	@RequestMapping("/addsay")
	@ResponseBody
	public String addSay(TMsay msay){
		msay.setMtime(new Date());
		sayService.addSay(msay);
		return "添加成功";
	}

	/**
	 * 删除闲话
	 * @param msay
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(TMsay msay){
		if (msay.getMid()!=null){
			sayService.delete(msay);
		}
		return "redirect:/back/mysay";
	}

	/**
	 * 闲话列表展示
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("")
	public String saylist(HttpServletRequest request,Model model){
		//查询页
		int currentPage=1;
		String cur=request.getParameter("currentPage");
		if (cur!=null&&!cur.trim().equals("")){
			currentPage=Integer.valueOf(cur);
		}
		//分页显示
		
		int count=this.sayService.findAllCount();
		
		List<TMsay> sayList=this.sayService.findMySayByLimit(new Page(currentPage, 10));
		PageBean page=PageUtils.getPageUtils(sayList, count, currentPage, 10);
		model.addAttribute("pageBean", page);
		return "head/saylist";
	}
	
}
