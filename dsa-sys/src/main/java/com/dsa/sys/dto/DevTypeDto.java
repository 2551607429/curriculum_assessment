package com.dsa.sys.dto;

import com.dsa.common.model.BaseEntityBean;
import com.dsa.sys.model.DevFunction;
import lombok.Data;

import java.util.List;

@Data
public class DevTypeDto extends BaseEntityBean{
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

    /**
     * 需关联的系统id
     */
    private List<Integer> subSystemIds;

    /**
     * 需新增的功能
     */
    private List<DevFunction> devFunctionList;
}
