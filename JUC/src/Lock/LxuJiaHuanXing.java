package Lock;

//使用Lock 模拟线程通信 虚假唤醒
//交替完成工作，就是 线程通信；

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LShare{
    private int num=0;

    private Lock lock= new ReentrantLock();   //创建可重锁
    private Condition  condition= lock.newCondition();

    //创建操作的方法
    public void add (){
        lock.lock();   //首先 手动上锁；
        try {  //判断，干活，通知
            while (num!=0){
                condition.await();
                //它使用的是这个对象 调用方法 等待
            }
         num++;
            System.out.println( Thread.currentThread().getName()+" 干活完成 ："+num);
            condition.signalAll(); //这个通知方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
           lock.unlock(); //最终不管出现什么错误，都会解锁
        }
    }

    //创建操作的方法
    public void jian (){
        lock.lock();   //首先 手动上锁；
        try {  //判断，干活，通知
            while (num!=1){
                condition.await();
                //它使用的是这个对象 调用方法 等待
            }
            num--;
            System.out.println( Thread.currentThread().getName()+" 干活完成 ："+num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); //最终不管出现什么错误，都会解锁
        }
    }

}


public class LxuJiaHuanXing {
    public static void main(String[] args) {

    LShare lShare = new LShare();
    new Thread (
            () ->{ for (int i = 0; i < 10; i++)
                lShare.add();
      },"t2"
    ).start();

      new Thread (
                () ->{ for (int i = 0; i < 10; i++)
        lShare.jian();
    } ,"t2"
            ).start();

    }

}