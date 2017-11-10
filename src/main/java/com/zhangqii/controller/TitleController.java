package com.zhangqii.controller;

import com.zhangqii.pojo.*;
import com.zhangqii.service.ConService;
import com.zhangqii.service.TagSerivce;
import com.zhangqii.service.TitleService;
import com.zhangqii.utils.FileUitls;
import com.zhangqii.utils.JedisUtils;
import com.zhangqii.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/title")
public class TitleController {

	@Autowired
	private TitleService titleService;
	@Autowired
	private ConService conService;
	@Autowired
	private TagSerivce tagService;
	@Value("${STORE_PATH}")
	private String STORE_PATH;

	/**
	 * 到文章列表页面，/title?currentPage  method=GET
	 * @return
	 */
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String titlelist(Model model,HttpServletRequest request){
		Integer currentPage=PageUtils.getPageNumber(
				request.getParameter("currentPage"));
		//查询共有多少文章,用于分页显示（后期将其放入缓存中）
		int count=this.titleService.findByStatusCount(true);


		//查询前10篇文章，在首页显示
		List<TitleAndTag>titleList=titleService.findTitleAndTagLimit(new Page(currentPage, 10, true));

		PageBean page=PageUtils.getPageUtils(titleList, count, currentPage, 10);
		model.addAttribute("pageBean", page);
		return "head/titlelist";
	}
	/**
	 *根据标签查询文章
	 * /title/tag/{id}?currentPage=** method=get
	 */
	@RequestMapping(value = "/tag/{id}",method = RequestMethod.GET)
	public String tagList(@PathVariable(value = "id") Integer tid,Model model,HttpServletRequest request){
		if (tid==null){
			return "head/taglist";
		}
		//查看第几页
		Integer currentPage=PageUtils.getPageNumber(
				request.getParameter("currentPage"));

		//查看是什么标签
		TTag tag=this.tagService.findByTid(tid);
		
		//根据标签查询
		int Count=this.titleService.findByTagCount(tid,true);
		List<TTitle> titleList=this.titleService.findByTagLimit(new Page(currentPage, 10,tid,true));
		PageBean pageBean=PageUtils.getPageUtils(titleList, Count, currentPage, 10);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("tid", tid);
		model.addAttribute("tag", tag);
		return "head/taglist";
	}

	/**
	 * /title/{id}.html  get
	 *  查询某一具体文章
	 * @param request
	 * @param model
	 * @param tid
	 * @return
	 */
	@RequestMapping(value = "/{id}.html",method = RequestMethod.GET)
	public String Content(HttpServletRequest request,Model model,@PathVariable(value = "id") Integer tid){
		/**
		 * 统计每篇文章的访问量
		 * 调用jedis，首先查看jedis中是否有当前文章，如果当前文章不存在，添加
		 * 查看对应IP是否存在访问，如果不存在，添加计数
		 */
		Jedis jedis=JedisUtils.getJedis();
		
		String ip=request.getRemoteAddr();
		
		String tiCount=jedis.get("titleCount:"+tid);
		Integer titleCount=0;
		if (tiCount==null){
			jedis.set("titleCount:"+tid,1+"");
			jedis.sadd("titleIp:"+tid,ip);
		}else{
			titleCount=Integer.valueOf(tiCount);
			if (!jedis.sismember("titleIp:"+tid,ip)){
				jedis.sadd("titleIp:"+tid,ip);
				titleCount+=1;
				jedis.set("titleCount:"+tid,titleCount+"");
			}
		}
		jedis.close();

		/**
		 * 添加文章访问量
		 */
		model.addAttribute("titleCount", titleCount);


		//查询热门的8篇文章，
		List<TTitle> countList=this.titleService.findByCountLimit(new Page(1, 8,true));

		//查询全部标签
		List<TTag> tagList=this.tagService.findAllTag();
		
		TTitle title=this.titleService.findById(tid);
		//比当前id小的文章
		TTitle title0=this.titleService.findMaxTidToTid(tid);
		//比当前id大的文章
		TTitle title1=this.titleService.findMinTidToTid(tid);
		TCon con=this.conService.findById(tid);
		model.addAttribute("title", title);
		model.addAttribute("con", con);
		model.addAttribute("countList",countList);
		model.addAttribute("tagList",tagList);
		model.addAttribute("title0", title0);
		model.addAttribute("title1", title1);
		return "head/content";
	}
	/*
	* 添加文章（包括新文章与草稿）
	* flag==1的话新文章
	*       0的话保存草稿
	* /title  method :POST
	* */
	@RequestMapping("")
	@ResponseBody
	public String addTitle(TTitle ttitle,TCon tcon,String flag,MultipartFile uploadFile){
		//储存图片
		String path=null;
		try{
			path=pictureSave(uploadFile);
		}catch (Exception e){
			e.printStackTrace();
		}
		/**
		 * 完善文章中的内容
		 */
		boolean fla=flag.equals("1")?true:false;
		this.finishTTitle(ttitle, fla,path);

		//文章添加,返回自增长的id
		this.titleService.addTitle(ttitle);
		//文章内容添加
		tcon.setCid(ttitle.getTid());
		conService.addTcon(tcon);

		return fla? "文章添加成功":"保存草稿成功";
	}
	//将嘈草稿存储
	@RequestMapping("/savetitle")
	@ResponseBody
	public String saveTitle(TTitle ttitle,TCon tcon,MultipartFile uploadFile){
		String path=null;
		try{
			path=pictureSave(uploadFile);
		}catch (Exception e){
			e.printStackTrace();
		}
		this.finishTTitle(ttitle, false,path);
		this.titleService.addTitle(ttitle);
		tcon.setCid(ttitle.getTid());
		this.titleService.update(ttitle);
		return "存草稿成功";
	}
	@RequestMapping("/delete")
	public String delete(TTitle title){
		if (title.getTid()!=null){
			titleService.delete(title);
		}
		return "redirect:/back/back";
	}

	/**
	 * 更新文章
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String  update(TCon con,TTitle title,String flag,MultipartFile uploadFile){
		if (flag!=null&&flag.equals("1")){
			title.setTstatus(true);
		}else{
			title.setTstatus(false);
		}
		if (uploadFile!=null){
			/**
			 * 为了防止配图的重复，用相同的名字把原来的文章覆盖
			 */
			String path=title.getTpic();
			path=path.substring(0,path.lastIndexOf("."));
			String orign=uploadFile.getOriginalFilename();
			orign=orign.substring(orign.lastIndexOf("."));
			path=STORE_PATH+path+orign;
			File file=new File(path);
			if (file.exists()){file.delete();}
			try {
				FileUitls.InputToFile(uploadFile.getInputStream(), file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.titleService.update(title);
		this.conService.update(con);
		return "success";
	}
	/**
	 * 文章存储的方法
	 * @return
	 */
	private String  pictureSave(MultipartFile uploadFile)throws Exception{
		String name=uploadFile.getOriginalFilename();
		name=name.substring(name.lastIndexOf("."));
		name=UUID.randomUUID().toString().replaceAll("-", "")+name;
		
		String path=STORE_PATH+name;
		File file=new File(path);
		FileUitls.InputToFile(uploadFile.getInputStream(), file);
		return name;
	}

	/**
	 * 完善文章内容
	 * 主要是文章状态的变化，用于add与save方法
	 */
	private TTitle finishTTitle(TTitle ttitle,boolean flag,String path){
		ttitle.setTcount(1);
		ttitle.setTstatus(true);
		ttitle.setTtime(new Date());
		ttitle.setTstatus(flag);
		ttitle.setTpic(path);
		return ttitle;
	}
}
