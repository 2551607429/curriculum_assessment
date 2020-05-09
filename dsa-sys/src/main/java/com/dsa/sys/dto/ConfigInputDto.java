package com.dsa.sys.dto;

import com.dsa.common.utils.Page;

/**
 * @author GUOJIKANG
 * @Title: 系统配置输人Dto
 * @ClassName ConfigInputDto
 * @Description: TODO
 * @date 2019/5/20  14:50
 * @Version 1.0
 */

public class ConfigInputDto {
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

    /**
     * 分页信息
     */
    private Page page = new Page();//new Page() 设置初始值 防止不传page报空指针

    /**
     * 约定字段 0保存 1修改
     */
    private String isSave;

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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getIsSave() {
        return isSave;
    }

    public void setIsSave(String isSave) {
        this.isSave = isSave;
    }

    @Override
    public String toString() {
        return "ConfigDto{" +
                "vcKey='" + vcKey + '\'' +
                ", vcDesc='" + vcDesc + '\'' +
                ", vcValue='" + vcValue + '\'' +
                ", iType=" + iType +
                ", iSort=" + iSort +
                ", iIsEnable=" + iIsEnable +
                ", iFlag=" + iFlag +
                ", vcMemo='" + vcMemo + '\'' +
                ", page=" + page +
                ", isSave='" + isSave + '\'' +
                '}';
    }
}
