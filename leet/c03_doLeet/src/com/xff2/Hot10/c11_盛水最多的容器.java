package com.xff2.Hot10;

import java.util.Map;

/**
 * @author xff
 * @createTime 2022/6/13 20:02
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，
 * 第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。

输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，
   容器能够容纳水（表示为蓝色部分）的最大值为 49。

 *
 */

//使用双指针 两边判断值，进行比较 循环
    //记录最大值，和下次比较

public class c11_盛水最多的容器 {

    public static void main(String[] args) {
        int [] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));

    }

    public  static int maxArea(int[] height) {
        int sta = 0; //前面的指针
        int end = height.length-1;  //后面的指示
        int max = 0;  //最大值，
        while(sta < end){
            max = Math.max(max,(end-sta)* Math.min(height[sta],height[end]));
            // 行 ，  高（取小的）
            if(height[sta] <height[end]){
                sta++;  //判断 移动哪一边的值
            } else {
                end--;
            }
        }

        return max;
    }

}
