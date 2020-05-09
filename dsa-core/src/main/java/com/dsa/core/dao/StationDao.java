package com.dsa.core.dao;

import com.dsa.core.dto.StationOutputDto;
import com.dsa.core.model.Station;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GUOJIKANG
 * @Title:
 * @ClassName StationDao
 * @Description: TODO
 * @date 2019/5/27  16:44
 * @Version 1.0
 */
@Repository
public interface StationDao {
    /**
     * 获取变电站
     * @return
     */
    List<StationOutputDto> findStationList(Station station);

    /**
     * 插入变电站
     * @return
     */
    Integer insertStation(Station station);


    /**
     * 修改变电站
     * @return
     */
    Integer updateStation(Station station);


    /**
     * 删除变电站
     * @return
     */
    Integer delStation(@Param("stationList") List<Station> stationList);


}
