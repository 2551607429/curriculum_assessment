package com.zx.sys.dto;

import lombok.Data;

/**
 * @ClassName QuestionInfoDto
 * @Description 题库题目信息表
 * @Author ZX
 * @Date 2020/5/11 22:00
 */
@Data
public class QuestionInfoDto {

    private Integer id;

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

    /**
     * 答案：注：填空题的答案，同义词直接用;隔开
     */
    private String answer;

    /**
     * 关键词：每个关键词之间用;隔开
     */
    private String keyword;

    private Integer curriculumId;

    private String curriculumName;

    private Integer chapterId;

    private String chapterName;

    /**
     * 难度：0-5
     */
    private Float difficulty;
}
