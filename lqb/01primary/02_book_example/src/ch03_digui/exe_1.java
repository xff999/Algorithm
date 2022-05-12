package ch03_digui;

import java.util.Scanner;

//第三章递归的练习题，第一 计算2 的加法
//2+22+222+......n 个2

public class exe_1 {
    public static void main(String[] args) {
        System.out.println("输入n 的计算个数");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s=0;
        int a=0;
        for (int i = 1; i <=n; i++) {
                a=a*10+2;
                s=s+a;
        }
        System.out.println(s);
    }
}



//递归是错误的，利用循环
//    static int total=0;
//    static int s=0;
//    public static void main(String[] args) {
//        System.out.println("输入n 的计算个数");
//        Scanner scanner =new Scanner(System.in);
//        int n=scanner.nextInt();
//        s=digui(n);
//        System.out.println(s);
//    }
//
//    public static int digui(int n) {
//        if (n == 1) {
//            s = s + 2;
//            return s;
//        } else {
//            total = 10 * digui(n - 1) + 2;
//            s = s + total;
//            return s;
//        }
//
//    }
//}


