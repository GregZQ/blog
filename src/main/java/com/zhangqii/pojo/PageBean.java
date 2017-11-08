package com.zhangqii.pojo;

import java.util.List;

public class PageBean<T> {

	//��ҳ��
	private int totalPage;
	//��ǰҳ
	private int currentPage;
	
	//�ܼ�¼��
	private int allCount;
	//ÿҳ��¼��
	private int row;
	//��ѯ���
	private List<T>list;
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
