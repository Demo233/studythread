package com.bim.thread_02;

import java.util.concurrent.*;

public class CallableThreadPool {

    public static void main(String[] args) throws Exception{

        /*ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            Future<String> submit = fixedThreadPool.submit(new MyCallable_01(i));
            System.out.println(submit.get());
        }
        fixedThreadPool.shutdown();
        */

       /* ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Future<String> submit = cachedThreadPool.submit(new MyCallable_01(i));
            System.out.println(submit.get());
        }
        cachedThreadPool.shutdown();*/

    }

}