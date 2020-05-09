package com.zx.sys.dto;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName NoticeInfoDto
 * @Description 公告信息
 * @Author ZX
 * @Date 2020/4/2 18:55
 */
@Data
public class NoticeInfoDto {

    /**
     * id:公告编号
     */
    private Integer id;

    /**
     * date:发布日期
     */
    private Date date;

    /**
     * name:发布人姓名
     */
    private String name;

    /**
     * name:发布人用户名
     */
    private String username;

    /**
     * title:公告标题
     */
    private String title;

    /**
     * content:公告内容
     */
    private String content;

    /**
     * issueRange:谁可以看到：0:全部用户；1:学生；2:教师；3:管理员；
     */
    private Integer issueRange;

    /**
     * 发布人身份：1:管理员；2:教师
     */
    private Integer identity;

    /**
     * 发布人编号
     */
    private Integer identityId;

    /**
     * state:是否已读  1:已读; 0：未读
     */
    private Integer state;

}
