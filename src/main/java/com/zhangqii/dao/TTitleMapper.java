package com.zhangqii.dao;

import com.zhangqii.pojo.Page;
import com.zhangqii.pojo.TTitle;
import com.zhangqii.pojo.TTitleExample;
import com.zhangqii.pojo.TitleAndTag;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTitleMapper {
    int countByExample(TTitleExample example);

    int deleteByExample(TTitleExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TTitle record);

    int insertSelective(TTitle record);

    List<TTitle> selectByExample(TTitleExample example);

    TTitle selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TTitle record, @Param("example") TTitleExample example);

    int updateByExample(@Param("record") TTitle record, @Param("example") TTitleExample example);

    int updateByPrimaryKeySelective(TTitle record);

    int updateByPrimaryKey(TTitle record);

	List<TTitle> findByStatusLimit(Page page);
	
	List<TitleAndTag> findTitleAndTagLimit(Page page);

	List<TTitle> findByCountLimit(Page page);

	List<TTitle> findByTagLimit(Page page);

	TTitle findMaxTidToTid(Integer tid);

	TTitle findMinTidToTid(Integer tid);
}