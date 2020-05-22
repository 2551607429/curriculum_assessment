package com.zx.sys.dao;

import com.zx.sys.model.Class;
import com.zx.sys.model.ClassExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClassMapper {
    int countByExample(ClassExample example);

    int deleteByExample(ClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Class record);

    int insertSelective(Class record);

    List<Class> selectByExample(ClassExample example);

    Class selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByExample(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);


    /**
     * 自定义
     */

    /**
     * 通过班级名称查询编号
     * @param name
     * @return
     */
    Integer selectByName(@Param("name")String name);

    /**
     * 分页获取班级列表
     * @param page：第几页
     * @param count：每页显示的数量
     * @return
     */
    List<Class> selectPagination(@Param("page")Integer page, @Param("count")Integer count);

    /**
     * 根据教师编号查询任课的全部班级
     * @param teacherId 教师编号
     * @param date 当前时间
     * @return
     */
    List<Class> selectByTeacher(@Param("teacherId")Integer teacherId, @Param("date") Date date);

    /**
     * 根据教师编号查询 某一课程任课的全部班级
     * @param teacherId 教师编号
     * @param date 当前时间
     * @param curriculumId 课程编号
     * @return
     */
    List<Class> selectByCurriculum(@Param("teacherId")Integer teacherId,
                                   @Param("date") Date date,
                                   @Param("curriculumId")Integer curriculumId);
}