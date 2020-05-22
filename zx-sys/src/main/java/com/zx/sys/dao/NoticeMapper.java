package com.zx.sys.dao;

import com.zx.sys.model.Notice;
import com.zx.sys.model.NoticeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface NoticeMapper {
    int countByExample(NoticeExample example);

    int deleteByExample(NoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExample(NoticeExample example);

    Notice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);





    //自定义
    /**
     * 根据用户身份查找公告
     * @param issueRange
     * @return
     */
    List<Notice> selectNotice(@Param("issueRange") Integer issueRange);

    /**
     * 获取发布人姓名
     * @param identity
     * @param identityId
     * @return
     */
    String selectName(@Param("identity") Integer identity,@Param("identityId") Integer identityId);

    /**
     * 分页获取公告列表
     * @param page：第几页
     * @param count：每页显示的数量
     * @return
     */
    List<Notice> selectPagination(@Param("page")Integer page, @Param("count")Integer count);
}