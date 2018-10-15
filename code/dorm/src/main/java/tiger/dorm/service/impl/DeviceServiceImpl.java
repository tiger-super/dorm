package tiger.dorm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tiger.dorm.entity.Dorm;
import tiger.dorm.mapper.DeviceManagementMapper;
import tiger.dorm.service.DeviceService;
@Service
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	DeviceManagementMapper deviceManagementMapper;
	@Override
	public List<String> queryAllDormAddress() {
		List<String> allDormAddress= deviceManagementMapper.queryAllDormAddress();
		return allDormAddress;
	}

	@Override
	public List<String> accordingToDormAddressQueryAllDormNo(String dormAddress) {
		List<String> allDormNo= deviceManagementMapper.accordingToDormAddressQueryAllDormNo(dormAddress);
		return allDormNo;
	}

	@Override
	public List<String> accordingToDormAddressAndDormNoQueryAllDeviceName(String dormAddress, String dormNo) {
		Dorm dorm = new Dorm();
		dorm.setDormAddress(dormAddress);
		dorm.setDormNo(dormNo);
		List<String> allDeviceName= deviceManagementMapper.accordingToDormAddressAndDormNoQueryAllDeviceName(dorm);
		return  allDeviceName;
	}
}
