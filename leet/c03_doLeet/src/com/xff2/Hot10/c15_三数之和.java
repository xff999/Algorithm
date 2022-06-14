package com.xff2.Hot10;

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

public class c15_三数之和 {

    public static void main(String[] args) {

        int [] nums = {-1,0,1,2,-1,-4};
        //int [] nums = {};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        int len = nums.length;  //元素的长度
        for(int i = 0;i < len;++i) {
            if(nums[i] > 0) return lists;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int curr = nums[i];   //当前的位置
            int L = i+1; //第二个元素，当前的后一个，向后跳转
            int R = len-1; //第三个元素， 最后一个向前
            while (L < R) { //结束条件
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                     ++L;
                     --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
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

