package com.dsa.core.dao;

import com.dsa.core.dto.AreaInfoOutputDto;
import com.dsa.core.dto.AreaInfoQueryDto;
import com.dsa.core.model.AreaInfo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GUOJIKANG
 * @Title: 区域管理 数据链路层
 * @ClassName AreaInfoDao
 * @Description: TODO
 * @date 2019/5/28  13:53
 * @Version 1.0
 */
@Repository
public interface AreaInfoDao {
    /**
     * 查询区域列表
     *
     * @param areaInfoQueryDto
     * @return
     */
    List<AreaInfoOutputDto> findAreaInfo(AreaInfoQueryDto areaInfoQueryDto);


    /**
     * 新增区域
     *
     * @param
     * @return
     */
    Integer insertAreaInfo(AreaInfo areaInfo);

    /**
     * 修改区域
     *
     * @param areaInfo
     * @return
     */
    Integer updateAreaInfo(AreaInfo areaInfo);

    /**
     * 删除区域
     *
     * @param areaInfoList
     * @return
     */
    Integer deleteAreaInfo(@Param("areaInfoList") List<AreaInfo> areaInfoList);


}
