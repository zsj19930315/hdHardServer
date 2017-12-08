/**   
* @Title: JiguangPush.java 
* @Package cn.org.fjiot.hdHardServer.push 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月6日 下午2:58:53 
* @version V1.0   
*/
package cn.org.fjiot.hdHardServer.push;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

/** 
* @ClassName: JiguangPush 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月6日 下午2:58:53 
*  
*/
@Component
public class JiguangPush {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JiguangPush.class);
	
	private static String masterSecret = "82d8fb4a907c8ef7265054a9";
	
	private static String appKey = "693586543aa3aa4fc825d8cc";
	
	private static final String ALERT = "fuck you";
	
	/*
	 * 发送给工作人员
	 */
	public void jiguangPushStaff() {
		String alias = "ios";
		LOGGER.warn("针对别名"+alias+"的用户推送消息");
		PushResult result = push(alias, ALERT);
		if (null != result && result.isResultOK()) {
			LOGGER.warn("针对别名"+alias+"的消息推送成功");
		} else {
			LOGGER.warn("针对别名"+alias+"的消息推送失败");
		}
	}

	/*
	 * 发送给工作护士
	 */
	public void jiguangPushUser() {
		String alias = "ios";
		LOGGER.warn("针对别名"+alias+"的用户推送消息");
		PushResult result = push(alias, ALERT);
		if (null != result && result.isResultOK()) {
			LOGGER.warn("针对别名"+alias+"的消息推送成功");
		} else {
			LOGGER.warn("针对别名"+alias+"的消息推送失败");
		}
	}

	/*
	 * 发送给工作游客
	 */
	public void jiguangPushVisitor() {
		String alias = "ios";
		LOGGER.warn("针对别名"+alias+"的用户推送消息");
		PushResult result = push(alias, ALERT);
		if (null != result && result.isResultOK()) {
			LOGGER.warn("针对别名"+alias+"的消息推送成功");
		} else {
			LOGGER.warn("针对别名"+alias+"的消息推送失败");
		}
	}

	/*
	 * 发送测试
	 */
	public void jiguangPush() {
		String alias = "ios";
		LOGGER.warn("针对别名"+alias+"的用户推送消息");
		PushResult result = push(alias, ALERT);
		if (null != result && result.isResultOK()) {
			LOGGER.warn("针对别名"+alias+"的消息推送成功");
		} else {
			LOGGER.warn("针对别名"+alias+"的消息推送失败");
		}
	}
	
	public static PushResult push(String alias, String alert) {
		ClientConfig clientConfig = ClientConfig.getInstance();
		JPushClient jPushClient = new JPushClient(masterSecret, appKey, null, clientConfig);
		PushPayload payload = buildPushObject_android_ios_alias_alert(alias, alert);
		try {
			return jPushClient.sendPush(payload);
		} catch (APIConnectionException e) {
			LOGGER.error("Connection error. Should retry later. ", e);
			e.printStackTrace();
			return null;
		} catch (APIRequestException e) {
			LOGGER.error("Error response from JPush server. Should review and fix it. ", e);
			LOGGER.error("HTTP Status: " + e.getStatus());
			LOGGER.error("Error Code: " + e.getErrorCode());
			LOGGER.error("Error Message: " + e.getErrorMessage());
			LOGGER.error("Msg ID: " + e.getMsgId());
			e.printStackTrace();
			return null;
		}
	}
	
	private static PushPayload buildPushObject_android_ios_alias_alert(String alias, String alert) {
		return PushPayload.newBuilder().setPlatform(Platform.android_ios()).setAudience(Audience.alias(alias)).setNotification(Notification.newBuilder().addPlatformNotification(AndroidNotification.newBuilder().addExtra("type", "infomation").setAlert(alert).build()).addPlatformNotification(IosNotification.newBuilder().addExtra("type", "infomation").setAlert(alert).build()).build()).setOptions(Options.newBuilder().setApnsProduction(false).setTimeToLive(90).build()).build();
	}

}
