package com.zx.sys.dto;

import lombok.Data;

/**
 * @ClassName AchievementInfoDto
 * @Description TODO
 * @Author ZX
 * @Date 2020/5/25 16:13
 */
@Data
public class AchievementInfoDto {

    private Integer studentId;

    private Integer classId;

    private Integer examId;

    private Float score;

    private String name;

    private String className;

    private String examName;

    private String username;

    private Integer option;

    /**
     * 班级应考人数
     */
    private Integer count;

    /**
     * 班级实际考试人数
     */
    private Integer realCount;

    /**
     * 参考率
     */
    private Float referenceRate;

    /**
     * 及格率
     */
    private Float passRate;
}
