package ch03_shuzu;

//开灯的问题，一号 关闭所有灯，2号开他的倍数的灯，3号给他的倍数的灯做相反的操作.....

import java.util.Scanner;

//利用数组的 标志，对立的状态
public class exp_26 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入灯数");
        int d=scanner.nextInt();
        System.out.println("输入同学数");
        int s = scanner.nextInt();
        int deng[]=new int [d+1]; //创建灯的数组 ，初始为0
        for(int i=2;i<=s;i++){//每个同学做操作
            int k=1 ; //控制前进的变量
            while(i*k<=d){
                deng[i*k]=1-deng[i*k];
                k++;
            }
        }
        for (int i = 1; i <= d ; i++) {
            if (deng[i]!=0){
                System.out.printf("%3d",i);
            }
        }
    }
}
