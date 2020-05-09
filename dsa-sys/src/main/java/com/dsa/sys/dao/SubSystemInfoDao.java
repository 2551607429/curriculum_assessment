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
public interface SubSystemInfoDao {

    /**
     * 新增子系统
     * @param record
     * @return
     */
    int insert(SubSystemInfo record);


    /**
     * 根据业务主键获取单个记录
     * @param subSystemId
     * @return
     */
    SubSystemInfo get(@Param("subSystemId") Integer subSystemId);

    /**
     * 查找出当前最大的 subSystemId
     * @return
     */
    Integer getMaxSubSystemId();

    /**
     * 更新子系统
     * @param record
     * @return
     */
    int update(SubSystemInfo record);

    /**
     * 删除单条子系统信息
     * @return
     */
    int delById(Integer subSystemId);

    /**
     * 查询子系统信息列表
     * @return
     */
    List<SubSystemInfo> find(SubSystemInfoDto subSystemInfoDto);

    /**
     * 查询子系统下的设备类型
     * @return
     */
    List<DevType> findDevTypes(Integer subSystemId);

    /**
     * 取消子系统下的所有关联
     * @return
     */
    int unLinkAllDevType(Integer subSystemId);

    /**
     * 子系统关联设备类型
     * @return
     * @param subSystemDevTypeList
     */
    int linkSubSystemDevTypes(List<SubSystemDevType> subSystemDevTypeList);
}
