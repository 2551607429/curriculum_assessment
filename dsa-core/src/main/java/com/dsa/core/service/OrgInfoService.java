package com.dsa.core.service;

import com.dsa.common.enums.ResponseBean;
import com.dsa.core.dto.OrgInfoInputDto;
import com.dsa.core.dto.OrgInfoQueryDto;


/**
 * @author GUOJIKANG
 * @Title: 组织结构业务逻辑接口层
 * @ClassName OrgInfoService
 * @Description: TODO
 * @date 2019/5/25  14:56
 * @Version 1.0
 */
public interface OrgInfoService {
    /**
     * 获取组织结构树
     * @param orgInfoQueryDto
     * @return
     */
    ResponseBean getOrgTree(OrgInfoQueryDto orgInfoQueryDto);
    /**
     * 获取组织树
     * @param orgInfoInputDto
     * @return
     */
    ResponseBean findTree(OrgInfoInputDto orgInfoInputDto);

    /**
     * 获取单条
     * @param orgInfoInputDto
     * @return
     */
    ResponseBean get(OrgInfoInputDto orgInfoInputDto);
    /**
     * 新增组织结构
     * @param orgInfoInputDto
     * @return
     */
    ResponseBean insert(OrgInfoInputDto orgInfoInputDto);

    /**
     * 修改组织结构
     * @param orgInfoInputDto
     * @return
     */
    ResponseBean update(OrgInfoInputDto orgInfoInputDto);

    /**
     * 删除组织结构
     * @param orgInfoInputDto
     * @return
     */
    ResponseBean deleteMultiple(OrgInfoInputDto orgInfoInputDto);
}
