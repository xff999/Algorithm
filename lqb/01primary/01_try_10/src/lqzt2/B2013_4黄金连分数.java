package lqzt2;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.math.BigDecimal.ROUND_HALF_DOWN;

/**
 * @author xff
 * @createTime 2022/5/12 19:41
 *
 *   黄金连分数
 *    1
 * -------------  ===>  +1  找规律  ===》斐波那契数列
 *        1
 *  1+  -------
 *          1
 *      1+-----
 *
 *         1+ ....
 *
 *   1 1 2 3 5 8 13 21 34 ....
 *  精确到 100位小数 （  问题？ 到多少项？  n/n+1 --》 n 在往上增长，小数点的 101位是不变的
 *                          数字怎么存储
 *
 * 主要调用 api 的熟悉程度，不同类型的转换
 *   BigInteger 整数形式的
 *   BigDecimal 小数形式的
 */

public class B2013_4黄金连分数 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger(String.valueOf(1));
        BigInteger b = new BigInteger(String.valueOf(1));
        for (int i = 3; i <400 ; i++) {
            BigInteger t =b;
            b=a.add(b);
            a=t;
        }
        BigDecimal a1 = new BigDecimal(a,110);
        BigDecimal b1 = new BigDecimal(b,110);

        BigDecimal str = a1.divide(b1, ROUND_HALF_DOWN);

        String s = str.toString().substring(0,103);
        System.out.println(s);

    }
}
