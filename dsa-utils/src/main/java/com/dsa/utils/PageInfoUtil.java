package com.dsa.utils;

import com.dsa.common.utils.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author GUOJIKANG
 * @Title: 自动转换Page类型
 * @ClassName PageInfoUtil
 * @Description: TODO
 * @date 2019/5/22  14:50
 * @Version 1.0
 */
public class PageInfoUtil {


    public PageInfoUtil() {

    }

    /**
     * pageInfo转换成Page
     *
     * @param pageInfo
     * @return
     */
    public static Page getPage(PageInfo pageInfo) {
        Page page = new Page();
        page.setTotalNum((int) pageInfo.getTotal());
        page.setPageSize(pageInfo.getPageSize());
        page.setCurrentPage(pageInfo.getPageNum());
        page.setTotalPage(pageInfo.getPages());
        return page;
    }
}
