package com.zx.utils;

import java.math.BigInteger;

/**
 * Class Name:
 * Author:akira
 * Date:2017-02-15
 * Time:23:55
 * ----------------------------------
 * Version:1.0
 * Description:
 * <p>
 * Remarks:
 */
public class UtilInteger {

    public static Integer parseInt(Object obj){
        if(obj instanceof Integer){
            return (Integer)obj;
        }else if(obj instanceof Long){
            return ((Long)obj).intValue();
        }else if(obj instanceof BigInteger){
            return ((BigInteger)obj).intValue();
        }else if(obj instanceof Short){
            return ((Short)obj).intValue();
        }else{
            try{
                return Integer.parseInt(String.valueOf(obj));
            }catch (Exception e){
                return null;
            }
        }
    }

}
