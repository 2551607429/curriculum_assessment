package com.zx.utils;

import java.math.BigInteger;

/**
 * Class Name:
 * Author:akira
 * Date:2017-02-20
 * Time:13:08
 * ----------------------------------
 * Version:1.0
 * Description:
 * <p>
 * Remarks:
 */
public class UtilShort {

    public static Short parseShort(Object obj){
        if(obj instanceof Short){
            return (Short)obj;
        }else if(obj instanceof Integer){
            return ((Integer)obj).shortValue();
        }else if(obj instanceof Long){
            return ((Long)obj).shortValue();
        }else if(obj instanceof BigInteger){
            return ((BigInteger)obj).shortValue();
        }else if(obj instanceof Short){
            return ((Short)obj).shortValue();
        }else{
            try{
                return Short.parseShort(String.valueOf(obj));
            }catch (Exception e){
                return null;
            }
        }
    }
}
