package com.bim.thread_01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * lockinterrupted()方法的使用
 *
 * lockinterrupted 中断阻塞线程
 *
 * 场景: t1 t2都想访问主进程的公共资源(写数据库入操作),中断的策略,获取公共资源之前先判断锁,如果2秒之内拿不到锁就中断继续干别的事情
 *
 *
 */
public class LockClass3 {


    public static Lock lock = new ReentrantLock();

    public static void main(String[] args){
        LockClass3 test = new LockClass3();
        MyThread t1 = new MyThread(test);
        MyThread t2 = new MyThread(test);
        t1.start();
        t2.start();

        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("=============");
        t2.interrupt();

    }

    /**
     * 公共资源
     * @param t
     * @throws InterruptedException
     */
    public void insert(Thread t) throws InterruptedException{
        lock.lockInterruptibly();
        try{
            System.out.println(t.getName() + "得到了锁");
            //t.sleep(2000);
            for ( ; ;) {
                // 写入数据库
            }
        }finally {
            System.out.println(t.getName() + "执行了finall");
            lock.unlock();
            System.out.println(t.getName() + "释放了锁");
        }
    }


}

class MyThread extends Thread{

    private LockClass3 test = null;
    public MyThread(LockClass3 test){
        this.test = test;
    }

    public void run (){
        try{
            test.insert(Thread.currentThread());
        }catch (InterruptedException e){
            // 资源被锁
            System.out.println(Thread.currentThread().getName() + "无法获取到锁被中断...");
        }
    }

}
