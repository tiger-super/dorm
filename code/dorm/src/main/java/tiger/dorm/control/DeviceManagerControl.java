package tiger.dorm.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tiger.dorm.entity.Dorm;
import tiger.dorm.service.DeviceService;
@Controller
@RequestMapping("/dorm/device")
public class DeviceManagerControl {
	 @Autowired
	  DeviceService deviceService;
	 // 查询所有的宿舍地址
		@RequestMapping("/querys/dormAddress")
	    @ResponseBody
		public List<String> queryAllDormAddress() {
			return deviceService.queryAllDormAddress();
		}
		@RequestMapping("/querys/dormNo")
	    @ResponseBody
		public List<String> accordingToDormAddressQueryAllDormNo(String dormAddress) {
			return deviceService.accordingToDormAddressQueryAllDormNo(dormAddress);
		}
		
		@RequestMapping("/query/devices")
	    @ResponseBody
		public List<String> accordingToDormAddressAndDormNoQueryAllDeviceName(String dormAddress,String dormNo) {
			return deviceService.accordingToDormAddressAndDormNoQueryAllDeviceName(dormAddress,dormNo);
		}
}
