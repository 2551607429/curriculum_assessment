package com.zx.sys.service;

import com.dsa.common.enums.ResponseBean;
import com.zx.sys.dto.DataInfoDto;
import com.zx.sys.dto.NoticeInfoDto;
import com.zx.sys.model.Chapter;
import com.zx.sys.model.Class;
import com.zx.sys.model.College;
import com.zx.sys.model.RegistrationKey;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ISystemManageService
 * @Description 系统管理 接口
 * @Author ZX
 * @Date 2020/5/2 16:13
 */
public interface ISystemManageService {

    /**
     * Description 增加公告信息
     * @Author ZX
     * @Date 16:14 2020/5/2
     * @param noticeInfoDto:公告信息
     * @return
     */
    ResponseBean addNotice(NoticeInfoDto noticeInfoDto);

    /**
     * Description 删除公告信息
     * @Author ZX
     * @Date 16:14 2020/5/2
     * @param dataInfoDto
     * @return
     */
    ResponseBean deleteNotice(DataInfoDto dataInfoDto);

    /**
     * Description 分页获取公告信息
     * @Author ZX
     * @Date 16:15 2020/5/2
     * @param dataInfoDto:分页数据信息
     * @return
     */
    Map<String,Object> noticeInit(DataInfoDto dataInfoDto);

    /**
     * Description 修改公告信息
     * @Author ZX
     * @Date 16:15 2020/5/2
     * @param noticeInfoDto
     * @return
     */
    ResponseBean editNotice(NoticeInfoDto noticeInfoDto);

    /**
     * Description 获取注册码信息
     * @Author ZX
     * @Date 22:55 2020/5/4
     * @param dataInfoDto:加载数据信息
     * @return
     */
    List<RegistrationKey> registerInit(DataInfoDto dataInfoDto);

    /**
     * Description 修改注册码信息
     * @Author ZX
     * @Date 22:56 2020/5/4
     * @param registrationKey:修改的注册码数据
     * @return
     */
    ResponseBean editRegister(RegistrationKey registrationKey);

    /**
     * Description 增加二级学院信息
     * @Author ZX
     * @Date 23:00 2020/5/4
     * @param college:二级学院信息
     * @return
     */
    ResponseBean addCollege(College college);

    /**
     * Description 删除二级学院信息
     * @Author ZX
     * @Date 23:01 2020/5/4
     * @param dataInfoDto:二级学院信息
     * @return
     */
    ResponseBean deleteCollege(DataInfoDto dataInfoDto);

    /**
     * Description 分页获取二级学院信息
     * @Author ZX
     * @Date 23:01 2020/5/4
     * @param dataInfoDto:加载数据信息
     * @return
     */
    Map<String,Object> collegeInit(DataInfoDto dataInfoDto);

    /**
     * Description 修改二级学院信息
     * @Author ZX
     * @Date 23:01 2020/5/4
     * @param college:修改的章节数据
     * @return
     */
    ResponseBean editCollege(College college);

    /**
     * Description 增加班级信息
     * @Author ZX
     * @Date 23:04 2020/5/4
     * @param classInfo:班级信息
     * @return
     */
    ResponseBean addClass(Class classInfo);

    /**
     * Description 删除班级信息
     * @Author ZX
     * @Date 23:04 2020/5/4
     * @param dataInfoDto:章节信息
     * @return
     */
    ResponseBean deleteClass(DataInfoDto dataInfoDto);


    /**
     * Description 分页获取班级信息
     * @Author ZX
     * @Date 23:05 2020/5/4
     * @param dataInfoDto:加载数据信息
     * @return
     */
    Map<String,Object> classInit(DataInfoDto dataInfoDto);

    /**
     * Description 修改班级信息
     * @Author ZX
     * @Date 23:05 2020/5/4
     * @param classInfo:修改的班级数据
     * @return
     */
    ResponseBean editClass(Class classInfo);


}
