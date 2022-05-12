package Lock;
//多线程实现卖票的功能  synchronized方式
//自动的完成解锁和上锁
 class Ticket{ //第一步 资源类 票
     private int num =30; //定义票的数量
     public synchronized void sale(){  //synchronized
         //给这个资源加上锁，防止多线程的错误
           //资源的操作 卖票的方法
         if(num>0){
             System.out.println(Thread.currentThread().getName()+
                     " 卖出了: 1张 还剩下"+(num--)); }
     }
 }


public class SaleTicket {
     //第二步，创建多个线程，调用资源类的操作方法
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i<10;i++){
                    ticket.sale();
                }
            }
        } ,"t1"
        );
        t1.start();
        Thread t2= new Thread(
                () ->{ for (int i = 0; i < 10; i++) {
                        ticket.sale();
                    } } ,"t2"
        );
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i<40;i++){
                    ticket.sale();
                }
            }
        } ,"t3"
        );
        t3.start();
    }
}
