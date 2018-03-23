package com.bim.thread_01;
/**
 *
 * Lock() 和UnLock() 的使用
 * lock()方法会获取锁
 * unlock()方法会释放锁
 *
 * 注意：一定要手动释放锁。不然会造成死锁
 *
 */


import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockClass1 {
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    
    public static Lock lock  = new ReentrantLock();
    
    public static void main(String[] args){
        new Thread("t1"){
            public void run (){
                Thread thread = Thread.currentThread();
                lock.lock();
                try{
                    int z =  1/0;
                    System.out.println(thread.getName() + "得到了lock");
                    for(int i=0;i<5;i++){
                        list.add(i);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    System.out.println(thread.getName() + "释放了lock");
                    lock.unlock();
                }
            }
        }.start();

        new Thread("t2"){
            public void run(){
                Thread thread = Thread.currentThread();
                lock.lock();
                try {
                    System.out.println(thread.getName() + "得到了lock");
                    for (int i = 0; i < 5; i++) {
                        list.add(i);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    System.out.println(thread.getName() + "释放了lock");
                    lock.unlock();
                }
            }
        }.start();

    }
    

}