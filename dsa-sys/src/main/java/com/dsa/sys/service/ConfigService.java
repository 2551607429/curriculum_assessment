package com.dsa.sys.service;

import com.dsa.common.enums.ResponseBean;
import com.dsa.sys.dto.ConfigInputDto;

import java.util.List;


public interface ConfigService {
    /**
     * 查询系统配置
     * @param configInputDto 系统配置实体 可根据实体内参数进行查询
     * @return
     */
    ResponseBean findConfig(ConfigInputDto configInputDto);

    /**
     * 修改系统配置
     * @param configInputDto 系统配置实体
     * @return
     */
    ResponseBean  updateConfig(ConfigInputDto configInputDto);

    /**
     * 新增系统配置
     * @param configInputDto 系统配置
     * @return
     */
    ResponseBean  saveConfig(ConfigInputDto configInputDto);

    /**
     * 删除系统配置
     * @param configs 关键字
     * @return
     */
    ResponseBean delConfig(List<ConfigInputDto> configs);
}
