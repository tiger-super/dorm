package tiger.dorm.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tiger.dorm.entity.Dorm;
import tiger.dorm.mapper.DormManagementMapper;
import tiger.dorm.service.DormService;
import tiger.dorm.tool.AnalysisXLSX;
import tiger.dorm.tool.LoadXML;
import tiger.dorm.tool.ReflexAssignmentToObject;

@Service
public class DormServiceImpl implements DormService {
	@Autowired
    private AnalysisXLSX aXLSX;
	@Autowired
    private LoadXML loadXML;
	@Autowired
	private ReflexAssignmentToObject rato;
    @Autowired
    private DormManagementMapper dmm;
	@Override
	public String batchAdditionDorm(String filePath) {
		List<Dorm> dorms = new ArrayList<Dorm>();
	    String result = "";
            // 调用解析工具
			List<Map<String, String>> list;
			try {
				list = aXLSX.analysisFile(filePath);
				// 获得对应的映射
				Map<String,String> map = loadXML.load("AnalysisXLSX.xml");
			    for(Map<String,String> xlxs: list) {
			    	Dorm dorm = new Dorm();
			    	Set<String> set = xlxs.keySet();
			        Iterator<String> it = set.iterator();
			        while(it.hasNext()) {
			        	String key = it.next();
			        	if(map.containsKey(key)) {
			        		// 拿到对应的映射字段
			        		String field = map.get(key);	
			        		// 拿到对应的值
			        		String value = xlxs.get(key);
							//通过反射给对象赋值
			        		dorm = rato.<Dorm>assignment(dorm, field, value);
			        	}else {
			        		result = "文件格式错误";
			        		break;
			        	}
			        }
			        dorms.add(dorm);
			    }
			    int success = dmm.insertDromFromXLSX(dorms);
			    result = "成功插入"+success+"条数据";
			} catch (IOException e) {
			result = "解析失败";
			} catch (DocumentException e) {
				result = "AnalysisXLSX.xml配置文件出错";
			}
         return result; 
	}

	@Override
	public String batchAdditionStudentCheckInDorm(String filePath) {
		// TODO Auto-generated method stub
      return "";
	}

	@Override
	public String  batchAdditionIpAddress(String filePath) {
		// TODO Auto-generated method stub
		  return "";
	}

	@Override
	public String batchAdditionDevice(String filePath) {
		// TODO Auto-generated method stub
		  return "";
	}

}
