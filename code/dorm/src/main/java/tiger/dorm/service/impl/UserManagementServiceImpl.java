package tiger.dorm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		if("学生".equals(user.getuType())) {
			String id_card = umm.StudentLogin(user.getuId());
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
		}
		return result;
	 }

}
