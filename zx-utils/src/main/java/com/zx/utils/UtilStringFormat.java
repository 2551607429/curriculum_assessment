package com.zx.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilStringFormat {

    public UtilStringFormat() {
    }

    /**
     * 判断字符串是否为空，或者null如果是则返回true，否则返回false
     * @param str
     * @return
     */
    public static boolean isStringNull(String str) {
	if (null == str || str.trim().length() <= 0||"null".equals(str)) {

	    return true;
	}
	return false;
    }

    /**
     * 按字实际占用字符数来统计字符长度
     * @param str
     * @return
     */
    public static int ansiLength(String str) {
	if (isStringNull(str)) {
	    return 0;
	}
	byte[] bs;
	try {
	    bs = str.getBytes("ISO-8859-1");
	    return bs.length;
	} catch (UnsupportedEncodingException e) {
	    //e.printStackTrace();
	    return -1;
	}
    }

	/**
	 * 格式化成ajax字符串
	 * @param str
	 * @return
     */
    public static String formatAjax(String str) {
	if (str == null)
	    return "";
	else
	    return str.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
		    .replaceAll("&nbsp;", "&#160;");
    }

	/**
	 * 删除特殊字符
	 * @param context
	 * @return
     */
    public static String delIPun(String context) {
	return delIPun(context,
		"[.,\"\\?!:'@#$%^&*()-+=_|;<>?/~`～｀！＠＃￥％……＆×（）——＋－＝｜｝｛＂：？＜＞＼］［＇；／．，]");
    }

	/**
	 * 将指定内容中的指定字符删除
	 * @param context
	 * @param ipun
     * @return
     */
    public static String delIPun(String context, String ipun) {
	Pattern p = Pattern.compile(ipun);//增加对应的标点
	Matcher m = p.matcher(context);
	return m.replaceAll(" ");
    }

    public static String sql(String sql) {
		return sql(sql,false);
    }

	public static String deleteSQL(String sql) {
		if(isStringNull(sql)){
			return null;
		}
		return sql.replaceAll("'","");
	}

	public static String sql(String sql,boolean isnull) {
		if(isStringNull(sql)){
			if(isnull){
				return "''";
			}
			return null;
		}
		return "'"+sql.replaceAll("'","")+"'";
	}

	public static String[] sql(String[] sql) {
    	if(null==sql||sql.length<=0){
    		return null;
		}
		String[] tmp=new String[sql.length];
		for(int i=0;i<sql.length;i++){
			tmp[i]="'"+sql[i]+"'";
		}
		return tmp;
	}
}