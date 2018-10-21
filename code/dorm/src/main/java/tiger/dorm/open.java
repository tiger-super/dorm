package tiger.dorm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
@MapperScan(value="tiger.dorm.mapper")
@SpringBootApplication
@EnableRedisHttpSession
public class open {
    public static void main(String[] args) {
    	SpringApplication.run(open.class, args);
    }
}
	