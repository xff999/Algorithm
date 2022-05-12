package ALGO;

import java.util.Arrays;
import java.util.Scanner;

/**
 *一串数，随便拿一些，得到一个数，再随便拿一些，要使得他们是相同的
 *  那么最大可达到多大？   题目给的规模很小可以使用 暴力搜索
 */

public class c1004_WuLiaoDeDou {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n=scanner.nextInt(); //输入的数量
        int []arr= new int[n];
        int total=0;
        for (int i = 0; i <n ; i++) {
            arr[i]=scanner.nextInt();
            total+=arr[i];
        }
        total=total/2; //要组成两部分，所以最大 可能比这个数小
        Arrays.sort(arr); //对数组进行排序



    }
}
