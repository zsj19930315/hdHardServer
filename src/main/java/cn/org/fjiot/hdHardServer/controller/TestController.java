/**   
* @Title: TestController.java 
* @Package cn.org.fjiot.hdHardServer.controller 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月25日 上午10:46:17 
* @version V1.0   
*/
package cn.org.fjiot.hdHardServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @ClassName: TestController 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月25日 上午10:46:17 
*  
*/
@Controller
@RequestMapping("/test")
public class TestController {
	
	@ResponseBody
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public String info(String info) {
		return info;
	}

}
