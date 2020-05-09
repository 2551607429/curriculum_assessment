package com.zx.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Class Name:
 * Author:akira
 * Date:2017-02-17
 * Time:16:24
 * ----------------------------------
 * Version:1.0
 * Description:
 * <p>
 * Remarks:
 */
public class UtilBigDecimal {

    public static BigDecimal parseBigDecimal(Object obj){
        if(obj instanceof BigDecimal){
            return (BigDecimal)obj;
        }else if(obj instanceof Integer){
            return new BigDecimal((Integer)obj);
        }else if(obj instanceof Float){
            return new BigDecimal((Float)obj);
        }else if(obj instanceof Double){
            return new BigDecimal((Double)obj);
        }else if(obj instanceof Long){
            return new BigDecimal((Long)obj);
        }else if(obj instanceof BigInteger){
            return new BigDecimal((BigInteger)obj);
        }else if(obj instanceof Short){
            return new BigDecimal((Short)obj);
        }else{
            try{
                return new BigDecimal(String.valueOf(obj));
            }catch (Exception e){
                return null;
            }
        }
    }
}
