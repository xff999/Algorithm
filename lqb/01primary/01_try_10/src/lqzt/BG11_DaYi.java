package lqzt;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BG11_DaYi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入总学生数");
        int total=scanner.nextInt();
//        int [] s = new int [total];  //创建数组，存储每个同学的数据
//        int [] a = new int [total];
//        int [] e = new int [total];

        stu [] stu = new stu[total];

//        int [] sum = new int[total]; //总时间

        for (int i = 0; i <stu.length ; i++) {
            stu[i]=new stu();
            stu[i].s=scanner.nextInt();
            stu[i].a=scanner.nextInt();
            stu[i].e=scanner.nextInt();  //输入每个同学具体的时间
        }
        int min=Integer.MIN_VALUE;
        int time=0;
        int ttime=0;
        int m=0;
        for (int j = 0; j < total; j++) {
            for (int i = 0; i <total ; i++) {
                if(stu[i].sum<min){
                    min=stu[i].sum;
                    m=i;
                }
            }

            if(j==0){
                time =stu[m].a+stu[m].s;
                ttime=stu[m].a+stu[m].s+stu[m].e;
            }else{
                time=ttime+stu[m].a+stu[m].s;
                ttime=stu[m].a+stu[m].s+stu[m].e;
            }

        }

        System.out.println(time);

    }
   /** public static void main(String[] args) {
        stu [] stu = new stu[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println(stu.length);

        System.out.println(stu[1].toString());

        stu[1].s=scanner.nextInt();
        System.out.println(stu[1].s);
    }*/

}

class stu {
    public int  s;
    public int  a;
    public int  e;
    public int sum =s+a+e;
}