package com.dsa.sys.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GUOJIKANG
 * @Title: 模块输出Dto
 * @ClassName ModuleOutputDto
 * @Description: TODO
 * @date 2019/5/20  14:50
 * @Version 1.0
 */
public class ModuleOutputDto implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 6794151179906658744L;

    private String id;

    private String text;

    private String pId;

    private String title;

    /**
     * 模块ID
     */
    private String moduleId;
    /**
     * 标题
     */
    private String vcCaption;
    /**
     * 类型
     */
    private String moduleType;
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
    private String moduleGroupId;
    /**
     * 模块组名称
     */
    private String moduleGroupName;
    /**
     * 排序
     */
    private String iSort;
    /**
     * 图标
     */
    private String vcImage;
    /**
     * 是否启用
     */
    private String iIsEnable;
    /**
     * 字体大小
     */
    private String iFontSize;
    /**
     * 标记
     */
    private String iFlag;
    /**
     * 冗余
     */
    private String vcMemo;

    private String isGroup;


    private Map<String, Object> tag = new HashMap<String, Object>();

    private String state;

    private boolean checked;


    private String phoneticize;

    private Map<String, Object> alarm_Status = new HashMap<String, Object>();

    private Map<String, Object> attributes = new HashMap<String, Object>();

    private List<ModuleOutputDto> children = new ArrayList<ModuleOutputDto>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getVcCaption() {
        return vcCaption;
    }

    public void setVcCaption(String vcCaption) {
        this.vcCaption = vcCaption;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
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

    public String getModuleGroupId() {
        return moduleGroupId;
    }

    public void setModuleGroupId(String moduleGroupId) {
        this.moduleGroupId = moduleGroupId;
    }

    public String getModuleGroupName() {
        return moduleGroupName;
    }

    public void setModuleGroupName(String moduleGroupName) {
        this.moduleGroupName = moduleGroupName;
    }

    public String getiSort() {
        return iSort;
    }

    public void setiSort(String iSort) {
        this.iSort = iSort;
    }

    public String getVcImage() {
        return vcImage;
    }

    public void setVcImage(String vcImage) {
        this.vcImage = vcImage;
    }

    public String getiIsEnable() {
        return iIsEnable;
    }

    public void setiIsEnable(String iIsEnable) {
        this.iIsEnable = iIsEnable;
    }

    public String getVcMemo() {
        return vcMemo;
    }

    public void setVcMemo(String vcMemo) {
        this.vcMemo = vcMemo;
    }

    public Map<String, Object> getTag() {
        return tag;
    }

    public void setTag(Map<String, Object> tag) {
        this.tag = tag;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getPhoneticize() {
        return phoneticize;
    }

    public void setPhoneticize(String phoneticize) {
        this.phoneticize = phoneticize;
    }

    public Map<String, Object> getAlarm_Status() {
        return alarm_Status;
    }

    public void setAlarm_Status(Map<String, Object> alarm_Status) {
        this.alarm_Status = alarm_Status;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public List<ModuleOutputDto> getChildren() {
        return children;
    }

    public void setChildren(List<ModuleOutputDto> children) {
        this.children = children;
    }

    public String getiFlag() {
        return iFlag;
    }

    public void setiFlag(String iFlag) {
        this.iFlag = iFlag;
    }

    public String getiFontSize() {
        return iFontSize;
    }

    public void setiFontSize(String iFontSize) {
        this.iFontSize = iFontSize;
    }

    public String getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(String isGroup) {
        this.isGroup = isGroup;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
