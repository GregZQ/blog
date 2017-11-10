package com.zhangqii.utils;

import java.util.List;

import com.zhangqii.pojo.PageBean;

public class PageUtils {

	@SuppressWarnings("rawtypes")
	public static PageBean getPageUtils(List list,int allCount,int currentPage,int row){
		PageBean pageBean=new PageBean();
		pageBean.setList(list);
		pageBean.setAllCount(allCount);
		pageBean.setRow(row);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(allCount/row);
		if (allCount%row!=0){
			pageBean.setTotalPage(pageBean.getTotalPage()+1);
		}
		return pageBean;
	}
	/**
	 * 得到一个页面的页码
	 */
	public  static  Integer getPageNumber(String currentPage){
		Integer pageNumber=1;
		if (currentPage==null||currentPage.trim().equals("")){
			return pageNumber;
		}
		return Integer.valueOf(currentPage);
	}
}
