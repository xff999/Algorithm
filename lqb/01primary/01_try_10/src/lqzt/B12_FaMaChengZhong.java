package lqzt;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

//砝码称重 能够称的可能个数
public class B12_FaMaChengZhong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      //  System.out.println("输入砝码的种类 N");
        int N=scanner.nextInt();
        int []w =new int[N+1];
        int total=0; //表示能够称出的总重量
      //  System.out.println("输入砝码每个的重量");
        for (int i = 1; i <=N ; i++) {  //下标从1 开始的
            w[i]=scanner.nextInt();
            total+=w[i];
        }

        boolean dp[][]=new boolean[2][total+1];
        //创建数组，第一行表示 能够称出的重量，1——total,存储的值表示是否能称出，
        //第二行，表示 上次能成出的 重量，临时变量
        dp[0][w[1]]=true ; //第一个砝码能成出的；

        for(int i=2;i<=N;i++){  //循环每个砝码,从第二个开始
          for(int j=1;j<=total;j++) {   //判断能够称出的状态
              if (dp[0][j]) { //j 这个重量能被称出
                  //可以计算 前面上次称出的和这次称出的，总共表示
                  int now1 = Math.abs(w[i]-j);
                  int now2 =w[i]+j;
                  //设置数组标志
                  dp[1][w[i]]=true;  //本身的重量
                  dp[1][now1]=true;
                  dp[1][now2]=true; //存储临时的
              }
            }
          //当这个砝码，表示完成之后，放入第一行，表示能够称出的
            for(int k=1;k<=total;k++){
                if(dp[1][k]){
                    dp[0][k]=true;
                }
            }
        }
        int count=0;
        for (int i = 1; i <=total ; i++) {
            if(dp[0][i]){
                count++;
            }
        }
      //  System.out.println(Arrays.toString(dp[0]));
        System.out.println(count);
    }
}
