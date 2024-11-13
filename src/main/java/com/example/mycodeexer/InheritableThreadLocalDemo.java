package com.example.mycodeexer;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

@Slf4j
public class InheritableThreadLocalDemo {
    public static void main(String[] args) {
//        m1();
        //m2();//InheritableThreadLocal
         m3();//TransmittableThreadLocal
       
    }

    private static void m3() {
        // 解决线程池中线程因为复用而不能取得外部线程数据的问题
        TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();
        transmittableThreadLocal.set(Thread.currentThread().getName() + "-java");
        log.info("major:{}", transmittableThreadLocal.get());

        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        threadPool = TtlExecutors.getTtlExecutorService(threadPool);
        threadPool.execute(() -> {
            log.info("threadPool第一次获取 major:{}", transmittableThreadLocal.get());
        });

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();

        transmittableThreadLocal.set(Thread.currentThread().getName() + "-vue");


        threadPool.execute(() -> {
            log.info("threadPool第二次获取 major:{}", transmittableThreadLocal.get());
        });
        threadPool.shutdown();
    }

    private static void m2() {
        //InheritableThreadLocal遇到线程池 会有问题
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set(Thread.currentThread().getName() + "-java");
        log.info("major:{}", inheritableThreadLocal.get());

        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        threadPool.execute(() -> {
            log.info("threadPool第一次获取 major:{}", inheritableThreadLocal.get());
        });

        inheritableThreadLocal.set(Thread.currentThread().getName() + "-vue");


        threadPool.execute(() -> {
            log.info("threadPool第二次获取 major:{}", inheritableThreadLocal.get());
        });
    }

    public static void m1() {
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        // 在主线程中设置一个值
        inheritableThreadLocal.set(Thread.currentThread().getName() + "-java");
        log.info("");
        // 创建一个子线程
        new Thread(() -> {
            // 子线程将从父线程继承该值
            String value = inheritableThreadLocal.get();
            System.out.println("子线程中的值：" + value);
        }).start();

        inheritableThreadLocal.set(Thread.currentThread().getName() + "-vue");

        new Thread(() -> {
            // 子线程将从父线程继承该值
            String value = inheritableThreadLocal.get();
            System.out.println("子线程中的值：" + value);
        }).start();

        new Thread(() -> {
            // 子线程将从父线程继承该值
            String value = inheritableThreadLocal.get();
            System.out.println("子线程中的值：" + value);
        }).start();
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {

            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }


}
