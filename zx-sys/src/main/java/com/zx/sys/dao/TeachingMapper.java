package com.zx.sys.dao;

import com.zx.sys.dto.TeachingInfoDto;
import com.zx.sys.model.Curriculum;
import com.zx.sys.model.Teaching;
import com.zx.sys.model.TeachingExample;
import com.zx.sys.model.TeachingKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TeachingMapper {
    int countByExample(TeachingExample example);

    int deleteByExample(TeachingExample example);

    int deleteByPrimaryKey(TeachingKey key);

    int insert(Teaching record);

    int insertSelective(Teaching record);

    List<Teaching> selectByExample(TeachingExample example);

    Teaching selectByPrimaryKey(TeachingKey key);

    int updateByExampleSelective(@Param("record") Teaching record, @Param("example") TeachingExample example);

    int updateByExample(@Param("record") Teaching record, @Param("example") TeachingExample example);

    int updateByPrimaryKeySelective(Teaching record);

    int updateByPrimaryKey(Teaching record);




    //自定义

    /**
     * 分页获取授课列表
     * @param page：第几页
     * @param count：每页显示的数量
     * @return
     */
    List<Teaching> selectPagination(@Param("page")Integer page, @Param("count")Integer count);

    /**
     * 查询表中某一列所包含的Id去重列表
     * @param column
     * @return
     */
    List<Integer> selectIdList(@Param("column")String column);
}