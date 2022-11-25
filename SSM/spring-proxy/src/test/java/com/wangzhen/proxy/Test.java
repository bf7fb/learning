package com.wangzhen.proxy;

import com.wangzhen.spring.cal.Calculator;
import com.wangzhen.spring.cal.CalculatorPureImpl;
import com.wangzhen.spring.cal.ProxyFactory;

public class Test {
    @org.junit.Test
    public void testForProxy(){
        // 静态代理
//        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorPureImpl());
//        proxy.add(7,7);

        // 动态代理 获取被代理类的工厂
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorPureImpl());

//        CalculatorPureImpl proxy1 = (CalculatorPureImpl) proxyFactory.getProxy(); 报错

        // 获取代理类。
        Calculator proxy1 = (Calculator) proxyFactory.getProxy();
        proxy1.add(7,7);
    }
}
