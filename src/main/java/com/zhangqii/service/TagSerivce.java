package com.zhangqii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangqii.dao.TTagMapper;
import com.zhangqii.pojo.Page;
import com.zhangqii.pojo.TTag;
import com.zhangqii.pojo.TTagExample;
import com.zhangqii.pojo.TTagExample.Criteria;
import com.zhangqii.pojo.TTagExample.Criterion;

@Service
public class TagSerivce {
	
	@Autowired
	private TTagMapper tTagMapper; 
	public int  findTTagCount(){
		TTagExample tagExample=new TTagExample();
		return tTagMapper.countByExample(tagExample);
	}
	public List<TTag> findByLimit(Page page) {
		return this.tTagMapper.findByLimit(page);
	}
	public void addTag(TTag tTag) {
		this.tTagMapper.insert(tTag);
	}
	public void delete(int tid) {
		this.tTagMapper.deleteByPrimaryKey(tid);
	}
	public void updateById(TTag tTag) {
		this.tTagMapper.updateByPrimaryKeySelective(tTag);
	}
	public List<TTag> findAllTag() {
		TTagExample tagExample=new TTagExample();
		Criteria criteria=tagExample.createCriteria();
		return this.tTagMapper.selectByExample(tagExample);
	}
	public TTag findByTid(Integer tid) {
		return this.tTagMapper.selectByPrimaryKey(tid);
	}
}
