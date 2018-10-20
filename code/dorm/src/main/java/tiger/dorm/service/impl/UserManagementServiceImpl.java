package tiger.dorm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tiger.dorm.entity.Student;
import tiger.dorm.entity.User;
import tiger.dorm.mapper.UserManagementMapper;
import tiger.dorm.service.UserManagementService;

@Service
public class UserManagementServiceImpl implements UserManagementService{
	@Autowired
	UserManagementMapper umm;
	@Override
	public String userLogin(User user) {
		String result = "";
		String id_card = "";
		if("学生".equals(user.getuType())) {
			 id_card = umm.studentLogin(user.getuId());
		}else if("教师".equals(user.getuType())){
			 id_card = umm.teacherLogin(user.getuId());
		}else {
			 id_card = umm.housemasterLogin(user.getuId()); 
		}
		if(id_card == null) {
			result = "用户不存在";
		}else {
			int length = id_card.length();
			if(id_card.substring(length-8, length).
					equals(user.getuPassword())) {
				result = "true";
			}else{
				result = "密码错误";
			};
		}
		return result;
	 }
	@Override
	public String queryUserNameFromId(User user) {
		if("学生".equals(user.getuType())) {
		    return umm.queryStudentNameFromId(user.getuId());
		}else if("教师".equals(user.getuType())){
			return umm.queryTeacherNameFromId(user.getuId());
		}else {
			return umm.queryHousemasterNameFromId(user.getuId());
		}
	}

}
