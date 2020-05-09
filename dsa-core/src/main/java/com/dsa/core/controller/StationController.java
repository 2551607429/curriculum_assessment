package com.dsa.core.controller;

import com.dsa.common.enums.ResponseBean;
import com.dsa.core.dto.AreaInfoInputDto;
import com.dsa.core.dto.StationInputDto;
import com.dsa.core.dto.StationQueryDto;
import com.dsa.core.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author GUOJIKANG
 * @Title: 站所管理控制层
 * @ClassName StationController
 * @Description: TODO
 * @date 2019/5/27  16:44
 * @Version 1.0
 */
@RestController
@RequestMapping("/station")
public class StationController {
    @Autowired
    StationService stationService;

    @PostMapping("/station_list")
    public ResponseBean findStationList(@RequestBody @Validated({StationQueryDto.FIND.class}) StationQueryDto stationQueryDto) {
        return stationService.findStationList(stationQueryDto);
    }

    @PostMapping("/get_station")
    public ResponseBean getStation(@RequestBody @Validated({StationQueryDto.GET.class}) StationQueryDto stationQueryDto) {
        return stationService.getStation(stationQueryDto);
    }

    @PostMapping("/save_station")
    public ResponseBean saveStation(@RequestBody @Validated({AreaInfoInputDto.INSERT.class}) StationInputDto stationInputDto) {
        return stationService.insertStation(stationInputDto);
    }

    @PostMapping("/update_station")
    public ResponseBean updateStation(@RequestBody @Validated({AreaInfoInputDto.INSERT.class, AreaInfoInputDto.UPDATE.class}) StationInputDto stationInputDto) {
        return stationService.updateStation(stationInputDto);
    }

    @PostMapping("/del_station")
    public ResponseBean delStation(@RequestBody @Validated({AreaInfoInputDto.UPDATE.class}) List<StationInputDto> stationInputDtoList) {
        return stationService.delStation(stationInputDtoList);
    }

}
