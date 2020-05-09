package com.zx.sys.dao;

import com.zx.sys.model.Curriculum;
import com.zx.sys.model.CurriculumExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CurriculumMapper {
    int countByExample(CurriculumExample example);

    int deleteByExample(CurriculumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Curriculum record);

    int insertSelective(Curriculum record);

    List<Curriculum> selectByExample(CurriculumExample example);

    Curriculum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Curriculum record, @Param("example") CurriculumExample example);

    int updateByExample(@Param("record") Curriculum record, @Param("example") CurriculumExample example);

    int updateByPrimaryKeySelective(Curriculum record);

    int updateByPrimaryKey(Curriculum record);





    //自定义

    /**
     * 分页获取课程列表
     * @param page：第几页
     * @param count：每页显示的数量
     * @return
     */
    List<Curriculum> selectPagination(@Param("page")Integer page, @Param("count")Integer count);

    /**
     * 通过课程名称查询编号
     * @param name
     * @return
     */
    Curriculum selectByName(@Param("name")String name);
}