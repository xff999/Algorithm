package com.xff2.hot40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author xff
 * @createTime 2022/7/6 21:55
 *
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

 */
public class c56_合并区间 {
    public static void main(String[] args) {
        int [][] arr = {  {1,3}, {2,6} , {8,10} , {15,18} };
        int[][] tatol =  merge(arr);
        for (int i = 0; i <tatol.length ; i++) {
            System.out.println(Arrays.toString(tatol[i]));
        }
    }


    public static int[][] merge(int[][] intervals) {
        LinkedList <int []> result =new LinkedList<>();
           //创建双向链表用来保存结果。它存储的是已经合并好的
        //对二维数组进行排序，根据元素的第一个的大小
        Arrays.sort(intervals, new Comparator<int[]>() {
               @Override  //自定义排序规则
               public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
               }
             });
        //(o1, o2) -> Integer.compare(o1[0], o2[0])
         //也可以替换 lamdba 表达式的形式

        result.add(intervals[0]) ; //把第一个数组放进去，用来下次的判断使用
              //此时只有一个元素，他
        //遍历剩下的 数组，判断是否要合并
        for (int i = 1; i < intervals.length ; i++) {
              //结果集合的 后一个，与这个要添加进入的第一个进行比较
              int [] end_res = result.getLast();
             if (end_res[1] >= intervals[i][0]){
                 //表示已经重复了
               int start = end_res[0]; //合并后的 起始
               int end = Math.max(end_res[1],intervals[i][1]); //比较那个大
               //移除结果集中的最后一个要 和这个元素 合并的，
                result.removeLast();
               //添加这个合并后的元素
                result.add(new int[]{start,end});
             } else {
                //不重复，直接添加进入这个元素
                result.add(intervals[i]);
            }
         }

     return result.toArray(new int[result.size()][]);
    }


}
