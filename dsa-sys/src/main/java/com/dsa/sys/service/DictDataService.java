package com.dsa.sys.service;

import com.dsa.common.enums.ResponseBean;
import com.dsa.sys.dto.DictDataDto;
import com.dsa.sys.model.DictData;
import com.dsa.sys.model.DictGroup;

import java.util.List;
import java.util.Map;

public interface DictDataService {
    /**
     * 添加字典数据
     * @return
     */
    ResponseBean saveDictData(DictDataDto dictData);

    /**
     * 修改字典数据
     * @return
     */
    ResponseBean updateDictData(DictDataDto dictData);

    /**
     *查询字典组列表
     * @return
     */
    ResponseBean findDictDataList(Integer dictGroupID);

    /**
     *根据主键id, 批量删除字典数据
     * @return
     */
    ResponseBean delDictDataByIds(List<Integer> dictIdList);
}
