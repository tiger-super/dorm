package tiger.dorm.control;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tiger.dorm.entity.Dorm;
import tiger.dorm.service.DormService;

@Controller
@RequestMapping("/dorm")

public class DormManagerControl {
	@Autowired
	DormService ds ;
	// 展示查询学生入住信息的界面
	@RequestMapping("/dormInfo/show")
    public String showQueryStudentUseDorm() {
    	return "dorm/querystudentdorminfo";
    }
	// 根据学号查询入住信息
	@RequestMapping("/query/dromInfo")
    @ResponseBody
	public Dorm queryStudentFromStuId(String stuId) {
		Dorm dorm =  ds.queryStudentDormInfoFromStuId(stuId);
		System.out.println(dorm);
		return dorm;
	}
	//展示宿舍入住信息
	@RequestMapping("/show")
	public String showQueryDorm() {
		return "dorm/addDorm";
	}
	
	// 批量添加宿舍信息
	@RequestMapping("/add")
	@ResponseBody
	public Map<String,String> addDormFromXLSX(@RequestParam("fileupload")MultipartFile file) {
		Map<String,String> map = new HashMap<String,String>();
		if(file.isEmpty()) {
			map.put("result", "文件为空");
		}else {			
			String result = ds.batchAdditionDorm(file);
			map.put("result", result);
		}
		return map;
	}
	
}
