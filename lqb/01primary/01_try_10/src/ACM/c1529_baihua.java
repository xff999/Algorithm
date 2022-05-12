package ACM;
//acm 1529 摆花的问题

import java.util.Arrays;
import java.util.Scanner;

/**
 * 分析题目，可以按照花的种类进行 分阶段动态处理，二维数组控制 种类，和放入的盆数
 *  一定注意下标的处理
 */
public class c1529_baihua {



    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        //System.out.println("输入花的种类 n 和 花的总数目m");
        int n=scanner.nextInt();
        int m=scanner.nextInt();

        int [] num =new int [n+1]; //存储每种能放几盆
        int [][] dp = new int [n+1][m+1];  //记录放的情况
       //行 表示能放的种类， 列 表示能放的个数
       // System.out.println("输入每种花对应的最大数目");
        for (int i = 1; i <n+1; i++) {
            num[i]=scanner.nextInt();
        }
        //如果 每种花都放 0，则他们的结果就是1
        for (int i = 1; i <=n ; i++) {
            dp[i][0]=1;
        }
     //先放只放第一种的情况
        for(int i=1;i<=m;i++){ //一直到小于总数，下面在判断是否足够花盆
            if(i<=num[1]){
                dp[1][i]=1; //可以把这种放入
            }
        }
        //开始判断其他 n-1 种 他们都依赖于上次放的情况
        for(int i=2;i<=n;i++){  //枚举放入的数组行
            for(int j=1;j<=m;j++){ //枚举放入的数组列
              for(int k=0;k<=num[i];k++) { //对每一种的从放入 1盆开始，到总数结束
                if(j>=k){ //能放的个数多于 还有的个数，可存放
                    dp[i][j]=dp[i][j]+dp[i-1][j-k];
                    dp[i][j] %=1000007;
                }
              }
            }
        }
//        for (int i = 0; i <dp.length ; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(dp[n][m]);
    }
}
