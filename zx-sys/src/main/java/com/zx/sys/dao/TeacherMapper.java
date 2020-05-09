package com.zx.sys.dao;

import com.zx.sys.dto.UserInfoDto;
import com.zx.sys.model.Teacher;
import com.zx.sys.model.TeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    int countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);







//    自定义


    /**
     * 根据用户名查询教师信息
     * @param username
     * @return
     */
    Teacher selectByUserName(@Param("username")String username);

    /**
     * 更新用户信息
     * @param input
     * @param id
     * @return
     */
    int updateInfo(@Param("input") UserInfoDto input, @Param("id")Integer id);

    /**
     * 修改密码
     * @param pwd
     * @param id
     * @return
     */
    int updatePwd(@Param("pwd") String pwd,@Param("id")Integer id);

    /**
     * 分页获取教师列表
     * @param page：第几页
     * @param count：每页显示的数量
     * @return
     */
    List<Teacher> selectPagination(@Param("page")Integer page, @Param("count")Integer count);



    /**
     * 根据教师编号查询教师信息
     * @param teacherId
     * @return
     */
    Teacher selectByTeacherId(@Param("teacherId")String teacherId);

}