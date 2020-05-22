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

    private String answer;

    private List<String> answerList;

    private Float score;

    private Float stuScore;
}
