package tiger.dorm.control;

import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tiger.dorm.tool.XLSXMould;

@Controller
@RequestMapping("/download")
public class DownloadControl {
	@Resource
	private ResourceLoader resourceLoader;
	@Autowired
    private XLSXMould  xm;	
	@RequestMapping("/dorm")
	public void DownloadDrom(HttpServletResponse response, HttpServletRequest request) {
		String filename = "宿舍.xlsx";
        String path = "temporary/dorm.xlsx";
        xm.download(response, request, filename, path);
	}
	
	@RequestMapping("/dormInfo")
	public void DownloadDromInfo(HttpServletResponse response, HttpServletRequest request) {
		String filename = "宿舍入住信息.xlsx";
        String path = "temporary/dorminfo.xlsx";
        xm.download(response, request, filename, path);
	}
}
