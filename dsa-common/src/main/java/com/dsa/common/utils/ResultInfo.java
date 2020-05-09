
package com.dsa.common.utils;

import java.io.Serializable;

/**
 *
 * @param <T>
 */
public class ResultInfo<T> implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 320213701357198704L;
	/**
	 * 接口响应码
	 */
	private Integer code;
	/**
	 * 响应信息
	 */
	private String message;

	/**
	 * 响应状态码 默认200
	 */
	private Integer status = 200;

	/**
	 * 响应数据
	 */
	private T data;

	/**
	 * 分页信息
	 */
	private Page page;

	/**
	 * 扩展信息
	 */
	private Object extendData;

	public ResultInfo() {

	}

	public ResultInfo(Integer code, String message, Integer status, T data) {
		super();
		this.code = code;
		this.message = message;
		this.status = status;
		this.data = data;
	}

	public ResultInfo(Integer code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ResultInfo(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResultInfo(Integer code, String message, Integer status) {
		this.code = code;
		this.message = message;
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Object getExtendData() {
		return extendData;
	}

	public void setExtendData(Object extendData) {
		this.extendData = extendData;
	}

	@Override
	public String toString()
	{
		return "ResultInfo [code=" + code + ", message=" + message + ", status="
				+ status + ", data=" + data + ", page=" + page + ", extendData="
				+ extendData + "]";
	}

	
	
}
