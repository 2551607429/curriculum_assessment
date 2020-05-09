package com.dsa.sys.dao;

import com.dsa.sys.dto.DevTypeDto;
import com.dsa.sys.model.DevFunction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevFunctionDao {

    /**
     * 查询设备功能列表
     * @param record
     * @return
     */
    List<DevFunction> find(DevTypeDto record);


    /**
     * 删除相关设备所有功能
     * @return
     */
    int removeLinkFuns(Integer devTypeId);

    /**
     * 获取表中最大的业务id
     * @return
     */
    Integer getMaxFunctionId();

    /**
     * 批量新增设备功能
     * @return
     */
    int insertBatch(List<DevFunction> devFunctionList);
}
