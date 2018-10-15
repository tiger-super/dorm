package tiger.dorm.service;

import org.springframework.stereotype.Service;

import tiger.dorm.entity.Student;
import tiger.dorm.entity.User;

public interface UserManagementService {
     public String userLogin(User user);
     
     public Student queryStudent(String stuId);
}
