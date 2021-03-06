package com.zx.sys.dao;

import com.zx.sys.dto.ExamInfoDto;
import com.zx.sys.dto.QuestionInfoDto;
import com.zx.sys.model.Exam;
import com.zx.sys.model.ExamExample;

import java.util.Date;
import java.util.List;

import com.zx.sys.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExamMapper {
    int countByExample(ExamExample example);

    int deleteByExample(ExamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Exam record);

    int insertSelective(Exam record);

    List<Exam> selectByExample(ExamExample example);

    Exam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Exam record, @Param("example") ExamExample example);

    int updateByExample(@Param("record") Exam record, @Param("example") ExamExample example);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);





    //自定义

    /**
     * 分页获取题库题目列表
     *
     * @param page：第几页
     * @param count：每页显示的数量
     * @return
     */
    List<Exam> selectPagination(@Param("page") Integer page, @Param("count") Integer count);

    /**
     * 根据更新信息进行更新
     * @param record 更新的题目信息
     * @param id 需要更新的编号
     * @return
     */
    int updateByInfo(@Param("record") ExamInfoDto record, @Param("id") Integer id);


    /**
     * 根据教师编号分页获取该教师任课的课程所包含的考试
     *
     * @param date：当前时间
     * @param teacherId：教师编号
     * @param page：第几页
     * @param count：每页显示的数量
     * @return
     */
    List<Exam> selectPaginByteach(@Param("date") Date date,
                                  @Param("teacherId")Integer teacherId,
                                  @Param("page") Integer page,
                                  @Param("count") Integer count);

    /**
     * 根据班级编号分页获取该班级所包含的 未发生的考试
     * @param date 当前时间
     * @param classId 班级编号
     * @param page 第几页
     * @param count 每页显示的数量
     * @return
     */
    List<Exam> unSelectPaginByStudent(@Param("date") Date date,
                                  @Param("classId")Integer classId,
                                  @Param("page") Integer page,
                                  @Param("count") Integer count);

    /**
     * 根据班级编号分页获取该班级所包含的 已发生的考试
     * @param date 当前时间
     * @param classId 班级编号
     * @param page 第几页
     * @param count 每页显示的数量
     * @return
     */
    List<Exam> SelectPaginByStudent(@Param("date") Date date,
                                  @Param("classId")Integer classId,
                                  @Param("page") Integer page,
                                  @Param("count") Integer count);

}