package com.zx.sys.controller;

import com.zx.common.enums.ResponseBean;
import com.zx.sys.dto.*;
import com.zx.sys.model.*;
import com.zx.sys.model.Class;
import com.zx.sys.service.IAssessManageService;
import com.zx.sys.service.ISystemManageService;
import com.zx.sys.service.IUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AdminController
 * @Description 管理员管理的功能
 * @Author ZX
 * @Date 2020/4/20 23:24
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAssessManageService iAssessManageService;

    @Autowired
    private ISystemManageService iSystemManageService;

    @Autowired
    private IUserManageService iUserManageService;


    @PostMapping("/type_init")
    /**
     * @Author ZX
     * @Description 题型信息初始化
     * @Date 23:54 2020/4/20
     * @param [loginInputDto]
     * @return java.util.List<com.zx.sys.model.QuestionType>
     */
    public List<QuestionType> typeInit(@RequestBody LoginInputDto loginInputDto){
        return iAssessManageService.typeInit(loginInputDto);
    }


    @PostMapping("/add_type")
    /**
     * @Description 增加题型
     * @Author ZX
     * @Date 23:28 2020/4/22
     * @param [questionType]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addType(@RequestBody QuestionType questionType){
        return iAssessManageService.addType(questionType);
    }


    @PostMapping("/delete_type")
    /**
     * Description 删除题型信息
     * @Author ZX
     * @Date 17:26 2020/4/23
     * @param [dataInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteType(@RequestBody DataInfoDto dataInfoDto){
        return iAssessManageService.deleteType(dataInfoDto);
    }

    @PostMapping("/edit_type")
    /**
     * Description 修改题型
     * @Author ZX
     * @Date 23:20 2020/4/25
     * @param [questionType]
     * id:需要修改的题型编号
     * name:修改后的题型名称
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editType(@RequestBody QuestionType questionType){
        return iAssessManageService.editType(questionType);
    }

    @PostMapping("/add_curriculum")
    /**
     * Description 增加课程信息
     * @Author ZX
     * @Date 22:55 2020/4/26
     * @param [curriculum]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addCurriculum(@RequestBody Curriculum curriculum){
        return iAssessManageService.addCurriculum(curriculum);
    }

    @PostMapping("/upload_curriculum")
    /**
     * Description 批量上传课程信息
     * @Author ZX
     * @Date 17:12 2020/4/29
     * @param [list]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean uploadCurriculum(@RequestBody List<Curriculum> list){
        return iAssessManageService.uploadCurriculum(list);
    }

    @PostMapping("/delete_curriculum")
    /**
     * Description 删除课程信息
     * @Author ZX
     * @Date 22:55 2020/4/26
     * @param [curriculum]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteCurriculum(@RequestBody DataInfoDto dataInfoDto){
        return iAssessManageService.deleteCurriculum(dataInfoDto);
    }


    @PostMapping("/curriculum_init")
    /**
     * @Author ZX
     * @Description 分页获取课程列表数据
     * @Date 16:27 2020/4/7
     * @param [dataInfoDto]
     * @return java.util.List<com.zx.sys.model.Curriculum>
     */
    public Map<String,Object> curriculumInit(@RequestBody DataInfoDto dataInfoDto){
        return iAssessManageService.curriculumInit(dataInfoDto);
    }

    @PostMapping("/edit_curriculum")
    /**
     * Description 修改课程信息
     * @Author ZX
     * @Date 22:15 2020/4/26
     * @param [curriculum]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editCurriculum(@RequestBody Curriculum curriculum){
        return iAssessManageService.editCurriculum(curriculum);
    }

    @PostMapping("/add_chapter")
    /**
     * Description 增加章节信息
     * @Author ZX
     * @Date 22:55 2020/4/26
     * @param [chapter]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addChapter(@RequestBody Chapter chapter){
        return iAssessManageService.addChapter(chapter);
    }

    @PostMapping("/delete_chapter")
    /**
     * Description 删除章节信息
     * @Author ZX
     * @Date 22:55 2020/4/26
     * @param [dataInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteChapter(@RequestBody DataInfoDto dataInfoDto){
        return iAssessManageService.deleteChapter(dataInfoDto);
    }


    @PostMapping("/chapter_init")
    /**
     * @Author ZX
     * @Description 分页获取章节列表数据
     * @Date 16:27 2020/4/7
     * @param [dataInfoDto]
     * @return java.util.List<com.zx.sys.model.Curriculum>
     */
    public Map<String,Object> chapterInit(@RequestBody DataInfoDto dataInfoDto){
        return iAssessManageService.chapterInit(dataInfoDto);
    }

    @PostMapping("/edit_chapter")
    /**
     * Description 修改章节信息
     * @Author ZX
     * @Date 22:15 2020/4/26
     * @param [chapter]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editChapter(@RequestBody Chapter chapter){
        return iAssessManageService.editChapter(chapter);
    }


    @PostMapping("/add_users")
    /**
     * Description 增加用户信息
     * @Author ZX
     * @Date 22:51 2020/4/29
     * @param [userInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addUser(@RequestBody UserInfoDto userInfoDto){
        return iUserManageService.addUser(userInfoDto);
    }

    @PostMapping("/upload_user")
    /**
     * Description 批量上传用户信息
     * @Author ZX
     * @Date 17:12 2020/4/29
     * @param [list]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean uploadUser(@RequestBody List<UserInfoDto> list){
        return iUserManageService.uploadUser(list);
    }

    @PostMapping("/delete_user")
    /**
     * Description 删除用户信息
     * @Author ZX
     * @Date 22:51 2020/4/29
     * @param [curriculum]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteUser(@RequestBody DataInfoDto dataInfoDto){
        return iUserManageService.deleteUser(dataInfoDto);
    }


    @PostMapping("/user_init")
    /**
     * @Author ZX
     * @Description 分页获取用户列表数据
     * @Date 22:51 2020/4/29
     * @param [dataInfoDto]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> userInit(@RequestBody DataInfoDto dataInfoDto){
        return iUserManageService.userInit(dataInfoDto);
    }

    @PostMapping("/edit_user")
    /**
     * Description 修改用户信息
     * @Author ZX
     * @Date 22:51 2020/4/29
     * @param [registerInputDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editUser(@RequestBody UserInfoDto userInfoDto){
        return iUserManageService.editUser(userInfoDto);
    }

    @PostMapping("/add_notice")
    /**
     * Description 增加公告信息
     * @Author ZX
     * @Date 21:37 2020/5/1
     * @param [noticeInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addNotice(@RequestBody NoticeInfoDto noticeInfoDto){
        return iSystemManageService.addNotice(noticeInfoDto);
    }

    @PostMapping("/delete_notice")
    /**
     * Description 删除公告信息
     * @Author ZX
     * @Date 21:36 2020/5/1
     * @param [dataInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteNotice(@RequestBody DataInfoDto dataInfoDto){
        return iSystemManageService.deleteNotice(dataInfoDto);
    }


    @PostMapping("/notice_init")
    /**
     * Description 分页获取公告列表数据
     * @Author ZX
     * @Date 21:35 2020/5/1
     * @param [dataInfoDto]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> NoticeInit(@RequestBody DataInfoDto dataInfoDto){
        return iSystemManageService.noticeInit(dataInfoDto);
    }

    @PostMapping("/edit_notice")
    /**
     * Description 修改公告信息
     * @Author ZX
     * @Date 21:34 2020/5/1
     * @param [noticeInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editNotice(@RequestBody NoticeInfoDto noticeInfoDto){
        return iSystemManageService.editNotice(noticeInfoDto);
    }


    @PostMapping("/register_init")
    /**
     * Description 分页获取注册码列表数据
     * @Author ZX
     * @Date 15:18 2020/5/5
     * @param [dataInfoDto]
     * @return java.util.List<com.zx.sys.model.RegistrationKey>
     */
    public List<RegistrationKey> registerInit(@RequestBody DataInfoDto dataInfoDto){
        return iSystemManageService.registerInit(dataInfoDto);
    }

    @PostMapping("/edit_register")
    /**
     * Description 修改注册码信息
     * @Author ZX
     * @Date 15:19 2020/5/5
     * @param [registrationKey]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editRegister(@RequestBody RegistrationKey registrationKey){
        return iSystemManageService.editRegister(registrationKey);
    }


    @PostMapping("/add_college")
    /**
     * Description 增加二级学院信息
     * @Author ZX
     * @Date 15:21 2020/5/5
     * @param [college]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addCollege(@RequestBody College college){
        return iSystemManageService.addCollege(college);
    }

    @PostMapping("/delete_college")
    /**
     * Description 删除二级学院信息
     * @Author ZX
     * @Date 15:23 2020/5/5
     * @param [dataInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteCollege(@RequestBody DataInfoDto dataInfoDto){
        return iSystemManageService.deleteCollege(dataInfoDto);
    }


    @PostMapping("/college_init")
    /**
     * Description 分页获取二级学院列表数据
     * @Author ZX
     * @Date 15:23 2020/5/5
     * @param [dataInfoDto]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> collegeInit(@RequestBody DataInfoDto dataInfoDto){
        return iSystemManageService.collegeInit(dataInfoDto);
    }

    @PostMapping("/edit_college")
    /**
     *      * Description 修改二级学院信息
     * @Author ZX
     * @Date 15:24 2020/5/5
     * @param [college]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editCollege(@RequestBody College college){
        return iSystemManageService.editCollege(college);
    }


    @PostMapping("/add_class")
    /**
     * Description 增加班级信息
     * @Author ZX
     * @Date 15:28 2020/5/5
     * @param [classInfo]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addClass(@RequestBody Class classInfo){
        return iSystemManageService.addClass(classInfo);
    }

    @PostMapping("/delete_class")
    /**
     * Description 删除班级信息
     * @Author ZX
     * @Date 15:28 2020/5/5
     * @param [dataInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteClass(@RequestBody DataInfoDto dataInfoDto){
        return iSystemManageService.deleteClass(dataInfoDto);
    }


    @PostMapping("/class_init")
    /**
     * Description 分页获取班级列表数据
     * @Author ZX
     * @Date 15:28 2020/5/5
     * @param [dataInfoDto]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> classInit(@RequestBody DataInfoDto dataInfoDto){
        return iSystemManageService.classInit(dataInfoDto);
    }

    @PostMapping("/edit_class")
    /**
     * Description 修改班级信息
     * @Author ZX
     * @Date 15:28 2020/5/5
     * @param [classInfo]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editClass(@RequestBody Class classInfo){
        return iSystemManageService.editClass(classInfo);
    }


    @PostMapping("/add_teaching")
    /**
     * Description 增加任课信息
     * @Author ZX
     * @Date 17:06 2020/5/8
     * @param [teachingInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addTeaching(@RequestBody TeachingInfoDto teachingInfoDto){
        return iUserManageService.addTeaching(teachingInfoDto);
    }

    @PostMapping("/upload_teaching")
    /**
     * Description 批量上传任课信息
     * @Author ZX
     * @Date 17:06 2020/5/8
     * @param [list]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean uploadTeaching(@RequestBody List<TeachingInfoDto> list){
        return iUserManageService.uploadTeaching(list);
    }

    @PostMapping("/delete_teaching")
    /**
     * Description 删除任课信息
     * @Author ZX
     * @Date 17:06 2020/5/8
     * @param [dataInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteTeaching(@RequestBody DataInfoDto dataInfoDto){
        return iUserManageService.deleteTeaching(dataInfoDto);
    }


    @PostMapping("/teaching_init")
    /**
     * Description 分页获取任课列表数据
     * @Author ZX
     * @Date 17:06 2020/5/8
     * @param [dataInfoDto]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> teachingInit(@RequestBody DataInfoDto dataInfoDto){
        return iUserManageService.teachingInit(dataInfoDto);
    }

    @PostMapping("/edit_teaching")
    /**
     * Description 修改任课信息
     * @Author ZX
     * @Date 17:06 2020/5/8
     * @param [teachingInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean esdiTeaching(@RequestBody TeachingInfoDto teachingInfoDto){
        return iUserManageService.editTeaching(teachingInfoDto);
    }

    @PostMapping("/teacher_info")
    /**
     * Description 获取所有的教师信息
     * @Author ZX
     * @Date 22:40 2020/5/8
     * @param []
     * @return java.util.Map<java.lang.Integer,com.zx.sys.model.Teacher>
     */
    public Map<Integer, Teacher> teacherInfo(){
        return iUserManageService.teacherInfo();
    }

    @PostMapping("/curriculum_info")
    /**
     * Description 获取所有的课程信息
     * @Author ZX
     * @Date 22:43 2020/5/8
     * @param []
     * @return java.util.Map<java.lang.Integer,com.zx.sys.model.Curriculum>
     */
    public Map<Integer, Curriculum> curriculumInfo(@RequestBody DataInfoDto dataInfoDto){
        return iUserManageService.curriculumInfo(dataInfoDto);
    }

    @PostMapping("/teaching_info")
    /**
     * Description 获取任课信息中的所有筛选信息
     * @Author ZX
     * @Date 22:51 2020/5/8
     * @param []
     * @return java.util.List<java.util.List<java.util.Map<java.lang.String,java.lang.String>>>
     */
    public List<List<Map<String, String>>> teachingInfo(){
        return iUserManageService.teachingInfo();
    }

}
