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
public class DevTypeServiceImpl implements DevTypeService{

    @Autowired
    DevTypeDao devTypeMapper;

    @Autowired
    DevFunctionDao devFunctionMapper;

    @Autowired
    SubSystemInfoDao subSystemInfoMapper;

    @Override
    public ResponseBean insert(DevTypeDto devTypeDto) {
        ResponseBean responseBean = new ResponseBean();

        //将dto转换为pojo,进行持久化
        DevType input = new DevType();
        BeanUtils.copyProperties(devTypeDto, input);

        //设置 devTypeID , 根据数据库最大的 DevTypeID 自增
        Integer maxDevTypeIdId = devTypeMapper.getMaxDevTypeId();
        if(maxDevTypeIdId != null){
            input.setDevTypeId(maxDevTypeIdId + 1);
        }else{
            input.setDevTypeId(1);
        }

        //新增记录
        int result = devTypeMapper.insert(input);
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

    @Override
    public ResponseBean update(DevTypeDto devTypeDto) {
        ResponseBean responseBean = new ResponseBean();

        DevType input = new DevType();
        BeanUtils.copyProperties(devTypeDto, input);

        // 更新数据
        int result = devTypeMapper.update(input);
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

    @Override
    public ResponseBean delete(Integer devTypeId) {
        ResponseBean responseBean = new ResponseBean();

        // 删除子系统数据
        int result = devTypeMapper.delById(devTypeId);
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

    @Override
    public ResponseBean get(Integer devTypeId) {
        ResponseBean responseBean = new ResponseBean();
        DevType devType = devTypeMapper.get(devTypeId);
        if(devType == null){
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.UPDATE_DATA.getCode());
            responseBean.setMsg(UnicomResponseEnums.UPDATE_DATA.getMsg());
        }else{
            responseBean.setData(devType);
            responseBean.setCode(UnicomResponseEnums.SUCCESS.getCode());
            responseBean.setMsg(UnicomResponseEnums.SUCCESS.getMsg());
        }

        return responseBean;
    }

    @Override
    public ResponseBean findDevTypes(DevTypeDto devTypeDto) {
        ResponseBean responseBean = new ResponseBean();
        //设置pagehelper分页查询
        PageHelper.startPage(devTypeDto.getCurrentPage(), devTypeDto.getPageSize());
        List<DevTypeDto> devTypeDtoList = devTypeMapper.find(devTypeDto);
        PageInfo<DevTypeDto> pageInfo = new PageInfo<>(devTypeDtoList);

        //数据封装
        ListOutput listOutput = new ListOutput();
        listOutput.setPage(PageInfoUtil.getPage(pageInfo));
        listOutput.setLists(devTypeDtoList);

        //返回结果
        responseBean.setData(listOutput);
        responseBean.setCode(UnicomResponseEnums.SUCCESS.getCode());
        responseBean.setMsg(UnicomResponseEnums.SUCCESS.getMsg());
        return responseBean;
    }

    @Override
    public ResponseBean findDevFunctions(DevTypeDto devTypeDto) {
        ResponseBean responseBean = new ResponseBean();
        //设置pagehelper分页查询
        PageHelper.startPage(devTypeDto.getCurrentPage(), devTypeDto.getPageSize());
        List<DevFunction> devFunctionList = devFunctionMapper.find(devTypeDto);
        PageInfo<DevFunction> pageInfo = new PageInfo<>(devFunctionList);

        //数据封装
        ListOutput listOutput = new ListOutput();
        listOutput.setPage(PageInfoUtil.getPage(pageInfo));
        listOutput.setLists(devFunctionList);

        //返回结果
        responseBean.setData(listOutput);
        responseBean.setCode(UnicomResponseEnums.SUCCESS.getCode());
        responseBean.setMsg(UnicomResponseEnums.SUCCESS.getMsg());
        return responseBean;
    }

    @Override
    public ResponseBean linkSubSystemInfos(DevTypeDto devTypeDto) {
        ResponseBean responseBean = new ResponseBean();

        // TODO 待优化
        //1.取消 devType 下的所有关联子系统
        int result = devTypeMapper.unLinkAllSubSystem(devTypeDto.getDevTypeId());
        if(result <= 0){
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.UPDATE_DATA.getCode());
            responseBean.setMsg(UnicomResponseEnums.UPDATE_DATA.getMsg());
            return responseBean;
        }

        //2.关联设备类型
        List<SubSystemDevType> subSystemDevTypeList = new ArrayList<>();
        for(Integer id : devTypeDto.getSubSystemIds()){
            SubSystemDevType subSystemDevType = new SubSystemDevType();
            subSystemDevType.setDevTypeId(devTypeDto.getDevTypeId());
            subSystemDevType.setSubSystemId(id);
            subSystemDevType.setFlag(0);
            subSystemDevTypeList.add(subSystemDevType);
        }
        result = subSystemInfoMapper.linkSubSystemDevTypes(subSystemDevTypeList);
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

    @Override
    public ResponseBean findSubSystems(DevTypeDto devTypeDto) {
        ResponseBean responseBean = new ResponseBean();

        PageHelper.startPage(devTypeDto.getCurrentPage(), devTypeDto.getPageSize());
        List<SubSystemInfo> subSystemInfoList = devTypeMapper.findSubSystems(devTypeDto.getDevTypeId());
        PageInfo<SubSystemInfo> pageInfo = new PageInfo<>(subSystemInfoList);

        if(!subSystemInfoList.isEmpty()){
            ListOutput data = new ListOutput();
            data.setLists(subSystemInfoList);
            data.setPage(PageInfoUtil.getPage(pageInfo));

            responseBean.setData(data);
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
