package com.zx.sys.dao;

import com.zx.sys.model.NoticeLog;
import com.zx.sys.model.NoticeLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface NoticeLogMapper {
    int countByExample(NoticeLogExample example);

    int deleteByExample(NoticeLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NoticeLog record);

    int insertSelective(NoticeLog record);

    List<NoticeLog> selectByExample(NoticeLogExample example);

    NoticeLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NoticeLog record, @Param("example") NoticeLogExample example);

    int updateByExample(@Param("record") NoticeLog record, @Param("example") NoticeLogExample example);

    int updateByPrimaryKeySelective(NoticeLog record);

    int updateByPrimaryKey(NoticeLog record);





    //自定义

    //查询指定学生用户是否阅读此公告
    NoticeLog selectStudentNoticeLog(@Param("notice_id") Integer notice_id,@Param("stu_id") Integer stu_id);

    //查询指定学生用户是否删除此公告
    NoticeLog deletedStudentNoticeLog(@Param("notice_id") Integer notice_id,@Param("stu_id") Integer stu_id);

    //查询指定教师用户是否阅读此公告
    NoticeLog selectTeacherNoticeLog(@Param("notice_id") Integer notice_id,@Param("teacher_id") Integer teacher_id);

    //查询指定教师用户是否删除此公告
    NoticeLog deletedTeacherNoticeLog(@Param("notice_id") Integer notice_id,@Param("teacher_id") Integer teacher_id);

    //查询指定管理员用户是否阅读此公告
    NoticeLog selectAdminNoticeLog(@Param("notice_id") Integer notice_id,@Param("admin_id") Integer admin_id);

    //查询指定管理员用户是否删除此公告
    NoticeLog deletedAdminNoticeLog(@Param("notice_id") Integer notice_id,@Param("admin_id") Integer admin_id);


}