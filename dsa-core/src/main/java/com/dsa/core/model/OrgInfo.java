package com.dsa.core.model;

import java.io.Serializable;

/**
 * @author GUOJIKANG
 * @Title: 组织结构数据持久层
 * @ClassName OrgInfo
 * @Description: TODO
 * @date 2019/5/25  14:43
 * @Version 1.0
 */
public class OrgInfo implements Serializable {
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
    private Integer iType;
    /**
     * 排序序号
     */
    private Integer iSort;
    /**
     * 地址
     */
    private String vcAddress;
    /**
     * X坐标
     */
    private Double dMapx;
    /**
     * Y坐标
     */
    private Double dMapy;
    /**
     * 状态
     */
    private Integer iIsEnable;
    /**
     * 标识
     */
    private Integer iFlag;
    /**
     * 冗余
     */
    private String vcMemo;

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

    public String getVcAddress() {
        return vcAddress;
    }

    public void setVcAddress(String vcAddress) {
        this.vcAddress = vcAddress;
    }

    public Double getdMapx() {
        return dMapx;
    }

    public void setdMapx(Double dMapx) {
        this.dMapx = dMapx;
    }

    public Double getdMapy() {
        return dMapy;
    }

    public void setdMapy(Double dMapy) {
        this.dMapy = dMapy;
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
