package ch04_dp;

import java.util.Arrays;
import java.util.Scanner;
//记住这个代码；；

//求两个字符串，他们公共的字符串序列长度和内容，
//主要侧重递推的动态规划，找到递推的公式，有具体到抽象，得到公式
//这主要注重递推关系的推出
public class exp_27 {
    static int [][]c =new int [10][10];
    static char a[] =new char[10];
    static char b[] =new char[10];
    static char str[] =new char[10];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       // System.out.println("输入A字符串：");
        String A= scanner.next();
       // System.out.println("输入B字符串：");
        String B= scanner.next();

         a =A.toCharArray();
         b =B.toCharArray();  //注意这里使用时，不在重新声明 类型

        //int [][]c =new int [A.length()][B.length()]; 设为全局
//         //创建c 数组，存储数字，表示相等的位置；

       int C= Str_len(A.length(),B.length()); //调用求长度的函数，得到数组的具体值

        //System.out.println("公共的长度"+C);
       // System.out.println("公共的字串为");
        Str_build(C, A.length(), B.length());
        for (int i = 0; i < str.length; i++) {
            if(str[i]!=0){
                System.out.print(str[i]);
            }
        }

    }
    public static int Str_len(int i,int j){
        int t1,t2;
        //下面是不同阶段的 相同递推关系式
        if(i==0||j==0){
            c[i][j]=0;
        }else{
          if(a[i-1]==b[j-1]){
              c[i][j]=Str_len(i-1, j-1)+1;
          }else{
              t1=Str_len(i-1, j); //不相等，把a 向前移一位
              t2=Str_len(i, j-1); //b
              c[i][j]= Math.max(t1, t2);
          }
        }
        return (c[i][j]);
    }

    public static void Str_build(int k,int i,int j){
        if(i==0||j==0){
            return ;
        }else{
            if(c[i][j]==c[i-1][j]){
                Str_build(k, i-1, j);
            }else if(c[i][j]==c[i][j-1]){
                Str_build(k, i, j-1);
            }else{
                str[k-1]=a[i-1];
                Str_build(k-1, i-1, j-1);
            }
        }
    }
}
/**
 * 上面求长度 提交时，递归调用函数，会出现运行超市，
 * 所以直接可以  dp 动态规划循环 求出他的长度
 */
//import java.util.Scanner;
//public class Main{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        String t = sc.next();
//        int n = s.length()+1,m = t.length()+1;
//        int[][] dp = new int[n][m];

//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                if (s.charAt(i-1) != t.charAt(j-1)){
//                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
//                }else {
//                    dp[i][j] = dp[i-1][j-1] + 1;
//                }
//            }
//        }
//        System.out.println(dp[n-1][m-1]);
//    }
//}