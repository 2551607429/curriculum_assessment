package com.zx.sys.dao;

import com.zx.sys.model.College;
import com.zx.sys.model.CollegeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CollegeMapper {
    int countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(College record);

    int insertSelective(College record);

    List<College> selectByExample(CollegeExample example);

    College selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);



    /**
     * 自定义
     */

    /**
     * 通过学院名称查询编号
     * @param name
     * @return
     */
    Integer selectByName(@Param("name")String name);

    /**
     * 分页获取学院列表
     * @param page：第几页
     * @param count：每页显示的数量
     * @return
     */
    List<College> selectPagination(@Param("page")Integer page, @Param("count")Integer count);
}