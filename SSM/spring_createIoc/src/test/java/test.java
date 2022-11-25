import com.wangzhen.spring.Clazz;
import com.wangzhen.spring.User;
import com.wangzhen.spring.controller.UserController;
import com.wangzhen.spring.student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class test {
    @Test
    public void test1(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        student student = ioc.getBean(student.class);
//        Person student = ioc.getBean(student.class);
//        Person student = ioc.getBean(Person.class);  报错 实现类有两个
        System.out.println(student);

        student studentthr = ioc.getBean("studentthr", student.class);
        System.out.println(studentthr);
    }
    @Test
    public void test2(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        student studentthr = ioc.getBean("studentthr", student.class);
        student studentfor = ioc.getBean("studentfor", student.class);
        System.out.println(studentthr);
        System.out.println(studentfor);
    }
    @Test
    public void test3(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        student studentfive = ioc.getBean("studentfive", student.class);
        System.out.println(studentfive);
        System.out.println(studentfive.getSname().toString());

    }
    @Test
    public void test4(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        student student1 = ioc.getBean("student1", student.class);
        System.out.println(student1);

    }
    @Test
    public void test5(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazz2 = ioc.getBean("clazz2", Clazz.class);
        System.out.println(clazz2);

    }
    @Test
    public void test6(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        student student1 = ioc.getBean("student1", student.class);
        System.out.println(student1);

    }
    @Test
    public void test7(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DataSource dataSource = ioc.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);

    }
    @Test
    public void test8(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User bean = ioc.getBean(User.class);
        System.out.println(bean);
    }
    @Test
    public void test9(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowrite.xml");
        UserController bean = ioc.getBean(UserController.class);
        bean.saveUser();
    }

}
