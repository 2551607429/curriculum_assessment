package com.dsa.sys.dao;

import com.dsa.sys.model.Config;
import com.dsa.sys.dto.ConfigOutputDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigDao {
    /**
     * 查询系统配置
     * @param config 可根据实体内参数进行查询
     * @return
     */
    List<ConfigOutputDto> findConfig(Config config);

    /**
     * 修改系统配置
     * @param config 系统配置实体
     * @return
     */
    int updateConfig(Config config);

    /**
     * 新增系统配置
     * @param config 系统配置实体
     * @return
     */
    int saveConfig(Config config);

    /**
     * 删除系统配置
     * @param configList 关键字集合
     * @return
     */
    int delConfig(@Param("configList") List<Config> configList);

    /**
     * 统计系统配置表
     * @return
     */
    int countConfig(Config config);
}
