package com.zx.sys.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName TeachingInfoDto
 * @Description 任课信息数据
 * @Author ZX
 * @Date 2020/5/7 16:09
 */
@Data
public class TeachingInfoDto {

    private Integer teacherId;

    private String teachId;

    private String teacherName;

    private Integer curriculumId;

    private String curriculumName;

    private Integer classId;

    private String className;

    private List<Date> teachingDate;

    private Date startTime;

    private Date endTime;

    private Integer option;

    private String key;

}
