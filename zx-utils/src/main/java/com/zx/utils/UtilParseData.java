package com.zx.utils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class UtilParseData {

	public static Long parseLongData(String s_school_id, Long object) {
		try{
			Long t=UtilLong.parseLong(s_school_id);
			return null==t?object:t;
		}catch(Exception e){
			return object;
		}
	}


	public static Long parseLongData(HttpServletRequest request, String key) {
		return parseLongData(request,key,null);
	}



	public static Short parseShortData(String s_state, Short object) {
		try{
			Short t=UtilShort.parseShort(s_state);
			return null==t?object:t;
		}catch(Exception e){
			return object;
		}
	}
	
	public static Long parseLongData(HttpServletRequest request, String key, Long object) {
		try{
			Long t= UtilLong.parseLong(request.getParameter(key));
			return null==t?object:t;
		}catch(Exception e){
			return object;
		}
	}

	public static Integer parseIntegerData(HttpServletRequest request, String key) {
		return parseIntegerData(request,key,null);
	}

	public static Integer parseIntegerData(HttpServletRequest request, String key, Integer object) {
		try{
			Integer t= UtilInteger.parseInt(request.getParameter(key));
			return null==t?object:t;
		}catch(Exception e){
			return object;
		}
	}

	public static Integer parseIntegerDataArray(HttpServletRequest request, String key, Integer[] is){
		return parseIntegerDataArray(request,key,is,is[0]);
	}
	public static Integer parseIntegerDataArray(HttpServletRequest request, String key, Integer[] is, Integer i) {
		try{
			Integer ti=UtilInteger.parseInt(request.getParameter(key));
			for(Integer tii:is){
				if(tii.equals(ti)){
					return ti;
				}
			}
			return i;
		}catch(Exception e){
			return i;
		}
	}

	public static Integer parsePageData(HttpServletRequest request) {
		return parseIntegerData(request,"page",1);
	}

	public static Integer parsePageSizeData(HttpServletRequest request) {
		return parseIntegerData(request,"page_size",UtilPageFormat.PAGE_SIZE.PAGE_10_SIZE.getPage());
	}

	public static Integer parsePageSizeData(HttpServletRequest request, Integer size) {
		return parseIntegerData(request,"page_size",size);
	}

	public static Short parseShortData(HttpServletRequest request, String key) {
		return parseShortData(request,key,null);
	}
	public static Short parseShortData(HttpServletRequest request, String key, Short object) {
		try{
			Short t=UtilShort.parseShort(request.getParameter(key));
			return null==t?object:t;
		}catch(Exception e){
			return object;
		}
	}

	public static Short parseShortDataArray(HttpServletRequest request, String key, Short[] ss) {
		return parseShortDataArray(request,key,ss,ss[0]);
	}

	public static Short parseShortDataArray(HttpServletRequest request, String key, Short[] ss, Short s) {
		try{
			Short ts= UtilShort.parseShort(request.getParameter(key));

			for(Short t:ss){
				if(ts==t){
					return ts;
				}
			}
			return s;

		}catch(Exception e){
			return s;
		}
	}

	public static String parseStringData(HttpServletRequest request, String key){
		return parseStringData(request,key,null);
	}

	public static String parseStringData(HttpServletRequest request, String key, String object) {
		try{
			String s=request.getParameter(key);
			if(!UtilStringFormat.isStringNull(s)){
				return s;
			}
			return object;
		}catch(Exception e){
			return object;
		}
	}

	public static Boolean parseBooleanData(HttpServletRequest request, String key, Boolean object){
		try{
			if("true".equals(UtilString.parseString(request.getParameter(key)))||"1".equals(UtilString.parseString(request.getParameter(key)))){
				return true;
			}else{
				return false;
			}
		}catch (Exception e){
			return object;
		}
	}


	public static BigDecimal parseBigDecimalData(HttpServletRequest request,
                                                 String key, BigDecimal object) {
		try{
			BigDecimal t= UtilBigDecimal.parseBigDecimal(request.getParameter(key));
			return null==t?object:t;
		}catch(Exception e){
			return object;
		}
	}

	public static BigDecimal parseBigDecimalData(HttpServletRequest request,
                                                 String key) {
		return parseBigDecimalData(request,key,null);
	}


	public static Float parseFloatData(HttpServletRequest request,
                                       String key){
		return parseFloatData(request,key,null);
	}
	public static Float parseFloatData(HttpServletRequest request,
                                       String key, Float object) {
		try{
			Float t= UtilFloat.parseFloat(request.getParameter(key));
			return null==t?object:t;
		}catch(Exception e){
			return object;
		}
	}

	public static Double parseDoubleData(HttpServletRequest request, String key) {
		return parseDoubleData(request,key,null);
	}
	public static Double parseDoubleData(HttpServletRequest request, String key, Double object) {
		try{
			Double t= UtilDouble.parseDouble(request.getParameter(key));
			return null==t?object:t;
		}catch(Exception e){
			return object;
		}
	}
}
