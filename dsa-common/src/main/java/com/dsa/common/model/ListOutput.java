package com.dsa.common.model;

import com.dsa.common.utils.Page;


/**
 * @author GUOJIKANG
 * @Title:
 * @ClassName ListOutput
 * @Description: TODO
 * @date 2019/5/27  17:05
 * @Version 1.0
 */
public class ListOutput<T> {
    private Page page;
    private T lists;

    public ListOutput() {

    }

    public ListOutput(Page page, T lists) {
        this.page = page;
        this.lists = lists;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }


    public T getLists() {
        return lists;
    }

    public void setLists(T lists) {
        this.lists = lists;
    }
}
