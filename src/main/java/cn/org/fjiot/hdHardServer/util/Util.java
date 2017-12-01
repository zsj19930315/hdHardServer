/**   
* @Title: Util.java 
* @Package cn.org.fjiot.hdHardServer.util 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年11月29日 上午10:24:14 
* @version V1.0   
*/
package cn.org.fjiot.hdHardServer.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import cn.org.fjiot.hdHardServer.other.RSData;

/** 
* @ClassName: Util 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年11月29日 上午10:24:14 
*  
*/
public class Util {
	
	public static String xstring2String(String xString) {
		return String.valueOf(Integer.parseInt(xString, 16));
	}
	
	public static String int2String(int i) {
		return String.valueOf(i);
	}
	
	public static int string2Int(String s) {
		return Integer.parseInt(s);
	}
	
	public static String byteBuffer2String(ByteBuffer byteBuffer) {
		Charset charset = null;
		CharsetDecoder decoder = null;
		CharBuffer charBuffer = null;
		try {
			charset = Charset.forName("UTF-8");
			decoder = charset.newDecoder();
			charBuffer = decoder.decode(byteBuffer.asReadOnlyBuffer());
			return charBuffer.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return "error";
		}
	}
	
	public static RSData string2RSData(String content) {
		RSData rsData = new RSData();
		rsData.head = content.substring(0, 2);
		rsData.version = content.substring(2, 6);
		rsData.deviceNo = content.substring(6, 12);
		rsData.code = content.substring(12, 14);
		rsData.len = content.substring(14, 16);
		rsData.data = xstring2String(content.substring(16, content.length() - 2));
		rsData.check = content.substring(content.length() - 2, content.length());
		rsData.oldData = content.substring(16, content.length() - 2);
		return rsData;
	}
	
	public static String rSData2String(RSData rsData) {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(rsData.head);
		stringBuilder.append(rsData.version);
		stringBuilder.append(rsData.deviceNo);
		stringBuilder.append(rsData.code);
		stringBuilder.append(rsData.len);
		stringBuilder.append(rsData.data);
		stringBuilder.append(rsData.check);
		String string = new String(stringBuilder);
		return string;
	}

}
