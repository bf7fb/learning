import com.wangzhen.controller.UserController;
import com.wangzhen.dao.UserDao;
import com.wangzhen.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void testForAnnoation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-annoation.xml");
        UserController userController = ioc.getBean(UserController.class);
        System.out.println(userController);

        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println(userDao);

        UserService userService = ioc.getBean(UserService.class);
        System.out.println(userService);
    }
    @Test
    public void testForAutowired(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-annoation.xml");
        UserController controller = ioc.getBean(UserController.class);
        controller.saveUser();
    }
}
