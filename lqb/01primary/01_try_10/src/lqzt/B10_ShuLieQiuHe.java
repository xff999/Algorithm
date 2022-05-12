package lqzt;

import java.util.Arrays;

//第三题
// 给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和,
// 求 第 20190324 项的最后 4 位数字
//最后四位数字（也就是变相的告诉我们运算过程只和每个数的后四位有关系），那么我们只需要保留每次运算结果的后四位就OK了，这样绝对不会溢出。
public class B10_ShuLieQiuHe {
    public static void main(String[] args) {
        int a = 1, b = 1, c = 1;
        int s=1039;
        int m=(s+"").indexOf('2'); //求是否包含字符的
        System.out.println(m);
        // 要是求第四项，则i < 4, 同理推得求20190324，则i < 20190324。
        for (int i = 3; i < 20190324; i++) {
            int temp = (a + b + c) % 10000;
            a = b;
            b = c;
            c = temp;
        }
        System.out.println(c);

        //直接计算，结果是错的 ，int 不能存,BigInteger也不能存
//       int a[] = new int[3];
//        a[0]=1;
//        a[1]=1;
//        a[2]=1;
//        int stop=20190324
//       for(int i=4;i<=stop;i++){
//           int m=(i-1)%3;
//           if (m==0){
//               a[0]= a[0]+a[1]+a[2];
//           }
//           if (m==1){
//               a[1]= a[0]+a[1]+a[2];
//           }
//           if (m==2){
//               a[2]= a[0]+a[1]+a[2];
//           }
//       }
//       int n=(stop-1)%3;
//        System.out.println(a[n]);
    }
}
