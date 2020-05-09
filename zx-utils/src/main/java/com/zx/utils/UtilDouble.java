package com.zx.utils;

import java.math.BigInteger;

/**
 * Class Name:
 * Author:akira
 * Date:2017-02-20
 * Time:13:21
 * ----------------------------------
 * Version:1.0
 * Description:
 * <p>
 * Remarks:
 */
public class UtilDouble {

    public static Double parseDouble(Object obj){
        if(obj instanceof Double){
            return (Double)obj;
        }else if(obj instanceof Integer){
            return ((Integer)obj).doubleValue();
        }else if(obj instanceof Long){
            return ((Long)obj).doubleValue();
        }else if(obj instanceof BigInteger){
            return ((BigInteger)obj).doubleValue();
        }else if(obj instanceof Short){
            return ((Short)obj).doubleValue();
        }else{
            try{
                return Double.parseDouble(String.valueOf(obj));
            }catch (Exception e){
                return null;
            }
        }
    }
}
