package com.dsa.sys.service.impl;

import com.alibaba.druid.sql.PagerUtils;
import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.common.model.ListOutput;
import com.dsa.sys.dao.SubSystemInfoDao;
import com.dsa.sys.dto.DevTypeDto;
import com.dsa.sys.dto.SubSystemInfoDto;
import com.dsa.sys.model.DevType;
import com.dsa.sys.model.DictGroup;
import com.dsa.sys.model.SubSystemDevType;
import com.dsa.sys.model.SubSystemInfo;
import com.dsa.sys.service.SubSystemInfoService;
import com.dsa.utils.GenerateUtil;
import com.dsa.utils.PageInfoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubSystemInfoServiceImpl implements SubSystemInfoService{

    @Autowired
    SubSystemInfoDao subSystemInfoMapper;

    @Override
    public ResponseBean insert(SubSystemInfoDto subSystemInfoDto) {
        ResponseBean responseBean = new ResponseBean();

        //将dto转换为pojo,进行持久化
        SubSystemInfo input = new SubSystemInfo();
        BeanUtils.copyProperties(subSystemInfoDto, input);

        //设置 subSystemId , 根据数据库最大的 SubSystemId 自增
        Integer maxSubSystemId = subSystemInfoMapper.getMaxSubSystemId();
        if(maxSubSystemId != null){
            input.setSubSystemId(maxSubSystemId + 1);
        }else{
            input.setSubSystemId(1);
        }

        //新增subSystemInfo记录
        int result = subSystemInfoMapper.insert(input);
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
    public ResponseBean update(SubSystemInfoDto subSystemInfoDto) {
        ResponseBean responseBean = new ResponseBean();

        SubSystemInfo input = new SubSystemInfo();
        BeanUtils.copyProperties(subSystemInfoDto, input);

        // 更新subSystemInfo数据
        int result = subSystemInfoMapper.update(input);
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
    public ResponseBean get(Integer subSystemId) {
        ResponseBean responseBean = new ResponseBean();
        SubSystemInfo subSystemInfo = subSystemInfoMapper.get(subSystemId);
        if(subSystemInfo == null){
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.UPDATE_DATA.getCode());
            responseBean.setMsg(UnicomResponseEnums.UPDATE_DATA.getMsg());
        }else{
            responseBean.setData(subSystemInfo);
            responseBean.setCode(UnicomResponseEnums.SUCCESS.getCode());
            responseBean.setMsg(UnicomResponseEnums.SUCCESS.getMsg());
        }

        return responseBean;
    }

    @Override
    public ResponseBean delete(Integer subSystemId) {
        ResponseBean responseBean = new ResponseBean();

        // 删除子系统数据
        int result = subSystemInfoMapper.delById(subSystemId);
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
    public ResponseBean find(SubSystemInfoDto subSystemInfoDto) {
        ResponseBean responseBean = new ResponseBean();

        //TODO  查询时条件参数有哪些待定
        // 根据条件查询子系统信息
        PageHelper.startPage(subSystemInfoDto.getCurrentPage(), subSystemInfoDto.getPageSize());
        List<SubSystemInfo> result = subSystemInfoMapper.find(subSystemInfoDto);
        PageInfo<SubSystemInfo> pageInfo = new PageInfo<>(result);

        if(!result.isEmpty()){
            ListOutput data = new ListOutput();
            data.setLists(result);
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

    @Override
    public ResponseBean findDevTypes(SubSystemInfoDto subSystemInfoDto) {
        ResponseBean responseBean = new ResponseBean();

        PageHelper.startPage(subSystemInfoDto.getCurrentPage(), subSystemInfoDto.getPageSize());
        List<DevType> devTypeDtoList = subSystemInfoMapper.findDevTypes(subSystemInfoDto.getSubSystemId());
        PageInfo<DevType> pageInfo = new PageInfo<>(devTypeDtoList);

        if(!devTypeDtoList.isEmpty()){
            ListOutput data = new ListOutput();
            data.setLists(devTypeDtoList);
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

    @Override
    public ResponseBean linkDevTypes(SubSystemInfoDto subSystemInfoDto) {
        ResponseBean responseBean = new ResponseBean();

        // TODO 待优化
        //1.取消 subSystemId 下的所有关联
        int result = subSystemInfoMapper.unLinkAllDevType(subSystemInfoDto.getSubSystemId());
        if(result <= 0){
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.UPDATE_DATA.getCode());
            responseBean.setMsg(UnicomResponseEnums.UPDATE_DATA.getMsg());
            return responseBean;
        }

        //2.关联设备类型
        List<SubSystemDevType> subSystemDevTypeList = new ArrayList<>();
        for(Integer id : subSystemInfoDto.getDevTypeIds()){
            SubSystemDevType subSystemDevType = new SubSystemDevType();
            subSystemDevType.setSubSystemId(subSystemInfoDto.getSubSystemId());
            subSystemDevType.setDevTypeId(id);
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

}
