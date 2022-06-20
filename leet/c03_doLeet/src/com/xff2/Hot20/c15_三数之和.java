package com.xff2.Hot20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author xff
 * @createTime 2022/6/13 20:24
 *给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]

输入：nums = []
输出：[]
 */

//  排序 + 双指针  （难点在于如何去除重复解。）
 /**
  * @author xff
  * @createTime 2022/6/13 20:44
  * 1特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []
  * 2对数组进行排序。
  * 3遍历排序后数组：
  *   a若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
  *   b对于重复元素：跳过，避免出现重复解
  *   c令左指针 L=i+1，右指针 R=n-1，当 L<R 时，执行循环：
  *        当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，
  *             去除重复解。并同时将 L,R移到下一位置，寻找新的解
  *        若和大于 0，说明 nums[R] 太大，R 左移
  *        若和小于 0，说明 nums[L] 太小，L 右移
  *
  *
  */
 // 注意 i++ 和 ++i  ，处理特殊情况，要在减少前

public class c15_三数之和 {

    public static void main(String[] args) {

        //int [] nums = {-1,0,1,2,-1,-4};
        int [] nums = null;
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
         Arrays.sort(nums); //排序数组
        int len = nums.length;
        //遍历每个元素 ，在元素内部处理
        for (int i = 0; i < len ; ++i) {
            if(nums[i]> 0) return lists; //第一个都等于0 直接返回
            if(i>0 && nums[i]==nums[i-1]) continue; //当前和前面相同，跳过避免重复

            int cur = nums[i]; //定义当前值
            int l=i+1; //下一个
            int r=len-1; //第三个，从后面循环
            while (l<r){
                //判断是否能得到结果
                int temp =cur+nums[l]+nums[r];
                if(temp ==0){
                    //创建集合放入数字
                    List list = new ArrayList();
                    list.add(cur);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    lists.add(list); //放入结果集
                   //移动双指标
                    //处理特殊的相同情况   处理特殊情况，要在减少前
                    while(l < r && nums[l+1] == nums[l]) ++l; //取消重复的元素
                    while (l < r && nums[r-1] == nums[r]) --r;  //条件移动
                    ++l;
                    --r;

                } else if(temp <0){ //左边的取数 较小
                    ++l;
                } else {
                    --r;
                }
            }

        }
        return lists;
    }
}

      //三重循环
//        if(nums.length>3) {
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    for (int k = j + 1; k < nums.length; k++) {
//                        if (nums[i] + nums[j] + nums[k] == 0) {
//                            listc.add(nums[i]);
//                            listc.add(nums[j]);
//                            listc.add(nums[k]);
//                            break;
//                        }
//                    }
//
//                }
//                list.add(listc);
//            }
//        } else {
//          listc.add(null);
//        }
//

