package tiger.dorm.mapper;

import org.springframework.stereotype.Repository;

import tiger.dorm.entity.Student;
@Repository
public interface UserManagementMapper {
	 // 学生登录
     String StudentLogin(String stuId);
     // 
}
