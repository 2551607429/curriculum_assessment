package com.dsa.sys.dao;

import com.dsa.sys.dto.DictGroupDto;
import com.dsa.sys.dto.DictGroupOutput;
import com.dsa.sys.model.DictData;
import com.dsa.sys.model.DictGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictDao {

    /**
     * 新增字典组数据
     * @param record
     * @return
     */
    int insertDictGroup(DictGroup record);

    /**
     * 更新字典组数据
     * @param record
     * @return
     */
    int updateDictGroup(DictGroup record);

    /**
     * 删除字典组数据
     * @param dictGroupID
     * @return
     */
    int delDictGroupById(@Param("dictGroupID") Integer dictGroupID);

    /**
     * 根据 dictGroupID 查找字典组数据
     * @param dictGroupID
     * @return
     */
    DictGroup selectByDictGroupID(@Param("dictGroupID") Integer dictGroupID);

    /**
     * 查找字典组列表数据
     * @return
     */
    List<DictGroupOutput> selectByPageAndSelections(DictGroupDto dictGroupDto);

    /**
     * 根据字典组id查找字典数据列表
     * @return
     */
    List<DictData> getDictDataList(int dictGroupID);

}
