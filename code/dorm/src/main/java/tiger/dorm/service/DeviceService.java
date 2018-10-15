package tiger.dorm.service;

import java.util.List;

import tiger.dorm.entity.Dorm;

public interface DeviceService {
    // 查询所有的宿舍地址
    public List<String> queryAllDormAddress();
    // 根据宿舍地址查询所有的房间号
    public List<String>  accordingToDormAddressQueryAllDormNo(String dormAddress);
    // 根据宿舍地址和房间号查询所有的设备
    public List<String> accordingToDormAddressAndDormNoQueryAllDeviceName(String dormAddress,String dormNo);
}
