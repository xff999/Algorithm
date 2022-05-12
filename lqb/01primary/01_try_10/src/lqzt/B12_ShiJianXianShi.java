package lqzt;

import java.math.BigInteger;

import java.util.Scanner;

//表示时间显示 的格式
//给定的毫秒数，距离1970年的数字，展示出，时分秒的格式
  //先得到天数，取余 计算时分秒
//这里主要是，使用BigInteger类,进行运算
public class B12_ShiJianXianShi {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         BigInteger num= scanner.nextBigInteger();
         BigInteger dtime =new BigInteger(String.valueOf(24*60*60*1000));
         BigInteger days =num.remainder(dtime); //得到天数的 余数

         // 先算出一个小时有多少毫秒,计算剩余的毫秒数有多少个小时，取商也取余
         BigInteger hours0 = days.divide(new BigInteger("3600000"));  // 取商，计算有多少小时
         BigInteger hours1 = days.remainder(new BigInteger("3600000")); // 取余，用于计算有多少分钟和秒
         // 算出一分钟多少毫秒，取商为分，取余计算秒数
         BigInteger minutes0 = hours1.divide(new BigInteger("60000")); // 取商，用于计算有多少分钟
         BigInteger minutes1 = hours1.remainder(new BigInteger("60000")); // 取余，用于计算有多少秒

         // 1秒=1000毫秒，取商得到秒数
         BigInteger seconds = minutes1.divide(new BigInteger("1000"));

         String strDateTime=
                 String.format("%02d", hours0)+":" +
                         String.format("%02d", minutes0) +":" +
                         String.format("%02d", seconds);
         System.out.println(strDateTime);
     }
}
