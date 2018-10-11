package dorm;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import tiger.dorm.service.DormService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DormServiceImplTest.class) 
@ComponentScan(basePackages="tiger.dorm") 
public class DormServiceImplTest {
    @Autowired
    private DormService ds ;
    // 测试batchAdditionDorm方法
    @Test
    public void batchAdditionDormTest() {
    	System.out.println(ds.batchAdditionDorm("C:\\Users\\TW\\Desktop\\dorm.xls"));
    }
 
}
