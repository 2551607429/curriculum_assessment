package com.dsa.sys.controller;

import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import com.dsa.sys.dto.DictDataDto;
import com.dsa.sys.service.DictDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys_dict")
public class DictDataController {

    @Autowired
    protected DictDataService dictDataService;

    /**
     * 新增字典数据
     * @return
     */
    @PostMapping(value = "/data/save")
    public ResponseBean saveDictData(@RequestBody DictDataDto dictData) {
        ResponseBean responseBean = new ResponseBean();
        if (dictData.getDictGroupID() == null || StringUtils.isBlank(dictData.getVcName()) ||
                dictData.getIsEnable() == null) {
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return dictDataService.saveDictData(dictData);
    }

    /**
     * 修改字典数据
     * @return
     */
    @PostMapping(value = "/data/update")
    public ResponseBean updateDictData(@RequestBody DictDataDto dictData) {
        ResponseBean responseBean = new ResponseBean();
        if (dictData.getDictID() == null) {
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return dictDataService.updateDictData(dictData);
    }


    /**
     * 删除字典数据
     * @return
     */
    @PostMapping(value = "/data/ids/del")
    public ResponseBean delDictDataByIds(@RequestBody List<Integer> dictIdList) {
        ResponseBean responseBean = new ResponseBean();
        if (dictIdList.isEmpty()) {
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return dictDataService.delDictDataByIds(dictIdList);
    }

    /**
     * 查询字典数据
     * @return
     */
    @PostMapping(value = "/data/find_list")
    public ResponseBean findDictDataList(@RequestBody DictDataDto dictDataDto) {
        ResponseBean responseBean = new ResponseBean();
        if (dictDataDto.getDictGroupID() == null) {
            responseBean.setSuccess(false);
            responseBean.setCode(UnicomResponseEnums.BAD_REQUEST.getCode());
            responseBean.setMsg(UnicomResponseEnums.BAD_REQUEST.getMsg());
            return responseBean;
        }

        return dictDataService.findDictDataList(dictDataDto.getDictGroupID());
    }

}
