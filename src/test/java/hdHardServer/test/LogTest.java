/**   
* @Title: LogTest.java 
* @Package hdHardServer.test 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年12月1日 上午8:34:54 
* @version V1.0   
*/
package hdHardServer.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* @ClassName: LogTest 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年12月1日 上午8:34:54 
*  
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class LogTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);
	
	@Test
	public void log() {
		String hello = "hello";
		LOGGER.error(hello);
		LOGGER.debug(hello);
		LOGGER.info(hello);
		LOGGER.warn(hello);
		LOGGER.error(hello);
	}

}
