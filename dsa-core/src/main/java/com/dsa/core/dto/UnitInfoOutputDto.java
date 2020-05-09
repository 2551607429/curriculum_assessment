package com.dsa.core.dto;

/**
 * @author GUOJIKANG
 * @Title: 管理单元 数据传输层
 * @ClassName UnitInfoOutputDto
 * @Description: TODO
 * @date 2019/5/25  13:55
 * @Version 1.0
 */
public class UnitInfoOutputDto {
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
    private String iType;
    /**
     *电压级别(字典组：)
     */
    private String iVoltageLevelId;
    /**
     * 排序序号
     */
    private String iSort;
    /**
     * 是否启用
     */
    private String iIsEnable;
    /**
     * 标示
     */
    private String iFlag;
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

    public String getiType() {
        return iType;
    }

    public void setiType(String iType) {
        this.iType = iType;
    }

    public String getiVoltageLevelId() {
        return iVoltageLevelId;
    }

    public void setiVoltageLevelId(String iVoltageLevelId) {
        this.iVoltageLevelId = iVoltageLevelId;
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
