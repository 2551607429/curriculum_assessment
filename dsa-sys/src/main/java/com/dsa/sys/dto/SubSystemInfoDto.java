package com.dsa.sys.dto;

import com.dsa.common.model.BaseEntityBean;
import lombok.Data;

import java.util.List;

@Data
public class SubSystemInfoDto extends BaseEntityBean{
    /**
     *子系统ID
     */
    private Integer subSystemId;

    /**
     *名称
     */
    private String vcName;

    /**
     *所属系统(字典9103)
     */
    private Integer type;

    /**
     * 是否可见
     */
    private Integer visible;

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
     * 需关联的设备类型id
     */
    private List<Integer> devTypeIds;
}
