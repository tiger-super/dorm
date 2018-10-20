package tiger.dorm.mapper;

import org.springframework.stereotype.Repository;

import tiger.dorm.entity.Student;

@Repository
public interface UserManagementMapper {
	// 学生登录
	public String studentLogin(String stuId);

	// 教师登录
	public String teacherLogin(String teaId);

	// 宿舍管理员登录
	public String housemasterLogin(String housemasterId);

	// 学生姓名查询
	public String queryStudentNameFromId(String stuId);

	// 教授姓名查询
	public String queryTeacherNameFromId(String teaId);
	
	// 管理员姓名查询
	public String queryHousemasterNameFromId(String housemasterId);
}
