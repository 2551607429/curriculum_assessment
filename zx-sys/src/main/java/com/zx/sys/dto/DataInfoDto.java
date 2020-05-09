package com.zx.sys.dto;

import lombok.Data;

/**
 * @ClassName DataInfoDto
 * @Description 分页获取数据信息
 * @Author ZX
 * @Date 2020/4/26 15:45
 */
@Data
public class DataInfoDto {

    /**
     * id:编号
     */
    private Integer[] id;

    /**
     * username:用户名
     */
    private String username;

    /**
     * option:用户身份：1：学生；2：教师；3：管理员
     */
    private Integer option;

    /**
     * page:页码
     */
    private Integer page;

    /**
     * count:每页个数
     */
    private Integer count;

    /**
     * teacherId:教师编号
     */
    private Integer[] teacherId;

    /**
     * curriculumId:课程编号
     */
    private Integer[] curriculumId;

    /**
     * classId:班级编号
     */
    private Integer[] classId;
}
