package com.dsa.sys.model;


import java.io.Serializable;


public class ModuleGroup implements Serializable {
    /**
     * 模块组ID
     */
    private Integer moduleGroupId;
    /**
     * 父级ID
     */
    private Integer parentId;
    /**
     * 组名称
     */
    private String vcName;
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
     * 冗余
     */
    private String vcMemo;

    public Integer getModuleGroupId() {
        return moduleGroupId;
    }

    public void setModuleGroupId(Integer moduleGroupId) {
        this.moduleGroupId = moduleGroupId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getVcName() {
        return vcName;
    }

    public void setVcName(String vcName) {
        this.vcName = vcName;
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
