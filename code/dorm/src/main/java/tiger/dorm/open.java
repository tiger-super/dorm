package tiger.dorm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value="tiger.dorm.mapper")
@SpringBootApplication
public class open {
    public static void main(String[] args) {
    	SpringApplication.run(open.class, args);
    }
}
	