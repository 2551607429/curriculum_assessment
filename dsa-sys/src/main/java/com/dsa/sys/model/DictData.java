package com.dsa.sys.model;

import lombok.Data;

@Data
public class DictData {
    /**
     * 字典id
     */
    private Integer dictID;

    /**
     * 字典组id
     */
    private Integer dictGroupID;

    /**
     * 字典内容
     */
    private String vcName;

    /**
     * 是否启用
     */
    private Integer isEnable;

    /**
     * 标示
     */
    private Integer flag;

    /**
     * 备注
     */
    private String vcMemo;
}
