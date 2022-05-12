package ACM;

import java.util.Arrays;
import java.util.Scanner;

public class c九届四题 {
	public static void main(String[] args) {
		
	    Scanner in= new Scanner(System.in);
		int m,N;  //m个手机  N层楼高 ，采用动态规划
		          //根据手机个数决定策略 ，如果大于一个手机，第一个可以随机取一层
		          //丢下去，这个层 k 为 1-N中可能
		System.out.println("输入手机个数 ，楼层高度");
		m=in.nextInt();
		N=in.nextInt();
	
		 int [][]  arr= new int [m+1][N+1];
		 for(int i=1;i<=m;i++) {
			 for(int j=1;j<=N;j++) {
				  if(i==1) {
					  arr[i][j]=j; //一个手机时，有多少层最多仍多少次
				 } //大于一个时，根据前一个的扔出的位置决定
				 else {
					   
			     	arr[i][j]=j;  //先初始化一个值，在判断最佳策略的时候
					 for(int k=1;k<=N;k++) {
			     		 int  no = 1+arr[i][N-k]; //如果在k 层没有坏 ，手机数不减少 在k 上面测				           
				         int yes= 1+arr[i-1][k-1];// 手机坏了 ，在下面寻找				         
				         int num = Math.max(no, yes);  	    
				             //最坏的运气，所以求最大,这是这个策略的结果	;
 
				         if(num<arr[i][j]) {
				        	 //在这么多的策略找一个  最佳的  次数最少的 ，
				        	 arr[i][j]=num;
				         }         
				 } 				 		          			
		      } 
			 }
		 }
		
		 for(int i=0;i<=m;i++) {
			 System.out.println(Arrays.toString(arr[i]));
		 }
		 System.out.println(arr[m][N]);
	}
}