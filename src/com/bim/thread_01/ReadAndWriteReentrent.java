package com.bim.thread_01;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 场景 : 利用ReadReadReentrent类实现 多个线程同时读、单个线程写操作
 */

public class ReadAndWriteReentrent {

    private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args){
        ReadAndWriteReentrent mainThread = new ReadAndWriteReentrent();

        new Thread(){
            public void run(){
                mainThread.read(this);
                mainThread.write(this);
            }

        }.start();

        new Thread(){
            public void run(){
                mainThread.read(this);
                mainThread.write(this);
            }

        }.start();


    }

    /**
     * 读
     */
    public void read(Thread thread){
        rwl.readLock().lock();
        try{
            // 让线程读2s
            long start = System.currentTimeMillis();
            while(System.currentTimeMillis() - start <= 1){
                System.out.println(thread.getName() + "正在读...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwl.readLock().unlock();
            System.out.println(thread.getName() + "读完了...");
        }

    }

    /**
     * 写
     */
    public void write(Thread thread){
        rwl.writeLock().lock();
        try{

            long start = System.currentTimeMillis();
            while(System.currentTimeMillis() - start <= 1){
                System.out.println(thread.getName() + "正在写...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwl.writeLock().unlock();
            System.out.println(thread.getName() + "写完了...");
        }

    }

}