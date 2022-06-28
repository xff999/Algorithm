package com.xff2.Hot20;


/**
 * @author xff
 * @createTime 2022/6/20 21:26

给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，
    可以接 6 个单位的雨水（蓝色部分表示雨水）

输入：height = [4,2,0,3,2,5]
输出：9

 */





public class c42_接雨水 {
    public static void main(String[] args) {
      int [] height = {0,1,0,2,1,0,1,3,2,1,2,1} ;
      //  System.out.println(trap(height));
    }

    //解法三: 动态规划
//我们注意到，解法二中。对于每一列，我们求它左边最高的墙和右边最高的墙，
// 都是重新遍历一遍所有高度，这里我们可以优化一下。

    /*
    首先用两个数组，max_left [i] 代表第 i 列左边最高的墙的高度，max_right[i] 代表第 i 列右边最高的墙的高度。
    （一定要注意下，第 i 列左（右）边最高的墙，是不包括自身的，
对于 max_left我们其实可以这样求。
max_left [i] = Max(max_left [i-1],height[i-1])。
它前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了。
对于 max_right我们可以这样求。
max_right[i] = Max(max_right[i+1],height[i+1]) 。
它后边的墙的右边的最高高度和它后边的墙的高度选一个较大的，就是当前列右边最高的墙了。
这样，我们再利用解法二的算法，就不用在 for 循环里每次重新遍历一次求 max_left 和 max_right 了。
     */
    public int trap(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }


    //2.按列求
  /*  public int trap(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {  //墙到哪，正在求的
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }*/


    //大数据会超出时间限制
//    1. 按行求
  /* //   相当于 直接暴力， 按照 水的高度 （每行）来求， ---》 1,2,3,....
//    如果求高度为 i 的水，首先用一个变量 temp 保存当前累积的水，初始化为 0。
//    从左到右遍历墙的高度，遇到高度大于等于 i 的时候，开始更新 temp。
//    更新原则是遇到高度小于 i 的就把 temp 加 1，遇到高度大于等于 i 的，
//    就把 temp 加到最终的答案 ans 里，并且 temp 置零，然后继续循环。

    // 水行i   temp水数量   遇到 墙 >= i 开始准备更新
    //   墙 <= i    temp +1
    //再遇见 墙 >=i  temp 加入到ans
    public static int trap(int[] height) {
        int sum = 0 ;
        int max = getMax(height);//找到最大的高度，以便遍历。

        for (int i = 1; i <= max; i++) { //水的高度 行
            boolean isStart = false; //标记是否开始更新 temp  标志
            int temp_sum = 0; //当前连续的获值
            for (int j = 0; j < height.length; j++) {  //遍历所有的高度
                if (isStart && height[j] < i) {
                    temp_sum++;
                }
                if (height[j] >= i) {
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }
    private static  int getMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    } */


}
