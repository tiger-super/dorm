package dorm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import tiger.dorm.entity.Dorm;
import tiger.dorm.entity.DormInfo;
import tiger.dorm.entity.NetWorkAddress;
import tiger.dorm.entity.Student;
import tiger.dorm.mapper.DormManagementMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestDormManagementMapper.class) 
@ComponentScan(basePackages="tiger.dorm") 
public class TestDormManagementMapper {
    @Autowired 
	private DormManagementMapper dmm;
    @Test 
    public void test() {
    	 Dorm dorm = new Dorm();
    	 dorm.setDormAddress("南一");
    	 dorm.setDormHold(6);
    	 dorm.setDormNo("306");
    	 dorm.setDormStatus(1);
    	 dorm.setDormUsePerson(6);
    	 System.out.println(dmm.insertDrom(dorm));
     }
    @Test
    public void test1() {
    	 Dorm dorm = new Dorm();
    	 dorm.setDormId("10000");
    	 dorm.setDormAddress("南一");
    	 dorm.setDormNo("306");
    	 List<DormInfo> dormInfos = new ArrayList<DormInfo>();
    	 DormInfo dormInfo = new DormInfo();
    	 dormInfo.setBedNo("4");
    	 NetWorkAddress netWorkAddress = new NetWorkAddress();
    	 netWorkAddress.setIpAddress("192.168.4.155");
    	 netWorkAddress.setSubnet("255.255.254.0");
    	 netWorkAddress.setDefaultNet("192.168.4.1");
    	 netWorkAddress.setFirstDns("210.38.161.130");
    	 netWorkAddress.setSpareDns("211.136.192.6");
    	 dormInfo.setNetWorkAddress(netWorkAddress);
    	 dormInfos.add(dormInfo);
    	 
    	 dorm.setDormInfos(dormInfos);
    	 
    	 System.out.println(dormInfos);
    	 
    	 System.out.println(dmm.insertNetWorkAddresssFromXLSX(dorm));
    }
    
    
}
