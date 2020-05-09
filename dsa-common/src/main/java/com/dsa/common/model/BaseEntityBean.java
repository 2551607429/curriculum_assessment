package com.dsa.common.model;

import lombok.Data;

/**
 * 项目名称：dsa5200
 * 类名称：BaseEntityBean
 * 创建人：fanhaiyang 范海洋
 * 创建时间：2019/5/22 14:24
 */
@Data
public class BaseEntityBean {
    private Integer currentPage = 1;

    private Integer pageSize = 10;
}
