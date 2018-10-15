package tiger.dorm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import tiger.dorm.entity.Dorm;

@Repository
public interface DeviceManagementMapper {
	 // 查询所有的宿舍地址
    List<String> queryAllDormAddress();
    // 根据宿舍地址查询所有的房间号
    List<String> accordingToDormAddressQueryAllDormNo(String dormAddress);
    // 根据宿舍地址和房间号查询所有设备
	public List<String> accordingToDormAddressAndDormNoQueryAllDeviceName(Dorm dorm);
}
