package com.example.mycodeexer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimal_BugDemo {
    private static void doubleDemo() {
        double amount1 = 0.03;
        double amount2 = 0.02;
        //double 有效位数为16位,这就会出现存储小数位数不够的情况,出现误差
        System.out.println(amount1 - amount2);//0.009999999999999998
    }

    private static void m1() {
        BigDecimal amount1 = new BigDecimal(0.03);
        BigDecimal amount2 = new BigDecimal(0.02);
        //优先推荐入参位String的构造方法
        BigDecimal amount3 = new BigDecimal("0.04");
        BigDecimal amount4 = new BigDecimal("0.03");
//        System.out.println("amount1: " + amount1);
//        System.out.println("amount2: " + amount2);
        System.out.println(amount3.subtract(amount4));
        System.out.println();
        //使用BigDecimal的valueOf方法
        BigDecimal amount5 = BigDecimal.valueOf(0.03);
        BigDecimal amount6 = BigDecimal.valueOf(0.02);
        System.out.println(amount5.subtract(amount6));

    }

    private static void m2(){
        BigDecimal number1= new BigDecimal("0.9");
        BigDecimal number2= new BigDecimal("0.90");
        BigDecimal number3= new BigDecimal("0.2");
        BigDecimal number4= new BigDecimal("0.3");
//        System.out.println(number1.equals(number2));
//        System.out.println(number1.compareTo(number2));
        System.out.println(number3.divide(number4,2, RoundingMode.HALF_UP));//四舍五入

        //科学计数法
        //***
    }
    public static void main(String[] args) {
        // doubleDemo();
//        m1();
        m2();
    }
}
