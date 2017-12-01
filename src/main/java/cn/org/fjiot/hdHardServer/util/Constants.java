/**   
* @Title: Constants.java 
* @Package cn.org.fjiot.hdHardServer.util 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月1日 上午10:03:01 
* @version V1.0   
*/
package cn.org.fjiot.hdHardServer.util;

/** 
* @ClassName: Constants 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月1日 上午10:03:01 
*  
*/
public class Constants {
	
	//RSChannel
	public static final int PORT = 9876;
	
	public static final String UDP_INIT_ERROR = "UDP初始化异常";
	
	public static final String UDP_RECEIVE_ERROR = "数据接收异常";
	
	public static final String UDP_SEND_ERROR = "数据发送异常";

	//RSBuffer
	public static final int RECEIVE_CAPACITY = 1024;

	public static final int SEND_CAPACITY = 1024;
	
	//RSData
	
	//UdpService
	public static final String RECEIVE_THREAD = "接收线程";

	public static final String RECEIVE_LOG_CONTENT = "receive data:";

	public static final String RECEIVE_LOG_IP = ",from ip:";

	public static final String RECEIVE_LOG_PORT = ",port:";

	public static final String SEND_BEAN = "SendService";
	
	//SendService
	public static final String ERROR_DATA = "无效数据:";

	public static final String ERROR_DATA_LENGTH = "无效数据长度:";
	
	public static final String FUNCODE_CODE_HEART = "01";
	
	public static final String FUNCODE_CODE_ELECTRICITY = "02";
	
	public static final String FUNCODE_CODE_START = "03";
	
	public static final String FUNCODE_CODE_END = "07";
	
	//DeviceService
	public static final String FUNCODE_CODE_STARTED = "04";
	
	public static final String FUNCODE_CODE_ALARM = "05";
	
	public static final String FUNCODE_CODE_REPLY = "06";
	
	public static final String FUNCODE_CODE_UNEXIST = "08";
	
	public static final String REPEAT_LEN_ONE = "01";
	
	public static final String REPEAT_LEN_TWO = "02";
	
	public static final String REPEAT_LEN_NODATA_ONE = "00";
	
	public static final String REPEAT_LEN_NODATA_TWO = "0000";
	
	public static final String UNEXIST_DATA = "该设备:";
	
	public static final String UNEXIST_DATA_SOLVE = "未添加至数据库，请联系管理员";
	
}
