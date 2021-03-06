package com.zx.sys.dao;

import com.zx.sys.model.AnswerPaper;
import com.zx.sys.model.AnswerPaperExample;
import com.zx.sys.model.AnswerPaperKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AnswerPaperMapper {
    int countByExample(AnswerPaperExample example);

    int deleteByExample(AnswerPaperExample example);

    int deleteByPrimaryKey(AnswerPaperKey key);

    int insert(AnswerPaper record);

    int insertSelective(AnswerPaper record);

    List<AnswerPaper> selectByExample(AnswerPaperExample example);

    AnswerPaper selectByPrimaryKey(AnswerPaperKey key);

    int updateByExampleSelective(@Param("record") AnswerPaper record, @Param("example") AnswerPaperExample example);

    int updateByExample(@Param("record") AnswerPaper record, @Param("example") AnswerPaperExample example);

    int updateByPrimaryKeySelective(AnswerPaper record);

    int updateByPrimaryKey(AnswerPaper record);




//    自定义

    /**
     * 学生查询试卷
     * @param stuId
     * @param examId
     * @return
     */
    List<AnswerPaper> selectPaperStu(@Param("stuId")Integer stuId,@Param("examId")Integer examId);

}