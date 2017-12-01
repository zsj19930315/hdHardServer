/**   
* @Title: DeviceMapper.java 
* @Package cn.org.fjiot.hdSoftServer.mapper 
* @Description: TODO
* @author zhengshaojian fjiot   
* @date 2017年11月28日 下午5:39:32 
* @version V1.0   
*/
package cn.org.fjiot.hdHardServer.mapper;

import java.util.List;

import cn.org.fjiot.hdHardServer.entity.Device;
import cn.org.fjiot.hdHardServer.framework.BaseMapper;

/** 
* @ClassName: DeviceMapper 
* @Description: TODO
* @author zhengshaojian fjiot 
* @date 2017年11月28日 下午5:39:32 
*  
*/
public interface DeviceMapper extends BaseMapper {
	
	public void add(Device device);
	
	public void update(Device device);
	
	public List<Device> selectList();
	
	public Device selectOne(String deviceNo);

}
