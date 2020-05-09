package com.dsa.core.model;

import java.io.Serializable;

/**
 * @author GUOJIKANG
 * @Title: 管理单元 数据持久层
 * @ClassName UnitInfo
 * @Description: TODO
 * @date 2019/5/25  13:54
 * @Version 1.0
 */
public class UnitInfo implements Serializable {
    /**
     * 管理单元
     */
    private String unitId;
    /**
     * 组织ID
     */
    private String orgId;
    /**
     * 名称
     */
    private String vcName;
    /**
     * 管理单元类型(字典组：):输电线路、变电站、配电所
     */
    private Integer iType;
    /**
     *电压级别(字典组：)
     */
    private Integer iVoltageLevelId;
    /**
     * 排序序号
     */
    private Integer iSort;
    /**
     * 是否启用
     */
    private Integer iIsEnable;
    /**
     * 标示
     */
    private Integer iFlag;
    /**
     * 冗余
     */
    private String vcMemo;

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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

    public Integer getiVoltageLevelId() {
        return iVoltageLevelId;
    }

    public void setiVoltageLevelId(Integer iVoltageLevelId) {
        this.iVoltageLevelId = iVoltageLevelId;
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
