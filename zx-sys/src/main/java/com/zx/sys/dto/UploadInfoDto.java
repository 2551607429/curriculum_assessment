package com.zx.sys.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName UploadInfoDto
 * @Description 批量上传数据信息
 * @Author ZX
 * @Date 2020/4/28 22:34
 */
@Data
public class UploadInfoDto {

    /**
     * successCount:成功上传数量
     */
    private Integer successCount;

    /**
     * allCount:全部上传数量
     */
    private Integer allCount;

    /**
     * failCount:失败上传数量
     */
    private Integer failCount;

    /**
     * responseList:成功上传列表
     */
    private List<Object> responseList;

}
