package com.bim.thread;

public class LiftOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private int id = taskCount++;

    public LiftOff(){}

    public LiftOff(int countDown){

        this.countDown = countDown;

    }

    public String status(){
        return "#" + id + "(" + (countDown>0?countDown:"LiftOff") + "), ";
    }

    @Override
    public void run() {
        while(countDown-- >0){
            System.out.println(status());
            Thread.yield();
        }
    }

    public static void main(String[] args){

        /*LiftOff l1 = new LiftOff();
        l1.run();*/
        /*Thread t1 = new Thread(new LiftOff());
        t1.start();*/

        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }

    }
}