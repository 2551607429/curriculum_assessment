package com.dsa.utils;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Clob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DealString {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(DealString.class);
	private final static String[] hex = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D", "5E", "5F", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E", "7F", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8A", "8B", "8C", "8D", "8E", "8F", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F", "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", "AC", "AD", "AE", "AF", "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF", "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF", "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC", "ED", "EE", "EF", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF"};
    private final static byte[]   val = { 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F };

	
    /**将字符串倒序  */
    public static String toStringByReverse(String allstr) {
    	StringBuffer sBuffer=new StringBuffer();
    	sBuffer.append(allstr);
    	sBuffer.reverse();
		return sBuffer.toString();
	}
    
    /** 把字符串转换为数组，allstr以","间隔 */
	public static String[] getAnyone(String allstr) {
		if (allstr == null || "".equals(allstr)) {
			return null;
		}
        String[] anyone = null;
		try {
				anyone = allstr.split(",");
			} catch (Exception ex) {
				return null;
			}
		return anyone;
	}
    
    /** 
     * 把字符串转换为数组(去除空值以及非数值型参数判断)
     * allstr以","间隔 
     * @param type  1:数值(去除非数值型参数)   2字符串((去除空值)
     * */
	public static String[] getAnyZeroWithTrim(String allstr,int type) {		
		if (allstr == null || "".equals(allstr)) {
			return null;
		}
        String[] anyone = null;
		try {
				String[] strs = allstr.split(",");				
				if(strs!=null&&strs.length>0){
					ArrayList<String> list=new ArrayList<String>();
					 for(String str:strs){
						 if(type==1){
							 str=DealString.toStringCheckLong(str,-100);
							 if(!"-100".equals(str)){
								 list.add(str); 
							 }
						 }else{
							 str=DealString.toString(str);
							 if(str.length()>0){
								 list.add(str); 							 
							 }	
						 }						 					 
					 }
					 if(list!=null&&list.size()>0){
						 anyone= list.toArray(new String[list.size()]);
					 }
				}
			} catch (Exception ex) {
				return null;
			}
		return anyone;
	}	
	
	/** 把list转换为 "," 间隔的字符串(可用于sql in)
	 * @param type  1:数值   2字符串
	 *  */
	public static String listToString(List<?> list,int type){
        if (list==null) {
            return null;
        }
        StringBuilder result=new StringBuilder();
        boolean flag=false;
        for (Object obj : list) {
            if (flag) {
                result.append(",");
            }else {
                flag=true;
            }
            if(type==2)
            	 result.append("'"+obj.toString()+"'");
            else
                 result.append(obj.toString());
        }
        return result.toString();
    }
	
	
	
	/** 把list转换为list,限定大小拆分(可用于sql in)
	 *  list 值为 "," 间隔的字符串
	 * @param type  1:数值   2字符串
	 * @param MaxNum 间隔大小
	 *  */
	public static List<String> listToStringForList(List<?> list,int type,int MaxNum){
        if (list==null||list.size()<=0) {
            return new ArrayList<String>();
        }
        boolean flag=false;
        StringBuilder result=new StringBuilder();
        List<String> rList=new ArrayList<String>();
        for (int i=0;i<list.size();i++) {
        	Object obj = list.get(i);
            if (flag) {
                result.append(",");
            }else {
                flag=true;
            }
            if(type==2)
            	 result.append("'"+obj.toString()+"'");
            else
                 result.append(obj.toString());
            if((i+1)%MaxNum==0||(i==list.size()-1)){
            	rList.add(result.toString());
            	result=new StringBuilder(); 
            	flag=false;
            }
        }
        return rList;
    }
	
	/** 把字符串转换为数组，以"" */
	public static  String[] getAnytwo(String allstr) {
		//log.info("getAnytwo(),原字符串:"+allstr);
		int j = 0;
		if (allstr == null || "".equals(allstr)) {
			return null;
		}
		j = allstr.length();
		if(j>0){
            String[] anyone = new String[j];
		  for (int i = 0; i < j; i++) {
			anyone[i]=allstr.substring(i,i+1);			
		  }
		 return anyone;
		}else return null;
	}
	
	/** 
	 * 把字符串转换为字符串(去除空值以及非数值型参数判断)(可用于sql in)     
     * allstr以","间隔 
     * @param type  1:数值(去除非数值型参数)   2字符串((去除空值)
     * */
	public static String strToStr(String allstr,int type){
		String resultStr="";
		String[] strs=getAnyZeroWithTrim(allstr,type);		
        StringBuilder result=new StringBuilder();
        boolean flag=false;
        if(strs!=null&&strs.length>0){
        for (String obj : strs) {
            if (flag) {
                result.append(",");
            }else {
                flag=true;
            }            
            if(type==2)
            	 result.append("'"+obj+"'");
            else
                 result.append(obj);
         }
          resultStr=result.toString();
        }
        logger.info("DealString.strToStr--------------param[allstr:"+allstr+"     type:"+type+"],return["+resultStr+"]");
        return resultStr;
    }
	
	
	/** 把字符串转换为数组，以"*" */
	public static String[] getXing1(String allstr) {
		int j = 0;
		if (allstr == null || "".equals(allstr)) {
			return null;
		}
		j = allstr.length();
        String[] anyone = null;
		for (int i = 0; i < j; i++) {
			try {
				anyone = allstr.split("[*]");
				// System.out.println(anyone[i]);
			} catch (ArrayIndexOutOfBoundsException ex) {}
		}
		
	return anyone;
	}

	/** 把字符串转换为数组，以"●" */
	public static String[] getOne(String allstr) {
		int j = allstr.length();
        String[] anyone = null;
		for (int i = 0; i < j; i++) {
			try {
				anyone = allstr.split("●");
			} catch (ArrayIndexOutOfBoundsException ex) {

			}
		}
		return anyone;
	}

	/** 把字符串转换为数组，以"★" */
	public static String[] getXing(String allstr) {
		int j = allstr.length();
        String[] anyone = null;
		for (int i = 0; i < j; i++) {
			try {
				anyone = allstr.split("★");
			} catch (ArrayIndexOutOfBoundsException ex) {

			}
		}
		return anyone;
	}
	/** 把字符串转换为数组，以"-" */
	public static String[] getHeng(String allstr) {
		int j = allstr.length();
        String[] anyone = null;
		for (int i = 0; i < j; i++) {
			try {
				anyone = allstr.split("-");
			} catch (ArrayIndexOutOfBoundsException ex) {

			}
		}
		return anyone;
	}
	/** 判断前者是否包含在后者中
	 *  有 返回true
	 * */
	public static boolean toStrIsHave(String str,String strs) {
		str=toString(str);
		strs=toString(strs);
		str=str.toUpperCase();
		strs=strs.toUpperCase();
        return strs.indexOf(str) != -1;
	}
    
	/** 字符串去除样式*/
	public static String replaceValue(String value) {
		//System.out.println("1:"+value);
		value=value.replaceAll("<[^<|^>]*>","");	
		//System.out.println("2"+value);
		return value;	
	}
	/** 字符串去除html标签*/
	public static String getTxtWithoutHTMLElement(String element) {

		if (null == element || "".equals(element.trim())) {
			return element;
		}
		Pattern pattern = Pattern.compile("< [^< |^>]*>");
		Matcher matcher = pattern.matcher(element);
		StringBuffer txt = new StringBuffer();
		while (matcher.find()) {
			String group = matcher.group();
			if (group.matches("< [\\s]*>")) {
				matcher.appendReplacement(txt, group);
			} else {
				matcher.appendReplacement(txt, "");
			}
		}
		matcher.appendTail(txt);
		repaceEntities(txt, "&amp;", "&");
		repaceEntities(txt, "&lt;", "<");
		repaceEntities(txt, "&gt;", ">");
		repaceEntities(txt, "&quot;", "\"");
		repaceEntities(txt, "&nbsp;", "");
		return txt.toString();
	}
	private static void repaceEntities(StringBuffer txt, String entity,
			String replace) {
		int pos = -1;
		while (-1 != (pos = txt.indexOf(entity))) {
			txt.replace(pos, pos + entity.length(), replace);
		}
	}
	public static String getDateTime() {
		SimpleDateFormat f = new SimpleDateFormat(
				"yyyyMMddHHmmss");
		String time = f.format(new Date());
		return time;
	}

	/** 把数组转换为字符串 */
	public static String getAllstr(String[] anyone) {
		String str = "";
		if (anyone == null) {
			return str;
		}
		int j = anyone.length;

		for (int i = 0; i < j - 1; i++) {
			str = str + anyone[i] + ",";
		}
		str = str + anyone[j - 1];
		return str;
	}

	/** 把null转化为" " */
	public static String toString(String str) {
		if (str == null)
			str = "";
		if (str.equals("null"))
			str = "";
		str = str.trim();
		return str;
	}
	/** 把null转化为" ",判断非法参数 */
	public static String toStringCheckString(String str) {
		if (str == null)
			str = "";
		if (str.equals("null"))
			str = "";
		str = str.trim();
		str=sql_inj_replaceall(str);
		return str;
	}
	/** 把null转化为" ",判断long型参数,默认值 */
	public static String toStringCheckLong(String str,long s) {
		if (str == null)
			str = "";
		if (str.equals("null"))
			str = "";
		str = str.trim();
		try {
			str=Long.parseLong(str)+"";
		} catch (Exception e) {
			str=s+"";
		}
		return str;
	}

	/** 把null转化为" ",判断int型参数，默认值 */
	public static String toStringCheckInt(String str,int s) {
		if (str == null)
			str = "";
		if (str.equals("null"))
			str = "";
		str = str.trim();
		try {
			str=Integer.parseInt(str)+"";
		} catch (Exception e) {
			str=s+"";
		}
		return str;
	}

	/** 把文本域中的换行符替换为html标签 */
	public static String toStringForTextArea(String value){
		if(value==null||"".equals(value))
			return "";
		String v = "";
	    v=value.replaceAll("\"","“");
	    v=value.replaceAll("\'","‘");
	    v=value.replaceAll("<","〈");
	    v=value.replaceAll(">","〉");
	    v=sql_inj_replaceall(v);
		return v;
	}

	/** 转换编码 中文处理 */
	public static String toGBK(String str) {
		try {
			if (str == null)
				str = "";
			else
				str = new String(str.getBytes(StandardCharsets.ISO_8859_1), "GBK");
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger
						.debug("toGBK(String) - DealString::toGBK(String)运行时出错：错误为："
								+ e.getMessage());
			}
		}
		return str;
	}

	/**
	 * 根据系统时间 生成10位 到秒 时间戳(1552102984)
	 * @return
	 */
	public static String getCurrentTime10() {
		return System.currentTimeMillis()/1000+"";
	}

	/**
	 * 根据系统时间 生成13位 到毫秒秒 时间戳(1552102984000)
	 * @return
	 */
	public static String getCurrentTime13() {
		return System.currentTimeMillis()+"";
	}

	/** 转换字符串为时间 格式2007-5 */
	public static String dateTostr(Date date,String format) {
		if(date==null){
			return "";
		}
		try {
			SimpleDateFormat sdf2 = new SimpleDateFormat(format);
			String newstr = sdf2.format(date);
			return newstr;
		}catch (Exception e){
			logger.error("dateTostr(date,format)", e);
			return "";
		}
	}

	/** 转换字符串时间格式为指定格式件,  sourFormat 原格式,objFormat 目标格式*/
	public static String strTotime0(String str,String sourFormat,String objFormat) {
		if("".equals(str)||str==null)
		{
			return "";
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat(sourFormat);
		Date date = null;
		try {
			date = sdf1.parse(str);
		} catch (ParseException e) {
			logger.error("strTotimeone(String)", e);
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat(objFormat);
		String newstr = sdf2.format(date);
		return newstr;

	}

	/** 转换字符串为时间 格式2007-5 */
	public static String strTotime(String str) {
		if("".equals(str)||str==null)
		{
			return "";
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat(
				"yyyy-M");
		Date date = null;
		try {
			date = sdf1.parse(str);
		} catch (ParseException e) {
			logger.error("strTotime(String)", e);
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-M");
		String newstr = sdf2.format(date);
		return newstr;

	}
	/** 转换字符串为时间 格式2007-5-30 */
	public static String strTotimeone(String str) {
		if("".equals(str)||str==null)
		{
			return "";
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat(
				"yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf1.parse(str);
		} catch (ParseException e) {
			logger.error("strTotimeone(String)", e);
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String newstr = sdf2.format(date);
		return newstr;

	}
	/** 格式化时间 格式2007-5-30 2:30 */
	public static String strTotimethree(String str) {
		if("".equals(str)||str==null)
		{
			return "";
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			date = sdf1.parse(str);
		} catch (ParseException e) {
			logger.error("strTotimeone(String)", e);
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String newstr = sdf2.format(date);
		return newstr;

	}

	/** 转换字符串为时间 格式2007-05-30 01:30:20 */
	public static String strTotimetwo(String str) {
		if("".equals(str)||str==null)
		{
			return "";
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf1.parse(str);
		} catch (ParseException e) {
			logger.error("strTotimetwo(String)", e);
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String newstr = sdf2.format(date);
		return newstr;

	}
	/** 取系统当前时间 格式2007-05-30 01:30:44 */
	public static Date getDateTimetwoDate(String str) {
		//注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
		 SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  //必须捕获异常try
		 Date date=null;
		 try {
			 date=simpleDateFormat.parse(str);
		  // System.out.println(date);
		  }
		  catch(ParseException px)
		  {
		   px.printStackTrace();
		  }
        return date;
	}
	/** 取系统当前时间 格式2007-05-30 01:30:44.345 */
	public static Date getDateTimethreeDate(String str) {
		//注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
		 SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		  //必须捕获异常try
		 Date date=null;
		 try {
			 date=simpleDateFormat.parse(str);
		  // System.out.println(date);
		  }
		  catch(ParseException px)
		  {
		   px.printStackTrace();
		  }
        return date;
	}

	/** 取系统当前时间 格式2007-05-30 */
	public static Date getDateTimeDate() {
		//注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
		 SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		  //必须捕获异常try
		 Date date=null;
		 String str=getDateTimeone();
		 try {
			 date=simpleDateFormat.parse(str);
		   //System.out.println(date);
		  }
		  catch(ParseException px)
		  {
		   px.printStackTrace();
		  }
       return date;
	}

	/** 取系统当前时间 格式2007-05-30 01:30:44 */
	public static Date getDateTimetwoDate() {
		//注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
		 SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  //必须捕获异常try
		 Date date=null;
		 String str=getDateTimetwo();
		 try {
			 date=simpleDateFormat.parse(str);
		  // System.out.println(date);
		  }
		  catch(ParseException px)
		  {
		   px.printStackTrace();
		  }
        return date;
	}
	/** 取系统当前时间 格式2007-05-30 01:30:44.345 */
	public static Date getDateTimethreeDate() {
		//注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
		 SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		  //必须捕获异常try
		 Date date=null;
		 String str=getDateTimeThree();
		 try {
			 date=simpleDateFormat.parse(str);
		  // System.out.println(date);
		  }
		  catch(ParseException px)
		  {
		   px.printStackTrace();
		  }
        return date;
	}

	/** 取系统当前时间 格式2007-05-30 */
	public static Date getDateTimeDate(String str) {
		//注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
		 SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		  //必须捕获异常try
		 Date date=null;
		 try {
			 date=simpleDateFormat.parse(str);
		   //System.out.println(date);
		  }
		  catch(ParseException px)
		  {
		   px.printStackTrace();
		  }
       return date;
	}

	/** 取系统当前时间 格式2007-05 */
	public static String getDateTimeFour() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
		String time = f.format(new Date());
		return time;
	}
	/** 取得系统当前时间编号 精确到毫秒 */
	public static String getDateTime0() {
		SimpleDateFormat f = new SimpleDateFormat(
				"yyyyMMddHHmmssSSS");
		String time = f.format(new Date());
		return time;
	}

	/** 取系统当前日期 格式2007-5-30 */
	public static String getDateTimeone() {
		SimpleDateFormat f = new SimpleDateFormat(
				"yyyy-MM-dd");
		String time = f.format(new Date());
		return time;
	}
	/** 取系统当前日期 格式2007 */
	public static String getDateyyyy() {
		SimpleDateFormat f = new SimpleDateFormat(
				"yyyy");
		String time = f.format(new Date());
		return time;
	}
	/** 取系统当前日期 格式1 */
	public static String getDatemm() {
		SimpleDateFormat f = new SimpleDateFormat(
				"M");
		String time = f.format(new Date());
		return time;
	}
	/** 取系统当前时间 格式2007-05-30 01:30:44 */
	public static String getDateTimetwo() {
		SimpleDateFormat f = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String time = f.format(new Date());
		return time;
	}
	/** 取系统当前时间 格式2007-05-30 01:30:44.345 */
	public static String getDateTimeThree() {
		SimpleDateFormat f = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS");
		String time = f.format(new Date());
		return time;
	}
	public static String getDateTime3() {
		SimpleDateFormat f = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		String time = f.format(new Date());
		return time;
	}

	/** 取系统当前时间 格式0705 */
	public static String getDateTimebh() {
		SimpleDateFormat f = new SimpleDateFormat("yyMM");
		String time = f.format(new Date());
		return time;
	}

	/** 取系统当前时间 格式20070505 */
	public static String getDateAll() {
		SimpleDateFormat f = new SimpleDateFormat(
				"yyyyMMdd");
		String time = f.format(new Date());
		return time;
	}

	/** 取系统当前时间 格式31(天) */
	public static String getDateTimeDay2() {
		SimpleDateFormat f = new SimpleDateFormat("dd");
		String time = f.format(new Date());
		return time;
	}

	/** 取系统当前时间 格式2007/07/08 14:23:12 */
	public static String getDates() {
		String time = null;
		SimpleDateFormat f = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		time = f.format(new Date());
		return time;
	}

	/** 取系统当前时间 格式2007/07/08*/
	public static String getDates1() {
		String time = null;
		SimpleDateFormat f = new SimpleDateFormat(
				"yyyy/MM/dd");
		time = f.format(new Date());
		return time;
	}

	/** 取系统当前时间 格式2007年07月08日 */
	public static String getNYR() {
		String time = null;
		SimpleDateFormat f = new SimpleDateFormat(
				"yyyy年MM月dd日");
		time = f.format(new Date());
		return time;
	}

	/** 取系统当前时间 格式200705 */
	public static String getDateTimezz() {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMM");
		String time = f.format(new Date());
		return time;
	}

	/** 取系统当前时间 格式070505 */
	public static String getDateTimeDay() {
		SimpleDateFormat f = new SimpleDateFormat("yyMMdd");
		String time = f.format(new Date());
		return time;
	}

	/** 替换字符串 */
	public static String replace(String source, String oldString,
			String newString) {
		StringBuffer output = new StringBuffer();

		int lengthOfSource = source.length(); // 源字符串长度
		int lengthOfOld = oldString.length(); // 老字符串长度
		int posStart = 0; // 开始搜索位置
		int pos; // 搜索到老字符串的位置

		while ((pos = source.indexOf(oldString, posStart)) >= 0) {
			output.append(source, posStart, pos);
			output.append(newString);
			posStart = pos + lengthOfOld;
		}
		if (posStart < lengthOfSource) {
			output.append(source.substring(posStart));
		}
		return output.toString();
	}

	/** 将字符串格式化为固定长度 */
	public static String toLengthStr(String instr, int len) {
		int n = instr.length();
		for (int i = 0; i < (len - n); i++) {
			instr = " " + instr;
		}
		return instr;
	}

	/** 转换为utf8编码 */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes(StandardCharsets.UTF_8);
				} catch (Exception ex) {
					if (logger.isDebugEnabled()) {
						logger.debug("toUtf8String(String) - " + ex);
					}
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}
    /**比较两个日期之差 前者>后者 日期格式yyyy/MM/dd   返回天数*/
	public static long getQuot1(String time1, String time2) { // 比较两个日期之差
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			quot = date1.getTime() - date2.getTime();

			if (logger.isDebugEnabled()) {
				logger.debug("getQuot1(String, String) - q=" + quot);
			}
			quot = quot / 1000 / 60 / 60 / 24;

		} catch (ParseException e) {
			logger.error("getQuot1(String, String)", e);
		}
		return quot;
	}
	/**比较两个日期之差 前者>后者 日期格式yyyy/MM/dd HH:mm:ss   返回小时相差毫秒数*/
	public static long getQuot2(String time1, String time2) { // 比较两个时间之差 精确到秒
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			quot = date1.getTime() - date2.getTime();
			if (logger.isDebugEnabled()) {
				logger.debug("getQuot2(String, String) - 相差秒数:" + quot / 1000);
			}
		} catch (ParseException e) {

			logger.error("getQuot2(String, String)", e);
		}
		return quot;
	}

	/**比较两个日期之差 前者>后者 日期格式yyyy-MM-dd HH:mm   返回小时相差天数*/
	public static long getQuot3(String time1, String time2) { // 比较两个时间之差
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			quot = date1.getTime() - date2.getTime();
			quot = quot / 1000 / 60 / 60 / 24;
			//System.out.println(quot);
		} catch (ParseException e) {
//			if (logger.isEnabledFor(org.apache.log4j.Level.ERROR)) {
//				logger.error("getQuot3(String, String)", e);
//			}
		}
		return quot;
	}
	/**比较两个日期之差 前者>后者 日期格式yyyy-MM-dd  返回小时相差天数*/
	public static long getQuot4(String time1, String time2) { // 比较两个时间之差
		// 精确到天
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			quot = date1.getTime() - date2.getTime();
			quot = quot /(24*60*60*1000);
			//System.out.println(quot);
		} catch (ParseException e) {
//			if (logger.isEnabledFor(org.apache.log4j.Level.ERROR)) {
//				logger.error("getQuot4(String, String)", e);
//			}
		}
		return quot;
	}

	/**比较两个日期之差 前者>后者 日期格式yyyy-MM-dd HH:mm:ss   返回小时相差毫秒数*/
	public static long getQuot5(String time1, String time2) { // 比较两个时间之差 精确到秒
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			quot = date1.getTime() - date2.getTime();
			if (logger.isDebugEnabled()) {
				logger.debug("getQuot2(String, String) - 相差秒数:" + quot / 1000);
			}
		} catch (ParseException e) {

			logger.error("getQuot5(String, String)", e);
		}
		return quot;
	}
	/**
	 * 比较两个时间是不是相等,相等返回0,不相等返回非0的long值
	 */
	public static long getTimeis(String mintime, String maxtime) {
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = ft.parse(maxtime);
			Date date2 = ft.parse(mintime);
			quot = date1.getTime() - date2.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return quot;
	}


	/**
	 *
	 * @param gc1	大时间(被比较)
	 * @param gc2	小时间
	 * @return	返回0表示两个时间相等,返回>0的值表示前参数时间大于后参数时间,返回<0的值表示前参数时间小于后参数时间
	 */
	public static int gettimeis2(String gc1,String  gc2)
	{
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		int i=0;
		try
		{
			Date temp1=ft.parse(gc1);
			Date temp2=ft.parse(gc2);
			Calendar gca=Calendar.getInstance();
			Calendar gcb=Calendar.getInstance();
			gca.setTime(temp1);
			gcb.setTime(temp2);
			i=gca.compareTo(gcb);
		}
		 catch (ParseException e) {
				e.printStackTrace();
			}


		//System.out.println(i);
		return i;

	}

	/**
	 *
	 * @return	返回实际年龄   根据  birthday yyyy-MM
	 */
	public static int getTrueAgeByData(String birthday)
	{
		int i=0;
		birthday=strTotime(birthday);
		String[] str1=birthday.split("-");
		if(str1.length>0){
			try {
				int year=Integer.parseInt(str1[0]);
				int month=Integer.parseInt(str1[1]);
				int now_year=Integer.parseInt(getDateyyyy());
				int now_month=Integer.parseInt(getDatemm());
				if(now_month>=month) i=now_year-year;
				else i=now_year-year-1;
			} catch (Exception e) {
				//System.out.println("Err");
			}
		}
		else i=-1;
		return i;
	}
	/**
	 * 获得给定日期是星期几
	 * @param day
	 *  日期
	 * @return j 0表示错误,返回1-7,1是星期一,7是星期天
	 */
	public static int getweeks(String day) {
		int i = 0; // 返回0表示错误
		int j = 0;
		String tmp = day;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date myDate = sdf.parse(tmp);
			Calendar myCalendar = Calendar.getInstance();
			myCalendar.setTime(myDate);
			i = myCalendar.get(Calendar.DAY_OF_WEEK);
			//System.out.println(i);// 星期日i==1，星期六i==7
			if (i == 1) {
				j = 7;
			}
			if (i == 2) {
				j = 1;
			}
			if (i == 3) {
				j = 2;
			}
			if (i == 4) {
				j = 3;
			}
			if (i == 5) {
				j = 4;
			}
			if (i == 6) {
				j = 5;
			}
			if (i == 7) {
				j = 6;
			}
		} catch (Exception ex) {
			//System.out.println("Err");
		}
		return j;
	}

	/**
	 * 给定日期+上一天
	 *
	 * @param s
	 * @param n
	 * @return
	 * @throws ParseException
	 */
	public static String addDay(String s, int n) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Calendar cd = Calendar.getInstance();
		String temp = null;
		try {

			cd.setTime(sdf.parse(s));
			cd.add(Calendar.DATE, n);
			temp = sdf.format(cd.getTime());
			//System.out.println(temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	/**
	 * 日期相减
	 * @param s
	 * @param n
	 * @return
	 */
	public static String subtractDay(String s,int n)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cd = Calendar.getInstance();
		String temp = null;
		try {
		cd.setTime(sdf.parse(s));
		cd.add(Calendar.DAY_OF_MONTH, n);
		temp = sdf.format(cd.getTime());
		//System.out.print(temp);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}



	/**
	 * 给定时间判断上午还是下午 上午返回0,下午返回1
	 *
	 * @param time1
	 * @return
	 */
	public static int getselectDays(String time1) {
		GregorianCalendar ca = new GregorianCalendar();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date1 = ft.parse(time1);
			ca.setTime(date1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(ca.get(GregorianCalendar.AM_PM));
		return ca.get(GregorianCalendar.AM_PM);
	}

	// 计算日期差的方法(完整版,包括闰年润月等)
	public static int getDays(GregorianCalendar g1, GregorianCalendar g2) {
		int elapsed = 0;
		GregorianCalendar gc1, gc2;
		if (g2.after(g1)) {
			gc2 = (GregorianCalendar) g2.clone();
			gc1 = (GregorianCalendar) g1.clone();
		} else {
			gc2 = (GregorianCalendar) g1.clone();
			gc1 = (GregorianCalendar) g2.clone();
		}
		gc1.clear(Calendar.MILLISECOND);
		gc1.clear(Calendar.SECOND);
		gc1.clear(Calendar.MINUTE);
		gc1.clear(Calendar.HOUR_OF_DAY);
		gc2.clear(Calendar.MILLISECOND);
		gc2.clear(Calendar.SECOND);
		gc2.clear(Calendar.MINUTE);
		gc2.clear(Calendar.HOUR_OF_DAY);
		while (gc1.before(gc2)) {
			gc1.add(Calendar.DATE, 1);
			elapsed++;
		}
		return elapsed;
	}

	// 数字转换成中文 getChinese(2147483648l,0) 数字+l,0
	public static String getChinese(long number, int depth) {
		if (depth < 0)
			depth = 0;
		String chinese = "";
		String src = number + "";
		if (src.charAt(src.length() - 1) == 'l'
				|| src.charAt(src.length() - 1) == 'L') {
			src = src.substring(0, src.length() - 1);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("getChinese(long, int) - " + src);
		}

		if (src.length() > 4)
			chinese = getChinese(Integer.parseInt(src.substring(0,
					src.length() - 4)), depth + 1)
					+ getChinese(Integer.parseInt(src.substring(
							src.length() - 4)), depth - 1);
		else {
			char prv = 0;
			for (int i = 0; i < src.length(); i++) {
				switch (src.charAt(i)) {
				case '0':
					if (prv != '0')
						chinese = chinese + "零";
					break;
				case '1':
					chinese = chinese + "一";
					break;
				case '2':
					chinese = chinese + "二";
					break;
				case '3':
					chinese = chinese + "三";
					break;
				case '4':
					chinese = chinese + "四";
					break;
				case '5':
					chinese = chinese + "五";
					break;
				case '6':
					chinese = chinese + "六";
					break;
				case '7':
					chinese = chinese + "七";
					break;
				case '8':
					chinese = chinese + "八";
					break;
				case '9':
					chinese = chinese + "九";
					break;
				}
				prv = src.charAt(i);

				switch (src.length() - 1 - i) {
				case 1:// 十
					if (prv != '0')
						chinese = chinese + "十";
					break;
				case 2:// 百
					if (prv != '0')
						chinese = chinese + "百";
					break;
				case 3:// 千
					if (prv != '0')
						chinese = chinese + "千";
					break;

				}
			}
		}
		while (chinese.length() > 0
				&& chinese.lastIndexOf("零") == chinese.length() - 1)
			chinese = chinese.substring(0, chinese.length() - 1);
		if (depth == 1)
			chinese += "万";
		if (depth == 2)
			chinese += "亿";

		return chinese;
	}

	/** 把小写数字转换成大写汉字 */
	public static String convertNumberToString(long number, int depth) {
		if (depth < 0)
			depth = 0;
		String chinese = "";
		String src = number + "";
		if (src.charAt(src.length() - 1) == 'l'
				|| src.charAt(src.length() - 1) == 'L') {
			src = src.substring(0, src.length() - 1);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("convertNumberToString(long, int) - " + src);
		}

		if (src.length() > 4)
			chinese = convertNumberToString(Integer.parseInt(src.substring(0,
					src.length() - 4)), depth + 1)
					+ convertNumberToString(Integer.parseInt(src.substring(src
							.length() - 4)), depth - 1);
		else {
			char prv = 0;
			for (int i = 0; i < src.length(); i++) {
				switch (src.charAt(i)) {
				case '0':
					if (prv != '0')
						chinese = chinese + "零";
					break;
				case '1':
					chinese = chinese + "壹";
					break;
				case '2':
					chinese = chinese + "贰";
					break;
				case '3':
					chinese = chinese + "叁";
					break;
				case '4':
					chinese = chinese + "肆";
					break;
				case '5':
					chinese = chinese + "伍";
					break;
				case '6':
					chinese = chinese + "陆";
					break;
				case '7':
					chinese = chinese + "柒";
					break;
				case '8':
					chinese = chinese + "捌";
					break;
				case '9':
					chinese = chinese + "玖";
					break;
				}
				prv = src.charAt(i);

				switch (src.length() - 1 - i) {
				case 1:// 十
					if (prv != '0')
						chinese = chinese + "拾";
					break;
				case 2:// 百
					if (prv != '0')
						chinese = chinese + "佰";
					break;
				case 3:// 千
					if (prv != '0')
						chinese = chinese + "仟";
					break;

				}
			}
		}
		while (chinese.length() > 0
				&& chinese.lastIndexOf("零") == chinese.length() - 1)
			chinese = chinese.substring(0, chinese.length() - 1);
		if (depth == 1)
			chinese += "万";
		if (depth == 2)
			chinese += "亿";

		return chinese;
	}

	public static Double convertToDouble(Double number) {
		if (number == null)
			return null;

		BigDecimal temp = new BigDecimal(number.toString()).setScale(2,
				BigDecimal.ROUND_HALF_UP);
		return Double.valueOf(temp.toString());
	}

	/**
	 * 四舍五入，保留两位小数
	 *
	 * @param number
	 * @return
	 */
	public static Double convertToDouble(String number) {
		if (number == null)
			return null;
		String strTemp = number.trim();
		if (strTemp.length() < 1)
			return null;

		BigDecimal temp = new BigDecimal(strTemp).setScale(2,
				BigDecimal.ROUND_HALF_UP);
		return Double.valueOf(temp.toString());
	}
	/**
	 * 去除字符串中的回车、换行 制表符
	 *
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		    Matcher m = p.matcher(str);
		    String after = m.replaceAll("");
		return after;
	}

	/**
	 * 四舍五入，保留两位小数
	 *
	 * @param number
	 * @return
	 */
	public static Double convertToDouble(double number) {
		BigDecimal temp = new BigDecimal(number).setScale(3,
				BigDecimal.ROUND_HALF_UP);
		return Double.valueOf(temp.toString());
	}

	/**
	 * 根据参数保留某几位小数，四舍五入，
	 *
	 * @param number
	 * @param scale
	 *            保留小数的
	 * @return
	 */
	public static String convertToDouble(double number, int scale) {
		BigDecimal temp = new BigDecimal(number).setScale(scale,
				BigDecimal.ROUND_HALF_UP);
		return temp.toString();
	}

	/** 截取小数点后面的数字 */
	public static String jqXsdTwo(String no) {
		String str = no;
		if (checkXsd(no)) {
			str = no.substring(no.indexOf("."));
		}
		return str;
	}
	/** 截取小数点前面的数字 */
	public static String jqXsdOne(String no) {
		String str = no;
		if (checkXsd(no)) {
			str = no.substring(0, no.indexOf("."));
		}
		return str;
	}

	/** 检查数字中是否包含小数点 */
	public static boolean checkXsd(String number) {
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if (c == '.') {
				return true;
			}
		}
		return false;
	}
	/**检查字符串是否是 数字和小数点**/
	public static boolean isnumber(String str){
        String number = "0123456789.";
        for (int i = 0; i < str.length(); i++) {
            if (number.indexOf(str.charAt(i)) == -1) {
                return false;
            }
        }
        return true;

	}

    /**检查字符串是否是 数字且没有小数点**/
    public static boolean isNumberWithOutDot(String str){
        String number = "0123456789";
        for (int i = 0; i < str.length(); i++) {
            if (number.indexOf(str.charAt(i)) == -1) {
                return false;
            }
        }
        return true;

    }

	/**去除字符串的字符 保留数字和小数点**/
	public static String getnumber(String str){
		StringBuffer str1=new StringBuffer();
        String number = "0123456789.";
        for (int i = 0; i < str.length(); i++) {
            if (number.indexOf(str.charAt(i)) == -1) {

            }else{
            	str1.append(str, i, i+1);
            }
        }
        return str1.toString();

	}


	public static boolean sql_inj(String s)
	{
	    boolean flag = true;
	    if(s==null || "".equals(s) ){
	    	return flag;
	    }
	    if(s.toLowerCase().indexOf("pagecount") != -1)
	        s = s.replaceAll("pagecount", "pagecoun");
        String[] as = {
                "create", "into", "insert", "select", "delete", "update", "count", "window.", "exec master.dbo.xp_cmdshell", "net localgroup administrators", "truncate", "declare",
                "script", "'", ";", "sp_", "%", "<", ">", "drop", "http", "\"", "html", "\""
        };
	    int i = 0;
	    do
	    {
	        if(i >= as.length)
	            break;
	        if(s.toLowerCase().indexOf(as[i]) != -1)
	        {
	            flag = false;
	            break;
	        }
	        i++;
	    } while(true);
	    return flag;
	}

	public static int getCount(String s1,String s2){
        int count=0;
        int temp;
        if(s1.length()>=s2.length()){
            for(int i=0;i<=s1.length();i++){
                temp=s1.indexOf(s2);
                if(temp>=0){
                    ++count;
                    s1=s1.substring(temp+1);
                }
            }
        }
        return count;
    }

	public static String HTMLEncode(String aTagFragment) {
	    StringBuffer result = new StringBuffer();
	    StringCharacterIterator iterator = new StringCharacterIterator(aTagFragment);
	    char character = iterator.current();
	    while (character != 65535) {
	      if (character == '<') result.append("<");
	      else if (character == '>') result.append(">");
	      else if (character == '"') result.append("“");
	      else if (character == '\'') result.append("‘");
	      else if (character == '\\') result.append("﹨");
	      else if (character == '&') result.append("﹠");
	      else
	        result.append(character);
	      character = iterator.next();
	    }
	    return result.toString();
	  }

	 /**
	  * 检查表单，如果表单值中有非法直接置换“”
	  * @param obj 清除非法值为“”.
	  * @return
	  */
	 public static <T extends Object> T check(T obj){

		 Field[] fields = obj.getClass().getDeclaredFields();
		 for (Field field : fields) {
			 if(field.getType()== String.class){
					field.setAccessible(true);
					try {
						if(field.get(obj) == null) continue;
						String newString=sql_inj_replaceall(field.get(obj).toString());
						field.set(obj,newString);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
			 }
		 }

    	return obj;
	 }

	 /**
	  * 检查表单，如果表单值中有非法直接false;
	  * @param obj 返回null通过，有非法返回非法的属性名称.
	  * @return
	  */
	 public static String checkForm(Object obj){
		 Field[] fields = obj.getClass().getDeclaredFields();
		 for (Field field : fields) {
			 if(field.getType()== String.class){
					field.setAccessible(true);
					try {
						if(field.get(obj) == null) continue;
						if(!sql_inj(field.get(obj).toString())){
							return field.getName();
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
			 }
		 }

    	return null;
	 }
	 /**
	  * 检查表单，如果表单值中有非法直接置换“”
	  * @param map 清除非法值为“”.
	  * @return
	  */
	 public static Map<String,Object> checkMapForReplace(Map<String,Object> map){
		 Map<String,Object> newMap=new HashMap<String, Object>();
		 if(map!=null){
			 for (String key : map.keySet()) {
				   String value=DealString.objectoString(map.get(key));
				   value=sql_inj_replaceall(value);
				   newMap.put(key, value);
				  }
		 }else newMap=null;
	     return newMap;
	 }
	 /**
	  * 检查表单，如果表单值中有非法值部分直接置换为“”
	  * @param map 替换非法值部分为“”
	  * @return
	  */
	 public static Map<String,Object> checkMapClear(Map<String,Object> map){
		 Map<String,Object> newMap=new HashMap<String, Object>();
		 if(map!=null){
			 for (String key : map.keySet()) {
				   String value=DealString.objectoString(map.get(key));
				   if(!sql_inj(value)){
					   value="";
					}
				   newMap.put(key, value);
				  }
		 }else newMap=null;
	     return newMap;
	 }

	 public static String objectoString(Object o)
		{
			 String s="";
		  if(o!=null&&!"".equals(o.toString()))
			 s=o.toString().trim();
		  return s;
		}
	 /**
		* 获取客户端IP
		* @param request
		* @return
		*/
		public static String getIp(HttpServletRequest request) {
		        String ip = request.getHeader("X-Forwarded-For");
		        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		            ip = request.getHeader("Proxy-Client-IP");
		        }
		        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		            ip = request.getHeader("WL-Proxy-Client-IP");
		        }
		        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		            ip = request.getHeader("HTTP_CLIENT_IP");
		        }
		        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		        }
		        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		            ip = request.getRemoteAddr();
		        }
		        return ip;
		    }

	public static final String POJECT_PATH =  DealString.class.getClassLoader().getResource("").getPath().substring(1).replaceAll("WEB-INF/classes/", "").replace("/", "\\");

	/** 取系统当前日日期的下一天的凌晨1点 */
	public static Date getNextDay() {
		SimpleDateFormat f = new SimpleDateFormat(
				"yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(f.parse(getDateTimeone()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.add(Calendar.DATE, 1);
		cal.add(Calendar.HOUR, 1);
		return cal.getTime();
	}
	/** 指定日期,指定间隔的日期  yyyy-MM-dd
	 *  间隔 天
	 * */
	public static String getNextDaytoStr(String timeStr,String format,int num) {
		SimpleDateFormat f = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance(); 
		try {
			cal.setTime(f.parse(timeStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.add(Calendar.DATE,num);		
		return f.format(cal.getTime());
	}
	
    public static boolean isMobileNO(String mobiles){
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 验证Email
     * @param email email地址，格式：zhangsan@sina.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkEmail(String email) {
        String regex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z]{2,}){1}$)";
        return Pattern.matches(regex, email);
    }

    

    

  
    
    /**
     * 将Clob字段转为String。
     * @param clob
     * @return resultstr
     */
    public static String Clob2String(Clob clob) {
        int i = 0;
        String resultstr = "";
        try {
            if(clob!=null&&!"".equals(clob.toString())){
                InputStream input = clob.getAsciiStream();
                int len = (int)clob.length();
                byte[] by = new byte[len];
                while(-1 != (i = input.read(by, 0, by.length))){
                    input.read(by, 0, i);
                }
                resultstr = new String(by, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
			logger.info("context", e);
        }
        return resultstr;
    }

    public static String getImgSrc(String source_str){
        int start = source_str.indexOf("src=\"")+5;
        int end = source_str.indexOf("\"",start+5);
        return source_str.substring(start,end);
    }
    
    public  static String sql_inj_replaceall(String str){
    	 Pattern pattern  =null;
    	 Matcher matcher =null;
    	 boolean flag=false;
		if(str==null || "".equals(str) ){
	    	return "";
	    }
        String[] as = {
                "create", "into", "insert", "select", "delete", "update", "count", "window.", "exec master.dbo.xp_cmdshell", "net localgroup administrators", "truncate", "declare",
                "script", "'", "sp_", "%", "<", ">", "drop", "\""
        };
		
		for (int i = 0; i < as.length; i++) {
			  pattern = Pattern.compile(as[i],Pattern.CASE_INSENSITIVE);
		      matcher = pattern.matcher(str);
		      flag= matcher.find();
              if(flag) str = matcher.replaceAll("");
		}		
		return str;
	}
    
    /**
	 * 编码
	 * 
	 * @param s
	 * @return
	 */
	public static String escape(String s) {
		StringBuffer sbuf = new StringBuffer();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			int ch = s.charAt(i);
			if ('A' <= ch && ch <= 'Z') { // 'A'..'Z' : as it was
				sbuf.append((char) ch);
			} else if ('a' <= ch && ch <= 'z') { // 'a'..'z' : as it was
				sbuf.append((char) ch);
			} else if ('0' <= ch && ch <= '9') { // '0'..'9' : as it was
				sbuf.append((char) ch);
			} else if (ch == '-'
					|| ch == '_' // unreserved : as it was
					|| ch == '.' || ch == '!' || ch == '~' || ch == '*'
					|| ch == '\'' || ch == '(' || ch == ')') {
				sbuf.append((char) ch);
			} else if (ch <= 0x007F) { // other ASCII : map to %XX
				sbuf.append('%');
				sbuf.append(hex[ch]);
			} else { // unicode : map to %uXXXX
				sbuf.append('%');
				sbuf.append('u');
				sbuf.append(hex[(ch >>> 8)]);
				sbuf.append(hex[(0x00FF & ch)]);
			}
		}
		return sbuf.toString();
	}

	/**
	 * 解码 说明：本方法保证 不论参数s是否经过escape()编码，均能得到正确的“解码”结果	 * 
	 * @param s
	 * @return
	 */
	public static String unescape(String s) {
		StringBuffer sbuf = new StringBuffer();
		int i = 0;
		int len = s.length();
		while (i < len) {
			int ch = s.charAt(i);
			if ('A' <= ch && ch <= 'Z') { // 'A'..'Z' : as it was
				sbuf.append((char) ch);
			} else if ('a' <= ch && ch <= 'z') { // 'a'..'z' : as it was
				sbuf.append((char) ch);
			} else if ('0' <= ch && ch <= '9') { // '0'..'9' : as it was
				sbuf.append((char) ch);
			} else if (ch == '-'
					|| ch == '_' // unreserved : as it was
					|| ch == '.' || ch == '!' || ch == '~' || ch == '*'
					|| ch == '\'' || ch == '(' || ch == ')') {
				sbuf.append((char) ch);
			} else if (ch == '%') {
				int cint = 0;
				if ('u' != s.charAt(i + 1)) { // %XX : map to ascii(XX)
					cint = (cint << 4) | val[s.charAt(i + 1)];
					cint = (cint << 4) | val[s.charAt(i + 2)];
					i += 2;
				} else { // %uXXXX : map to unicode(XXXX)
					cint = (cint << 4) | val[s.charAt(i + 2)];
					cint = (cint << 4) | val[s.charAt(i + 3)];
					cint = (cint << 4) | val[s.charAt(i + 4)];
					cint = (cint << 4) | val[s.charAt(i + 5)];
					i += 5;
				}
				sbuf.append((char) cint);
			} else { // 对应的字符未经过编码
				sbuf.append((char) ch);
			}
			i++;
		}
		return sbuf.toString();
	}
    
    public static HashMap<String,Object> getGrid(List<?> list,int count){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("rows", list);
		map.put("records", count);
		return map;
	}
    /**
     * 设置最大值,获取随机数数组
     * **/
    public static int[] getRandom(int max){
    	int[] seed = new int[max];
    	for(int i=0;i<max;i++){
    		seed[i]=i;
    	}
    	int[] ranArr = new int[max];
    	Random ran = new Random();
    	  // 数量你可以自己定义。
    	  for (int i = 0; i < seed.length; i++) {
    	  // 得到一个位置
    	  int j = ran.nextInt(seed.length - i);
    	  // 得到那个位置的数值
    	  ranArr[i] = seed[j];
    	  // 将最后一个未用的数字放到这里
    	  seed[j] = seed[seed.length - 1 - i];
         }    	  
    	  return ranArr;
    }
    
    
    public static void main(String[] args) {
//    	String string=DealString.strTotime0("2016-12-07","yyyy-MM-dd","yyyyMMdd");
//    	System.out.println("-------------"+string);
//	    for(int i=0;i<13;i++){
//		System.out.println("json:"+DealString.getNextDaytoStr(string,"yyyyMMdd",i));
//       }
//	    TOPIC.getNameByValue(10000);
//	    System.out.println(getCurrentTime10());
//	    System.out.println(TOPIC.getNameByValue(0,14001));
	}
}
