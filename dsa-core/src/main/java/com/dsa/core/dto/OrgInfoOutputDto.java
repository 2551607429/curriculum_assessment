package com.dsa.core.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GUOJIKANG
 * @Title: 组织结构 数据传输层
 * @ClassName OrgInfoOutputDto
 * @Description: TODO
 * @date 2019/5/25  14:47
 * @Version 1.0
 */
public class OrgInfoOutputDto {

    private String id;

    private String text;

    private String pId;

    private String title;


    /**
     * 组织ID
     */
    private String orgId;
    /**
     * 上级组织ID
     */
    private String parentOrgId;
    /**
     * 编码
     */
    private String vcCode;
    /**
     * 名称
     */
    private String vcName;
    /**
     * 组织类型(字典组：)- 市公司，运维班组
     */
    private String iType;
    /**
     * 排序序号
     */
    private String iSort;
    /**
     * 地址
     */
    private String vcAddress;
    /**
     * X坐标
     */
    private String dMapx;
    /**
     * Y坐标
     */
    private String dMapy;
    /**
     * 状态
     */
    private String iIsEnable;
    /**
     * 标识
     */
    private String iFlag;
    /**
     * 冗余
     */
    private String vcMemo;

    private Map<String, Object> tag = new HashMap<String, Object>();

    private String state;

    private boolean checked;


    private String phoneticize;

    private Map<String, Object> alarm_Status = new HashMap<String, Object>();

    private Map<String, Object> attributes = new HashMap<String, Object>();

    private List<OrgInfoOutputDto> children = new ArrayList<OrgInfoOutputDto>();

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public String getVcCode() {
        return vcCode;
    }

    public void setVcCode(String vcCode) {
        this.vcCode = vcCode;
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

    public String getVcAddress() {
        return vcAddress;
    }

    public void setVcAddress(String vcAddress) {
        this.vcAddress = vcAddress;
    }

    public String getdMapx() {
        return dMapx;
    }

    public void setdMapx(String dMapx) {
        this.dMapx = dMapx;
    }

    public String getdMapy() {
        return dMapy;
    }

    public void setdMapy(String dMapy) {
        this.dMapy = dMapy;
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

    public List<OrgInfoOutputDto> getChildren() {
        return children;
    }

    public void setChildren(List<OrgInfoOutputDto> children) {
        this.children = children;
    }
}
