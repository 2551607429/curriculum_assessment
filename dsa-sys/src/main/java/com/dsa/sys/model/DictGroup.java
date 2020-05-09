package com.dsa.sys.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DictGroup implements Serializable{
    private Integer id;

    /**
     * 字典组id
     */
    private Integer dictGroupID;

    /**
     * 字典组名称
     */
    private String vcName;

    /**
     * 字典组类型
     */
    private Integer type;

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
