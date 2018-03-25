package com.bim.thread_02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用Rubable任务
 */

public class RunableThreadPool {

    public static void main(String[] args){
        // 初始化线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5 ; i++) {
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"run ...");
                }
            });
        }
        cachedThreadPool.shutdown();
    }


}