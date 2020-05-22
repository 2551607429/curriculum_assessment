package com.zx.sys.dao;

import com.zx.sys.model.RegistrationKey;
import com.zx.sys.model.RegistrationKeyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RegistrationKeyMapper {
    int countByExample(RegistrationKeyExample example);

    int deleteByExample(RegistrationKeyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RegistrationKey record);

    int insertSelective(RegistrationKey record);

    List<RegistrationKey> selectByExample(RegistrationKeyExample example);

    RegistrationKey selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RegistrationKey record, @Param("example") RegistrationKeyExample example);

    int updateByExample(@Param("record") RegistrationKey record, @Param("example") RegistrationKeyExample example);

    int updateByPrimaryKeySelective(RegistrationKey record);

    int updateByPrimaryKey(RegistrationKey record);
}