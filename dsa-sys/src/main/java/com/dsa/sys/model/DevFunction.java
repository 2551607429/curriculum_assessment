package com.dsa.sys.model;

import com.dsa.common.model.BaseEntityBean;
import lombok.Data;

@Data
public class DevFunction {
    private Integer ID;
    /**
     *设备类型id
     */
    private Integer devTypeId;

    /**
     *设备功能id
     */
    private Integer functionId;

    /**
     *名称
     */
    private String vcName;

    /**
     *功能描述
     */
    private String vcDesc;

    /**
     *单位
     */
    private String vcUnit;

    /**
     * 四遥类型,1 遥测，2 遥信 ，3 遥控，4 遥调
     */
    private Integer nodeType;

    /**
     * 标示
     */
    private Integer flag;

    /**
     * 备注
     */
    private String vcMemo;
}
