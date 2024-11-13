package com.example.mycodeexer;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ThreadLocalDemoV1 {
    public static void main(String[] args) throws InterruptedException {
        SU7 su7 = new SU7();
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < new Random().nextInt(3) + 1; j++) {
                        su7.saleTotal();//本门店销售总和统计全部加
                        su7.salePersonal();//各个销售独立的销售额,之和自己有关
                    }
                    System.out.println(Thread.currentThread().getName() + "\t" + "号销售卖出: " + su7.salePersonal.get());
                } finally {
                    latch.countDown();
                }
            }, String.valueOf(i)).start();
        }
        latch.await();
        System.out.println(Thread.currentThread().getName() + "\t" + "销售总额: " + su7.getSaleTotal());
    }

}

class SU7 {
    @Getter
    private int saleTotal;//本门店总体销售额

    public synchronized void saleTotal() {
        saleTotal++;
    }

    //ThreadLocal 求三个销售的各自独立的个体销售额,不参加总和计算
    ThreadLocal<Integer> salePersonal = ThreadLocal.withInitial(() -> 0);
    public void salePersonal(){
        salePersonal.set(1+salePersonal.get());
    }
}
