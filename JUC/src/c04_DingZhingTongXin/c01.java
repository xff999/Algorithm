package c04_DingZhingTongXin;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**定制化通信  （ 规定完成工作量，交替）
 *   AA 打印 5 次 ， BB打印10次  CC打印15次
 *   完成10次这样的交替
 *  怎么完成呢？  设置标志位，对应线程， 指定唤醒线程
 *  sysnchronzied 是随机唤醒的， Lock 锁创建Condition 可以指定唤醒
 */
class  ShareRes{
    private int flag =1; // 1 AA,  2 BB ,3 CC
    Lock lock = new ReentrantLock(); //一定记得创建可重锁

    Condition c1 =lock.newCondition(); //可以指定唤醒线程
    Condition c2 =lock.newCondition();
    Condition c3 =lock.newCondition();
    //注意唤醒的线程，以及标志位， 和线程的start

    //指定AA 做的工作 参数：循环次数
    public void AA(int loop) throws InterruptedException {
        //上锁 ，判断 ，干活，通知，解锁
        lock.lock();
      try {
          while (flag != 1) {
              c1.await();
          }
          for (int i = 1; i <= 5; i++) {
              System.out.println(Thread.currentThread().getName() + " ::" + i + "循环的次数" + loop);
          }
          flag = 2; //修改标志位，定向唤醒 线程b
          c2.signal();
      }finally {
          lock.unlock();
      }
    }

    //指定AA 做的工作 参数：循环次数
    public void BB(int loop) throws InterruptedException {
        //上锁 ，判断 ，干活，通知，解锁
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " ::" + i + "循环的次数" + loop);
            }
            flag = 3; //修改标志位，定向唤醒 线程b
            c3.signal();
        }finally {
            lock.unlock();
        }
    }

    //指定AA 做的工作 参数：循环次数
    public void CC(int loop) throws InterruptedException {
        //上锁 ，判断 ，干活，通知，解锁
        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + " ::" + i + "循环的次数" + loop);
            }
            flag = 1; //修改标志位，定向唤醒 线程A
            c1.signal();
        }finally {
            lock.unlock();
        }
    }
}

public class c01 {
    public static void main(String[] args) {
        ShareRes shareRes = new ShareRes();

        new Thread(
                () ->{
                    for (int i = 0; i < 10; i++) {
                        try {
                            shareRes.AA(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } } }
       ,"AA" ).start();
        new Thread(
                () ->{
                    for (int i = 0; i < 10; i++) {
                        try {
                            shareRes.BB(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } } }
                ,"BB" ).start();
        new Thread(
                () ->{
                    for (int i = 0; i < 10; i++) {
                        try {
                            shareRes.CC(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } } }
                ,"CC" ).start();

    }


}
