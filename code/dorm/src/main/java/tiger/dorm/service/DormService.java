package tiger.dorm.service;

import tiger.dorm.entity.Dorm;

public interface DormService {
	 // 批量添加宿舍信息
     public String batchAdditionDorm(String filePath);
     
     // 批量添加学生入住信息
     public String batchAdditionStudentCheckInDorm(String filePath);
     
     // 批量添加网络ip地址信息
     public String batchAdditionIpAddress(String filePath);
     
     // 批量添加宿舍仪器
     public String batchAdditionDevice(String filePath);
     
     
}
