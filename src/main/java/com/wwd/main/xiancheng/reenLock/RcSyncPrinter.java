package com.wwd.main.xiancheng.reenLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * 基于一个ReentrantLock和三个conditon实现连续打印abcabc...
 * @author fhr
 * @since 2017/09/04
 */
public class RcSyncPrinter {

    @Test
    public void test() throws InterruptedException {
        ThreadGroup group = new ThreadGroup("xx");
        // 写锁
        ReentrantLock lock = new ReentrantLock();
        // 打印a线程的condition
        Condition conditionA = lock.newCondition();
        // 打印b线程的condition
        Condition conditionB = lock.newCondition();
        // 打印c线程的condition
        Condition conditionC = lock.newCondition();
        // 实例化A线程
        Thread printerA = new Thread(group, new Printer(lock, conditionA, conditionB, 'A'));
        // 实例化B线程
        Thread printerB = new Thread(group, new Printer(lock, conditionB, conditionC, 'B'));
        // 实例化C线程
        Thread printerC = new Thread(group, new Printer(lock, conditionC, conditionA, 'C'));
        // 依次开始A B C线程
        printerA.start();
        Thread.sleep(100);
        printerB.start();
        Thread.sleep(100);
        printerC.start();
        // 主线程循环让出CPU使用权
        while (group.activeCount() > 0) {
            Thread.yield();
        }
    }

    // 打印线程
    private class Printer implements Runnable {
        // 打印次数
        private static final int PRINT_COUNT = 6;
        // 打印锁
        private final ReentrantLock reentrantLock;
        // 本线程打印所需的condition
        private final Condition thisCondtion;
        // 下一个线程打印所需要的condition
        private final Condition nextCondtion;
        // 打印字符
        private final char printChar;

        public Printer(ReentrantLock reentrantLock, Condition thisCondtion, Condition nextCondition, char printChar) {
            this.reentrantLock = reentrantLock;
            this.nextCondtion = nextCondition;
            this.thisCondtion = thisCondtion;
            this.printChar = printChar;
        }

        @Override
        public void run() {
            // 获取打印锁 进入临界区
            reentrantLock.lock();
            try {
                // 连续打印PRINT_COUNT次
                for (int i = 0; i < PRINT_COUNT; i++) {
                    System.out.print(printChar);
                    // 使用nextCondition唤醒下一个线程
                    // 因为只有一个线程在等待，所以signal或者signalAll都可以
                    nextCondtion.signal();
                    // 不是最后一次则通过thisCondtion等待被唤醒
                    // 必须要加判断，不然能够打印6次 但6次后就会直接死锁
                    if (i < PRINT_COUNT - 1) {
                        try {
                            // 本线程让出锁并等待唤醒
                            thisCondtion.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            } finally {
                // 释放打印锁
                reentrantLock.unlock();
            }
        }
    }
}
