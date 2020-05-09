package com.dsa.core.controller;

import com.dsa.common.config.exception.NotEmptyException;
import com.dsa.common.enums.ResponseBean;
import com.dsa.core.dto.UnitInfoInputDto;
import com.dsa.core.service.UnitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GUOJIKANG
 * @Title: 管理单元控制器
 * @ClassName UnitInfoController
 * @Description: TODO
 * @date 2019/5/25  13:51
 * @Version 1.0
 */
@RestController
@RequestMapping("/unit")
public class UnitInfoController {

    @Autowired
    UnitInfoService unitInfoService;

    /**
     * 是否启用
     * @param unitInfoInputDto
     * @return
     */
    @RequestMapping("/set_status")
    public ResponseBean setStatus(@RequestBody @Validated({UnitInfoInputDto.UPDATE.class}) UnitInfoInputDto unitInfoInputDto) {
        if (unitInfoInputDto.getiIsEnable() == null) {
            throw new NotEmptyException("iIsEnable不能为空");
        }
        return unitInfoService.setStatus(unitInfoInputDto);
    }

}
