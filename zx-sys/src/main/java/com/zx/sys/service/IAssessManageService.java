package com.zx.sys.service;

import com.dsa.common.enums.ResponseBean;
import com.zx.sys.dto.DataInfoDto;
import com.zx.sys.dto.LoginInputDto;
import com.zx.sys.dto.UserInfoDto;
import com.zx.sys.model.Chapter;
import com.zx.sys.model.Curriculum;
import com.zx.sys.model.QuestionType;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IAssessManageService
 * @Description 考核管理 后台接口
 * @Author ZX
 * @Date 2020/4/20 23:29
 */
public interface IAssessManageService {

    /**
     * Description 加载题型详情
     * @Author ZX
     * @Date 23:30 2020/4/22
     * @param loginInputDto: 学生基本信息：用户名和用户身份
     * @return
     */
    List<QuestionType> typeInit(LoginInputDto loginInputDto);

    /**
     * Description 增加题型
     * @Author ZX
     * @Date 23:37 2020/4/22
     * @param questionType:题型信息
     * @return
     */
    ResponseBean addType(QuestionType questionType);

    /**
     * Description 删除题型
     * @Author ZX
     * @Date 17:27 2020/4/23
     * @param dataInfoDto
     * @return
     */
    ResponseBean deleteType(DataInfoDto dataInfoDto);

    /**
     * Description 修改题型信息
     * @Author ZX
     * @Date 17:29 2020/4/23
     * @param questionType:题型信息
     * @return
     */
    ResponseBean editType(QuestionType questionType);


    /**
     * Description 增加课程信息
     * @Author ZX
     * @Date 22:56 2020/4/26
     * @param curriculum:课程信息
     * @return
     */
    ResponseBean addCurriculum(Curriculum curriculum);

    /**
     * Description 批量上传课程信息
     * @Author ZX
     * @Date 22:21 2020/4/28
     * @param list:课程列表
     * @return com.dsa.common.enums.ResponseBean
     */
    ResponseBean uploadCurriculum(List<Curriculum> list);

    /**
     * Description 删除课程信息
     * @Author ZX
     * @Date 22:56 2020/4/26
     * @param dataInfoDto:课程信息
     * @return
     */
    ResponseBean deleteCurriculum(DataInfoDto dataInfoDto);


    /**
     * Description 分页获取课程信息
     * @Author ZX
     * @Date 20:32 2020/4/26
     * @param dataInfoDto:加载数据信息
     * @return
     */
    Map<String,Object> curriculumInit(DataInfoDto dataInfoDto);

    /**
     * Description 修改课程信息
     * @Author ZX
     * @Date 22:17 2020/4/26
     * @param curriculum:修改的课程数据
     * @return
     */
    ResponseBean editCurriculum(Curriculum curriculum);

    /**
     * Description 增加章节信息
     * @Author ZX
     * @Date 22:56 2020/4/26
     * @param chapter:章节信息
     * @return
     */
    ResponseBean addChapter(Chapter chapter);

    /**
     * Description 删除章节信息
     * @Author ZX
     * @Date 22:56 2020/4/26
     * @param dataInfoDto:章节信息
     * @return
     */
    ResponseBean deleteChapter(DataInfoDto dataInfoDto);


    /**
     * Description 分页获取章节信息
     * @Author ZX
     * @Date 20:32 2020/4/26
     * @param dataInfoDto:加载数据信息
     * @return
     */
    Map<String,Object> chapterInit(DataInfoDto dataInfoDto);

    /**
     * Description 修改章节信息
     * @Author ZX
     * @Date 22:17 2020/4/26
     * @param chapter:修改的章节数据
     * @return
     */
    ResponseBean editChapter(Chapter chapter);

}
