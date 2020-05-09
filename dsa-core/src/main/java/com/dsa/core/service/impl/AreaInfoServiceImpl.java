package com.dsa.core.service.impl;

import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.common.model.ListOutput;
import com.dsa.core.dao.AreaInfoDao;
import com.dsa.core.dto.AreaInfoInputDto;
import com.dsa.core.dto.AreaInfoOutputDto;
import com.dsa.core.dto.AreaInfoQueryDto;
import com.dsa.core.model.AreaInfo;
import com.dsa.core.service.AreaInfoService;
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
 * @Title: 区域管理业务逻辑接口实现层
 * @ClassName AreaInfoServiceImpl
 * @Description: TODO
 * @date 2019/5/28  15:26
 * @Version 1.0
 */
@Service
@Transactional
public class AreaInfoServiceImpl implements AreaInfoService {

    @Autowired
    AreaInfoDao areaInfoDao;

    @Override
    public ResponseBean findAreaInfo(AreaInfoQueryDto areaInfoQueryDto) {
        List<AreaInfoOutputDto> areaInfoList = new ArrayList<>();
        PageHelper.startPage(areaInfoQueryDto.getPage().getCurrentPage(),areaInfoQueryDto.getPage().getPageSize(),true);
        areaInfoList = areaInfoDao.findAreaInfo(areaInfoQueryDto);
        PageInfo<AreaInfoOutputDto> pageInfo = new PageInfo<>(areaInfoList);
        ListOutput listOutput = new ListOutput(PageInfoUtil.getPage(pageInfo),areaInfoList);
        return new ResponseBean(UnicomResponseEnums.SUCCESS.getCode(), listOutput, UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean insertAreaInfo(AreaInfoInputDto areaInfoInputDto) {
        areaInfoInputDto.setAreaId(GenerateUtil.getGUID32());
        AreaInfo areaInfo = new AreaInfo();
        BeanUtils.copyProperties(areaInfoInputDto, areaInfo);
        areaInfoDao.insertAreaInfo(areaInfo);
        return new ResponseBean(true,UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());

    }

    @Override
    public ResponseBean updateAreaInfo(AreaInfoInputDto areaInfoInputDto) {
        AreaInfo areaInfo = new AreaInfo();
        BeanUtils.copyProperties(areaInfoInputDto, areaInfo);
        areaInfoDao.updateAreaInfo(areaInfo);
        return new ResponseBean(true,UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());

    }

    @Override
    public ResponseBean deleteAreaInfo(List<AreaInfoInputDto> areaInfoInputDtoList) {
        AreaInfo areaInfo;
        List<AreaInfo> areaInfoList = new ArrayList<>();
        for (AreaInfoInputDto o:areaInfoInputDtoList) {
            areaInfo = new AreaInfo();
            BeanUtils.copyProperties(o,areaInfo);
            areaInfoList.add(areaInfo);
        }
        areaInfoDao.deleteAreaInfo(areaInfoList);
        return new ResponseBean(true,UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());

    }
}
