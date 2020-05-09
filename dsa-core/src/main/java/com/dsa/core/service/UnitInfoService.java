package com.dsa.core.service;

import com.dsa.common.enums.ResponseBean;
import com.dsa.core.dto.UnitInfoInputDto;

/**
 * @author GUOJIKANG
 * @Title: 管理单元业务逻辑接口类
 * @ClassName UnitInfoService
 * @Description: TODO
 * @date 2019/5/25  14:17
 * @Version 1.0
 */
public interface UnitInfoService {
    /**
     * 设置状态 是否启用
     * @param unitInfoInputDto
     * @return
     */
    ResponseBean setStatus(UnitInfoInputDto unitInfoInputDto);

}
