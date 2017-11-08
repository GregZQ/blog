package com.zhangqii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangqii.dao.TTitleMapper;
import com.zhangqii.pojo.Page;
import com.zhangqii.pojo.TMsay;
import com.zhangqii.pojo.TTitle;
import com.zhangqii.pojo.TTitleExample;
import com.zhangqii.pojo.TTitleExample.Criteria;
import com.zhangqii.pojo.TitleAndTag;

@Service
public class TitleService {
	
	@Autowired
	private  TTitleMapper titleMapper;
	
	public int addTitle(TTitle title){
		return this.titleMapper.insert(title);
	}
	public Integer findByStatusCount(Boolean status) {
		TTitleExample example=new TTitleExample();
		Criteria criteria=example.createCriteria();
		criteria.andTstatusEqualTo(status);
		return titleMapper.countByExample(example);
	}
	public List<TTitle> findByStatusLimit(Page page) {
		return this.titleMapper.findByStatusLimit(page);
	}
	public void delete(TTitle title) {
		this.titleMapper.deleteByPrimaryKey(title.getTid());
		
	}
	public TTitle  findById(Integer id) {
		return titleMapper.selectByPrimaryKey(id);
	}
	public void update(TTitle title) {
		this.titleMapper.updateByPrimaryKey(title);
	}
	public List<TitleAndTag> findTitleAndTagLimit(Page page) {
		return this.titleMapper.findTitleAndTagLimit(page);
	}
	public List<TTitle> findByCountLimit(Page page) {
		return this.titleMapper.findByCountLimit(page);
	}
	public List<TTitle> findByTagLimit(Page page) {
		return this.titleMapper.findByTagLimit(page);
	}
	public int findByTagCount(Integer tid,Boolean status) {
		TTitleExample example=new TTitleExample();
		Criteria criteria=example.createCriteria();
		criteria.andTtagEqualTo(tid);
		criteria.andTstatusEqualTo(status);
		
		int Count=titleMapper.countByExample(example);
		return Count;
	}
	public TTitle findMaxTidToTid(Integer tid) {
		return this.titleMapper.findMaxTidToTid(tid);
	}
	public TTitle findMinTidToTid(Integer tid) {
		return this.titleMapper.findMinTidToTid(tid);
	}
}
