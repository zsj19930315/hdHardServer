/**   
 * @Title: UdpService.java 
 * @Package cn.org.fjiot.hdHardServer.service 
 * @Description: TODO
 * @author zhengshaojian fjiot   
 * @date 2017年11月29日 上午10:03:43 
 * @version V1.0   
 */
package cn.org.fjiot.hdHardServer.service;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import cn.org.fjiot.hdHardServer.other.RSBuffer;
import cn.org.fjiot.hdHardServer.other.RSChannel;
import cn.org.fjiot.hdHardServer.util.Constants;
import cn.org.fjiot.hdHardServer.util.SpringUtil;
import cn.org.fjiot.hdHardServer.util.Util;

/** 
 * @ClassName: UdpService 
 * @Description: TODO
 * @author zhengshaojian fjiot 
 * @date 2017年11月29日 上午10:03:43 
 *  
 */
@Service
public class UdpService implements ServletContextAware {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UdpService.class);

	@Override
	public void setServletContext(ServletContext servletContext) {
		Thread receive = new Thread() {
			@Override
			public void run() {
				RSChannel.init();
				RSBuffer.allocReceive();
				while (true) {
					SocketAddress socketAddress = RSChannel.receive(RSBuffer.getReceive());
					InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
					String ip = inetSocketAddress.getAddress().getHostName();
					int port = inetSocketAddress.getPort();
					RSBuffer.flipReceive();
					String content = Util.byteBuffer2String(RSBuffer.getReceive());
					RSBuffer.clearReceive();
					LOGGER.error(Constants.RECEIVE_LOG_CONTENT+content.trim()+Constants.RECEIVE_LOG_IP+ip+Constants.RECEIVE_LOG_PORT+port);
					SendService sendService = (SendService) SpringUtil.getBean(Constants.SEND_BEAN);
					sendService.setContent(content);
					sendService.setIp(ip);
					sendService.setPort(port);
					new Thread(sendService).start();
				}
			}
		};
		receive.setName(Constants.RECEIVE_THREAD);
		receive.start();
	}

}
