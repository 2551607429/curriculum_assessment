package com.dsa.sys.controller;

import com.dsa.common.aop.NoRepeatSubmit;
import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.sys.dto.ConfigInputDto;
import com.dsa.sys.service.ConfigService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GUOJIKANG
 * @Title: 系统配置Api 控制器
 * @ClassName ConfigController
 * @Description: TODO
 * @date 2019/5/20  14:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys_config")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    /**
     * 查询系统配置表 分页
     *
     * @param
     * @return
     */
    @PostMapping("/find_config")
    public ResponseBean findConfig(@RequestBody ConfigInputDto configInputDto) {
        ResponseBean result = configService.findConfig(configInputDto);
        return result;
    }

    /**
     * 保存系统配置 或修改
     *
     * @param configInputDto
     * @return
     */
    @PostMapping("/save_config")
    public ResponseBean saveConfig(@RequestBody ConfigInputDto configInputDto) {
        if (StringUtil.isEmpty(configInputDto.getVcKey())) {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), "vcKey " + UnicomResponseEnums.BAD_REQUEST.getMsg());
        }
        if (StringUtil.isEmpty(configInputDto.getVcDesc())) {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), "vcDesc " + UnicomResponseEnums.BAD_REQUEST.getMsg());
        }
        if (StringUtil.isEmpty(configInputDto.getVcValue())) {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), "vcValue " + UnicomResponseEnums.BAD_REQUEST.getMsg());
        }
        String isSave = configInputDto.getIsSave();
        if ("0".equals(isSave)) { //约定字段 为0保存 为1 修改
            return configService.saveConfig(configInputDto);
        } else if ("1".equals(isSave)) {
            if (configInputDto.getiIsEnable() == null) {
                return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), "iIsEnable " + UnicomResponseEnums.BAD_REQUEST.getMsg());
            }
            if (configInputDto.getiFlag() == null) {
                return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), "iFlag " + UnicomResponseEnums.BAD_REQUEST.getMsg());
            }
            return configService.updateConfig(configInputDto);
        } else {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), "isSave " + UnicomResponseEnums.BAD_REQUEST.getMsg());
        }
    }

    /**
     * 删除系统配置
     *
     * @param configInputDto 批量删除 只支持 application/json格式
     * @return
     */
    @PostMapping("/del_config")
    public ResponseBean delConfig(@RequestBody List<ConfigInputDto> configInputDto) {
        if (configInputDto.size() == 0) {
            return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), "configs " + UnicomResponseEnums.BAD_REQUEST.getMsg());
        }
        return configService.delConfig(configInputDto);
    }
}
