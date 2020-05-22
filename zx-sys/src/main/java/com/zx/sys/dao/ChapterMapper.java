package com.zx.sys.dao;

import com.zx.sys.model.Chapter;
import com.zx.sys.model.ChapterExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ChapterMapper {
    int countByExample(ChapterExample example);

    int deleteByExample(ChapterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    List<Chapter> selectByExample(ChapterExample example);

    Chapter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Chapter record, @Param("example") ChapterExample example);

    int updateByExample(@Param("record") Chapter record, @Param("example") ChapterExample example);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);






    //自定义

    /**
     * 分页获取章节列表
     * @param page：第几页
     * @param count：每页显示的数量
     * @return
     */
    List<Chapter> selectPagination(@Param("page")Integer page, @Param("count")Integer count);
}