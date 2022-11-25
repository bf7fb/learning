import com.wangzhen.spring.User;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {
    @Test
    public void test1(){
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifeCycle.xml");
        User user = ioc.getBean(User.class);
        ioc.close();
        System.out.println(user);
    }
}
