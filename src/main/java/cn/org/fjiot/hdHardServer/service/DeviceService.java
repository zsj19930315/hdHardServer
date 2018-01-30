/**   
* @Title: DeviceService.java 
* @Package cn.org.fjiot.hdHardServer.service 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年11月29日 下午3:11:02 
* @version V1.0   
*/
package cn.org.fjiot.hdHardServer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.org.fjiot.hdHardServer.entity.Device;
import cn.org.fjiot.hdHardServer.mapper.DeviceMapper;
import cn.org.fjiot.hdHardServer.other.RSData;
import cn.org.fjiot.hdHardServer.push.JiguangPush;
import cn.org.fjiot.hdHardServer.util.Constants;
import cn.org.fjiot.hdHardServer.util.TimeUtil;
import cn.org.fjiot.hdHardServer.util.Util;

/** 
* @ClassName: DeviceService 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年11月29日 下午3:11:02 
*  
*/
@Service
public class DeviceService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceService.class);
	
	@Autowired
	DeviceMapper deviceMapper;
	
	@Autowired
	private JiguangPush jiguangPush;
	
	public RSData start(RSData receive) {
		Device device = deviceMapper.selectOne(receive.deviceNo);
		if (null == device) {
			receive.alter(Constants.FUNCODE_CODE_UNEXIST, Constants.REPEAT_LEN_TWO, Constants.REPEAT_LEN_NODATA_TWO);
			LOGGER.error(Constants.UNEXIST_DATA+receive.deviceNo+Constants.UNEXIST_DATA_SOLVE);
			return receive;
		}
		device.setIsLose("0");
		device.setIsError("0");
		device.setIsLowLevel("0");
		if ("1".equals(device.getIsStart())) {
			device.setIsStart("0");
			deviceMapper.update(device);
			receive.alter(Constants.FUNCODE_CODE_REPLY, Constants.REPEAT_LEN_TWO, TimeUtil.getNextTime());
			return receive;
		}
		device.setIsStart("1");
		device.setStartTime(TimeUtil.getNowTime());
		device.setWeightSum(receive.data);
		device.setWeightThreshold(Util.int2String(Util.string2Int(receive.data)/10*9));
		device.setWeightCur("0");
		deviceMapper.update(device);
		receive.alter(Constants.FUNCODE_CODE_STARTED, Constants.REPEAT_LEN_TWO, receive.oldData);
		return receive;
	}
	
	public RSData electricity(RSData receive) {
		Device device = deviceMapper.selectOne(receive.deviceNo);
		device.setUpdateTime(TimeUtil.getNowTime());
		device.setIsLose("0");
		int elec = Util.string2Int(receive.data);
		device.setElectric(receive.data);
		if (15 >= elec) {
			device.setIsLowElec("1");
			jiguangPush.push(device.getUserName(), device.getRoomBed()+"设备电量过低,电量："+device.getElectric());
		} else {
			device.setIsLowElec("0");
		}
		deviceMapper.update(device);
		receive.alter(Constants.FUNCODE_CODE_REPLY, Constants.REPEAT_LEN_TWO, TimeUtil.getNextTime());
		return receive;
	}

	public RSData heart(RSData receive) {
		Device device = deviceMapper.selectOne(receive.deviceNo);
		device.setUpdateTime(TimeUtil.getNowTime());
		device.setIsLose("0");
		String sumWeight = device.getWeightSum();
		String lastWeight = device.getWeightCur();
		String thresholdWeight = device.getWeightThreshold();
		int sum = Util.string2Int(sumWeight);
		int last = Util.string2Int(lastWeight);
		int threshold = Util.string2Int(thresholdWeight);
		int cur = Util.string2Int(receive.data);
		if (cur >= threshold && cur <= sum) {
			device.setIsLowLevel("1");
			jiguangPush.push(device.getUserName(), device.getRoomBed()+"设备容量不足");
			device.setWeightCur(receive.data);
			deviceMapper.update(device);
			receive.alter(Constants.FUNCODE_CODE_ALARM, Constants.REPEAT_LEN_ONE, Constants.REPEAT_LEN_NODATA_ONE);
			return receive;
		}
		if (cur > sum) {
			device.setIsLowLevel("1");
			jiguangPush.push(device.getUserName(), device.getRoomBed()+"设备容量不足");
			device.setWeightCur(sumWeight);
			deviceMapper.update(device);
			receive.alter(Constants.FUNCODE_CODE_ALARM, Constants.REPEAT_LEN_ONE, Constants.REPEAT_LEN_NODATA_ONE);
			return receive;
		}
		if (cur < last && 5 > (last - cur)) {
			device.setIsError("1");
			device.setWeightCur(lastWeight);
			deviceMapper.update(device);
			int timeCount = (sum - last) * 10 / sum;
			receive.alter(Constants.FUNCODE_CODE_REPLY, Constants.REPEAT_LEN_TWO, TimeUtil.getNextTime());
			return receive;
		}
		int timeCount = (sum - cur) * 10 / sum;
		device.setIsLowLevel("0");
		device.setIsError("0");
		device.setWeightCur(receive.data);
		deviceMapper.update(device);
		receive.alter(Constants.FUNCODE_CODE_REPLY, Constants.REPEAT_LEN_TWO, TimeUtil.getNextTime());
		return receive;
	}

	public RSData end(RSData receive) {
		Device device = deviceMapper.selectOne(receive.deviceNo);
		device.setEndTime(TimeUtil.getNowTime());
		device.setIsError("0");
		device.setIsLose("0");
		device.setIsLowLevel("0");
		device.setIsStart("0");
		deviceMapper.update(device);
		receive.alter(Constants.FUNCODE_CODE_REPLY, Constants.REPEAT_LEN_TWO, Constants.REPEAT_LEN_NODATA_TWO);
		return receive;
	}

	/**
	 * @return the jiguangPush
	 */
	public JiguangPush getJiguangPush() {
		return jiguangPush;
	}

	/**
	 * @param jiguangPush the jiguangPush to set
	 */
	public void setJiguangPush(JiguangPush jiguangPush) {
		this.jiguangPush = jiguangPush;
	}

}
