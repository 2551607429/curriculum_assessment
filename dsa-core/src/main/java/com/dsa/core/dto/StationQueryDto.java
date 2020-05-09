package com.dsa.core.dto;

import com.dsa.common.utils.Page;

import javax.validation.constraints.NotBlank;


/**
 * @author GUOJIKANG
 * @Title: 查询传输
 * @ClassName StationQueryDto
 * @Description: TODO
 * @date 2019/5/27  16:19
 * @Version 1.0
 */
public class StationQueryDto {
    @NotBlank(message = "unitId不能为空", groups = GET.class)
    private String unitId;
    private String vcProjectCompany;
    private Integer iAccessTime;
    private Integer iRunTime;
    private String vcAddress;
    private Double dMapx;
    private Double dMapy;
    private Integer iSort;
    private Integer iStatus;
    private Integer iParam1;
    private Integer iParam2;
    private Integer iParam3;
    private String vcParam1;
    private String vcParam2;
    private String vcParam3;
    private Integer iFlag;
    private String vcMemo;
    private String vcName;
    private String iVoltageLevelId;//电压等级
    @NotBlank(message = "orgId不能为空", groups = FIND.class)
    private String orgId;


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

    public Integer getiSort() {
        return iSort;
    }

    public void setiSort(Integer iSort) {
        this.iSort = iSort;
    }

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

    public String getiVoltageLevelId() {
        return iVoltageLevelId;
    }

    public void setiVoltageLevelId(String iVoltageLevelId) {
        this.iVoltageLevelId = iVoltageLevelId;
    }

    public interface GET {

    }

    public interface FIND {

    }


}
