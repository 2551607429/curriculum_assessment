package com.zx.utils;

/**
 * Class Name:
 * Author:ZX
 * Date:2017-02-20
 * Time:12:54
 * ----------------------------------
 * Version:1.0
 * Description:
 * <p>
 * Remarks:
 */
public class UtilString {

    public static String parseString(Object obj){
        if(obj instanceof String){
            return (String)obj;
        }else{
            try{
                return String.valueOf(obj);
            }catch (Exception e){
                return null;
            }
        }
    }
}
