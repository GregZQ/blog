package com.zhangqii.pojo;

public class Page {
	int currentSum;
	int row;
	Integer tid;
	Boolean status;
	Boolean type;
	String ttag;
	public Page(int currentSum,int row){
		this.currentSum=(currentSum-1)*row;
		this.row=row;
	}
	public Page(int currentSum,int row,int tid,Boolean status){
		this.currentSum=(currentSum-1)*row;
		this.row=row;
		this.tid=tid;
		this.status=status;
	}
	public Page(int currentSum,int row,Boolean status){
		this.currentSum=(currentSum-1)*row;
		this.row=row;
		this.status=status;
	}
	public Page(int currentSum,int row,Boolean status,String ttag){
		this.currentSum=(currentSum-1)*row;
		this.row=row;
		this.status=status;
		this.ttag=ttag;
	}
	public Page(int currentSum,int row,Boolean status,Boolean type,String ttag){
		this.currentSum=(currentSum-1)*row;
		this.row=row;
		this.status=status;
		this.ttag=ttag;
		this.type=type;
	}
	public void setType(Boolean type) {
		this.type = type;
	}
	public Boolean getType() {
		return type;
	}
	public void setTtag(String ttag) {
		this.ttag = ttag;
	}
	public String getTtag() {
		return ttag;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setCurrentSum(int currentSum) {
		this.currentSum = currentSum;
	}
	public int getCurrentSum() {
		return currentSum;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getTid() {
		return tid;
	}
}
