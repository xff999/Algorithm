package ch03_shuzu;

import java.util.Scanner;

// 大数的表示 和整数的相乘
public class exp_18 {
    //大数用字符串表示，他是由高位到低位的存储方式，因为相乘有进位，所以先从末尾
    // 字符串的ASCII -48 = 数字值
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入一个字符串的大数");
        String s=scanner.next();
        System.out.println("输入一个整数");
        int num = scanner.nextInt();
        //执行计算，调用计算的函数，因为结果很大，就直接输出无返回；
        calculate(s,num);
    }

    public static void calculate(String s,int num){
        //先处理字符串的大数
        //i 控制数字的存储位置，j 控制在字符串的循环位置
        int n=s.length();
         int [] a =new int[n+10];  //数组共有字符串的长度 个，i控制位置
        int d=0; //每位运算的进位
        int b=0; //运算的结果
        for(int i=0,j=n-1;i<n; i++,j--){
            b=(s.charAt(j)-48)*num+d;
            a[i]=b%10;  //除去进位要存储的数字
            d=b/10; //下次的进位
        }
        while (d!=0){ //处理最后一个高位的情况
            a[n]=d%10;
            d=d/10;
            n=n+1;
        }
        //做反向输出，因为先存的是小数
        for(int i=n-1;i>=0;i--){
            System.out.printf("%d",a[i]);
        }
    }
}
