package com.dsa.core.dto;

import com.dsa.common.utils.Page;


/**
 * @author GUOJIKANG
 * @Title:
 * @ClassName Station
 * @Description: TODO
 * @date 2019/5/27  16:19
 * @Version 1.0
 */
public class StationInputDto extends UnitInfoInputDto {
    private String unitId;
    /**
     * 工程商
     */
    private String vcProjectCompany;
    /**
     * 接入时间
     */
    private Integer iAccessTime;
    /**
     * 投入日期
     */
    private Integer iRunTime;
    /**
     * 地址
     */
    private String vcAddress;
    /**
     * 坐标
     */
    private Double dMapx;
    /**
     * 坐标
     */
    private Double dMapy;
    /**
     * 排序
     */
//    private Integer iSort;
    /**
     * 状态
     */
    private Integer iStatus;
    private Integer iParam1;
    private Integer iParam2;
    private Integer iParam3;
    private String vcParam1;
    private String vcParam2;
    private String vcParam3;
    private Integer iFlag;
    private String vcMemo;


    private Page page = new Page();

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getVcProjectCompany() {
        return vcProjectCompany;
    }

    public void setVcProjectCompany(String vcProjectCompany) {
        this.vcProjectCompany = vcProjectCompany;
    }

    public Integer getiAccessTime() {
        return iAccessTime;
    }

    public void setiAccessTime(Integer iAccessTime) {
        this.iAccessTime = iAccessTime;
    }

    public Integer getiRunTime() {
        return iRunTime;
    }

    public void setiRunTime(Integer iRunTime) {
        this.iRunTime = iRunTime;
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

//    public Integer getiSort() {
//        return iSort;
//    }
//
//    public void setiSort(Integer iSort) {
//        this.iSort = iSort;
//    }

    public Integer getiStatus() {
        return iStatus;
    }

    public void setiStatus(Integer iStatus) {
        this.iStatus = iStatus;
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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }


    @Override
    public String getVcName() {
        return super.getVcName();
    }

    @Override
    public void setVcName(String vcName) {
        super.setVcName(vcName);
    }

    @Override
    public Integer getiType() {
        return super.getiType();
    }

    @Override
    public void setiType(Integer iType) {
        super.setiType(iType);
    }

    @Override
    public Integer getiVoltageLevelId() {
        return super.getiVoltageLevelId();
    }

    @Override
    public void setiVoltageLevelId(Integer iVoltageLevelId) {
        super.setiVoltageLevelId(iVoltageLevelId);
    }

    @Override
    public Integer getiIsEnable() {
        return super.getiIsEnable();
    }

    @Override
    public void setiIsEnable(Integer iIsEnable) {
        super.setiIsEnable(iIsEnable);
    }
}
