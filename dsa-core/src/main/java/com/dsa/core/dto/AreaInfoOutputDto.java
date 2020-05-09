package com.dsa.core.dto;


/**
 * @author GUOJIKANG
 * @Title:
 * @ClassName AreaInfoOutputDto
 * @Description: TODO
 * @date 2019/5/28  11:53
 * @Version 1.0
 */
public class AreaInfoOutputDto{
    /**
     * 管理单元ID
     */
    private String unitId;
    /**
     * 区域ID
     */
    private String areaId;
    /**
     * 编码
     */
    private String vcCode;
    /**
     * 名称
     */
    private String vcName;
    /**
     *区域类型（字典15）物理区域、电压等级、间隔
     */
    private String iMainType;
    /**
     * 区域特性，预留。区域类型：0主变区域、1主控楼、2高压室、3设备区
     */
    private String iSubType;
    /**
     * 平面图ID
     */
    private String svgId;
    /**
     * 三维图ID
     */
    private String t3DId;
    private String iParam1;
    private String iParam2;
    private String iParam3;
    private String vcParam1;
    private String vcParam2;
    private String vcParam3;
    private String iSort;
    private String iIsEnable;
    private String iFlag;
    private String vcMemo;
    private String unitName;

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
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

    public String getiMainType() {
        return iMainType;
    }

    public void setiMainType(String iMainType) {
        this.iMainType = iMainType;
    }

    public String getiSubType() {
        return iSubType;
    }

    public void setiSubType(String iSubType) {
        this.iSubType = iSubType;
    }

    public String getSvgId() {
        return svgId;
    }

    public void setSvgId(String svgId) {
        this.svgId = svgId;
    }

    public String getT3DId() {
        return t3DId;
    }

    public void setT3DId(String t3DId) {
        this.t3DId = t3DId;
    }

    public String getiParam1() {
        return iParam1;
    }

    public void setiParam1(String iParam1) {
        this.iParam1 = iParam1;
    }

    public String getiParam2() {
        return iParam2;
    }

    public void setiParam2(String iParam2) {
        this.iParam2 = iParam2;
    }

    public String getiParam3() {
        return iParam3;
    }

    public void setiParam3(String iParam3) {
        this.iParam3 = iParam3;
    }

    public String getVcParam1() {
        return vcParam1;
    }

    public void setVcParam1(String vcParam1) {
        this.vcParam1 = vcParam1;
    }

    public String getVcParam2() {
        return vcParam2;
    }

    public void setVcParam2(String vcParam2) {
        this.vcParam2 = vcParam2;
    }

    public String getVcParam3() {
        return vcParam3;
    }

    public void setVcParam3(String vcParam3) {
        this.vcParam3 = vcParam3;
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
