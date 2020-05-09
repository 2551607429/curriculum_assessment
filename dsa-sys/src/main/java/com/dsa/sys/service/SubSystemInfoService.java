package com.dsa.sys.service;

import com.dsa.common.enums.ResponseBean;
import com.dsa.sys.dao.SubSystemInfoDao;
import com.dsa.sys.dto.SubSystemInfoDto;

public interface SubSystemInfoService {
    /**
     * 添加子系统数据
     * @return
     */
    ResponseBean insert(SubSystemInfoDto subSystemInfoDto);

    /**
     * 更新子系统数据
     * @return
     */
    ResponseBean update(SubSystemInfoDto subSystemInfoDto);

    /**
     * 获取单条子系统数据
     * @return
     */
    ResponseBean get(Integer subSystemId);

    /**
     * 删除单条子系统数据
     * @return
     */
    ResponseBean delete(Integer subSystemId);

    /**
     * 查询子系统数据列表
     * @return
     */
    ResponseBean find(SubSystemInfoDto subSystemInfoDto);

    /**
     * 查询子系统相关联的设备类型列表
     * @return
     */
    ResponseBean findDevTypes(SubSystemInfoDto subSystemInfoDto);

    /**
     * 关联设备类型
     * @return
     */
    ResponseBean linkDevTypes(SubSystemInfoDto subSystemInfoDto);
}
