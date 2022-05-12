package lqzt;

//后缀表达式，关于正负符号和数字，能够取得最大值的问题
//  讨论情况 对特殊的 负号进行和负数的个数比较

import java.util.Arrays;
import java.util.Scanner;

public class B10_HouZhuiBiaoDaShi {
    public static void main(String[] args) {
        long total=0; //总结果
        int z=0,f=0; //表示指示正负数组的
        long []zs = new long[100000]; //存正数
        long []fs = new long[100000]; //存负数
        Scanner scanner = new Scanner(System.in);
       // System.out.println("输入加号 的个数 N");
         int N=scanner.nextInt();
       // System.out.println("输入减号 的个数 M");
         int M=scanner.nextInt();
       // System.out.println("输入N+M+1个数字");
        for (int i = 0; i <N+M+1; i++) {
           long num =scanner.nextLong();
           if(num>0){
               zs[z++]=num;
           }else{
               fs[f++]=num;
           }
           total=total+num;
        }

        if (M==0){
            System.out.println(total);
        }else{
            if(M<f){ //符号数 < 负数的个数
                for (int i = 0; i <f ; i++) {
                    total =total- fs[i]*2; //减去这些负数，因为有第一次
                }
                System.out.println(total);
            }else{
                for (int i = 0; i <f ; i++) {
                    total =total-fs[i]*2;
                }
                Arrays.sort(zs,0,z);
              //  System.out.println(Arrays.toString(zs));  测试排序后减的数
                for (int i = 0; i <M-f ; i++) {
                    total =total-zs[i]*2;
                }
                System.out.println(total);
            }
        }

    }
}
