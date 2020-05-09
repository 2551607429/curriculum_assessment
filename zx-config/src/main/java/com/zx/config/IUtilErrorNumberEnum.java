package com.zx.config;

/**
 * Created by fxm on 2016/4/6.
 */
public interface IUtilErrorNumberEnum {

    /**
     * 获取错误描述
     * @return
     */
    public String getMsg();

    /**
     * 获取错误编号
     * @return
     */
    public int getErrorId();

    /**
     * 获取国际化代码
     * @return
     */
    public String getLocale();
}
