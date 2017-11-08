package com.zhangqii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangqii.dao.TConMapper;
import com.zhangqii.pojo.TCon;

@Service
public class ConService {
	
	@Autowired
	private TConMapper tConMapper;
	public void addTcon(TCon tCon){
		this.tConMapper.insert(tCon);
	}
	public TCon findById(Integer tid) {
		return this.tConMapper.selectByPrimaryKey(tid);
	}
	public void update(TCon con) {
		this.tConMapper.updateByPrimaryKeyWithBLOBs(con);
	}
}
