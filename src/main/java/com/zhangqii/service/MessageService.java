package com.zhangqii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.zhangqii.dao.TMessageMapper;
import com.zhangqii.pojo.Page;
import com.zhangqii.pojo.TMessage;
import com.zhangqii.pojo.TMessageExample;
import com.zhangqii.pojo.TMessageExample.Criteria;

@Service
public class MessageService {
	
	@Autowired
	private TMessageMapper messageMapper;

	public void add(TMessage message) {
		this.messageMapper.insert(message);
	}

	public Integer findAllCount() {
		TMessageExample example=new TMessageExample();
		Criteria criteria=example.createCriteria();
		Integer count=this.messageMapper.countByExample(example);
		return count;
	}

	public List<TMessage> findByLimit(Page page) {
		return this.messageMapper.findByLimit(page);
	}

	public void deleteById(Integer mid) {
		this.messageMapper.deleteByPrimaryKey(mid);
		
	}
}
