package com.bim.thread_02;

import java.util.concurrent.Callable;

public class MyCallable_01 implements Callable<String> {

    public static int tag = 0;

    public MyCallable_01() {

    }

    public MyCallable_01(int tag) {
        this.tag = tag;
    }

    @Override
    public String call() throws Exception {

        /*long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 1000){

        }
*/
        return tag + "--------" + Thread.currentThread().getName();
    }
}