package com.dsa.sys.service.impl;

import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.sys.dao.DictDao;
import com.dsa.sys.dto.DictGroupDto;
import com.dsa.sys.dto.DictGroupOutput;
import com.dsa.sys.model.DictGroup;
import com.dsa.sys.service.DictService;
import com.dsa.utils.PageInfoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DictServiceImpl implements DictService{

    @Autowired
    DictDao dictMapper;

    @Override
    public ResponseBean addDictGroup(DictGroupDto dictGroup) {
        ResponseBean responseBean = new ResponseBean();

        //不可插入重复的dictGroupID
        DictGroup record = dictMapper.selectByDictGroupID(dictGroup.getDictGroupID());
        if(record != null) {
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.REPEAT_DATA.getCode());
            responseBean.setMsg(UnicomResponseEnums.REPEAT_DATA.getMsg());
            return responseBean;
        }

        //将dto转换为pojo,进行持久化
        DictGroup dictGroup1 = new DictGroup();
        BeanUtils.copyProperties(dictGroup, dictGroup1);

        //新增dictGroup记录
        int result = dictMapper.insertDictGroup(dictGroup1);
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
    public ResponseBean updateDictGroup(DictGroupDto dictGroup) {
        ResponseBean responseBean = new ResponseBean();

        DictGroup dictGroup1 = new DictGroup();
        BeanUtils.copyProperties(dictGroup, dictGroup1);

        // 更新dictGroup数据
        int result = dictMapper.updateDictGroup(dictGroup1);
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
    public ResponseBean delDictGroupById(Integer dictGroupID) {
        ResponseBean responseBean = new ResponseBean();

        // 删除字典组数据
        int result = dictMapper.delDictGroupById(dictGroupID);
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
    public ResponseBean findByCondition(DictGroupDto dictGroupDto) {
        ResponseBean responseBean = new ResponseBean();
        //设置pagehelper分页查询
        PageHelper.startPage(dictGroupDto.getCurrentPage(), dictGroupDto.getPageSize());
        List<DictGroupOutput> dictGroupVoList = dictMapper.selectByPageAndSelections(dictGroupDto);
        PageInfo<DictGroupOutput> pageInfo = new PageInfo<>(dictGroupVoList);

        //数据封装
        Map<String, Object> map = new HashMap<>();
        map.put("page",PageInfoUtil.getPage(pageInfo));
        map.put("list",dictGroupVoList);

        responseBean.setData(map);
        responseBean.setCode(UnicomResponseEnums.SUCCESS.getCode());
        responseBean.setMsg(UnicomResponseEnums.SUCCESS.getMsg());
        return responseBean;
    }
}
