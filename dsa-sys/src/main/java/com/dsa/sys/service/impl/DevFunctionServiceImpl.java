package com.dsa.sys.service.impl;

import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.common.model.ListOutput;
import com.dsa.sys.dao.DevFunctionDao;
import com.dsa.sys.dao.DevTypeDao;
import com.dsa.sys.dao.SubSystemInfoDao;
import com.dsa.sys.dto.DevTypeDto;
import com.dsa.sys.model.DevFunction;
import com.dsa.sys.model.DevType;
import com.dsa.sys.model.SubSystemDevType;
import com.dsa.sys.model.SubSystemInfo;
import com.dsa.sys.service.DevFunctionService;
import com.dsa.sys.service.DevTypeService;
import com.dsa.utils.PageInfoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DevFunctionServiceImpl implements DevFunctionService{

    @Autowired
    DevFunctionDao devFunctionMapper;


    @Override
    public ResponseBean modifyDevFunction(DevTypeDto devTypeDto) {
        ResponseBean responseBean = new ResponseBean();

        // TODO 待优化
        //1.取消设备的所有相关功能
        int result = devFunctionMapper.removeLinkFuns(devTypeDto.getDevTypeId());
        if(result <= 0){
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.UPDATE_DATA.getCode());
            responseBean.setMsg(UnicomResponseEnums.UPDATE_DATA.getMsg());
            return responseBean;
        }

        //2.查找数据库中最大的功能id
        Integer maxFunctionId = devFunctionMapper.getMaxFunctionId();
        if(maxFunctionId == null){
            maxFunctionId = 1;
        }

        //3.数据组装
        List<DevFunction> devFunctionList = new ArrayList<>();
        for(DevFunction devFunction : devTypeDto.getDevFunctionList()){
            devFunction.setDevTypeId(devTypeDto.getDevTypeId());
            devFunction.setFunctionId(maxFunctionId);
            maxFunctionId += 1;
            devFunctionList.add(devFunction);
        }

        //4.批量插入设备功能表
        result = devFunctionMapper.insertBatch(devFunctionList);
        if(result > 0){
            responseBean.setCode(UnicomResponseEnums.SUCCESS.getCode());
            responseBean.setMsg(UnicomResponseEnums.SUCCESS.getMsg());
        }else{
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.UPDATE_DATA.getCode());
            responseBean.setMsg(UnicomResponseEnums.UPDATE_DATA.getMsg());
        }

        return responseBean;
    }
}
