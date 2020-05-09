package com.dsa.sys.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(value = {"handler"})
public class DictGroupOutput {
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

    /**
     * 字典数据列表
     */
    private List<DictDataDto> dictDataList;
}
