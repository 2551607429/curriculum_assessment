package com.dsa.core.service;

import com.dsa.common.enums.ResponseBean;
import com.dsa.core.dto.StationInputDto;
import com.dsa.core.dto.StationQueryDto;

import java.util.List;

/**
 * @author GUOJIKANG
 * @Title: 站所管理业务逻辑接口层
 * @ClassName StationService
 * @Description: TODO
 * @date 2019/5/27  16:45
 * @Version 1.0
 */
public interface StationService {
    /**
     * 获取变电站
     *
     * @param stationQueryDto
     * @return
     */
    ResponseBean findStationList(StationQueryDto stationQueryDto);

    /**
     * 插入变电站
     *
     * @param stationInputDto
     * @return
     */
    ResponseBean insertStation(StationInputDto stationInputDto);


    /**
     * 修改变电站
     *
     * @param stationInputDto
     * @return
     */
    ResponseBean updateStation(StationInputDto stationInputDto);


    /**
     * 删除变电站
     *
     * @param stationInputDtoList
     * @return
     */
    ResponseBean delStation(List<StationInputDto> stationInputDtoList);

    /**
     * 获取单条
     *
     * @param stationQueryDto
     * @return
     */
    ResponseBean getStation(StationQueryDto stationQueryDto);
}
