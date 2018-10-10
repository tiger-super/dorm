package tiger.dorm.mapper;

import org.springframework.stereotype.Repository;

import tiger.dorm.entity.Student;
@Repository
public interface UserManagementMapper {
	 // 用户登录
     Student QueryStudent();
}
