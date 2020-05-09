package com.dsa.sys.dao;

import com.dsa.sys.dto.DevTypeDto;
import com.dsa.sys.dto.SubSystemInfoDto;
import com.dsa.sys.model.DevType;
import com.dsa.sys.model.SubSystemDevType;
import com.dsa.sys.model.SubSystemInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevTypeDao {

    /**
     * 新增设备类型
     * @param record
     * @return
     */
    int insert(DevType record);

    /**
     * 获取最大的主键id
     * @return
     */
    Integer getMaxDevTypeId();

    /**
     * 更新设备类型
     * @param record
     * @return
     */
    int update(DevType record);

    /**
     * 删除设备类型
     * @param devTypeId
     * @return
     */
    int delById(Integer devTypeId);

    /**
     * 获取单条设备类型
     * @param devTypeId
     * @return
     */
    DevType get(Integer devTypeId);

    /**
     * 获取设备类型列表
     * @param devTypeDto
     * @return
     */
    // TODO mapper中传入的条件有哪些
    List<DevTypeDto> find(DevTypeDto devTypeDto);

    /**
     * 取消设备类型相关联的所有子系统
     * @param devTypeId
     * @return
     */
    int unLinkAllSubSystem(Integer devTypeId);

    /**
     * 查询设备类型下子系统
     * @param devTypeId
     * @return
     */
    List<SubSystemInfo> findSubSystems(Integer devTypeId);

}
