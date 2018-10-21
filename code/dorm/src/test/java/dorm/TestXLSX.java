package dorm;

import static org.mockito.Mockito.CALLS_REAL_METHODS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
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

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import tiger.dorm.entity.Dorm;
import tiger.dorm.entity.DormInfo;
import tiger.dorm.tool.AnalysisXLSX;
import tiger.dorm.tool.XLSXMould;

public class TestXLSX {

	@Test
	public void test() throws IOException, EncryptedDocumentException, InvalidFormatException {
		/* String filePath = "C:\\Users\\TW\\Desktop\\dorm.xlsx"; */
		String filePath = "C:\\Users\\TW\\Desktop\\宿舍网络ip地址.xlsx";
		InputStream is = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(is);
		/* HSSFWorkbook wb = new HSSFWorkbook(is); */
		List list = new ArrayList<Map<String, String>>();
		Sheet sheet = wb.getSheetAt(0);
		// 获得最大行
		int rownum = sheet.getPhysicalNumberOfRows();
		// 获得第一行
		Row row = sheet.getRow(0);
		// 获得最大列
		int colnum = row.getPhysicalNumberOfCells();
		for (int i = 1; i < rownum; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colnum; j++) {
				Cell cell = row.getCell(j);
				System.out.println("类型为:"+cell.getCellType());
				System.out.println("值为:"+cell.toString().endsWith(".0"));
				/* System.out.println(cell.getNumericCellValue()); */
				 if(cell.getCellType() == 0 && cell.toString().endsWith(".0")) { 
					System.out.println(cell.toString().substring(0, cell.toString().lastIndexOf(".")));
				} else {
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
/*	@Test
	public void analysisiXLSXTest() throws IOException {
		System.out.println(new AnalysisXLSX().analysisFile("C:\\Users\\TW\\Desktop\\dorm.xls"));
	}
*/
	@Test
	public void testReflex() throws NoSuchFieldException, SecurityException {
		Class c = Dorm.class;
		Field f = c.getDeclaredField("dormHold");
		System.out.println(f.getType() == int.class);
		System.out.println(int.class);
	}

	@Test
	public void StringToIntTest() {
		String s = "306.0";
		/* System.out.println(s.substring(0,s.lastIndexOf("."))); */
		System.out.println(s.indexOf("x"));
		/* System.out.println(Integer.valueOf((s.split("."))[0].toString())); */
	}

	@Test
	public void IpAddressTest() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		/*
		 * Field[] f = Dorm.class.getDeclaredFields(); for(int i = 0 ; i < f.length ;
		 * i++) {
		 * System.out.println(f[i].getGenericType()+"----"+f[i].getType().isPrimitive())
		 * ; }
		 * 
		 * System.out.println("............................................"); for(int i
		 * = 0 ; i < f.length ; i++) {
		 * System.out.println(f[i].getGenericType()+"----"+f[i].getType().isInterface())
		 * ; } System.out.println("............................................");
		 * for(int i = 0 ; i < f.length ; i++) {
		 * System.out.println(f[i].getGenericType()+"----"+(f[i].getType() ==
		 * String.class)); }
		 */
		Field[] fields = Dorm.class.getDeclaredFields();
		 for(int i = 0 ; i < fields.length ; i++) {
			System.out.println(fields[i].getName());
		 }
		Method method = Dorm.class.getMethod("setDormInfos", List.class);
		Type[] types = method.getGenericParameterTypes();
		for (Type type : types) {
			if (type instanceof ParameterizedType) {
				Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
				for (Type type2 : actualTypeArguments) {
					System.out.println("泛型参数类型：" + type2);
				}
			}
		}
	}
	@Test
	public void test3() {
		System.out.println("10000.0".indexOf("."));
	}
	@Test
	public void test4() throws RowsExceededException, WriteException, IOException {
		XLSXMould cxm = new XLSXMould();
		List<String> list = new ArrayList<String>();
		list.add("宿舍地址");
		list.add("房间号");
		list.add("可容纳人数");
		list.add("状态");
		list.add("已入住学生人数");
		cxm.create("C:\\Users\\TW\\Desktop\\宿舍.xlsx",list );
	}

}
