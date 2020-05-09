package com.dsa.sys.controller;

import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.sys.dto.DevTypeDto;
import com.dsa.sys.service.DevTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev_type")
public class DevTypeController {

    @Autowired
    protected DevTypeService devTypeService;

    /**
     * 新增设备类型
     * @return
     */
    @PostMapping(value = "/save")
    public ResponseBean insertDevType(@RequestBody DevTypeDto devTypeDto) {
        ResponseBean responseBean = new ResponseBean();
        if (StringUtils.isBlank(devTypeDto.getVcName()) || devTypeDto.getIsEnable()==null) {
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return devTypeService.insert(devTypeDto);
    }

    /**
     * 修改设备类型
     * @return
     */
    @PostMapping(value = "/update")
    public ResponseBean updateDevType(@RequestBody DevTypeDto devTypeDto) {
        ResponseBean responseBean = new ResponseBean();
        if (devTypeDto.getIsEnable()==null || StringUtils.isBlank(devTypeDto.getVcName())
               || devTypeDto.getFlag()==null) {
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return devTypeService.update(devTypeDto);
    }

    /**
     * 查询设备类型列表
     * @return
     */
    @PostMapping(value = "/find")
    public ResponseBean findDevTypes(@RequestBody DevTypeDto devTypeDto) {
        return devTypeService.findDevTypes(devTypeDto);
    }

    /**
     * 查询设备类型功能列表
     * @return
     */
    @PostMapping(value = "/dev_fun/find")
    public ResponseBean findDevFunctions(@RequestBody DevTypeDto devTypeDto) {
        ResponseBean responseBean = new ResponseBean();
        if (devTypeDto.getDevTypeId()==null) {
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }
        return devTypeService.findDevFunctions(devTypeDto);
    }

    /**
     * 查询某个设备类型关联的所有子系统
     * @return
     */
    @PostMapping(value = "/sub_system/find")
    public ResponseBean findSubSystems(@RequestBody DevTypeDto devTypeDto) {
        ResponseBean responseBean = new ResponseBean();
        if(devTypeDto.getDevTypeId() == null){
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return devTypeService.findSubSystems(devTypeDto);
    }

    /**
     * 关联子系统
     * @return
     */
    @PostMapping(value = "/sub_system/link")
    public ResponseBean linkSubSystemInfos(@RequestBody DevTypeDto devTypeDto) {
        ResponseBean responseBean = new ResponseBean();
        if(devTypeDto.getDevTypeId() == null || devTypeDto.getSubSystemIds().isEmpty()){
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return devTypeService.linkSubSystemInfos(devTypeDto);
    }

    /**
     * 删除设备类型
     * @return
     */
    @PostMapping(value = "/del")
    public ResponseBean delSubSystemInfo(@RequestBody DevTypeDto devTypeDto) {
        ResponseBean responseBean = new ResponseBean();
        if(devTypeDto.getDevTypeId() == null){
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }
        return devTypeService.delete(devTypeDto.getDevTypeId());
    }

}
