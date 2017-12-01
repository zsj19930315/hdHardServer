/**   
* @Title: Receive.java 
* @Package cn.org.fjiot.hdDataServer.entity 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年11月29日 下午2:38:01 
* @version V1.0   
*/
package cn.org.fjiot.hdHardServer.other;

/** 
* @ClassName: Receive 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年11月29日 下午2:38:01 
*  
*/
public class RSData {
	
	public String head;
	
	public String version;
	
	public String deviceNo;
	
	public String code;
	
	public String len;
	
	public String data;
	
	public String check;
	
	public String oldData;
	
	public void alter(String code) {
		this.code = code;
	}
	
	public void alter(String code, String len) {
		this.code = code;
		this.len = len;
	}
	
	public void alter(String code, String len, String data) {
		this.code = code;
		this.len = len;
		this.data = data;
	}

}
