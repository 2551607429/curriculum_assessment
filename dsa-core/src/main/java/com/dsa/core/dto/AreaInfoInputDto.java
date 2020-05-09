package com.dsa.core.dto;



import javax.validation.constraints.NotBlank;

/**
 * @author GUOJIKANG
 * @Title: 区域管理数据持久层
 * @ClassName AreaInfoInputDto
 * @Description: TODO
 * @date 2019/5/28  11:53
 * @Version 1.0
 */
public class AreaInfoInputDto {
    /**
     * 管理单元ID
     */
    @NotBlank(message = "unitId不能为空", groups = INSERT.class)
    private String unitId;
    /**
     * 区域ID
     */
    @NotBlank(message = "areaId不能为空", groups = UPDATE.class)
    private String areaId;
    /**
     * 编码
     */
    private String vcCode;
    /**
     * 名称
     */
    @NotBlank(message = "vcName不能为空", groups = INSERT.class)
    private String vcName;
    /**
     * 区域类型（字典15）物理区域、电压等级、间隔
     */
    private Integer iMainType;
    /**
     * 区域特性，预留。区域类型：0主变区域、1主控楼、2高压室、3设备区
     */
    private Integer iSubType;
    /**
     * 平面图ID
     */
    private String svgId;
    /**
     * 三维图ID
     */
    private String t3DId;
    private Integer iParam1;
    private Integer iParam2;
    private Integer iParam3;
    private String vcParam1;
    private String vcParam2;
    private String vcParam3;
    private Integer iSort;
    private Integer iIsEnable;
    private Integer iFlag;
    private String vcMemo;


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

    public Integer getiMainType() {
        return iMainType;
    }

    public void setiMainType(Integer iMainType) {
        this.iMainType = iMainType;
    }

    public Integer getiSubType() {
        return iSubType;
    }

    public void setiSubType(Integer iSubType) {
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

    public Integer getiParam1() {
        return iParam1;
    }

    public void setiParam1(Integer iParam1) {
        this.iParam1 = iParam1;
    }

    public Integer getiParam2() {
        return iParam2;
    }

    public void setiParam2(Integer iParam2) {
        this.iParam2 = iParam2;
    }

    public Integer getiParam3() {
        return iParam3;
    }

    public void setiParam3(Integer iParam3) {
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

    public interface INSERT {
    }

    public interface UPDATE {
    }

}
