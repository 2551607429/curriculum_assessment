package com.zx.sys.dao;

import com.zx.sys.dto.QuestionInfoDto;
import com.zx.sys.model.Chapter;
import com.zx.sys.model.Question;
import com.zx.sys.model.QuestionExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
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

    /**
     * 根据教师编号分页获取该教师任课的课程所包含的题库
     * @param date 当前日期
     * @param teacherId 教师编号
     * @param page 第几页
     * @param count 每页显示的个数
     * @return
     */
    List<Question> selectPaginByTeach(@Param("date") Date date,
                                      @Param("teacherId")Integer teacherId,
                                      @Param("page") Integer page,
                                      @Param("count") Integer count);

    /**
     * 根据教师编号获取该教师任课的题库数量
     * @param teacherId
     * @return
     */
    int countByTeacher(@Param("teacherId")Integer teacherId);

    /**
     * 根据课程编号和题型编号进行统计各题型的数量
     * @param curriculumId 课程编号
     * @param typeId 题型编号
     * @return
     */
    Integer countByCurriculum(@Param("curriculumId")Integer curriculumId,@Param("typeId")Integer typeId);


    /**
     * 根据教师编号获取该教师任课的课程所包含的 某种题型的题目编号列表
     * @param date 当前日期
     * @param teacherId 教师编号
     * @param typeId 题型编号
     * @param difficulty 难度
     * @param count 数量
     * @return
     */
    List<Integer> selectAllByType(@Param("date") Date date,
                                      @Param("teacherId")Integer teacherId,
                                    @Param("typeId")Integer typeId,
                                    @Param("difficulty")Float difficulty,
                                    @Param("count")Integer count);

}