package ACM;

public class c1566ChiDanGao {
	public static void main(String[] args) {
		int m=10;  //达到的美食度
		int n =2 ;//拥有的美食种类
		int []du= {4,2};  //两个商品的各自美食度
		int []num= {1,10};  //两个商品的个数
		
		//动态规划思想，或者贪心
		
		//动态  分阶段，要存储上阶段的结果，
		int [][] result=new int [n+1][6] ;  //对于每个商品的取得 个数，得到的美食度
		for(int i=1;i<=n;i++) {
			for(int j=1;j<result[0].length;j++) {
			  if(num[i-1]>0) {
				   int max1=result[i-1][j];
				   int mxa2=du[i-1]+result[i][j-1];
				   if(mxa2>max1){
				   	num[i-1]=num[i-1]-1;
				   }
				   result[i][j]=result[i][j]+Math.max(max1, mxa2);
			     }
			   else
				   result[i][j]=result[i][j-1];
			}
		}
		int k=0;
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[0].length;j++) {
				//System.out.printf("%3d",result[i][j]);
				if(result[i][j]==m){
					k=j;
				}
			}
			//System.out.println();
		}
		System.out.println(k);
	}

}
