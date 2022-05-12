package ch03_shuzu;

import java.math.BigInteger;
import java.util.Scanner;

//直接使用Java提供的 类型表示数字
public class exp_18_ {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入一个字符串的大数");
        BigInteger s= scanner.nextBigInteger();
        System.out.println("输入一个整数");
        BigInteger num = scanner.nextBigInteger();
        BigInteger out = s.multiply(num);
        // 他的乘除计算 是通过他自己提供的方法调用 得到的
        System.out.println(out);
    }
}
