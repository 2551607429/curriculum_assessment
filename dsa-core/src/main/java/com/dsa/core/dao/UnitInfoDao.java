package com.dsa.core.dao;

import com.dsa.core.model.UnitInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GUOJIKANG
 * @Title: 管理单元数据链路层
 * @ClassName UnitInfoDao
 * @Description: TODO
 * @date 2019/5/25  13:53
 * @Version 1.0
 */
@Repository
public interface UnitInfoDao {

    /**
     * 插入管理单元
     * @param unitInfo
     * @return
     */
    Integer insertUnitInfo(UnitInfo unitInfo);


    /**
     * 修改
     * @param unitInfo
     * @return
     */
    Integer updateUnitInfo(UnitInfo unitInfo);


    /**
     * 删除
     * @param unitInfoList
     * @return
     */
    Integer delUnitInfo(@Param("unitInfoList") List<UnitInfo> unitInfoList);
}
