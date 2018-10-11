package dorm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import tiger.dorm.tool.AnalysisXLSX;

public class TestXLSX {
	
	@Test
	public void test() throws IOException, EncryptedDocumentException, InvalidFormatException {
/*	String filePath = "C:\\Users\\TW\\Desktop\\dorm.xlsx";	*/
		String filePath = "C:\\Users\\TW\\Desktop\\dorm.xls";	
	InputStream is = new FileInputStream(filePath);
 	XSSFWorkbook wb = new XSSFWorkbook(is);
	/*HSSFWorkbook wb = new HSSFWorkbook(is);*/
	List list  = new ArrayList<Map<String,String>>();
	Sheet sheet = wb.getSheetAt(0);
	// 获得最大行
      int rownum = sheet.getPhysicalNumberOfRows();
      // 获得第一行
      Row row = sheet.getRow(0);
      // 获得最大列
      int colnum = row.getPhysicalNumberOfCells();
	   for(int i = 1; i < rownum;i++) {
	    row = sheet.getRow(i);
	    for(int j=0; j < colnum; j++) {
	    	Cell cell = row.getCell(j);
	   /* 	System.out.println(cell.getNumericCellValue());*/
	    	if(cell.getCellType() == 0) {
	    		System.out.println(cell.getNumericCellValue());
	    	}else {
	    		System.out.println(cell.toString());
	    		
	    	}
	    }
	   }
	
	
	}
     @Test
     public void test1() {
    	 String filePath = "C:\\Users\\TW\\Desktop\\dorm.xls";
    	 System.out.println(filePath.endsWith(".xl"));
     }
     // 测试analysisiXLS
     @Test
     public void analysisiXLSXTest() throws IOException {
    	 new AnalysisXLSX().analysisFile("C:\\Users\\TW\\Desktop\\dorm.xls");;
     }
}
