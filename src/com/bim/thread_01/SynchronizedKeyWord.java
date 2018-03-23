package com.bim.thread_01;

/**
 * synchronized用法
 *
 * synchronized的缺点: 会阻塞线程的运行,如果没有释放锁，其余的线程就不能干别的事，效率低。 因此我们使用concurrent包下面的Lock接口
 *
 * 我们期望的是如果你拿着锁，我先干别的事情。
 *
 */
public class SynchronizedKeyWord {

    public static void main(String[] args){

        SynchronizedKeyWord mySynchronized = new SynchronizedKeyWord();

        SynchronizedKeyWord mySynchronized1 = new SynchronizedKeyWord();

        new Thread("thread1"){

            public void run(){
                synchronized(mySynchronized){
                    System.out.println(this.getName() + "start");
                    System.out.println(this.getName() + "run");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally{
                        System.out.println(this.getName() + "end");
                    }
                }
            }

        }.start();

        new Thread("thread2"){
            public void run (){
                synchronized(mySynchronized1){
                    System.out.println(this.getName() + "start");
                    System.out.println(this.getName() + "run");
                    System.out.println(this.getName() + "end");
                }
            }
        }.start();

    }


}