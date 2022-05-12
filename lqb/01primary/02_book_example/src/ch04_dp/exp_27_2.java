package ch04_dp;

import java.util.Arrays;
import java.util.Scanner;

public class exp_27_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      //  System.out.println("输入一个字符串");
        String str1 = scanner.next();
       // System.out.println("输入一个字符串");
        String str2 = scanner.next();
     //   System.out.println("一个"+str1.length());
       // System.out.println("两个"+str2.length());
        int [][]dp = new int[str1.length()+1][str2.length()+1];

        //注意边界，和下标的使用
        for (int i = 1; i <=str1.length() ; i++) {
            for (int j = 1; j <=str2.length() ; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1] +1;
                }else{
                    dp[i][j]=  Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
//        for (int i = 0; i <=str1.length() ; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(dp[str1.length()][str2.length()]);
    }
}
