package tiger.dorm.tool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;
@Component
public class LoadXML {
	public Map<String, String> load(String filePath) throws DocumentException {
		Map<String, String> map = new HashMap<String, String>();
		// 创建saxReader对象
		SAXReader reader = new SAXReader();
		// 通过read方法读取一个文件 转换成Document对象
		Document document = reader.read(ClassLoader.getSystemResourceAsStream(filePath));
		// 获取根节点元素对象
		Element node = document.getRootElement();
		System.out.println("当前节点的名称：：" + node.getName());
		// 获取当前节点的所有属性节点
		List<Element> list = node.elements("word");
		for (Element element : list) {
			List<Attribute> attributes = element.attributes();
			map.put(attributes.get(0).getValue(), attributes.get(1).getValue());
		}
		return map;
	}
}
