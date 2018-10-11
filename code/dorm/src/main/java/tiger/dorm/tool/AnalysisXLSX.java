package tiger.dorm.tool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AnalysisXLSX {
   // 判断是否为xlsx
   public boolean isXLSX(String filePath) {
    	 if(filePath.endsWith(".xlsx") || filePath.endsWith(".xls")) {
    		 return true;
    	 }else {
    		 return false;
    	 }
     }
   
   public void analysisFile(String filePath) throws IOException {
	   if(isXLSX(filePath)) {
		   InputStream is = new FileInputStream(filePath);
		   XSSFWorkbook wb = new XSSFWorkbook(is);
		   Sheet sheet = wb.getSheetAt(0);
		   // 获得最大行
		   int rownum = sheet.getPhysicalNumberOfRows();
		   // 获得最大列
		   int colnum = sheet.getRow(0).getPhysicalNumberOfCells();
		   for(int i = 0 ; i < rownum ;i++) {
			   // 获得第i行
			   Row row = sheet.getRow(i);
			   for(int j = 0 ; j < colnum; j ++) {
				   Cell cell = row.getCell(j);
				   System.out.print(cell.toString()+"    ");
			   }
			   System.out.println();
		   }
		   
	   }
   }
}
