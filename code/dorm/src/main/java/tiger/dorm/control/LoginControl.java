package tiger.dorm.control;

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
import org.springframework.web.servlet.ModelAndView;

import tiger.dorm.entity.User;
import tiger.dorm.service.UserManagementService;

@Controller
@RequestMapping("/dorm/login")
public class LoginControl {
	@Autowired
	UserManagementService ums;
    @RequestMapping("/show")
    public String showLogin() {
    	return "login";
    }
    
    @RequestMapping(value="/LoginVerification",method=RequestMethod.GET)
    @ResponseBody
    public String LoginVerification(User user){
       String result = ums.userLogin(user);
    	return result;
    }
    @RequestMapping(value="/success/jump")
    public String LoginSuccessJump() {
    	return "index";
    }
}
