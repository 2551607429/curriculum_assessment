package com.dsa.sys.controller;

import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.sys.dto.DictGroupDto;
import com.dsa.sys.service.DictService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys_dict")
public class DictController {

    @Autowired
    protected DictService dictService;

    /**
     * 新增字典组
     * @return
     */
    @PostMapping(value = "/group/save")
    public ResponseBean saveDictGroup(@RequestBody DictGroupDto dictGroup) {
        ResponseBean responseBean = new ResponseBean();
        if (dictGroup.getDictGroupID()==null || StringUtils.isBlank(dictGroup.getVcName())
                || dictGroup.getType()==null || dictGroup.getIsEnable()==null) {
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return dictService.addDictGroup(dictGroup);
    }

    /**
     * 修改字典组
     * @return
     */
    @PostMapping(value = "/group/update")
    public ResponseBean updateDictGroup(@RequestBody DictGroupDto dictGroup) {
        ResponseBean responseBean = new ResponseBean();
        if (dictGroup.getDictGroupID()==null) {
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return dictService.updateDictGroup(dictGroup);
    }

    /**
     * 查询字典组
     * @return
     */
    @PostMapping(value = "/group/find_list")
    public ResponseBean findDictGroupList(@RequestBody DictGroupDto dictGroupDto) {
        return dictService.findByCondition(dictGroupDto);
    }

    /**
     * 删除字典组
     * @return
     */
    @PostMapping(value = "/group/del")
    public ResponseBean delDictGroupById(@RequestBody DictGroupDto dictGroupDto) {
        ResponseBean responseBean = new ResponseBean();
        if(dictGroupDto.getDictGroupID() == null){
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }
        return dictService.delDictGroupById(dictGroupDto.getDictGroupID());
    }

}
