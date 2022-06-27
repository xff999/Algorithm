package com.xff2.Hot20;


import java.util.*;

/**
 * @author xff
 * @createTime 2022/6/20 21:24

给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 
 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
  对于给定的输入，保证和为 target 的不同组合数少于 150 个。

输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
解释：
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。

输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]

输入: candidates = [2], target = 1
输出: []

 */

// dfs 深度遍历的方式   以target 减去 元素，注意去重


public class c39_组合总和 {
    public static void main(String[] args) {
     int [] candidates = {2,3,6,7};
     int target = 7;
        System.out.println(combinationSum(candidates, target));

    }

    public  static List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>>  lists = new ArrayList<>();

        // 排序是剪枝的前提
        Arrays.sort(candidates);

         if(candidates.length==0) return lists;
         Deque<Integer> path = new ArrayDeque<>(); //从根结点到叶子结点的路径，是一个栈
         dfs(candidates,0,target,path,lists);


        return  lists;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private static void dfs(int[] candidates, int begin, int target,
                        Deque<Integer> path, List<List<Integer>> res) {
          //判断结束标志

        if (target ==0) {
            res.add(new ArrayList<>( path )) ; //添加元素 path 保存
            return;
        }
        //重点理解这里从 begin 开始搜索的语意
           //如果前面出现了 减去的数字，那么后面，就不再包含这个数，去重
        for (int i = begin; i < candidates.length ; i++) {

            //提前判断 剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }

             path.add( candidates[i]); //遍历的保存
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i,  target - candidates[i], path, res);

            // 状态重置, 不去这个元素，回溯，使用其他的部分
            path.removeLast();
        }

    }


}
