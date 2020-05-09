package com.zx.utils;

/**
 * Class Name:
 * Author:ZX
 * Date:2020-02-16
 * Time:00:16
 * ----------------------------------
 * Version:1.0
 * Description:
 * <p>
 * Remarks:
 */
public class UtilLong {

    public static Long parseLong(Object obj){
        if(obj instanceof Long){
            return (Long)obj;
        }else if(obj instanceof Integer){
            return ((Integer)obj).longValue();
        }else if(obj instanceof Short){
            return ((Short)obj).longValue();
        }else{
            try{
                return Long.parseLong(String.valueOf(obj));
            }catch (Exception e){
                return null;
            }
        }
    }
}
