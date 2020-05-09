package com.dsa.sys.model;

import lombok.Data;

@Data
public class SubSystemDevType {
    private Integer ID;
    /**
     *子系统id
     */
    private Integer subSystemId;

    /**
     *设备类型id
     */
    private Integer devTypeId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 标示
     */
    private Integer flag;

    /**
     * 备注
     */
    private String vcMemo;
}
