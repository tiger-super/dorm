package tiger.dorm.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tiger.dorm.entity.Repair;
import tiger.dorm.service.RepairManagementService;
@Controller
@RequestMapping("/dorm/repair")
public class RepairManagerControl {
	@Autowired
	RepairManagementService repairManagementService;
	// 维修申请的界面显示
	 @RequestMapping("/show")
	    public String showRepairApply() {
	    	return "repairapply";
	    }
	 
	 // 接收维修单的申请
	 @RequestMapping("/accept")
	 @ResponseBody
	 public String acceptRepairApply(Repair repair) {
		 int result = repairManagementService.insertRepairApply(repair);
		 if(result > 0) {
			 return "true";
		 }else {
			 return "false";
		 }
		 
	 }
	    
}
