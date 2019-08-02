package com.wwd.main.xiancheng.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimingThreadPool extends ThreadPoolExecutor {
	 private static final RejectedExecutionHandler defaultHandler =
		        new AbortPolicy();
    public TimingThreadPool() {
        super(1, 1, 0L, TimeUnit.SECONDS, null);
    }
    
    public TimingThreadPool(int corePoolSize,
            int maximumPoolSize,
            long keepAliveTime,
            TimeUnit unit,
            BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
		Executors.defaultThreadFactory(), defaultHandler);
		}

    private final ThreadLocal<String> startTime = new ThreadLocal<String>();
    private final Logger log = LoggerFactory.getLogger(TimingThreadPool.class);

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        startTime.set(t.getName());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
           String endTime = startTime.get();
            log.debug("afterExecute:	"+endTime);
        } finally {
            super.afterExecute(r, t);
        }
    }

    @Override
    protected void terminated() {
        try {
        } finally {
            super.terminated();
        }
    }
}
