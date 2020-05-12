package com.zx.sys.dao;

import com.zx.sys.dto.QuestionInfoDto;
import com.zx.sys.model.Chapter;
import com.zx.sys.model.Question;
import com.zx.sys.model.QuestionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface QuestionMapper {
    int countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);


    //自定义

    /**
     * 分页获取题库题目列表
     *
     * @param page：第几页
     * @param count：每页显示的数量
     * @return
     */
    List<Question> selectPagination(@Param("page") Integer page, @Param("count") Integer count);

    /**
     * 根据更新信息进行更新
     * @param record 更新的题目信息
     * @param id 需要更新的编号
     * @return
     */
    int updateByInfo(@Param("record") QuestionInfoDto record, @Param("id") Integer id);
}