package ALGO;


import java.util.Arrays;
import java.util.Scanner;

/**‎有一个背包，容量为M。 有N种物品，每种物品有其体积Wi与价值Vi。
   将这些物品的一部分放入背包，每种物品可以放任意多个，要求总体积不超过容量，且总价值最大。‎

 * 0/1 背包问题，每个物品可以选与不选，枚举
 * 数组存储，val[i][j]  前i 个装j 达到的最大价值
 */
public class c857_BeiBao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("输入物品个数");
        int N=scanner.nextInt();
       // System.out.println("输入背包容量");
        int M=scanner.nextInt();
        int []w=new int[N+1];
        int []v=new int[N+1];  //下标使用从 1 开始
       // System.out.println("输入每个重量，及价值");
        for (int i = 1; i < w.length ; i++) {
            w[i]=scanner.nextInt();
            v[i]=scanner.nextInt();
        }
        //开始对每一个 进行选择，二维数组，存储找到的最大价值
        // 物品个数，和背包容量  ,可以选多次的，

        int [][]val = new int[N+1][M+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j <=M; j++) {
                for (int k=0;k*w[i]<=M;k++) {  //k表示选的个数
                    if ( k*w[i]  >j ) {  //不能装入  k*如果删除，表示一个物品只能使用一次
                        val[i][j] = val[i - 1][j]; //等于装入前i-1个的最大价值
                    } else {
                        val[i][j] = Math.max(val[i - 1][j], val[i - 1][j - k*w[i]] + k*v[i]);
                    }
                }
            }
        }
        System.out.println(val[N][M]);
//        for (int i = 0; i < N+1; i++) {
//            System.out.println(Arrays.toString(val[i]));
//        }
    }
}
