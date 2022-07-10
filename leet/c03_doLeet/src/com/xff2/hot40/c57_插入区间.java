package com.xff2.hot40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author xff
 * @createTime 2022/7/7 21:37

 给你一个无重叠的  按照区间起始端点排序的区间列表。
 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠
（如果有必要的话，可以合并区间）。

输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]
 
输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

输入：intervals = [], newInterval = [5,7]
输出：[[5,7]]

输入：intervals = [[1,5]], newInterval = [2,3]
输出：[[1,5]]

输入：intervals = [[1,5]], newInterval = [2,7]
输出：[[1,7]]
 */

public class c57_插入区间 {


    public static void main(String[] args) {
        int [][] arr = {  {1,2}, {3,5} , {6,7} , {8,10}, {12,16} };
        int [] newIn = {4,8};
        int[][] tatol = insert(arr,newIn);
        for (int i = 0; i <tatol.length ; i++) {
            System.out.println(Arrays.toString(tatol[i]));
        }
    }


    //主要思路就是 分三段判断 它是否和新数组哟重复的，原数组本身就是有序的，遍历寻找即可
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList< int [] > result = new ArrayList<>();
          //创建集合用来保存结果。它存储的是已经合并好的
        int len = intervals.length;
        //判断这个左边 和新数组的大小，是否可重,
         //不重复直接添加进入 结果集，然后找到重复的位置，进行合并
        int i=0; //当前所在的位置下标
        while ( i< len && intervals[i][1] <newInterval[0]){
             //当前的位置，和要添加的进行比较，看是否重复
            result.add(intervals[i]); //不重复添加进入结果集
            i++;
        }
       //跳出 while之后，i 就是重复的开始，进行比较每个位置的大小m
      while ( i<len && intervals[i][0] <= newInterval[1]){
             //数组的开始，和要添加的结束比较
          //更新要添加的数组的 起尾值
          newInterval[0] = Math.min(intervals[i][0], newInterval[0]); //取小的
          newInterval[1] = Math.max(intervals[i][1], newInterval[1]); //结尾取最大的
          i++;
      }
      result.add(newInterval);
    //i结束重复的之后，添加进入合并后的 ,后面是不重复的

      while (i<len ){ //直接添加
          result.add(intervals[i]);
          i++;
      }

        return  result.toArray( new int[0][]);
                      //结果要有 转换

    }


}
