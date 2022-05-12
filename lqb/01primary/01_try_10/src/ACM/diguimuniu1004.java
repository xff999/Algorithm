package ACM;

import java.util.Scanner;

public class diguimuniu1004 {

    //递归找规律

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("输入年份数组形式：");
        String s = scanner.nextLine();
        String[] str = s.split(" ");
        int n = 0;
        for (String data : str) {
            n++;
        }
        for (int i = 0; i < n; i++) {

        }
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(str[i]);
        }
        int m=0;
        while (a[m]!= 0) {
            int num= fun1(a[m]);
            System.out.println(num);
            m++;
        }
        }

    public static int fun1(int n) {
        if(n<5){
            return n;
        }
        else
            return fun1(n-1)+fun1(n-3);
    }
}




