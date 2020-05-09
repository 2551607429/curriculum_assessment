package com.dsa.sys.dto;


import java.io.Serializable;

/**
 * @author GUOJIKANG
 * @Title: 模块组输人Dto
 * @ClassName ModuleGroupInputDto
 * @Description: TODO
 * @date 2019/5/20  14:50
 * @Version 1.0
 */
public class ModuleGroupInputDto implements Serializable {
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

    /**
     * 保存或修改 约定字段 0 保存 1修改
     */
    private String isSave;

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

    public String getIsSave() {
        return isSave;
    }

    public void setIsSave(String isSave) {
        this.isSave = isSave;
    }

    @Override
    public String toString() {
        return "ModuleGroupDto{" +
                "moduleGroupId=" + moduleGroupId +
                ", parentId=" + parentId +
                ", vcName='" + vcName + '\'' +
                ", iType=" + iType +
                ", iSort=" + iSort +
                ", iIsEnable=" + iIsEnable +
                ", iFlag=" + iFlag +
                ", vcMemo='" + vcMemo + '\'' +
                ", isSave='" + isSave + '\'' +
                '}';
    }
}
