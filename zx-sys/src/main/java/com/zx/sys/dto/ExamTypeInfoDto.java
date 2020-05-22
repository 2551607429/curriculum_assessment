package com.zx.sys.dto;

import lombok.Data;

/**
 * @ClassName ExamTypeInfoDto
 * @Description 考试题型选择
 * @Author ZX
 * @Date 2020/5/17 15:54
 */
@Data
public class ExamTypeInfoDto {
    private Integer typeId;

    private Integer count;

    private Float score;

    private Integer maxCount;
}
