package com.zx.sys.dto;

import lombok.Data;

/**
 * @ClassName RegisterStudentDto
 * @Description TODO
 * @Author ZX
 * @Date 2020/3/25 14:16
 */
@Data
public class UserInfoDto {

    private Integer id;

    private String stuId;

    private String teacherId;

    private String username;

    private String oldPass;

    private String pass;

    private String checkPass;

    private Integer classId;

    private String className;

    private Integer collegeId;

    private String collegeName;

    private String tel;

    private String address;

    private String gender;

    private String name;

    private String key;

    private Integer option;

}
