package com.dsa.sys.service;

import com.dsa.common.enums.ResponseBean;
import com.dsa.sys.dto.DictGroupDto;
import com.dsa.sys.model.DictGroup;

import java.util.Map;

public interface DictService {
    /**
     * 添加字典组数据
     * @return
     */
    ResponseBean addDictGroup(DictGroupDto dictGroup);

    /**
     * 更新字典组数据
     * @return
     */
    ResponseBean updateDictGroup(DictGroupDto dictGroup);

    /**
     *根据 dictGroupID 删除字典组
     * @return
     */
    ResponseBean delDictGroupById(Integer dictGroupID);

    /**
     *根据传入条件查询字典组列表
     * @return
     */
    ResponseBean findByCondition(DictGroupDto dictGroupDto);
}
