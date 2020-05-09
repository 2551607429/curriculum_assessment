package com.dsa.sys.dto;


import java.io.Serializable;


/**
 * @author GUOJIKANG
 * @Title: 模块输入Dto
 * @ClassName ModuleInputDto
 * @Description: TODO
 * @date 2019/5/20  14:50
 * @Version 1.0
 */
public class ModuleInputDto implements Serializable {

    private static final long serialVersionUID = 6794151179906658744L;

    /**
     * 模块ID
     */
    private Integer moduleId;
    /**
     * 标题
     */
    private String vcCaption;
    /**
     * 类型
     */
    private Integer moduleType;
    /**
     * 执行对象
     */
    private String vcExecuteObject;
    /**
     * 启动参数
     */
    private String vcExecuteParams;
    /**
     * 模块组ID
     */
    private Integer moduleGroupId;
    /**
     * 模块组名称
     */
    private String moduleGroupName;
    /**
     * 排序
     */
    private Integer iSort;
    /**
     * 图标
     */
    private String vcImage;
    /**
     * 是否启用
     */
    private Integer iIsEnable;
    /**
     * 字体大小
     */
    private Integer iFontSize;
    /**
     * 标记
     */
    private Integer iFlag;
    /**
     * 冗余
     */
    private String vcMemo;

    /**
     * 是否保存 约定字段 0保存 1修改
     */
    private String isSave;

    /**
     * 约束条件查询 0 查询全部 1条件查询
     */
    private String isSearch;

    /**
     * 是否启勇模块或模块组 0模块 1模块组
     */
    private String moduleIsEnable;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getVcCaption() {
        return vcCaption;
    }

    public void setVcCaption(String vcCaption) {
        this.vcCaption = vcCaption;
    }

    public Integer getModuleType() {
        return moduleType;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    public String getVcExecuteObject() {
        return vcExecuteObject;
    }

    public void setVcExecuteObject(String vcExecuteObject) {
        this.vcExecuteObject = vcExecuteObject;
    }

    public String getVcExecuteParams() {
        return vcExecuteParams;
    }

    public void setVcExecuteParams(String vcExecuteParams) {
        this.vcExecuteParams = vcExecuteParams;
    }

    public Integer getModuleGroupId() {
        return moduleGroupId;
    }

    public void setModuleGroupId(Integer moduleGroupId) {
        this.moduleGroupId = moduleGroupId;
    }

    public String getModuleGroupName() {
        return moduleGroupName;
    }

    public void setModuleGroupName(String moduleGroupName) {
        this.moduleGroupName = moduleGroupName;
    }

    public Integer getiSort() {
        return iSort;
    }

    public void setiSort(Integer iSort) {
        this.iSort = iSort;
    }

    public String getVcImage() {
        return vcImage;
    }

    public void setVcImage(String vcImage) {
        this.vcImage = vcImage;
    }

    public Integer getiIsEnable() {
        return iIsEnable;
    }

    public void setiIsEnable(Integer iIsEnable) {
        this.iIsEnable = iIsEnable;
    }

    public Integer getiFontSize() {
        return iFontSize;
    }

    public void setiFontSize(Integer iFontSize) {
        this.iFontSize = iFontSize;
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

    public String getIsSearch() {
        return isSearch;
    }

    public void setIsSearch(String isSearch) {
        this.isSearch = isSearch;
    }

    public String getModuleIsEnable() {
        return moduleIsEnable;
    }

    public void setModuleIsEnable(String moduleIsEnable) {
        this.moduleIsEnable = moduleIsEnable;
    }

    @Override
    public String toString() {
        return "ModuleDto{" +
                "moduleId=" + moduleId +
                ", vcCaption='" + vcCaption + '\'' +
                ", moduleType=" + moduleType +
                ", vcExecuteObject='" + vcExecuteObject + '\'' +
                ", vcExecuteParams='" + vcExecuteParams + '\'' +
                ", moduleGroupId=" + moduleGroupId +
                ", moduleGroupName='" + moduleGroupName + '\'' +
                ", iSort=" + iSort +
                ", vcImage='" + vcImage + '\'' +
                ", iIsEnable=" + iIsEnable +
                ", iFontSize=" + iFontSize +
                ", iFlag=" + iFlag +
                ", vcMemo='" + vcMemo + '\'' +
                ", isSave='" + isSave + '\'' +
                ", isSearch='" + isSearch + '\'' +
                '}';
    }
}
