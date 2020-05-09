package com.zx.utils;

import com.alibaba.fastjson.JSONObject;
import com.zx.config.ErrorNumberSystem;
import com.zx.config.IUtilErrorNumberEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fxm on 2016/4/6.
 */
public abstract class UtilErrorNumber {


    public static Map<String, Object> loadError(IUtilErrorNumberEnum error_enum) {
        return loadErrorExe(error_enum, null,null,null,null);
    }

    public static Map<String, Object> loadError(IUtilErrorNumberEnum error_enum,String key,Object value) {
        return loadErrorExe(error_enum, null,null,key,value);
    }

    public static Map<String, Object> loadError(IUtilErrorNumberEnum error_enum, HttpServletRequest request) {
        return loadErrorExe(error_enum, null,request,null,null);
    }


    public static Map<String, Object> loadError(IUtilErrorNumberEnum error_enum,Map<String, Object> m_err) {
        return loadErrorExe(error_enum, m_err,null,null,null);
    }

    public static Map<String, Object> loadError(IUtilErrorNumberEnum error_enum, Map<String, Object> m_err, HttpServletRequest request) {
        return loadErrorExe(error_enum,m_err,request,null,null);
    }

    private static Map<String, Object> loadErrorExe(IUtilErrorNumberEnum error_enum, Map<String, Object> m_err, HttpServletRequest request, String key, Object value) {
        if (null == m_err) {
            m_err = new HashMap<String, Object>();
        }
        m_err.put("key", error_enum.getErrorId());

        if(UtilStringFormat.isStringNull(error_enum.getLocale())) {
            m_err.put("msg", error_enum.getMsg());
        }else{
            m_err.put("msg",error_enum.getMsg());
            /*if(null==request){
                // m_err.put("msg",UtilContextLocale.getApplicationContext().getMessage(error_enum.getLocale(), null, null));
                m_err.put("msg",error_enum.getMsg());
            }else {
                //从后台代码获取国际化信息
                RequestContext requestContext = new RequestContext(request);
                m_err.put("msg", requestContext.getMessage(error_enum.getLocale()));
            }*/
        }

        if(null!=key){
            m_err.put(key,value);
        }
        return m_err;
    }

    /**
     * 判断是否执行成功,执行成功返回true
     *
     * @param m_err
     * @return
     */
    public static boolean checkError(Map<String, Object> m_err) {
        if (null == m_err) {
            return false;
        }
        try {
            int keyid = UtilInteger.parseInt( m_err.get("key"));
            if (ErrorNumberSystem.ERROR_ENUM.SUCCESS.getErrorId() == keyid) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkError(Map<String, Object> m_err, IUtilErrorNumberEnum ee) {
        if (null == m_err || null == ee) {
            return false;
        }
        try {
            int keyid = UtilInteger.parseInt( m_err.get("key"));
            if (ee.getErrorId() == keyid) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void parseErrorJSON(HttpServletResponse response, IUtilErrorNumberEnum ene) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        json.put("key",ene.getErrorId());
        json.put("msg",ene.getMsg());
        out.write(json.toString());
        out.close();
    }
}
