package com.dsa.sys.controller;

import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.sys.dto.DictGroupDto;
import com.dsa.sys.dto.SubSystemInfoDto;
import com.dsa.sys.service.DictService;
import com.dsa.sys.service.SubSystemInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sub_system")
public class SubSystemController {

    @Autowired
    protected SubSystemInfoService systemInfoService;

    /**
     * 新增子系统
     * @return
     */
    @PostMapping(value = "/save")
    public ResponseBean insertSubSystemInfo(@RequestBody SubSystemInfoDto subSystemInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        if (subSystemInfoDto.getVisible()==null || StringUtils.isBlank(subSystemInfoDto.getVcName())
                || subSystemInfoDto.getType()==null || subSystemInfoDto.getIsEnable()==null) {
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return systemInfoService.insert(subSystemInfoDto);
    }

    /**
     * 修改子系统
     * @return
     */
    @PostMapping(value = "/update")
    public ResponseBean updateSubSystemInfo(@RequestBody SubSystemInfoDto subSystemInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        if (subSystemInfoDto.getSubSystemId()==null || StringUtils.isBlank(subSystemInfoDto.getVcName())
                || subSystemInfoDto.getType().toString().equals("") || subSystemInfoDto.getVisible()==null) {
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return systemInfoService.update(subSystemInfoDto);
    }

    /**
     * 查询子系统列表
     * @return
     */
    @PostMapping(value = "/find")
    public ResponseBean findSubSystemInfo(@RequestBody SubSystemInfoDto subSystemInfoDto) {
        return systemInfoService.find(subSystemInfoDto);
    }

    /**
     * 查询子系统所属的设备类型列表
     * @return
     */
    @PostMapping(value = "/dev_type/find")
    public ResponseBean findDevTypes(@RequestBody SubSystemInfoDto subSystemInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        if(subSystemInfoDto.getSubSystemId() == null){
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return systemInfoService.findDevTypes(subSystemInfoDto);
    }

    /**
     * 关联设备类型
     * @return
     */
    @PostMapping(value = "/dev_type/link")
    public ResponseBean linkDevTypes(@RequestBody SubSystemInfoDto subSystemInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        if(subSystemInfoDto.getSubSystemId() == null || subSystemInfoDto.getDevTypeIds().isEmpty()){
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return systemInfoService.linkDevTypes(subSystemInfoDto);
    }

    /**
     * 删除子系统
     * @return
     */
    @PostMapping(value = "/del")
    public ResponseBean delSubSystemInfo(@RequestBody SubSystemInfoDto subSystemInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        if(subSystemInfoDto.getSubSystemId() == null){
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }
        return systemInfoService.delete(subSystemInfoDto.getSubSystemId());
    }

}
