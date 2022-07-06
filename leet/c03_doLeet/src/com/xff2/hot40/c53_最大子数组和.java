package com.xff2.hot40;

/**
 * @author xff
 * @createTime 2022/7/6 21:01
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组
 （子数组最少包含一个元素），返回其最大和。
  子数组 是数组中的一个连续部分。

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

输入：nums = [5,4,-1,7,8]
输出：23
 */
public class c53_最大子数组和 {
    public static void main(String[] args) {
   // int [] arr ={-2,1,-3,4,-1,2,1,-5,4};
        int [] arr ={5,4,-1,7,8};
        System.out.println(maxSubArray(arr));
    }

     //主要找 状态转移，分析
    public static int maxSubArray(int[] nums) {
       //使用dp 数组，判断这个是否比上次的大
        int [] dp = new int[nums.length];
                  //  dp[i]：表示以 nums[i] 结尾 的 连续 子数组的最大和。
        dp[0]=nums[0];
        for (int i = 1; i <nums.length ; i++) {
             //判断上个结束时的值，是否是<0 的  若是，则直接重新复制，从当前开始，
            if (dp[i-1] > 0 ){
                dp[i] = dp[i-1]+nums[i];
            } else{
                dp[i] =nums[i];
            }
         }
        // 也可以在上面遍历的同时求出 res 的最大值，这里我们为了语义清晰分开写，大家可以自行选择
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
