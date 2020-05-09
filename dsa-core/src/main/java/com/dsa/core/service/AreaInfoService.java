package com.dsa.core.service;

import com.dsa.common.enums.ResponseBean;
import com.dsa.core.dto.AreaInfoInputDto;
import com.dsa.core.dto.AreaInfoQueryDto;

import java.util.List;

/**
 * @author GUOJIKANG
 * @Title: 区域管理业务逻辑接口层
 * @ClassName AreaInfoService
 * @Description: TODO
 * @date 2019/5/28  15:08
 * @Version 1.0
 */
public interface AreaInfoService {
    /**
     * 查询区域列表
     *
     * @param areaInfoQueryDto
     * @return
     */
    ResponseBean findAreaInfo(AreaInfoQueryDto areaInfoQueryDto);


    /**
     * 新增区域
     *
     * @param
     * @return
     */
    ResponseBean insertAreaInfo(AreaInfoInputDto areaInfoInputDto);

    /**
     * 修改区域
     *
     * @param areaInfoInputDto
     * @return
     */
    ResponseBean updateAreaInfo(AreaInfoInputDto areaInfoInputDto);

    /**
     * 删除区域
     *
     * @param areaInfoInputDtoList
     * @return
     */
    ResponseBean deleteAreaInfo(List<AreaInfoInputDto> areaInfoInputDtoList);

}
