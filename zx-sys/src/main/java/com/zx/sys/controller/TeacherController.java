package com.zx.sys.controller;

import com.zx.common.enums.ResponseBean;
import com.zx.sys.dto.DataInfoDto;
import com.zx.sys.dto.QuestionInfoDto;
import com.zx.sys.dto.TeachingInfoDto;
import com.zx.sys.model.Chapter;
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


}
