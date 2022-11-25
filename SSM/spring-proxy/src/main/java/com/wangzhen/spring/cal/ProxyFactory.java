package com.wangzhen.spring.cal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author wz
 * @ClassName ProxyFactory
 * @date 2022/9/25 13:50
 * @Description jdk动态代理的实现
 */
public class ProxyFactory {
    // 目标代理对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }
    public Object getProxy(){
        /**
         * classLoader 获取代理类的类加载器
         * interfaces 获取目标对象实现接口的所有接口数组
         * invocationHandler 设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
         */
        ClassLoader classLoader = target.getClass().getClassLoader();

        Class<?>[] interfaces = target.getClass().getInterfaces();

        System.out.println("interfaces: " + Arrays.toString(interfaces));
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * proxy：代理对象
             * method：代理对象需要实现的方法，即其中需要重写的方法
             * args：method所对应方法的参数
             * invoke方法 代理对象执行的方法，代理对象在调用方法时，会传入method方法名，
             * invoke方法根据method方法名来确定调用哪个方法
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("[动态代理][日志] "+method.getName()+ "参数" + Arrays.toString(args));
                Object result;
                result = method.invoke(target,args);
                System.out.println("[动态代理][日志] "+method.getName()+ "结果" + (Integer)result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }
}
