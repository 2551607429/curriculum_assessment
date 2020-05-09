package com.dsa.sys.model;

import lombok.Data;

/**
 * 项目名称：dsa5200
 * 类名称：SubSystemInfo
 * 创建人：fanhaiyang 范海洋
 * 创建时间：2019/5/27 16:17
 */
@Data
public class SubSystemInfo {
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
}
