package com.zhangqii.dao;

import com.zhangqii.pojo.TCon;
import com.zhangqii.pojo.TConExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TConMapper {
    int countByExample(TConExample example);

    int deleteByExample(TConExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(TCon record);

    int insertSelective(TCon record);

    List<TCon> selectByExampleWithBLOBs(TConExample example);

    List<TCon> selectByExample(TConExample example);

    TCon selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") TCon record, @Param("example") TConExample example);

    int updateByExampleWithBLOBs(@Param("record") TCon record, @Param("example") TConExample example);

    int updateByExample(@Param("record") TCon record, @Param("example") TConExample example);

    int updateByPrimaryKeySelective(TCon record);

    int updateByPrimaryKeyWithBLOBs(TCon record);
}