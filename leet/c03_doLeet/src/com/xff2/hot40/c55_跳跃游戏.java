package com.xff2.hot40;


import java.util.Map;

/**
 * @author xff
 * @createTime 2022/7/6 21:24
给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标。给定一个非负整数数组 nums ，

输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

 */
public class c55_跳跃游戏 {
    public static void main(String[] args) {
//      int [] arr = {2,3,1,1,4};
        int [] arr = {3,2,1,0,4};
      boolean flag  = canJump(arr);
        System.out.println(flag);
    }

    // 他要跳的最大位置，则他跳这个数的前面，也全部都能可以跳到的
    // 遍历每次的位置，看是否能跳到最后的位置，一直不停
    // 主要判断分析每步的位置，和怎么判断能到达的公式
    public static boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }

        int k =0 ; //前面 n-1 个元素， 所能跳的最大位置
        //遍历这个能跳的位置，看是否能到最后
        for (int i = 0; i <=k ; i++) {
             //遍历跳这个 k 前面的位置，找最值
            int temp = i +nums[i]; //i 这个位置，下次能跳 i +nums[i]的步数
            //此时，更新最值
            k = Math.max(k,temp);

            //看能跳的是否超过 最后一个元素
            if( k>= nums.length-1){  //因为下标使用的是 0 开始的
                return true;
            }

        }
        //跳出循环之后， 没跳出，就是不能跳了
        return false;
    }
}
