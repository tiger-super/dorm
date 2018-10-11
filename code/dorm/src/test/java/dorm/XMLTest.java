package dorm;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;


public class XMLTest {
     @Test
     public void test(){
    	 // 创建saxReader对象  
         SAXReader reader = new SAXReader();  
         // 通过read方法读取一个文件 转换成Document对象  
         try {
			Document document = reader.read(ClassLoader.getSystemResourceAsStream("AnalysisXLSX.xml"));
			 //获取根节点元素对象  
	        Element node = document.getRootElement();  
	        System.out.println("当前节点的名称：：" + node.getName());  
	        // 获取当前节点的所有属性节点  
	        List<Element> list = node.elements("word");  
	        for(Element element:list) {
	        	List<Attribute> childList = element.attributes();  
	        // 遍历属性节点  
	      System.out.println(childList.get(0).getValue()+"----"+childList.get(1).getValue());
	        }
 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
         

     }
}
