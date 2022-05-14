package com.xff.some;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class c_0105_一次编译 {
    public static void main(String[] args) {
        String str1 = "plesd";
        String str2 = "ples";
        System.out.println(oneEditAway(str1, str2));

    }

    public static boolean oneEditAway(String first, String second) {

        char[] fir=first.toCharArray();
        char[] sec=second.toCharArray();
        int n1=fir.length,n2=sec.length;
        int[][] change=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            change[i][0]=change[i-1][0]+1;
        }
        for(int i=1;i<=n2;i++){
            change[0][i]=change[0][i-1]+1;
        }
        String str1 = "plesd";
        String str2 = "ples";
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(fir[i-1]==sec[j-1]) change[i][j]=change[i-1][j-1];
                else change[i][j]=Math.min(Math.min(change[i-1][j],change[i][j-1]),change[i-1][j-1])+1;
            }
        }
        for (int i = 0; i <change[0].length ; i++) {
            System.out.println(Arrays.toString(change[i]));
        }
        return change[n1][n2]<=1;


//        if(first.equals(second)) return  true;
//        if (Math.abs(l1 -second.length())>=2){
//               return false;
//           }
//           //求最长公共子串
//        int[][] dp = new int[l1+1][l2+1];
//        for (int i = 1; i < l1+1; i++) {
//            for (int j = 1; j < l2+1 ; j++) {
//                if(first.charAt(i-1)!=second.charAt(j-1)){
//                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
//                }else{
//                    dp[i][j]=dp[i-1][j-1]+1;
//                }
//            }
//        }
//        //System.out.println(dp[l1][l2]);
//        if (Math.max(l1,l2)-dp[l1][l2]>=2) {
//            return false;
//        }else{
//            HashSet<String> set = new HashSet<>();
//            for (int i = 0; i <first.length() ; i++) {
//                set.add(String.valueOf(first.charAt(i)));
//            }
//            for (int i = 0; i <second.length() ; i++) {
//                set.add(String.valueOf(second.charAt(i)));
//            }
//            if(first.length()+second.length()-set.size() !=2){
//                return false;
//            }
//        }
//        return  true;
    }
}
