package com.dsa.core.dto;


import com.dsa.common.utils.Page;


/**
 * @author GUOJIKANG
 * @Title: 区域管理数据持久层
 * @ClassName AreaInfoInputDto
 * @Description: TODO
 * @date 2019/5/28  11:53
 * @Version 1.0
 */
public class AreaInfoQueryDto {
    private String unitId;
    private String orgId;
    private String unitName;
    private String vcName;
    private String vcCode;
    private String iMainType;
    private String iSubType;

    private Page page = new Page();

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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getVcName() {
        return vcName;
    }

    public void setVcName(String vcName) {
        this.vcName = vcName;
    }

    public String getVcCode() {
        return vcCode;
    }

    public void setVcCode(String vcCode) {
        this.vcCode = vcCode;
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
}
