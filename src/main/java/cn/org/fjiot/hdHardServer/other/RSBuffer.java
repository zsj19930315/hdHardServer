/**   
* @Title: RSBuffer.java 
* @Package cn.org.fjiot.hdHardServer.other 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年11月30日 上午9:19:46 
* @version V1.0   
*/
package cn.org.fjiot.hdHardServer.other;

import java.nio.ByteBuffer;

import cn.org.fjiot.hdHardServer.util.Constants;

/** 
* @ClassName: RSBuffer 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年11月30日 上午9:19:46 
*  
*/
public class RSBuffer {
	
	private static ByteBuffer receiveBuffer = null;
	
	private static ByteBuffer sendBuffer = null;
	
	public static void allocReceive() {
		if (null == receiveBuffer) {
			receiveBuffer = ByteBuffer.allocateDirect(Constants.RECEIVE_CAPACITY);
		}
	}
	
	public static void allocSend() {
		if (null == sendBuffer) {
			sendBuffer = ByteBuffer.allocateDirect(Constants.SEND_CAPACITY);
		}
	}
	
	public static ByteBuffer getReceive() {
		return receiveBuffer;
	}
	
	public static ByteBuffer getSend() {
		return sendBuffer;
	}
	
	public static ByteBuffer putSend(byte[] bytes) {
		return sendBuffer.put(bytes);
	}
	
	public static void clearReceive() {
		receiveBuffer.clear();
	}
	
	public static void clearSend() {
		sendBuffer.clear();
	}
	
	public static void flipReceive() {
		receiveBuffer.flip();
	}
	
	public static void flipSend() {
		sendBuffer.flip();
	}

}
