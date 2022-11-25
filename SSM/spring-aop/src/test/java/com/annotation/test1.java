package com.annotation;

import com.wangzhen.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wz
 * @ClassName test1
 * @date 2022/9/27 18:03
 * @Description TODO
 */
public class test1 {
    @Test
    public void test1(){
        /**
         * 在获取bean时，我们通常通过接口来获取bean。但要满足接口的实现类唯一，否则报错NoUniqueBeanDefinitionException；
         * 因为ioc中有个多匹配的bean，找不到唯一的bean
         *
         * 在面向切面编程aop中，是不可以通过实现类来获取bean的。 NoSuchBeanDefinitionException
         * 而在非aop中，可以通过实现类来获取，但我们一般不这么做
         *
         * aop编程思想：将核心代码保存，将非核心代码(比如日志)进行抽取，封装到方法中(叫做通知方法),通知方法中会通过注解来指定某个
         * 方法的位置，然后再将这些方法封装到一个类中 (叫做切面),
         * 通过aspect，和before等注解，就可以实现核心代码和非核心代码的相聚与分离。
         */
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop_annotation.xml");
//        CalculatorImpl calculator = ioc.getBean(CalculatorImpl.class);
        Calculator calculator = ioc.getBean(Calculator.class);
        System.out.println(calculator.toString());
        calculator.add(7,7);
        calculator.div(7,7);

    }
}
