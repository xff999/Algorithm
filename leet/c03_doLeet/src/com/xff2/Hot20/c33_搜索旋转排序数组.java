package com.xff2.Hot20;

/**
 * @author xff
 * @createTime 2022/6/20 21:14

整数数组 nums 按升序排列，数组中的值 互不相同 。

  在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
     使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
     下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，
     则返回它的下标，否则返回 -1 。你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1

输入：nums = [1], target = 0
输出：-1

 */


public class c33_搜索旋转排序数组 {
    public static void main(String[] args) {
        int []nums = {4,5,6,7,0,1,2};
        int target = 3;
        System.out.println(search(nums,target));
    }


    //直接for遍历  但是时间复杂度 o(n)  不符合要求  o(log n)
      //查找log n --> 使用 二分查找
    public  static int search(int[] nums, int target) {
        int len = nums.length;  //长度
        int left = 0, right = len-1; // 左右下标
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
             //比二分法 多了一个 判断它是否是有序的还是无序的
            else if(nums[mid] < nums[right]){  //中间 小于 右边的 右边有序的
                if(nums[mid] < target && target <= nums[right])  //判断下次在那边寻找
                    left = mid+1;         //在右边找
                else
                    right = mid-1;  //下次再左边找
            }
            else{  //右边是无序的 ，左边有序，在左边找
                if( target >=nums[left] && target < nums[mid])
                    right = mid-1;  //比左边大 ，向前移动
                else
                    left = mid+1;
            }
        }
        return -1;
    }

    /*public  static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    } */
}
