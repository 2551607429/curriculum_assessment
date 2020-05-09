package com.dsa.sys.service;

import com.dsa.common.enums.ResponseBean;
import com.dsa.sys.dto.DevTypeDto;
import com.dsa.sys.dto.SubSystemInfoDto;

public interface DevTypeService {
    /**
     * 添加设备类型
     * @return
     */
    ResponseBean insert(DevTypeDto devTypeDto);

    /**
     * 修改设备类型
     * @return
     */
    ResponseBean update(DevTypeDto devTypeDto);

    /**
     * 删除设备类型
     * @return
     */
    ResponseBean delete(Integer devTypeId);

    /**
     * 获取单条设备类型
     * @return
     */
    ResponseBean get(Integer devTypeId);

    /**
     * 获取设备类型列表
     * @return
     */
    ResponseBean findDevTypes(DevTypeDto devTypeDto);

    /**
     * 获取设备类型功能列表
     * @return
     */
    ResponseBean findDevFunctions(DevTypeDto devTypeDto);

    /**
     * 关联子系统
     * @return
     */
    ResponseBean linkSubSystemInfos(DevTypeDto devTypeDto);

    /**
     * 查询某个设备类型关联的所有子系统
     * @return
     */
    ResponseBean findSubSystems(DevTypeDto devTypeDto);
}
