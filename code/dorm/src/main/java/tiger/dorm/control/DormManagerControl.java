package tiger.dorm.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tiger.dorm.entity.Dorm;
import tiger.dorm.service.DormService;

@Controller
@RequestMapping("/dorm/show")
public class DormManagerControl {
	@Autowired
	DormService ds ;
	// 展示查询学生入住信息的界面
	@RequestMapping("/query/student")
    public String showQueryStudentUseDorm() {
    	return "querystudentdorminfo";
    }
	// 根据学号查询入住信息
	@RequestMapping("/query/sutId")
    @ResponseBody
	public Dorm queryStudentFromStuId(String stuId) {
		Dorm dorm =  ds.queryStudentDormInfoFromStuId(stuId);
		System.out.println(dorm);
		return dorm;
	}
}
