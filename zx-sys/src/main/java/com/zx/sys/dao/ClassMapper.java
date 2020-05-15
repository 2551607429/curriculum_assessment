package com.zx.sys.dao;

import com.zx.sys.model.Class;
import com.zx.sys.model.ClassExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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
     * 根据教师编号查询任课的班级
     * @param teacherId 教师编号
     * @return
     */
    List<Class> selectByTeacher(@Param("teacherId")Integer teacherId);
}