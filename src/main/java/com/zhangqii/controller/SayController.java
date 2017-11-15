package com.zhangqii.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhangqii.annocation.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @Value("${SAY_COUNT}")
	private String SAY_COUNT;
	@Autowired
	private SayService sayService;

	/**
	 * 添加闲话
	 * @param msay
	 * @return
	 */
	@RequestMapping(value = "",method = RequestMethod.POST)
	@Token(remove = true)
	@ResponseBody
	public String addSay(TMsay msay){
		msay.setMtime(new Date());
		sayService.addSay(msay);
		return "添加成功";
	}

	/**
	 * 删除闲话
	 * url： /title/id method :DELETE
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseBody  public String delete(@PathVariable Integer id){
		sayService.deleteById(id);
		return "删除成功";
	}
	@RequestMapping(value = "",method = RequestMethod.GET)
    public  String list(Model model,HttpServletRequest request){
		Integer currentPage=PageUtils.getPageNumber(request.getParameter("currentPage"));
		Integer allCount=this.sayService.findAllCount();
		List<TMsay> list=this.sayService.findMySayByLimit(new Page(currentPage,Integer.valueOf(SAY_COUNT)));
		PageBean pageBean=PageUtils.getPageUtils(list,allCount,currentPage,Integer.valueOf(SAY_COUNT));
		model.addAttribute("pageBean",pageBean);
		return "head/saylist";
	}
	
}
