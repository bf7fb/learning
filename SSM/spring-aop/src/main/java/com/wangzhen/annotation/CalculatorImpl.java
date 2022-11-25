package com.wangzhen.annotation;

import org.springframework.stereotype.Component;

/**
 * @author wz
 * @ClassName CalculatorImpl
 * @date 2022/9/27 17:55
 * @Description TODO
 */
@Component
public class CalculatorImpl implements Calculator{
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
}
