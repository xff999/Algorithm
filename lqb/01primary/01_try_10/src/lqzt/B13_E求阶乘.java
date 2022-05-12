package lqzt;
import java.util.Scanner;

//1--x!  找2和5的个数( 或者对5 的倍数）取二者见最小的。2 一定比5 多
//所以找 5 及其倍数  的个数
//二分法，x! 这个数字  5^i  i--<1-k>    求和 x!/5^i ==k
public class B13_E求阶乘 {

    static long k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextLong();
        long m = 1;
        for (long i = 1; i <= k; i++) {
            m = m * 10;
        }

    }
}


//    public static boolean pd(long num){
//        long total=1;   //num 判断这个数的阶乘，是否有k 个0
//        for(long j=1;j<=num;j++){
//            total=total*j;
//        }
//        long max=0;
//        String str = total+"";
//        long start = str.length();
//        long x= total%10;
//        while(x==0){
//            total=total/10;
//            x=total%10;
//        }
//        String end =total+"";
//        long strend = end.length();
//        if ((strend-start)==k){
//            return true;
//         }
//        return false;
//    }}

