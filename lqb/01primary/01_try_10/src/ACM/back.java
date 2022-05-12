package ACM;

import java.util.Scanner;

public class back {


    //与利润有关的   部分背包，（可以把商品拆开装入）
    /*
     * 问题4：一个商人带着能装入m 千克的背包去收购货物，准备在去城里卖 了获利
     *     现在有n中货源  且第i种货物 有 wi千克 可以获利  pi元  ，编写算法所得利润最大
     *   思路：采用贪婪算法 局部最优以此达到全局最优
     *      引文商品是可以分开任意小部分的 ，每次选择利润比最大的装入背包 获得最高利润
     */
        public static void main(String[] args) {
            Scanner scanner= new Scanner(System.in);

            int m,n;  //背包容量m ，n种商品
            System.out.println("输入背包容量m ，n种商品");
            m=scanner.nextInt();
            n=scanner.nextInt();
            int []w=new int[n+1];  //每种商品重量
            int []p=new int[n+1];  //每种商品利润
            int []p1=new int[20];  //存放临时数据 用来做交换时使用
            int []b=new int[5];   //根据性价比 把商品按顺序放入
            int totalw = 0;   //总重量
            int max=0;  //单位重量利润最大的 商品号

            System.out.println("输入每种商品重量");
            for(int i=1;i<=n;i++) {
                w[i]=scanner.nextInt();
                totalw=totalw+w[i];  //累加所有判断能否全部装入
            }
            System.out.println("输入每种商品jiazhi");
            for(int i=1;i<=n;i++) {
                p[i]=scanner.nextInt();
                p1[i]=p[i];  //做利润的数组备份 下面好使用
            }
            if(totalw<=m) {
                System.out.println("全部装入");
                return ;
            }

            //根据选择排序 ，按照单位重量得到性价比  商品顺序放入b[]数组
            for(int i=1;i<=n;i++)
            {
                System.out.println("i="+i);
                //循环每个商品
                max =i;  //假设性价比最高为第一个
                for(int j=i+1;j<=n;j++) {
                    System.out.println("j="+j);
                    if((p1[j]/w[j]) > ( p1[max]/w[max])) {
                        //循环的下一个比这个大
                        max=j;
                        b[i]=j;   //给商品排序 下标放入b[i]
                        p1[max]=0 ;  //把这个临时数组已经比较的数组置为0


                    }

                }
                System.out.println("max="+max);
                System.out.println("b="+b[i]);
            }

//		    for(int k=1;k<=n;k++) {
//				System.err.println("重量"+w[k]+" li"+p[k]);
//				System.out.println("排序后的下标"+b[k]);
//
//			}

            int i; //表示加到的商品下标
            //累加商品直到  总重量超过m
            for(i=1,totalw=0; totalw<m && i<n;i++) {
                totalw=totalw+w[b[i]];
            }
            //for之后 肯定是超出m  i也是加了1  然后  把超出的部分去掉
            if(totalw!=m) {
                w[b[i-1]]=m-(totalw-w[b[i-1]]);
            }
		 //把结果输出
		 for(int j=1;j<=i-1;j++) {

			 System.out.println("选择了第"+b[j]+"商品重量为"+w[b[j]]);

	 }



        }

    }

