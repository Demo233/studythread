package com.bim.thread_01;
/**
 *
 * Trylock的使用
 *
 * Trylock()方法会尝试获取锁,如果拿到了返回true
 *
 */


import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockClass2 {
    private static ArrayList<Integer> list = new ArrayList<Integer>();

    public static Lock lock  = new ReentrantLock();
    
    public static void main(String[] args){
        new Thread("t1"){
            public void run (){
                Thread thread = Thread.currentThread();
                boolean b = lock.tryLock();
                System.out.println(thread.getName() + "尝试拿锁" + b);
                if(b){
                    try{
                        thread.sleep(5000);
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
            }
        }.start();

        new Thread("t2"){
            public void run(){
                Thread thread = Thread.currentThread();
                boolean b = lock.tryLock();
                System.out.println(thread.getName() + "尝试拿锁" + b);
                if(b){
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
                }else{

                }
            }
        }.start();

    }
    

}