package com.zx.sys.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName PaperInfoDto
 * @Description TODO
 * @Author ZX
 * @Date 2020/5/18 19:51
 */
@Data
public class PaperInfoDto {

    private Integer examId;

    private String examName;

    private Date startTime;

    private Date endTime;

    private Integer questionId;

    /**
     * 题型编号
     */
    private Integer typeId;

    /**
     * 题型名称
     */
    private String typeName;

    /**
     * 题干
     */
    private String stem;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private Integer stuId;

    private String name;

    private String stuAnswer;

    private List<String> stuAnswerList;

    private String answer;

    private List<String> answerList;

    /**
     * 多选题的学生答案
     */
    private List<String> checkList;

    private Float score;

    private Float stuScore;

    /**
     * 做题结果：0：错，1:对；
     */
    private Integer result;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 学号
     */
    private String studentId;

    /**
     * 学生总得分
     */
    private Float stuTotalScore;

    /**
     * 试卷总分
     */
     private Integer totalScore;

}
