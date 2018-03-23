package com.bim.thread_01;

/**
 *  使用synchronzied关键字实现一个线程的读和写操作
 *
 */

public class ReadAndWriteSynchronzied {


    public static void main(String[] args){

        ReadAndWriteSynchronzied mainThread = new ReadAndWriteSynchronzied();

        new Thread(){
            public void run(){
                mainThread.readAndWrite(Thread.currentThread());
            }
        }.start();

        new Thread(){
            public void run(){
                mainThread.readAndWrite(Thread.currentThread());
            }
        }.start();

    }


    public synchronized void readAndWrite(Thread thread){
        int i = 0;

        long start = System.currentTimeMillis();

        while(System.currentTimeMillis() - start <= 2){
            //  read and writer
            i++;
            if(i%2 == 0){
                System.out.println(thread.getName() + "read....");
            }else{
                System.out.println(thread.getName() + "writer....");
            }
            System.out.println(thread.getName() + "close....");

        }

    }

}