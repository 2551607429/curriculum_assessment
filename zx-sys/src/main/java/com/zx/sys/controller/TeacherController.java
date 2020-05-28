package com.zx.sys.controller;

import com.zx.common.enums.ResponseBean;
import com.zx.sys.dto.*;
import com.zx.sys.model.Chapter;
import com.zx.sys.model.Class;
import com.zx.sys.model.Curriculum;
import com.zx.sys.model.QuestionType;
import com.zx.sys.service.IAssessManageService;
import com.zx.sys.service.IUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TeacherController
 * @Description 教师管理的功能
 * @Author ZX
 * @Date 2020/5/7 10:33
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {


    @Autowired
    private IAssessManageService iAssessManageService;

    @Autowired
    private IUserManageService iUserManageService;


    @PostMapping("/add_question")
    /**
     * Description 增加题库题目信息
     * @Author ZX
     * @Date 10:36 2020/5/12
     * @param [questionInfoDto]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean addQuestion(@RequestBody QuestionInfoDto questionInfoDto){
        return iAssessManageService.addQuestion(questionInfoDto);
    }

    @PostMapping("/upload_question")
    /**
     * Description 批量上传题库题目信息
     * @Author ZX
     * @Date 10:37 2020/5/12
     * @param [list]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean uploadQuestion(@RequestBody List<QuestionInfoDto> list){
        return iAssessManageService.uploadQuestion(list);
    }

    @PostMapping("/delete_question")
    /**
     * Description 删除题库题目信息
     * @Author ZX
     * @Date 10:37 2020/5/12
     * @param [dataInfoDto]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean deleteQuestion(@RequestBody DataInfoDto dataInfoDto){
        return iAssessManageService.deleteQuestion(dataInfoDto);
    }


    @PostMapping("/question_init")
    /**
     * Description 分页获取题库题目列表数据
     * @Author ZX
     * @Date 10:37 2020/5/12
     * @param [dataInfoDto]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> questionInit(@RequestBody DataInfoDto dataInfoDto){
        return iAssessManageService.questionInit(dataInfoDto);
    }

    @PostMapping("/edit_question")
    /**
     * Description 修改题库题目信息
     * @Author ZX
     * @Date 10:37 2020/5/12
     * @param [questionInfoDto]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean esdiQuestion(@RequestBody QuestionInfoDto questionInfoDto){
        return iAssessManageService.editQuestion(questionInfoDto);
    }

    @PostMapping("/type_info")
    /**
     * Description 获取所有的题目题型信息
     * @Author ZX
     * @Date 16:57 2020/5/12
     * @param []
     * @return java.util.Map<java.lang.Integer,com.zx.sys.model.QuestionType>
     */
    public Map<Integer, QuestionType> typeInfo(){
        return iAssessManageService.typeInfo();
    }


    @PostMapping("/chapter_info")
    /**
     * Description 获取所有的章节信息
     * @Author ZX
     * @Date 17:05 2020/5/12
     * @param []
     * @return java.util.Map<java.lang.Integer,com.zx.sys.model.Chapter>
     */
    public Map<Integer, Chapter> chapterInfo(){
        return iAssessManageService.chapterInfo();
    }

    @PostMapping("/add_exam")
    /**
     * Description 增加考试信息
     * @Author ZX
     * @Date 10:36 2020/5/12
     * @param [examInfoDto]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean addExam(@RequestBody ExamInfoDto examInfoDto){
        return iAssessManageService.addExam(examInfoDto);
    }

    @PostMapping("/delete_exam")
    /**
     * Description 删除考试信息
     * @Author ZX
     * @Date 10:37 2020/5/12
     * @param [dataInfoDto]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean deleteExam(@RequestBody DataInfoDto dataInfoDto){
        return iAssessManageService.deleteExam(dataInfoDto);
    }


    @PostMapping("/exam_init")
    /**
     * Description 分页获取考试列表数据
     * @Author ZX
     * @Date 10:37 2020/5/12
     * @param [dataInfoDto]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> examInit(@RequestBody DataInfoDto dataInfoDto){
        return iAssessManageService.examInit(dataInfoDto);
    }

    @PostMapping("/edit_exam")
    /**
     * Description 修改考试信息
     * @Author ZX
     * @Date 10:37 2020/5/12
     * @param [examInfoDto]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean editExam(@RequestBody ExamInfoDto examInfoDto){
        return iAssessManageService.editExam(examInfoDto);
    }

    @PostMapping("/curriculum_info")
    /**
     * Description 获取自己任课的所有课程信息
     * @Author ZX
     * @Date 10:13 2020/5/13
     * @param [dataInfoDto]
     * @return java.util.Map<java.lang.Integer,com.zx.sys.model.Curriculum>
     */
    public Map<Integer, Curriculum> curriculumInfo(@RequestBody DataInfoDto dataInfoDto){
        return iUserManageService.curriculumInfo(dataInfoDto);
    }

    @PostMapping("/class_info")
    /**
     * Description 获取自己任课的所有班级信息
     * @Author ZX
     * @Date 15:18 2020/5/13
     * @param [dataInfoDto]
     * @return java.util.Map<java.lang.Integer,com.zx.sys.model.Class>
     */
    public Map<Integer, Class> classInfo(@RequestBody DataInfoDto dataInfoDto){
        return iAssessManageService.classInfo(dataInfoDto);
    }

    @PostMapping("/question_count_type")
    /**
     * Description 查询课程的各个题型的问题数量
     * @Author ZX
     * @Date 19:49 2020/5/13
     * @param dataInfoDto
     * @return
     */
    public Map<Integer, Integer> questionCountByType(@RequestBody DataInfoDto dataInfoDto){
        return iAssessManageService.questionCountByType(dataInfoDto);
    }

    @PostMapping("/exam_student_init")
    /**
     * Description 分页获取学生考试列表信息
     * @Author ZX
     * @Date 10:37 2020/5/12
     * @param [dataInfoDto]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> examStudentInit(@RequestBody DataInfoDto dataInfoDto){
        return iAssessManageService.examStudentInit(dataInfoDto);
    }


    @PostMapping("/paper_init")
    /**
     * Description 加载试卷信息
     * @Author ZX
     * @Date 10:37 2020/5/12
     * @param [examInfoDto]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public List<PaperInfoDto> paperInit(@RequestBody ExamInfoDto examInfoDto){
        return iAssessManageService.paperInit(examInfoDto);
    }

    @PostMapping("/submit_correct_paper")
    /**
     * Description 教师提交阅卷
     * @Author ZX
     * @Date 21:05 2020/5/26
     * @param [list]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean submitCorrectPaper(@RequestBody List<PaperInfoDto> list){
        return iAssessManageService.submitCorrectPaper(list);
    }

}
