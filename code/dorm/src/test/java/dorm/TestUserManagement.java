package dorm;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TestTransaction;

import tiger.dorm.mapper.UserManagementMapper;
import tiger.dorm.service.impl.UserManagementServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestUserManagement.class) 
@ComponentScan(basePackages="tiger.dorm") 
public class TestUserManagement {
	@Autowired
	private UserManagementMapper umm;
	@Autowired
	private UserManagementServiceImpl umsi; 
	@Test
	public void test() {
		System.out.println("开始");
	    System.out.println(umm.StudentLogin("10000"));
		System.out.println("结束");
	}

}
