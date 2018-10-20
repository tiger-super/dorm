package tiger.dorm.service;
import tiger.dorm.entity.Student;
import tiger.dorm.entity.User;

public interface UserManagementService {
     public String userLogin(User user);
     
     public String queryUserNameFromId(User user);
}
