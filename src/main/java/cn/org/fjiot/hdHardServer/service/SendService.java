/**   
 * @Title: SendThread.java 
 * @Package cn.org.fjiot.hdHardServer.service 
 * @Description: TODO
 * @author zhengshaojian fjiot   
 * @date 2017年11月29日 下午2:20:32 
 * @version V1.0   
 */
package cn.org.fjiot.hdHardServer.service;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.org.fjiot.hdHardServer.other.RSBuffer;
import cn.org.fjiot.hdHardServer.other.RSChannel;
import cn.org.fjiot.hdHardServer.other.RSData;
import cn.org.fjiot.hdHardServer.push.JiguangPush;
import cn.org.fjiot.hdHardServer.util.Constants;
import cn.org.fjiot.hdHardServer.util.Util;

/** 
 * @ClassName: SendThread 
 * @Description: TODO
 * @author zhengshaojian fjiot 
 * @date 2017年11月29日 下午2:20:32 
 *  
 */
@Service("SendService")
public class SendService implements Runnable {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SendService.class);

	@Autowired
	private DeviceService deviceService;

	private String content;

	private String ip;

	private int port;

	public void run() {
		int contentLength = content.length();
		if (20 > contentLength) {
			LOGGER.error(Constants.ERROR_DATA+content);
			return;
		}
		RSData receive = Util.string2RSData(content);
		if (receive.oldData.length()/2 != Integer.parseInt(receive.len)) {
			LOGGER.error(Constants.ERROR_DATA_LENGTH+content);
			return;
		}
		switch (receive.code) {
		case Constants.FUNCODE_CODE_HEART:
			receive = deviceService.heart(receive);
			break;
		case Constants.FUNCODE_CODE_ELECTRICITY:
			receive = deviceService.electricity(receive);
			break;
		case Constants.FUNCODE_CODE_START:
			receive = deviceService.start(receive);
			break;
		case Constants.FUNCODE_CODE_END:
			receive = deviceService.end(receive);
			break;
		case Constants.FUNCODE_CODE_SUSPEND:
			receive = deviceService.suspend(receive);
		default:
			break;
		}
		RSBuffer.allocSend();
		RSBuffer.clearSend();
		RSBuffer.putSend(Util.rSData2String(receive).getBytes());
		RSBuffer.flipSend();
		RSChannel.send(RSBuffer.getSend(), new InetSocketAddress(ip, port));
	}

	public DeviceService getDeviceService() {
		return deviceService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
