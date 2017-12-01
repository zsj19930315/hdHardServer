/**   
* @Title: TimeUtil.java 
* @Package cn.org.fjiot.hdHardServer.util 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年11月30日 下午12:01:02 
* @version V1.0   
*/
package cn.org.fjiot.hdHardServer.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
* @ClassName: TimeUtil 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年11月30日 下午12:01:02 
*  
*/
public class TimeUtil {
	
	public static String getNowTime() {
		String time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		return time;
	}
	
	/*
	 * 设置下次发送的时间（先设置为05dc-15s）
	 */
	public static String getNextTime() {
		return "05dc";
	}

}
