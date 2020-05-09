package com.dsa.sys.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(value = {"handler"})
public class DictDataDto {
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
