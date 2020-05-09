package com.dsa.core.service.impl;


import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.core.dao.UnitInfoDao;
import com.dsa.core.dto.UnitInfoInputDto;
import com.dsa.core.model.UnitInfo;
import com.dsa.core.service.UnitInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author GUOJIKANG
 * @Title: 管理单元业务逻辑实现类
 * @ClassName UnitInfoServiceImpl
 * @Description: TODO
 * @date 2019/5/25  14:18
 * @Version 1.0
 */
@Service
public class UnitInfoServiceImpl implements UnitInfoService {

    @Autowired
    UnitInfoDao unitInfoDao;


    @Override
    public ResponseBean setStatus(UnitInfoInputDto unitInfoInputDto) {
        UnitInfo unitInfo = new UnitInfo();
        unitInfo.setUnitId(unitInfoInputDto.getUnitId());
        unitInfo.setiIsEnable(unitInfoInputDto.getiIsEnable());
        unitInfoDao.updateUnitInfo(unitInfo);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }
}
