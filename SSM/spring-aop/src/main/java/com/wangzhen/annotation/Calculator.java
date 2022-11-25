package com.wangzhen.annotation;

import org.springframework.stereotype.Component;

/**
 * @author wz
 * @ClassName Calculator
 * @date 2022/9/27 17:54
 * @Description TODO
 */
@Component
public interface Calculator {
    int add(int i, int j);
    int sub(int i, int j);
    int mul(int i, int j);
    int div(int i, int j);

}
