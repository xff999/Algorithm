package Lock;

// 可重上锁  Lock 他是一个类，创建它的对象
//他是手动的上锁 和解锁   （竞争激励时，他的效率比较好

//多线程，Lock 实现 用来使 一个线程+1 一个线程 -1
//共享资源 ，线程间的通信操作

class Share{
     private  int  num=0;
     public synchronized void add(){ //线程+1操作
       //判断，干活，通知
         if(num !=0){   //如果此时不为0 ，等待 -1
             try {
                 this.wait(); //在哪里睡，在哪里被唤醒  虚假唤醒 放在while
                //if判断，只会判断一次 所以改为while ；循环判断；
             } catch (InterruptedException e) {
             }
         }
             num++;  //干活
             System.out.println( Thread.currentThread().getName()+" 干活完成 ："+num);
             this.notifyAll();  //通知
     }
    public synchronized void jian(){ //线程+1操作
        //判断，干活，通知
        if(num !=1){   //如果此时不为1 ，等待 +1
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }else {
            num--;  //干活
            System.out.println( Thread.currentThread().getName()+" 干活完成 ："+num);
            this.notifyAll();  //通知
        }
    }
}

public class xuJiaHuanXing {

    public static void main(String[] args) {
        Share share = new Share();
         new Thread (
                 () ->{ for (int i = 0; i < 10; i++) {
                     share.add();
                 }} ,"t1"
         ) .start(); //一定要启动线程
        new Thread (
                () ->{ for (int i = 0; i < 10; i++)
                       share.jian();
                 } ,"t2"
        ).start();
        new Thread (
                () ->{ for (int i = 0; i < 10; i++) {
                    share.add();
                }} ,"t3"
        ) .start(); //一定要启动线程
        new Thread (
                () ->{ for (int i = 0; i < 10; i++)
                    share.jian();
                } ,"t4"
        ).start();

    }


}













