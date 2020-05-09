package com.dsa.sys.dto;


/**
 * @author GUOJIKANG
 * @Title: 系统配置输出Dto
 * @ClassName ConfigOutputDto
 * @Description: TODO
 * @date 2019/5/20  14:50
 * @Version 1.0
 */
public class ConfigOutputDto {
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
    private String iType;
    /**
     * 排序
     */
    private String iSort;
    /**
     * 是否启用
     */
    private String iIsEnable;
    /**
     * 标记
     */
    private String iFlag;
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

    public String getiType() {
        return iType;
    }

    public void setiType(String iType) {
        this.iType = iType;
    }

    public String getiSort() {
        return iSort;
    }

    public void setiSort(String iSort) {
        this.iSort = iSort;
    }

    public String getiIsEnable() {
        return iIsEnable;
    }

    public void setiIsEnable(String iIsEnable) {
        this.iIsEnable = iIsEnable;
    }

    public String getiFlag() {
        return iFlag;
    }

    public void setiFlag(String iFlag) {
        this.iFlag = iFlag;
    }

    public String getVcMemo() {
        return vcMemo;
    }

    public void setVcMemo(String vcMemo) {
        this.vcMemo = vcMemo;
    }
}
