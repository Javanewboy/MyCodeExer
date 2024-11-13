package com.example.mycodeexer;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal+线程池问题
 * 必须回收自定义的ThreadLocal变量,尤其是在线程池场景下,线程经常会被复用,如果不清理自定义的
 * ThreadLocal变量,可能会影响后续业务逻辑和造成内存泄漏等问题,
 * 尽量在代理中使用try-finally块进行回收
 */
public class ThreadLocalDemoV2 {
    public static void main(String[] args) throws InterruptedException {
        MyData myData = new MyData();
        //模拟一个银行有三个办理业务的窗口
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        try {
            //10个顾客请求线程,池子里面有三个受理线程,负责处理业务
            for (int i = 1; i <= 10; i++) {
                int finalI = i;
                threadPool.submit(() -> {
                    try {
                        Integer beforeInt = myData.threadLocalField.get();
                        myData.add();
                        Integer afterInt = myData.threadLocalField.get();
                        System.out.println(Thread.currentThread().getName() + "\t" + "工作窗口\t" +
                                "受理第: " + finalI + "个顾客业务" + "\t beforeInt: " + beforeInt + "\t afterInt: " + afterInt);
                    } finally {
                        //每次结束业务,需要清空数据结束上一个顾客的数据,不然复用到了前一个顾客的数据,不体面
                        myData.threadLocalField.remove();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

}

class MyData {

    ThreadLocal<Integer> threadLocalField = ThreadLocal.withInitial(() -> 0);

    public void add() {
        threadLocalField.set(1 + threadLocalField.get());
    }



}
