package com.xff.some;


/**
 * @author xff
 * @createTime 2022/5/12 14:33
 *
 * 使用动态规划，买卖股票的最佳时机
 *  设计数据结构，找出状态转移方程
 *prices[i] --> 第i 天的股票价格
 *  dp[i][j] ---> 第i天 j 状态 获利值
 *    j=0 本天没有股票   （dp 取值）  max( dp[i-1][0], dp[i-1][1]+prices[i])
 *           来源：  i-1本身没有股票  ， i-1有，以i天的价格买了，所获利润
 *    j=1 手中有股票    max( dp[i-1][1], -prices[i])
 *           来源 ：   前一天就有的，   以i 天的价格新买入的
 *    效率较慢
 *  =============================================================
 *  创建两个变量 一个记录，当前最小的值， 一个记录当前最大的差距
 *   循环遍历数组即可
 */
public class c_121_MaiGuPiao {
    public static void main(String[] args) {
    int[] prices = {7,1,5,3,6,4};

    int res = GuPiao2(prices);
        System.out.println(res);

    }
    //动归实现
    public static int GuPiao(int[] prices){
        if(prices.length<2){
            return 0; //天数小于2 直接返回，没有获利
        }
        int[][] dp = new int[prices.length][2];
        //初始化 第一天的 可能
        dp[0][0]=0; //第一天没有股票
        dp[0][1]=-prices[0]; // 第一天新买的股票，此时的获利

        //从第二天开始遍历
        for (int i = 1; i <prices.length ; i++) {
            dp[i][0]= Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }
        //每一步存储的都是当天最大的获利，
        return dp[prices.length-1][0];
    }

    //更高的效率，直接判断数组的大小间隔
    public static int GuPiao2(int[] prices){
        if(prices.length<2){
            return 0; //天数小于2 直接返回，没有获利
        }
        int minNumb = prices[0];
        int maxD=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minNumb){  //当前元素 比最小值  小，更新最小值
                minNumb=prices[i];
            }else{  // 当前元素比最小值大 ， 看看是否可以更新  最大差距
                maxD=Math.max(maxD, prices[i]-minNumb);
            }
        }
        return maxD;
    }

}
