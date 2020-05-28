package com.zx.sys.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ExamInfoDto
 * @Description TODO
 * @Author ZX
 * @Date 2020/5/12 21:39
 */
@Data
public class ExamInfoDto {

    private Integer stuId;

    private Integer id;

    private String name;

    private Date startTime;

    private Date endTime;

    private List<Date> examTime;

    /**
     * 考试总分
     */
    private Integer totalScore;

    /**
     * 学生考试总分
     */
    private Float stuTotalScore;

    /**
     * 考试难度：0-5
     */
    private Float difficulty;

    /**
     * 考试范围：1：全部学生；2：按照班级划分
     */
    private Integer examRange;

    /**
     * 参加考试班级范围：当考试范围是2时，输入该信息，班级编号之间以；隔开
     */
    private String classRange;

    private Integer[] classIdRange;

    private String classNameRange;

    private Integer curriculumId;

    private String curriculumName;

    private List<ExamTypeInfoDto> typeList;

    private Integer option;

    private String username;


}
