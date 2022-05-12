package lqzt;

import java.math.BigInteger;

public class B13_A星期计算 {
    public static void main(String[] args) {
        BigInteger big = new BigInteger(String.valueOf(20));
        BigInteger num = big.pow(22);
        BigInteger total = num.mod(BigInteger.valueOf(7));
        System.out.println(total);
    }
}
