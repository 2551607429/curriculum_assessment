package com.zx.sys.controller;

import com.zx.common.enums.ResponseBean;
import com.zx.sys.dto.DataInfoDto;
import com.zx.sys.dto.ExamInfoDto;
import com.zx.sys.dto.PaperInfoDto;
import com.zx.sys.service.IAssessManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentController
 * @Description 与学生相关的基本信息
 * @Author ZX
 * @Date 2020/3/27 18:56
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IAssessManageService iAssessManageService;




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

    @PostMapping("/submit_paper")
    /**
     * Description 学生提交试卷
     * @Author ZX
     * @Date 19:18 2020/5/23
     * @param [list]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean submitPaper(@RequestBody List<PaperInfoDto> list){
        return iAssessManageService.submitPaper(list);
    }

}
