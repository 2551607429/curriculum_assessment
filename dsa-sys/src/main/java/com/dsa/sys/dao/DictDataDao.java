package com.dsa.sys.dao;

import com.dsa.sys.model.DictData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictDataDao {

    /**
     * 添加字典数据
     * @return
     */
    int saveDictData(DictData dictData);

    /**
     * 修改字典数据
     * @return
     */
    int updateDictData(DictData dictData);

    /**
     * 根据字典组id查找最大字典数据
     * @return
     */
    DictData selectMaxDictID(Integer dictGroupID);

    /**
     * 根据字典组id查找字典数据列表
     * @return
     */
    List<DictData> findDictDataList(Integer dictGroupID);

    /**
     *根据主键id, 批量删除字典数据
     * @return
     */
    int delDictDataByIds(List<Integer> dictIdList);
}
