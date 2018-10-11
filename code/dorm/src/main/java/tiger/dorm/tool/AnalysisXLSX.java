package tiger.dorm.tool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
@Component
public class AnalysisXLSX {
   // 判断是否为xlsx
   public boolean isXLSX(String filePath) {
    	 if(filePath.endsWith(".xlsx") || filePath.endsWith(".xls")) {
    		 return true;
    	 }else {
    		 return false;
    	 }
     }
    
   public List<Map<String,String>> analysisFile(String filePath) throws IOException {
	   List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	   if(isXLSX(filePath)) {
		   InputStream is = new FileInputStream(filePath);
		   XSSFWorkbook wb = new XSSFWorkbook(is);
		   Sheet sheet = wb.getSheetAt(0);
		   // 获得最大行
		   int rownum = sheet.getPhysicalNumberOfRows();
		   // 获得最大列
		   int colnum = sheet.getRow(0).getPhysicalNumberOfCells();
		   Row rowOne = sheet.getRow(0);
		   for(int i = 1 ; i < rownum ;i++) {
			   Map<String,String> map = new HashMap<String,String>();
			   // 获得第i行
			   Row row = sheet.getRow(i);
			   for(int j = 0 ; j < colnum; j ++) {
				   Cell cell = row.getCell(j);
				   map.put(rowOne.getCell(j).toString(), cell.toString());
			   }
			  list.add(map);
		   }
		   
	   }
	   return list;
   }
}
