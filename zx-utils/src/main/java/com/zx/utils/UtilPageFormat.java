package com.zx.utils;

import com.zx.config.ErrorNumberSystem;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fxm on 2016/4/13.
 */
public class UtilPageFormat {

    /**
     * 当前页数
     */
    public static final String KEY_PAGE="page";

    /**
     * 分页数据
     */
    public static final String KEY_LIST_OBJECT="list";

    /**
     * 共有多少页
     */
    public static final String KEY_PAGE_COUNT="page_count";

    /**
     * 共有多少条数据
     */
    public static final String KEY_COUNT="count";


    public enum PAGE_SIZE{
        PAGE_10_SIZE(10),PAGE_15_SIZE(15),PAGE_20_SIZE(20),PAGE_30_SIZE(30),PAGE_40_SIZE(40),PAGE_50_SIZE(50);

        private Integer page;

        PAGE_SIZE(int page){
            this.page=page;
        }

        public Integer getPage(){
            return this.page;
        }
    }

    public static Integer startSize(int page,PAGE_SIZE page_size){
        return startSize(page,page_size.getPage());
    }

    public static Integer startSize(int page,Integer page_size){
        return (page-1)*page_size;
    }

    public static Integer endSize(int page,PAGE_SIZE page_size){
        return page*page_size.getPage();
    }

    /**
     * 处理分页数据格式
     * @param list
     * @param page
     * @param count
     * @param page_count
     * @return
     */
    public static Map<String,Object> parsePage(List<?> list,Integer page,Integer count,Integer page_count, HttpServletRequest request){
        Map<String,Object> m=new HashMap<String,Object>();
        m.put(KEY_PAGE,page);
        m.put(KEY_LIST_OBJECT,list);
        m.put(KEY_COUNT,count);
        m.put(KEY_PAGE_COUNT,page_count);

        if(null!=request) {
            return UtilErrorNumber.loadError(ErrorNumberSystem.ERROR_ENUM.SUCCESS, m,request);
        }else {
            return UtilErrorNumber.loadError(ErrorNumberSystem.ERROR_ENUM.SUCCESS, m);
        }
    }

    public static Map<String,Object> parsePage(List<?> list,Integer page,Long count,Integer page_count, HttpServletRequest request){
        Map<String,Object> m=new HashMap<String,Object>();
        m.put(KEY_PAGE,page);
        m.put(KEY_LIST_OBJECT,list);
        m.put(KEY_COUNT,count);
        m.put(KEY_PAGE_COUNT,page_count);

        if(null!=request) {
            return UtilErrorNumber.loadError(ErrorNumberSystem.ERROR_ENUM.SUCCESS, m,request);
        }else {
            return UtilErrorNumber.loadError(ErrorNumberSystem.ERROR_ENUM.SUCCESS, m);
        }
    }

    public static Map<String,Object> parsePage(List<?> list,Integer page,Integer count,Integer page_size){
        int page_count=0;
        int tpcount=page_size;
        if(count%tpcount==0){
            page_count=count/tpcount;
        }else{
            page_count=count/tpcount+1;
        }
        if(page_count<=0){page_count=1;}

        return parsePage(list,page,count,page_count,null);
    }

    public static Map<String,Object> parsePage(List<?> list,Integer page,Long count,Integer page_size){
        int page_count=0;
        Integer tpcount=page_size;
        if(count%tpcount==0){
            page_count= UtilInteger.parseInt(count/tpcount);
        }else{
            page_count= UtilInteger.parseInt(count/tpcount)+1;
        }
        if(page_count<=0){page_count=1;}

        return parsePage(list,page,count,page_count,null);
    }


    public static Map<String,Object> parsePage(List<?> list,Integer page,Integer count,PAGE_SIZE page_size){
        return parsePage(list,page,count,page_size.getPage());
    }

    public static Map<String,Object> parsePage(List<?> list, Integer page, Integer count, PAGE_SIZE page_size, HttpServletRequest request){
        int page_count=0;
        int tpcount=page_size.getPage();
        if(count%tpcount==0){
            page_count=count/tpcount;
        }else{
            page_count=count/tpcount+1;
        }

        return parsePage(list,page,count,page_count,request);
    }
}
