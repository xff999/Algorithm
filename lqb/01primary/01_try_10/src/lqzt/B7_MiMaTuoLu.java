package lqzt;

import java.util.Scanner;
 //第七届密码脱落，
public class B7_MiMaTuoLu {

//主要侧重递推的动态规划，找到递推的公式，有具体到抽象，得到公式
//这主要注重递推关系的推出
        static int [][]c =new int [10][10];
        static char a[] =new char[10];
        static char b[] =new char[10];
        static char str[] =new char[10];
        static  int total=0;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入A字符串：");
            String A= scanner.next();
           // System.out.println("输入B字符串：");
            //String B= scanner.next();
            String B=reverse1(A);
            total=A.length();
            System.out.println(A);
            System.out.println(B);
             a =A.toCharArray();
             b =B.toCharArray();

            //int [][]c =new int [A.length()][B.length()]; 设为全局
//         //创建c 数组，存储数字，表示相等的位置；

            int C= Str_len(A.length(),B.length()); //调用求长度的函数，得到数组的具体值

            System.out.println("公共的长度"+C);
            System.out.println("公共的字串为");
            Str_build(C, A.length(), B.length());
            for (int i = 0; i < str.length; i++) {
                if(str[i]!=0){
                    System.out.print(str[i]);
                }
            }
            System.out.println("脱离"+(total-C));

        }

     // StringBuffer  反转字符串函数
     public static String reverse1(String str) {
         return new StringBuilder(str).reverse().toString();
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


