package com.dsa.sys.model;


import lombok.Data;

/**
 * 系统配置 数据库持久化
 */

public class Config {
    /**
     * 关键字
     */
    private String vcKey;
    /**
     * 描述
     */
    private String vcDesc;
    /**
     * 值
     */
    private String vcValue;
    /**
     * 类型
     */
    private Integer iType;
    /**
     * 排序
     */
    private Integer iSort;
    /**
     * 是否启用
     */
    private Integer iIsEnable;
    /**
     * 标记
     */
    private Integer iFlag;
    /**
     * 备注
     */
    private String vcMemo;

    public String getVcKey() {
        return vcKey;
    }

    public void setVcKey(String vcKey) {
        this.vcKey = vcKey;
    }

    public String getVcDesc() {
        return vcDesc;
    }

    public void setVcDesc(String vcDesc) {
        this.vcDesc = vcDesc;
    }

    public String getVcValue() {
        return vcValue;
    }

    public void setVcValue(String vcValue) {
        this.vcValue = vcValue;
    }

    public Integer getiType() {
        return iType;
    }

    public void setiType(Integer iType) {
        this.iType = iType;
    }

    public Integer getiSort() {
        return iSort;
    }

    public void setiSort(Integer iSort) {
        this.iSort = iSort;
    }

    public Integer getiIsEnable() {
        return iIsEnable;
    }

    public void setiIsEnable(Integer iIsEnable) {
        this.iIsEnable = iIsEnable;
    }

    public Integer getiFlag() {
        return iFlag;
    }

    public void setiFlag(Integer iFlag) {
        this.iFlag = iFlag;
    }

    public String getVcMemo() {
        return vcMemo;
    }

    public void setVcMemo(String vcMemo) {
        this.vcMemo = vcMemo;
    }
}
