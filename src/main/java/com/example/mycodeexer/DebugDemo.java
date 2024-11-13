package com.example.mycodeexer;

public class DebugDemo {
    public static void main(String[] args) {
        Integer i = null;
        //运行含有null异常的代码,自动闪电定位,不用人工打断点
        System.out.println(i.intValue());

    }

}
