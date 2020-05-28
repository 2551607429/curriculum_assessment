package com.zx.sys.dao;

import com.zx.sys.dto.UserInfoDto;
import com.zx.sys.model.Student;
import com.zx.sys.model.StudentExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);



//    自定义

    /**
     * 根据用户名查询学生信息
     * @Author ZX
     * @Date 17:40 2020/4/22
     * @param username:用户名
     * @return
     */
    Student selectByUserName(@Param("username")String username);


    /**
     * 更新用户信息
     * @Author ZX
     * @Date 17:38 2020/4/22
     * @param input:用户信息
     * @param id:用户编号
     * @return
     */
    int updateInfo(@Param("input") UserInfoDto input, @Param("id")Integer id);

    /**
     * 修改密码
     * @param pwd:新密码
     * @param id: 用户名id
     * @return
     */
    int updatePwd(@Param("pwd") String pwd,@Param("id")Integer id);

    /**
     * 分页获取学生信息
     * @param page：第几页
     * @param count：每页显示的数量
     * @return
     */
    List<Student> selectPagination(@Param("page")Integer page,@Param("count")Integer count);

    /**
     * 根据教师编号查询当前所教授班级
     * @param teacherId 教师编号
     * @param date 当前时间
     * @param curriculumId 课程编号
     * @return
     */
    List<Integer> selectByTeacher(@Param("teacherId")Integer teacherId,
                              @Param("date") Date date,
                              @Param("curriculumId")Integer curriculumId);

    /**
     * 根据班级编号列表查询学生
     * @param classId
     * @return
     */
    List<Integer> selectByClassList(@Param("array")Integer[] classId);

    /**
     * 分页获取班级考试学生
     * @param classId
     * @param page
     * @param count
     * @return
     */
    List<Integer> selectByClassPagin(@Param("array")Integer[] classId,
                                     @Param("page")Integer page,
                                     @Param("count")Integer count);

    /**
     * 查询班级人数
     * @param class_id 班级编号
     * @return
     */
    Integer classCount(@Param("class_id")Integer class_id);
}