package com.zx.sys.dto;

import lombok.Data;

/**
 * @ClassName NoticeLogDto
 * @Description TODO
 * @Author ZX
 * @Date 2020/4/7 17:35
 */
@Data
public class NoticeLogDto {

    /**
     *id:公告编号
     */
    private Integer[] id;

    /**
     * username:用户名
     */
    private String username;

    /**
     * option:用户身份
     */
    private Integer option;

    /**
     * state:设置公告状态 1：已读；2：删除
     */
    private Integer state;

}
