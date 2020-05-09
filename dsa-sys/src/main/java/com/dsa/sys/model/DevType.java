package com.dsa.sys.model;

import com.dsa.common.model.BaseEntityBean;
import lombok.Data;

@Data
public class DevType{
    private Integer ID;
    /**
     *设备类型id
     */
    private Integer devTypeId;

    /**
     *名称
     */
    private String vcName;

    /**
     *默认图标
     */
    private String vcIcon;

    /**
     * 排序
     */
    private Integer sort;

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
