package com.zhangqii.dao;

import com.zhangqii.pojo.Page;
import com.zhangqii.pojo.TMsay;
import com.zhangqii.pojo.TMsayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMsayMapper {
    int countByExample(TMsayExample example);

    int deleteByExample(TMsayExample example);

    int deleteByPrimaryKey(Integer mid);

    int insert(TMsay record);

    int insertSelective(TMsay record);

    List<TMsay> selectByExample(TMsayExample example);

    TMsay selectByPrimaryKey(Integer mid);

    int updateByExampleSelective(@Param("record") TMsay record, @Param("example") TMsayExample example);

    int updateByExample(@Param("record") TMsay record, @Param("example") TMsayExample example);

    int updateByPrimaryKeySelective(TMsay record);

    int updateByPrimaryKey(TMsay record);

	List<TMsay> findMySayByLimit(Page page);
}