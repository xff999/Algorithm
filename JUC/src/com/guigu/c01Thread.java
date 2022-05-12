package com.guigu;

public class c01Thread {
    public static void main(String[] args) {

        Thread t1 = new Thread ( //使用Lambda 表达式实现这个接口
                () -> { //创建 线程t1
                    System.out.println(Thread.currentThread().getName() + " :"
                            + Thread.currentThread().isDaemon());
                                 //判断是否是守护线程，（后台运行的）
                    while(true){
                   //主线程结束，程序还在运行，jvm 没停止
                    }
                } ,"t1");
        t1.setDaemon(true) ; //把他设置为守护线程 ，主线程结束这个程序没有用户线程了，结束了
       //启动线程
        t1.start();  //主线程调用t1子线程，
        System.out.println(Thread.currentThread().getName() +"结束");
    }
}
