package lqzt;

import java.util.Arrays;
import java.util.Scanner;

// Ai 个同学，他刷的题目 个数，大于他的人数，不超过小于他的人数
//  抽象--> 排序， --->分奇偶数 --->判断排名，-->加数；
//奇数，本学生排名 N/2+1 ； 偶数个学生 --> N/2;

// 找个中间的数，在比较即可，无需按数组输出
//每次比较一个输出一个
public class B13_D最少刷题数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int N= scanner.nextInt();
         int[] arr = new int [N];
         int[] res = new int [N];
        int[] temp = new int [N];; //用来保存初始值
        for (int i = 0; i <N ; i++) {
            arr[i]=scanner.nextInt();
            temp[i]=arr[i];
        }

        System.out.println(Arrays.toString(temp));

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int p = N/2;
        if(N%2==1){
            p=p+1;
            for (int i = 0; i <N ; i++) {
                if(arr[p-1]-arr[i]>0)
                    res[i]=arr[p-1]-arr[i]+1;
                else
                    res[i]=0;
            }
        }else {
            for (int i = 0; i < N; i++) {
                if (arr[p] - arr[i] > 0)
                    res[i] = arr[p] - arr[i] + 1;
                else
                    res[i] = 0;
            }
        }
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j < N; j++) {
                if(temp[i]==arr[j]){
                    System.out.printf(res[j]+" ");
                }
            }
        }

//        System.out.println(Arrays.toString(res));
    }
}
