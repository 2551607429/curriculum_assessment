package com.zx.utils;

import java.math.BigInteger;

/**
 * Class Name:
 * Author:akira
 * Date:2017-02-20
 * Time:09:37
 * ----------------------------------
 * Version:1.0
 * Description:
 * <p>
 * Remarks:
 */
public class UtilFloat {

    public static Float parseFloat(Object obj){
        if(obj instanceof Float){
            return (Float)obj;
        }else if(obj instanceof Integer){
            return ((Integer)obj).floatValue();
        }else if(obj instanceof Long){
            return ((Long)obj).floatValue();
        }else if(obj instanceof BigInteger){
            return ((BigInteger)obj).floatValue();
        }else if(obj instanceof Short){
            return ((Short)obj).floatValue();
        }else{
            try{
                return Float.parseFloat(String.valueOf(obj));
            }catch (Exception e){
                return null;
            }
        }
    }
}
