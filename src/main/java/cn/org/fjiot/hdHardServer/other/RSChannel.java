/**   
* @Title: RSChannel.java 
* @Package cn.org.fjiot.hdHardServer.other 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年11月29日 下午4:38:31 
* @version V1.0   
*/
package cn.org.fjiot.hdHardServer.other;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.org.fjiot.hdHardServer.util.Constants;

/** 
* @ClassName: RSChannel 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年11月29日 下午4:38:31 
*  
*/
@Component
public class RSChannel {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RSChannel.class);
	
	public static DatagramChannel datagramChannel = null;
	
	public static void init() {
		if (null == datagramChannel) {
			try {
				datagramChannel = DatagramChannel.open();
				datagramChannel.socket().bind(new InetSocketAddress(Constants.PORT));
			} catch (IOException e) {
				LOGGER.error(Constants.UDP_INIT_ERROR);
				e.printStackTrace();
			}
		}
	}
	
	public static SocketAddress receive(ByteBuffer byteBuffer) {
		SocketAddress socketAddress = null;
		try {
			socketAddress = datagramChannel.receive(byteBuffer);
		} catch (IOException e) {
			LOGGER.error(Constants.UDP_RECEIVE_ERROR);
			e.printStackTrace();
		}
		return socketAddress;
	}
	
	public static void send(ByteBuffer byteBuffer, SocketAddress socketAddress) {
		try {
			datagramChannel.send(byteBuffer, socketAddress);
		} catch (IOException e) {
			LOGGER.error(Constants.UDP_SEND_ERROR);
			e.printStackTrace();
		}
	}

}
