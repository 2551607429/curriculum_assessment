package com.dsa.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.sys.dao.ConfigDao;
import com.dsa.sys.dto.ConfigInputDto;
import com.dsa.sys.model.Config;
import com.dsa.sys.service.ConfigService;

import com.dsa.sys.dto.ConfigOutputDto;
import com.dsa.utils.PageInfoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConfigServiceImpl implements ConfigService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ConfigDao configDao;

    @Override
    public ResponseBean findConfig(ConfigInputDto configInputDto) {
        logger.info(configInputDto.toString());
        ResponseBean responseBean = new ResponseBean();
        Config config = new Config();
        BeanUtils.copyProperties(configInputDto, config);
        PageHelper.startPage(configInputDto.getPage().getCurrentPage(), configInputDto.getPage().getPageSize(), "i_Sort ASC");
        List<ConfigOutputDto> configList = configDao.findConfig(config);
//        int countNums = configDao.countConfig(config);
        PageInfo<ConfigOutputDto> pageInfo = new PageInfo(configList);
        logger.info(JSON.toJSONString(configList));
        responseBean.setCode(UnicomResponseEnums.SUCCESS.getCode());
        responseBean.setMsg(UnicomResponseEnums.SUCCESS.getMsg());
        Map<String, Object> map = new HashMap<>();
        map.put("list", configList);
        map.put("page", PageInfoUtil.getPage(pageInfo));
        responseBean.setData(map);
        return responseBean;
    }

    @Override
    public ResponseBean updateConfig(ConfigInputDto configInputDto) {
        Config config = new Config();
        config.setVcKey(configInputDto.getVcKey());
        int result = configDao.countConfig(config);
        BeanUtils.copyProperties(configInputDto, config);
        if (result == 0) { //用户不存在
            return new ResponseBean(false, UnicomResponseEnums.NO_USER_EXIST.getCode(), UnicomResponseEnums.NO_USER_EXIST.getMsg());
        }
        configDao.updateConfig(config);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean saveConfig(ConfigInputDto configInputDto) {
        configInputDto.setiFlag(0);
        configInputDto.setiIsEnable(1);
        Config config = new Config();
        config.setVcKey(configInputDto.getVcKey());
        int count = configDao.countConfig(config);
        if (count != 0) { //key重复
            return new ResponseBean(false, UnicomResponseEnums.REPEAT_DATA.getCode(), UnicomResponseEnums.REPEAT_DATA.getMsg() + " vcKey不能重复");
        }
        //将数据放入持久层 存入数据库
        BeanUtils.copyProperties(configInputDto, config);
        configDao.saveConfig(config);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }

    @Override
    public ResponseBean delConfig(List<ConfigInputDto> configs) {
        List<Config> configList = new ArrayList<>();
        for (ConfigInputDto c : configs) {
            Config config = new Config();
            BeanUtils.copyProperties(c, config);
            configList.add(config);
        }
        configDao.delConfig(configList);
        return new ResponseBean(true, UnicomResponseEnums.SUCCESS.getCode(), UnicomResponseEnums.SUCCESS.getMsg());
    }
}
