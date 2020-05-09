package com.zx.sys.service;

import com.dsa.common.enums.ResponseBean;
import com.zx.sys.dto.DataInfoDto;
import com.zx.sys.dto.TeachingInfoDto;
import com.zx.sys.dto.UserInfoDto;
import com.zx.sys.model.Class;
import com.zx.sys.model.Curriculum;
import com.zx.sys.model.Teacher;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IUserManageService
 * @Description 成员管理 接口
 * @Author ZX
 * @Date 2020/4/30 9:05
 */
public interface IUserManageService {

    /**
     * Description 增加用户信息
     * @Author ZX
     * @Date 9:11 2020/4/30
     * @param userInfoDto:用户信息
     * @return
     */
    ResponseBean addUser(UserInfoDto userInfoDto);

    /**
     * Description 批量上传用户信息
     * @Author ZX
     * @Date 9:14 2020/4/30
     * @param list
     * @return
     */
    ResponseBean uploadUser(List<UserInfoDto> list);

    /**
     * Description 删除用户信息
     * @Author ZX
     * @Date 9:14 2020/4/30
     * @param dataInfoDto
     * @return
     */
    ResponseBean deleteUser(DataInfoDto dataInfoDto);

    /**
     * Description 分页获取用户信息
     * @Author ZX
     * @Date 9:09 2020/4/30
     * @param dataInfoDto:分页数据信息
     * @return
     */
    Map<String,Object> userInit(DataInfoDto dataInfoDto);

    /**
     * Description 修改用户信息
     * @Author ZX
     * @Date 9:15 2020/4/30
     * @param userInfoDto
     * @return
     */
    ResponseBean editUser(UserInfoDto userInfoDto);


    /**
     * Description 增加任课信息
     * @Author ZX
     * @Date 16:05 2020/5/7
     * @param teachingInfoDto:任课信息
     * @return
     */
    ResponseBean addTeaching(TeachingInfoDto teachingInfoDto);

    /**
     * Description 批量上传任课信息
     * @Author ZX
     * @Date 16:05 2020/5/7
     * @param list
     * @return
     */
    ResponseBean uploadTeaching(List<TeachingInfoDto> list);

    /**
     * Description 删除任课信息
     * @Author ZX
     * @Date 16:06 2020/5/7
     * @param dataInfoDto
     * @return
     */
    ResponseBean deleteTeaching(DataInfoDto dataInfoDto);

    /**
     * Description 分页获取任课信息
     * @Author ZX
     * @Date 16:06 2020/5/7
     * @param dataInfoDto:分页数据信息
     * @return
     */
    Map<String,Object> teachingInit(DataInfoDto dataInfoDto);

    /**
     * Description 修改任课信息
     * @Author ZX
     * @Date 16:06 2020/5/7
     * @param teachingInfoDto
     * @return
     */
    ResponseBean editTeaching(TeachingInfoDto teachingInfoDto);


    /**
     * Description 获取所有的教师信息
     * @Author ZX
     * @Date 21:46 2020/5/8
     * @param
     * @return
     */
    Map<Integer, Teacher> teacherInfo();

    /**
     * Description 获取所有的课程信息
     * @Author ZX
     * @Date 21:48 2020/5/8
     * @param
     * @return
     */
    Map<Integer, Curriculum> curriculumInfo();

    /**
     * Description 获取任课信息中的所有筛选信息
     * @Author ZX
     * @Date 21:49 2020/5/8
     * @param
     * @return
     */
    List<List<Map<String, String>>> teachingInfo();
}
