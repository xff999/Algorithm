package lqzt;

//杨辉三角，求整数N,第一次出现，是在第几个数

import java.math.BigInteger;
import java.util.Scanner;

public class B12_YangHuiSanJiao {
    static int N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      //   System.out.println("输入要查找的整数 N");
         N=scanner.nextInt();
        for (int i = 16;  ; i--) {
            if(check(i))
                break;
        }
    }

    //计算C(a,b)的函数
    public static BigInteger Cab(int a,int b){
        BigInteger res = BigInteger.valueOf(1);

        for(int i=a,j=1; j<=b ; i--,j++){
            res=res.multiply(BigInteger.valueOf((i/j)));

            if(res.compareTo(BigInteger.valueOf(N))>0){
                return res;
            }
        }
        return res;
    }

    public static boolean check(int k){
        //二分该斜行，在这个斜行里面找值
        //k 指的是第 k 斜行，找到 第一个值要大于要找的数
        int l= 2*k;   //左边界2k ,右边界 max(l,N),再找的数和左边界求最大
        int r=Math.max(l, N);
        while(l<r){
            int mid =(l+r)/2;  //在这个该斜行里面找值
            if(Cab(mid, k).compareTo( BigInteger.valueOf(N))>=0){
                r=mid;
            }else l=mid+1;
        }
        if(Cab(r,k).compareTo(BigInteger.valueOf(N))!=0){
            return false;
        }
        System.out.println(BigInteger.valueOf( (r*(r+1)/2) +k+1));
        return true;
    }
}
