package com.zx.sys.dao;

import com.zx.sys.model.Study;
import com.zx.sys.model.StudyExample;
import com.zx.sys.model.StudyKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface StudyMapper {
    int countByExample(StudyExample example);

    int deleteByExample(StudyExample example);

    int deleteByPrimaryKey(StudyKey key);

    int insert(Study record);

    int insertSelective(Study record);

    List<Study> selectByExample(StudyExample example);

    Study selectByPrimaryKey(StudyKey key);

    int updateByExampleSelective(@Param("record") Study record, @Param("example") StudyExample example);

    int updateByExample(@Param("record") Study record, @Param("example") StudyExample example);

    int updateByPrimaryKeySelective(Study record);

    int updateByPrimaryKey(Study record);
}