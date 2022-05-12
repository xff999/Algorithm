package ch03_shuzu;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

//对N个长度最长可达到1000的数进行排序。
public class ACM_1743 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextBigInteger()) {
            //这里的while 一定要加入，不然会出错
                int n = sc.nextInt();
                BigInteger bg[] = new BigInteger[n];
                for (int i = 0; i < n; i++) {
                    bg[i] = sc.nextBigInteger();
                }
                Arrays.sort(bg);
                for (int i = 0; i < bg.length; i++) {
                    System.out.println(bg[i]);
                }
            }
        }
    }
