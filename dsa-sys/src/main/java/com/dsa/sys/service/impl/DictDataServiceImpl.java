package com.dsa.sys.service.impl;

import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.sys.dao.DictDataDao;
import com.dsa.sys.dto.DictDataDto;
import com.dsa.sys.model.DictData;
import com.dsa.sys.service.DictDataService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictDataServiceImpl implements DictDataService {

    @Autowired
    DictDataDao dictDataMapper;

    @Override
    public ResponseBean saveDictData(DictDataDto dictDataDto) {
        ResponseBean responseBean = new ResponseBean();

        //1.根据 dictGroupID 来生成 dictID
        DictData dictDataResultBean = dictDataMapper.selectMaxDictID(dictDataDto.getDictGroupID());
        int newDictID = -1;
        if(dictDataResultBean!=null){
            newDictID = dictDataResultBean.getDictID() + 1;
            dictDataDto.setDictID(newDictID);
        }else{
            newDictID = dictDataDto.getDictGroupID()*10000 + 1;
            dictDataDto.setDictID(newDictID);
        }

        //拷贝属性
        DictData dictData = new DictData();
        BeanUtils.copyProperties(dictDataDto, dictData);

        //2.新增dictData记录
        int result = dictDataMapper.saveDictData(dictData);
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
    public ResponseBean updateDictData(DictDataDto dictDataDto) {
        ResponseBean responseBean = new ResponseBean();

        //拷贝属性
        DictData dictData = new DictData();
        BeanUtils.copyProperties(dictDataDto, dictData);

        // 更新字典数据
        int result = dictDataMapper.updateDictData(dictData);
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
    public ResponseBean findDictDataList(Integer dictGroupID) {
        ResponseBean responseBean = new ResponseBean();

        // 查询所有字典数据
        List<DictData> result = dictDataMapper.findDictDataList(dictGroupID);
        if(result != null){
            responseBean.setData(result);
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
    public ResponseBean delDictDataByIds(List<Integer> dictIdList) {
        ResponseBean responseBean = new ResponseBean();

        // 查询所有字典数据
        int result = dictDataMapper.delDictDataByIds(dictIdList);
        if(result > 0){
            responseBean.setData(result);
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
