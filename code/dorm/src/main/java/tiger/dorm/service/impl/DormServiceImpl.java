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
import tiger.dorm.entity.DormInfo;
import tiger.dorm.entity.NetWorkAddress;
import tiger.dorm.entity.Student;
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
			Map<String, String> map = loadXML.load("AnalysisXLSX.xml");
			for (Map<String, String> xlxs : list) {
				Dorm dorm = new Dorm();
				Set<String> set = xlxs.keySet();
				Iterator<String> it = set.iterator();
				while (it.hasNext()) {
					String key = it.next();
					if (map.containsKey(key)) {
						// 拿到对应的映射字段
						String field = map.get(key);
						// 拿到对应的值
						String value = xlxs.get(key);
						// 通过反射给对象赋值
						dorm = rato.<Dorm>assignment(dorm, field, value);
					} else {
						result = "文件格式错误";
						break;
					}
				}
				dorms.add(dorm);
			}
			int success = dmm.insertDromFromXLSX(dorms);
			result = "成功插入" + success + "条数据";
		} catch (IOException e) {
			result = "解析失败";
		} catch (DocumentException e) {
			result = "AnalysisXLSX.xml配置文件出错";
		}
		return result;
	}

	// 学生入住信息
	@Override
	public String batchAdditionStudentCheckInDorm(String filePath) {
		String result = "";
		List<Dorm> dorms = new ArrayList<Dorm>();
		List<Map<String, String>> list;
		try {
			list = aXLSX.analysisFile(filePath);
			// 获得对应的映射
			Map<String, String> map = loadXML.load("AnalysisXLSX.xml");
		    // 初始宿舍id
			String dormId = list.get(0).get("宿舍id");
			// 初始dorm对象
			Dorm dorm = new Dorm(); 
			dorm.setDormId(dormId.substring(0, dormId.lastIndexOf(".")));		
			// 创建宿舍详细信息对象
			List<DormInfo> dormInfos = new ArrayList<DormInfo>();
			for (Map<String, String> xlxs : list) {
				String nowDormId = xlxs.get("宿舍id");
				xlxs.remove("宿舍id");
				if(!(nowDormId.equals(dormId))) {
					dorm.setDormInfos(dormInfos);
				    dorms.add(dorm);
				    dorm = new Dorm();
				    dormInfos = new ArrayList<DormInfo>();
					dormId = nowDormId;
					dorm.setDormId(dormId.substring(0, dormId.lastIndexOf(".")));	
				}
				// 宿舍详细对象
				DormInfo dormInfo = new DormInfo();
				Student student = new Student();
				Set<String> set = xlxs.keySet();
				Iterator<String> it = set.iterator();
				while (it.hasNext()) {
					String key = it.next();
					if (map.containsKey(key)) {
							// 拿到对应的映射字段
							String field = map.get(key);
							// 拿到对应的值
							String value = xlxs.get(key);
							// 通过反射给对象赋值
							dorm = rato.<Dorm>assignment(dorm, field, value);
							if(!(rato.isSuccess())) {
							dormInfo = rato.<DormInfo>assignment(dormInfo, field, value);	
					        if(!(rato.isSuccess())) {
					        	student = rato.<Student>assignment(student, field, value);
					        }
					        }
					}
				}
				dormInfo.setStudent(student);
				dormInfos.add(dormInfo);
			}
			dorm.setDormInfos(dormInfos);
		    dorms.add(dorm);
		    int success = 0;
			  for(int i = 0 ; i < dorms.size() ; i++) {
		     success += dmm.insertDromInfoFromXLSX(dorms.get(i));
				
			  }			
			  result = "成功插入" + success + "条数据";
		} catch (IOException e) {
			result = "解析失败";
		} catch (DocumentException e) {
			result = "AnalysisXLSX.xml配置文件出错";
		}

		return result;
	}

	@Override
	public String batchAdditionIpAddress(String filePath) {
		String result = "";
		List<Dorm> dorms = new ArrayList<Dorm>();
		List<Map<String, String>> list;
		try {
			list = aXLSX.analysisFile(filePath);
			// 获得对应的映射
			Map<String, String> map = loadXML.load("AnalysisXLSX.xml");
		    // 初始地址
			String dormAddress = list.get(0).get("宿舍地址");
		    // 初始房间号
			String dormNo = list.get(0).get("房间号");
			// 初始dorm对象
			Dorm dorm = new Dorm(); 
			dorm.setDormAddress(dormAddress);
			dorm.setDormNo(dormNo);
			// 创建宿舍详细信息对象
			List<DormInfo> dormInfos = new ArrayList<DormInfo>();
			for (Map<String, String> xlxs : list) {
				String nowDormAddress = xlxs.get("宿舍地址");
				String nowDormNo = xlxs.get("房间号");
				if(!(nowDormAddress.equals(dormAddress) && nowDormNo.equals(dormNo))) {
				    dorm = new Dorm(); 
					dorm.setDormAddress(nowDormAddress);
					dorm.setDormNo(nowDormNo);
				}
				// 宿舍详细对象
				DormInfo dormInfo = new DormInfo();
				// 网络地址对象
				NetWorkAddress nwa = new NetWorkAddress();
				Set<String> set = xlxs.keySet();
				Iterator<String> it = set.iterator();
				while (it.hasNext()) {
					String key = it.next();
					if (map.containsKey(key)) {
							// 拿到对应的映射字段
							String field = map.get(key);
							// 拿到对应的值
							String value = xlxs.get(key);
							
					}
				}
			}
		} catch (IOException e) {
			result = "解析失败";
		} catch (DocumentException e) {
			result = "AnalysisXLSX.xml配置文件出错";
		}

		return result;
	}

	@Override
	public String batchAdditionDevice(String filePath) {
		// TODO Auto-generated method stub
		return "";
	}

}
