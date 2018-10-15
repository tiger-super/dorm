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

import tiger.dorm.entity.Device;
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
		if (aXLSX.isXLSX(filePath)) {
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
		} else {
			result = "文件格式错误";
		}
		return result;
	}

	// 学生入住信息
	@Override
	public String batchAdditionStudentCheckInDorm(String filePath) {
		String result = "";
		List<Dorm> dorms = new ArrayList<Dorm>();
		List<Map<String, String>> list;
		if (aXLSX.isXLSX(filePath)) {
			try {
				list = aXLSX.analysisFile(filePath);
				// 获得对应的映射
				Map<String, String> map = loadXML.load("AnalysisXLSX.xml");
				// 初始宿舍id
				String dormId = list.get(0).get("宿舍id");
				// 初始dorm对象
				Dorm dorm = new Dorm();
				dorm.setDormId(dormId);
				// 创建宿舍详细信息对象
				List<DormInfo> dormInfos = new ArrayList<DormInfo>();
				for (Map<String, String> xlxs : list) {
					String nowDormId = xlxs.get("宿舍id");
					xlxs.remove("宿舍id");
					if (!(nowDormId.equals(dormId))) {
						dorm.setDormInfos(dormInfos);
						dorms.add(dorm);
						dorm = new Dorm();
						dormInfos = new ArrayList<DormInfo>();
						dormId = nowDormId;
						dorm.setDormId(dormId);
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
							if (!(rato.isSuccess())) {
								dormInfo = rato.<DormInfo>assignment(dormInfo, field, value);
								if (!(rato.isSuccess())) {
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
				for (int i = 0; i < dorms.size(); i++) {
					success += dmm.insertDromInfoFromXLSX(dorms.get(i));

				}
				result = "成功插入" + success + "条数据";
			} catch (IOException e) {
				result = "解析失败";
			} catch (DocumentException e) {
				result = "AnalysisXLSX.xml配置文件出错";
			}
		} else {
			result = "文件格式错误";
		}

		return result;
	}

	@Override
	public String batchAdditionIpAddress(String filePath) {
		String result = "";
		List<Dorm> dorms = new ArrayList<Dorm>();
		List<Map<String, String>> list;
		if (aXLSX.isXLSX(filePath)) {
			try {
				list = aXLSX.analysisFile(filePath);
				// 获得对应的映射
				Map<String, String> map = loadXML.load("AnalysisXLSX.xml");
				// 初始宿舍id
				String dormId = list.get(0).get("宿舍id");
				// 初始dorm对象
				Dorm dorm = new Dorm();
				dorm.setDormId(dormId);
				// 创建宿舍详细信息对象
				List<DormInfo> dormInfos = new ArrayList<DormInfo>();
				// 遍历
				for (Map<String, String> xlxs : list) {
					String nowDormId = xlxs.get("宿舍id");
					xlxs.remove("宿舍id");
					if (!(nowDormId.equals(dormId))) {
						dorm.setDormInfos(dormInfos);
						dorms.add(dorm);
						dorm = new Dorm();
						dormInfos = new ArrayList<DormInfo>();
						dormId = nowDormId;
						dorm.setDormId(dormId);
					}
					// 宿舍详细对象
					DormInfo dormInfo = new DormInfo();
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
							// 通过反射给对象赋值
							dorm = rato.<Dorm>assignment(dorm, field, value);
							if (!(rato.isSuccess())) {
								dormInfo = rato.<DormInfo>assignment(dormInfo, field, value);
								if (!(rato.isSuccess())) {
									nwa = rato.<NetWorkAddress>assignment(nwa, field, value);
								}
							}
						}
					}
					dormInfo.setNetWorkAddress(nwa);
					dormInfos.add(dormInfo);
				}
				dorm.setDormInfos(dormInfos);
				dorms.add(dorm);
				int success = 0;
				for (int i = 0; i < dorms.size(); i++) {
					success += dmm.insertNetWorkAddresssFromXLSX(dorms.get(i));
				}
				result = "成功插入" + success + "条数据";
			} catch (IOException e) {
				result = "解析失败";
			} catch (DocumentException e) {
				result = "AnalysisXLSX.xml配置文件出错";
			}
		} else {
			result = "文件格式错误";
		}

		return result;
	}

	@Override
	public String batchAdditionDevice(String filePath) {
		String result = "";
		List<Dorm> dorms = new ArrayList<Dorm>();
		List<Map<String, String>> list;
		if (aXLSX.isXLSX(filePath)) {
			try {
				list = aXLSX.analysisFile(filePath);
				// 获得对应的映射
				Map<String, String> map = loadXML.load("AnalysisXLSX.xml");
				// 初始宿舍id
				String dormId = list.get(0).get("宿舍id");
				// 初始dorm对象
				Dorm dorm = new Dorm();
				dorm.setDormId(dormId);
				// 创建宿舍详细信息对象
				List<Device> devices = new ArrayList<Device>();
				// 遍历
				for (Map<String, String> xlxs : list) {
					String nowDormId = xlxs.get("宿舍id");
					xlxs.remove("宿舍id");
					if (!(nowDormId.equals(dormId))) {
						dorm.setDevices(devices);
						dorms.add(dorm);
						dorm = new Dorm();
						devices = new ArrayList<Device>();
						dormId = nowDormId;
						dorm.setDormId(dormId);
					}
					// 设备对象
					Device device = new Device();
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
							if (!(rato.isSuccess())) {
								device = rato.<Device>assignment(device, field, value);

							}
						}
					}

					devices.add(device);
				}
				dorm.setDevices(devices);
				dorms.add(dorm);
				int success = 0;
				for (int i = 0; i < dorms.size(); i++) {
					success += dmm.insertDormDeviceFromXLSX(dorms.get(i));
				}
				result = "成功插入" + success + "条数据";
			} catch (IOException e) {
				result = "解析失败";
			} catch (DocumentException e) {
				result = "AnalysisXLSX.xml配置文件出错";
			}
		} else {
			result = "文件格式错误";
		}
		return result;
	}

	@Override
	public Dorm queryStudentDormInfoFromStuId(String stuId) {
		return dmm.queryStudentDormInfoFromStuId(stuId);
	}

}
