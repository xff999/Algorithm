package com.xff2.Hot20;

import java.util.Arrays;

/**
 * @author xff
 * @createTime 2022/6/21 21:22
在排序数组中查找元素的第一个和最后一个位置
  给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
  请你找出给定目标值在数组中的开始位置和结束位置。
   如果数组中不存在目标值 target，返回 [-1, -1]。
   你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]

输入：nums = [], target = 0
输出：[-1,-1]

 */

public class c34_找数组中的元素 {
    public static void main(String[] args) {
       int[] nums ={5,7,7,8,8,10};
       int target =8;
        int [] tal = searchRange(nums, target);
        System.out.println(Arrays.toString(tal));
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};

        int l = 0, r = nums.length - 1; //二分范围
        while( l < r)			        //查找元素的开始位置
        {
            int mid = (l + r )/2;
                //判断的中间比较条件
            if(nums[mid] >= target) r = mid;  //左边找
            else l = mid + 1;  //右边找，改 l
        }
        //退出循环 时，l=r  ，判断这个元素
        if( nums[r] != target) return new int[]{-1,-1}; //查找失败

        //查找成功，寻找元素范围 第二次的
        int L = r;
        l = 0; r = nums.length - 1;     //二分范围
        while( l < r)			        //查找元素的结束位置
        {
            int mid = (l + r + 1)/2;  //两次的条件不同
            if(nums[mid] <= target ) l = mid;  //向右边找
            else r = mid - 1;
        }
        return new int[]{L,r};

    }
}
