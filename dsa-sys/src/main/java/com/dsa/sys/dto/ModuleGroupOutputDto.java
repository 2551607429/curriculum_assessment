package com.dsa.sys.dto;

import java.io.Serializable;

/**
 * @author GUOJIKANG
 * @Title: 模块组输出Dto
 * @ClassName ModuleGroupOutputDto
 * @Description: TODO
 * @date 2019/5/20  14:50
 * @Version 1.0
 */
public class ModuleGroupOutputDto implements Serializable {
    /**
     * 模块组ID
     */
    private String moduleGroupId;
    /**
     * 父级ID
     */
    private String parentId;
    /**
     * 组名称
     */
    private String vcName;
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
     * 冗余
     */
    private String vcMemo;

    public String getModuleGroupId() {
        return moduleGroupId;
    }

    public void setModuleGroupId(String moduleGroupId) {
        this.moduleGroupId = moduleGroupId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getVcName() {
        return vcName;
    }

    public void setVcName(String vcName) {
        this.vcName = vcName;
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

    @Override
    public String toString() {
        return "ModuleGroup{" +
                "moduleGroupId='" + moduleGroupId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", vcName='" + vcName + '\'' +
                ", iType='" + iType + '\'' +
                ", iSort='" + iSort + '\'' +
                ", iIsEnable='" + iIsEnable + '\'' +
                ", iFlag='" + iFlag + '\'' +
                ", vcMemo='" + vcMemo + '\'' +
                '}';
    }
}
