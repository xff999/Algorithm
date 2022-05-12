package ch03_digui;

import java.util.Scanner;

//递归求正整数用 2的次幂表示
public class exp_9 {
    public static void main(String[] args) {
        System.out.println("输入一个整数");
        Scanner scanner= new Scanner(System.in);
        int n=scanner.nextInt();
        if(n>=1){
            digui(n, 0);
        }else{
            System.out.println("数据错误");
        }

     }

    public static void digui(int n, int r) {
        //方法定义为静态，方便调用，写的是方法
          if(n==1){  //出口判断
              System.out.print("2^"+r+" ");
          }
          else{
              digui(n/2, r+1);  //跳转循环规律
              if(n%2==1){   //满足另一个输出条件，递归之后输出
                  System.out.print("+2^"+r+" ");
              }
          }
    }
}