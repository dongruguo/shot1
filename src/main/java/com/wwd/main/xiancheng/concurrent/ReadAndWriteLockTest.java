package com.wwd.main.xiancheng.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteLockTest {
	private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static void write(Thread thread) {
        lock.writeLock().lock();
        try {
        
        	System.out.println(thread.getName() + ":写操作完毕！");
            System.out.println(thread.getName() + ":正在进行写操作……");
            System.out.println("-----------------");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.writeLock().unlock();
    }
    
    public static void get(Thread thread) {
        lock.readLock().lock();
        try {
            System.out.println(thread.getName() + ":正在进行读操作……");
            System.out.println("-----------------");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.readLock().unlock();
    }

    public static void main(String[] args) {
    	 new Thread(new Runnable() {
             @Override
             public void run() {
             	write(Thread.currentThread());
             }
         }).start(); 
    	
    	new Thread(new Runnable() {
             @Override
             public void run() {
             	get(Thread.currentThread());
             }
         }).start();

         new Thread(new Runnable() {
             @Override
             public void run() {
             	get(Thread.currentThread());
             }
         }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
            	write(Thread.currentThread());
            }
        }).start();
    }

}