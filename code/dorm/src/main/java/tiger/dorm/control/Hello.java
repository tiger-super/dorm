package tiger.dorm.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Hello {
	@RequestMapping("/hello")
    public void say() {
    	System.out.println("hello");
    }
}
