package com.example.mycodeexer;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

class CalcDemoTest {

    @Test
    void add() {
        CalcDemo calcDemo = new CalcDemo();
        //System.out.println(calcDemo.add(2, 4));//error,看到绿条不一定正确,不可以使用sysout
        int retValue = calcDemo.add(2, 2);
        Assertions.assertEquals(4,retValue);
        //看到绿条+使用了assert断言也不一定正确,为什么单元测试的多样性和覆盖率如此重要
        retValue = calcDemo.add(2, 7);
        Assertions.assertEquals(14,retValue);
    }

    @Test
    void sub() {

    }
}