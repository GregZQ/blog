package com.zhangqii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangqii.dao.TMsayMapper;
import com.zhangqii.pojo.Page;
import com.zhangqii.pojo.TMsay;
import com.zhangqii.pojo.TMsayExample;

@Service
public class SayService {

	@Autowired
	private TMsayMapper tMsayMapper;
	public void addSay(TMsay msay) {
		// TODO Auto-generated method stub
		tMsayMapper.insert(msay);
	}
	public int findAllCount() {
		TMsayExample example=new TMsayExample();
		return tMsayMapper.countByExample(example);
	}
	public List<TMsay> findMySayByLimit(Page page) {
		return tMsayMapper.findMySayByLimit(page);
	}
	public void delete(TMsay msay) {
		tMsayMapper.deleteByPrimaryKey(msay.getMid());
		
	}

}
