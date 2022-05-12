package c06Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//比较 callable和runnable 的区别
class MyThread1 implements Runnable{
    @Override
    public void run() {
        //这里没有返回值
    }
}
class MyThread2 implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"线程运行");
        return "Callable 的实现线程";  //有返回值
    }
}

public class diffentence {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建 实现Runnable 的线程
        new Thread( new MyThread1(),"t1" ).start();
        //创建 实现Callable 的线程 不能直接替换 ，没有这个类型的构造方法
        // new Thread( new MyThread2(),"t2" ).start();
        //选择FutureTask 他是 Runnable 的实现类，而且构造方法含有Callable类型
        FutureTask<String>  task = new FutureTask(new MyThread2());
        new Thread(task,"hhh").start();
        System.out.println("返回值"+task.get()); //调用里面的返回值
    }
}
