package tiger.dorm.tool;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.util.IOUtils;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
@Component
public class XLSXMould {
	
	@Resource
	private ResourceLoader resourceLoader;
   public void create(String path,List<String> list) throws IOException, RowsExceededException, WriteException {

	   OutputStream os = new FileOutputStream(path);
	   //创建工作薄
       WritableWorkbook workbook = Workbook.createWorkbook(os);
       //创建新的一页
       WritableSheet sheet = workbook.createSheet("First Sheet",0);
     //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
       for(int i = 0 ; i <list.size(); i++) {
    	   Label label = new Label(i,0,list.get(i));
    	   sheet.addCell(label);
       }
       workbook.write();
       workbook.close();
       os.close();
   }
   
   
   public void download(HttpServletResponse response, HttpServletRequest request,String filename,String path ) {
	   InputStream inputStream = null;
	   ServletOutputStream servletOutputStream = null;
       try {
	   org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:"+path);
       response.setContentType("application/vnd.ms-excel");
       response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
       response.addHeader("charset", "utf-8");
       response.addHeader("Pragma", "no-cache");
       String encodeName = URLEncoder.encode(filename, StandardCharsets.UTF_8.toString());
       response.setHeader("Content-Disposition", "attachment; filename=\"" + encodeName + "\"; filename*=utf-8''" + encodeName);
       inputStream = resource.getInputStream();
       servletOutputStream = response.getOutputStream();
       IOUtils.copy(inputStream, servletOutputStream);
       response.flushBuffer();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (servletOutputStream != null) {
				servletOutputStream.close();
				servletOutputStream = null;
			}
			if (inputStream != null) {
				inputStream.close();
				inputStream = null;
			}
			// 召唤jvm的垃圾回收器
			System.gc();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   }
}
