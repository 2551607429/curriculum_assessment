package com.dsa.core.service.impl;

import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.common.model.ListOutput;
import com.dsa.core.dao.StationDao;
import com.dsa.core.dao.UnitInfoDao;
import com.dsa.core.dto.StationInputDto;
import com.dsa.core.dto.StationOutputDto;
import com.dsa.core.dto.StationQueryDto;
import com.dsa.core.model.Station;
import com.dsa.core.model.UnitInfo;
import com.dsa.core.service.StationService;
import com.dsa.utils.GenerateUtil;
import com.dsa.utils.PageInfoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GUOJIKANG
 * @Title: 站所管理业务逻辑接口实现层
 * @ClassName StationServiceImpl
 * @Description: TODO
 * @date 2019/5/27  16:45
 * @Version 1.0
 */

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    StationDao stationDao;
    @Autowired
    UnitInfoDao unitInfoDao;

    @Override
    public ResponseBean findStationList(StationQueryDto stationQueryDto) {
        List<StationOutputDto> stationList = new ArrayList<>();
        Station station = new Station();
        BeanUtils.copyProperties(stationQueryDto, station);
        PageHelper.startPage(stationQueryDto.getPage().getCurrentPage(), stationQueryDto.getPage().getPageSize());
        stationList = stationDao.findStationList(station);
        PageInfo<Station> pageInfo = new PageInfo(stationList);
        ListOutput listOutput = new ListOutput();
        listOutput.setPage(PageInfoUtil.getPage(pageInfo));
        listOutput.setLists(stationList);
        return new ResponseBean(UnicomResponseEnums.SUCCESS.getCode(), listOutput, UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBean insertStation(StationInputDto stationInputDto) {
        Station station = new Station();
        stationInputDto.setUnitId(GenerateUtil.getGUID32());
        BeanUtils.copyProperties(stationInputDto, station);
        stationDao.insertStation(station);
        UnitInfo unitInfo = new UnitInfo();
        BeanUtils.copyProperties(stationInputDto, unitInfo);
        unitInfoDao.insertUnitInfo(unitInfo);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBean updateStation(StationInputDto stationInputDto) {
        Station station = new Station();
        BeanUtils.copyProperties(stationInputDto, station);
        stationDao.updateStation(station);
        UnitInfo unitInfo = new UnitInfo();
        BeanUtils.copyProperties(stationInputDto, unitInfo);
        unitInfoDao.updateUnitInfo(unitInfo);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBean delStation(List<StationInputDto> stationInputDtoList) {
        List<Station> stationList = new ArrayList<>();
        List<UnitInfo> unitInfoList = new ArrayList<>();
        Station station ;
        UnitInfo unitInfo;
        for (StationInputDto s : stationInputDtoList) {
            unitInfo = new UnitInfo();
            station = new Station();
            BeanUtils.copyProperties(s, station);
            BeanUtils.copyProperties(s, unitInfo);
            stationList.add(station);
            unitInfoList.add(unitInfo);
        }
        stationDao.delStation(stationList);
        unitInfoDao.delUnitInfo(unitInfoList);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean getStation(StationQueryDto stationQueryDto) {
        List<StationOutputDto> stationList = new ArrayList<>();
        Station station = new Station();
        BeanUtils.copyProperties(stationQueryDto, station);
        stationList = stationDao.findStationList(station);
        StationOutputDto stationOutputDto = new StationOutputDto();
        if (stationList.size() != 0) {
            stationOutputDto = stationList.get(0);
            return new ResponseBean(UnicomResponseEnums.SUCCESS.getCode(), stationOutputDto, UnicomResponseEnums.SUCCESS.getMsg());
        } else {
            return new ResponseBean(false, UnicomResponseEnums.NO_RECORD.getCode(), UnicomResponseEnums.NO_RECORD.getMsg());
        }
    }
}
