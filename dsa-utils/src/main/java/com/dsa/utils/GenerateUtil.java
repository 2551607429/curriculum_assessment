package com.dsa.utils;


import java.util.UUID;

public class GenerateUtil {

	
	public static long queryCommonId(String name) {
		long id = CRCUtil.calcCrc32(name.getBytes());
		return 0;
	}
	
	public static String getUUId16() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0     
        // 4 代表长度为4     
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }
	
	/**
	 * 生产GUID数据
	 * @return
	 */
	public static String getGUID32() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
