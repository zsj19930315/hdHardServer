/**   
* @Title: DeviceTest.java 
* @Package hdHardServer.test 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年11月29日 下午4:54:28 
* @version V1.0   
*/
package hdHardServer.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.org.fjiot.hdHardServer.entity.Device;
import cn.org.fjiot.hdHardServer.mapper.DeviceMapper;

/** 
* @ClassName: DeviceTest 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年11月29日 下午4:54:28 
*  
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DeviceTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceTest.class);
	
	@Autowired
	DeviceMapper deviceMapper;
	
	String content = null;
	
	@Test
	public void test() {
		String test = "test";
		Device newDevice = new Device();
		newDevice.setDeviceNo("00000011");
//		newDevice.setElectric(test);
//		newDevice.setEndTime(test);
//		newDevice.setIsError(test);
//		newDevice.setIsLose(test);
//		newDevice.setIsLowElec(test);
//		newDevice.setIsLowLevel(test);
//		newDevice.setIsStart(test);
//		newDevice.setRoomBed(test);
//		newDevice.setStartTime(test);
//		newDevice.setUpdateTime(test);
//		newDevice.setUserId(test);
//		newDevice.setWeightCur(test);
//		newDevice.setWeightSum(test);
//		newDevice.setWeightThreshold(test);
		deviceMapper.add(newDevice);
//		List<Device> devices = deviceMapper.selectList();
//		for (Device device : devices) {
//			LOGGER.error(device.toString());
//		}
//		Device device = deviceMapper.selectOne("00000002");
//		LOGGER.error(device.toString());
	}

}
