package com.xff2.hot40;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案

 输入：nums = [1,2,3]
 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 输入：nums = [0,1]
 输出：[[0,1],[1,0]]

 输入：nums = [1]
 输出：[[1]]
 */
// 全排列 --> 回溯的算法 (dfs)
public class c46_全排列 {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> lists = permute(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  lists = new ArrayList<>();
        int len =nums.length;
        if (len ==0){
            return  lists;
         }
        boolean [] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums,0,path,used,lists);
        return  lists;
    }

      //使用dfs
    public static void dfs(int[] nums , int depth , //构建的原数组 ， 当前深度
                           List<Integer> path , //当前遍历的 路径
                           boolean [] used ,  // 元素是否使用的标志
                           List<List<Integer>> lists){  //总的返回结果
        //判断
        if(depth ==nums.length) {  //已经找到一个深度相同的
            lists.add(new ArrayList<>(path)); //当前的路径结果，添加到结果集中
                 //注意这个返回的是，新创建的 集合，带有原来的数据，不然结果会出错
            return;
          }
        //依次判断，这个结点可以存放哪些元素
        for (int i = 0; i <nums.length ; i++) {
            if(!used[i]){  //这个元素没有被使用过
                path.add(nums[i]); // 使用这个元素
                used[i] = true ; //置为已使用
                //调用下一层的
                dfs(nums,depth+1,path,used,lists);

                //结束调用时，这层会产生回溯
                used[i] = false;
                path.remove(path.size()-1) ; //移除这个元素
            }
        }

    }



}
