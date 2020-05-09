package com.dsa.sys.dto;

import com.dsa.common.model.BaseEntityBean;
import lombok.Data;

@Data
public class DictGroupDto extends BaseEntityBean{
    /**
     * 字典组id
     */
    private Integer dictGroupID;

    /**
     * 字典组类型
     */
    private Integer type;

    /**
     * 字典组内容
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
