package com.dsa.sys.service;

import com.dsa.common.enums.ResponseBean;
import com.dsa.sys.dto.DevTypeDto;

public interface DevFunctionService {
    /**
     * 批量更改设备功能
     * @return
     */
    ResponseBean modifyDevFunction(DevTypeDto devTypeDto);
}
