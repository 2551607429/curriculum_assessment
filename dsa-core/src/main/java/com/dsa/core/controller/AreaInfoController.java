package com.dsa.core.controller;

import com.dsa.common.config.exception.NotEmptyException;
import com.dsa.common.enums.ResponseBean;
import com.dsa.core.dto.AreaInfoInputDto;
import com.dsa.core.dto.AreaInfoQueryDto;
import com.dsa.core.service.AreaInfoService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author GUOJIKANG
 * @Title: 区域管理控制器
 * @ClassName AreaInfo
 * @Description: TODO
 * @date 2019/5/25  13:52
 * @Version 1.0
 */
@RestController
@RequestMapping("/area")
public class AreaInfoController {

    @Autowired
    AreaInfoService areaInfoService;

    /**
     * 查询区域列表
     *
     * @param areaInfoQueryDto
     * @return
     */
    @RequestMapping("/area_list")
    public ResponseBean findAreaInfo(@RequestBody AreaInfoQueryDto areaInfoQueryDto){
        if(StringUtil.isEmpty(areaInfoQueryDto.getUnitId()) && StringUtil.isEmpty(areaInfoQueryDto.getOrgId())){
            throw new NotEmptyException("unitId,orgId必须选填一个");
        }
        return areaInfoService.findAreaInfo(areaInfoQueryDto);
    }


    /**
     * 新增区域
     *
     * @param
     * @return
     */
    @RequestMapping("/save_area")
    public ResponseBean saveAreaInfo(@RequestBody @Validated({AreaInfoInputDto.INSERT.class}) AreaInfoInputDto areaInfoInputDto){
        return areaInfoService.insertAreaInfo(areaInfoInputDto);
    }

    /**
     * 修改区域
     *
     * @param areaInfoInputDto
     * @return
     */
    @RequestMapping("/update_area")
    public ResponseBean updateAreaInfo(@RequestBody @Validated({AreaInfoInputDto.UPDATE.class}) AreaInfoInputDto areaInfoInputDto){
        return areaInfoService.updateAreaInfo(areaInfoInputDto);
    }

    /**
     * 删除区域
     *
     * @param areaInfoInputDtoList
     * @return
     */
    @RequestMapping("/del_area")
    public ResponseBean deleteAreaInfo(@RequestBody @Validated({AreaInfoInputDto.UPDATE.class}) List<AreaInfoInputDto> areaInfoInputDtoList){
        return areaInfoService.deleteAreaInfo(areaInfoInputDtoList);
    }
}
