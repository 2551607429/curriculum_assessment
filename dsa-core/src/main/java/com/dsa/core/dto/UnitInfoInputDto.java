package com.dsa.core.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author GUOJIKANG
 * @Title: 管理单元 数据传输层
 * @ClassName UnitInfoInputDto
 * @Description: TODO
 * @date 2019/5/25  13:54
 * @Version 1.0
 */
public class UnitInfoInputDto {
    /**
     * 管理单元
     */
    @NotBlank(message = "unitId不能为空",groups = UPDATE.class)
    private String unitId;
    /**
     * 组织ID
     */
    @NotBlank(message = "orgId不能为空",groups = INSERT.class)
    private String orgId;
    /**
     * 名称
     */
    @NotBlank(message = "vcName不能为空",groups = INSERT.class)
    private String vcName;
    /**
     * 管理单元类型(字典组：):输电线路、变电站、配电所
     */
    @NotNull(message = "iType不能为空",groups = INSERT.class)
    private Integer iType;
    /**
     *电压级别(字典组：)
     */
    @NotNull(message = "iVoltageLevelId不能为空",groups = INSERT.class)
    private Integer iVoltageLevelId;
    /**
     * 排序序号
     */
    @NotNull(message = "iSort不能为空",groups = INSERT.class)
    private Integer iSort;
    /**
     * 是否启用
     */
    @NotNull(message = "iIsEnable不能为空",groups = INSERT.class)
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
    public interface INSERT{}
    public interface UPDATE{}
}
