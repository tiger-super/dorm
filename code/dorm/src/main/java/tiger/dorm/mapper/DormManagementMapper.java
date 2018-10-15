package tiger.dorm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import tiger.dorm.entity.Dorm;

@Repository
public interface DormManagementMapper {
     int insertDrom(Dorm dorm);
     // 通过xlsx插入网络ip
     int insertNetWorkAddresssFromXLSX(Dorm dorm);
     // 通过xlsx插入宿舍信息
     int insertDromFromXLSX(List<Dorm> dorms);
     // 通过xlsx插入宿舍详细信息
     int insertDromInfoFromXLSX(Dorm dorm);
     // 通过xlsx插入宿舍设备信息
     int insertDormDeviceFromXLSX(Dorm dorm);
     // 通过学号查询学生入住信息
     Dorm queryStudentDormInfoFromStuId(String stuId);
     
}
