package tiger.dorm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tiger.dorm.entity.Dorm;
public interface DormService {
	 // 批量添加宿舍信息
     public String batchAdditionDorm(MultipartFile file);
     
     // 批量添加学生入住信息
     public String batchAdditionStudentCheckInDorm(MultipartFile file);
     
     // 批量添加网络ip地址信息
     public String batchAdditionIpAddress(MultipartFile file);
     
     // 批量添加宿舍仪器
     public String batchAdditionDevice(MultipartFile file);
     
     
     // 根据学号查询入住信息
     public Dorm queryStudentDormInfoFromStuId(String stuId);
}
