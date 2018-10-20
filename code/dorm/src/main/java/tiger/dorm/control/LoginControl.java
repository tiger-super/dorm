package tiger.dorm.control;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import tiger.dorm.entity.Student;
import tiger.dorm.entity.User;
import tiger.dorm.service.UserManagementService;

@Controller
@RequestMapping("/dorm/login")
@SessionAttributes(value= {"userSession"},types={User.class})
public class LoginControl {
	@Autowired
	UserManagementService ums;
	// 界面显示
    @RequestMapping("/show")
    public String showLogin() {
    	return "login";
    }
    // 登录验证
    @RequestMapping(value="/LoginVerification",method=RequestMethod.GET)
    @ResponseBody
    public String LoginVerification(User user,Map<String,User> map){
       String result = ums.userLogin(user);
        if("true".equals(result)) {
        	String name = ums.queryUserNameFromId(user);
        	user.setuName(name);
        	map.put("userSession", user);
        }
    	return result;
    }
    // 登录成功界面跳转
    @RequestMapping(value="/success/jump")
    public String LoginSuccessJump() {
    	return "index";
    }
}
