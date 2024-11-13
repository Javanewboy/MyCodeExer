package com.example.mycodeexer;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ThreadLocalDemoV3 {
    public static void main(String[] args) {
        //ThreadLocal可以在当前线程中共享数据,set/get需要在同一个线程中执行才行,别人取不到
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> null);
        threadLocal.set(Thread.currentThread().getName() + "-java");
        log.info("major:{}", threadLocal.get());


        new Thread(() -> {
            log.info("major: {}", threadLocal.get());
            threadLocal.set(Thread.currentThread().getName() + "-vue");
            log.info("major: {}", threadLocal.get());
        }, "线程一").start();

        System.out.println();

        new Thread(() -> {
            log.info("major: {}", threadLocal.get());
            threadLocal.set(Thread.currentThread().getName() + "-Flink");
            log.info("major: {}", threadLocal.get());
        }, "线程二").start();
    }
}
