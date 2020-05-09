package com.dsa.sys.controller;

import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.sys.dto.DevTypeDto;
import com.dsa.sys.service.DevFunctionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev_function")
public class DevFunctionController {

    @Autowired
    protected DevFunctionService devFunctionService;

    /**
     * 新增或修改设备功能
     * @return
     */
    @PostMapping(value = "/modify")
    public ResponseBean modifyDevFunction(@RequestBody DevTypeDto devTypeDto) {
        ResponseBean responseBean = new ResponseBean();
        if (devTypeDto.getDevTypeId()==null || devTypeDto.getDevFunctionList().isEmpty()) {
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return devFunctionService.modifyDevFunction(devTypeDto);
    }

}
