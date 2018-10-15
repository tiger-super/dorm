package tiger.dorm.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/dorm/repair")
public class RepairManagerControl {
	// 维修申请的界面显示
	 @RequestMapping("/show")
	    public String showReqairApply() {
	    	return "repairapply";
	    }
	    
}
