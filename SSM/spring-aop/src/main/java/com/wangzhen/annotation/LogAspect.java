package com.wangzhen.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author wz
 * @ClassName LogAspect
 * @date 2022/9/27 17:56
 * @Description aop前置通知
 */
@Aspect
@Component
public class LogAspect {


    /**
     * 第一个* 权限修饰符 返回值任意
     * 第二个* annotation包下的所有类
     * 第三个* 这些类的所有方法
     *  (..) 参数任意
     */
    @Pointcut("execution(* com.wangzhen.annotation.*.*(..))")
    public void pointCut(){

    }
    //方法一    @Before("execution(public int com.wangzhen.annotation.CalculatorImpl.add(int,int))")
    //方法二    @Before("execution(* com.wangzhen.annotation.*.*(..))")
    // 方法三
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        // 获取切入点方法名
        String name = joinPoint.getSignature().getName();
        // 获取切入点方法参数
        Object[] args = joinPoint.getArgs();

        System.out.println("beforeAdviceMethod-----前置通知");
        System.out.println(name + "  " + Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        // 获取切入点方法名
        String name = joinPoint.getSignature().getName();
        // 获取切入点方法参数
        Object[] args = joinPoint.getArgs();

        System.out.println("beforeAdviceMethod-----后置通知");
        System.out.println(name + "  " + Arrays.toString(args));
    }

}
