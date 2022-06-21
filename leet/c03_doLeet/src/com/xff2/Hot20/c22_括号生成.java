package com.xff2.Hot20;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @author xff
 * @createTime 2022/6/17 13:12

  数字 n 代表生成括号的对数，请你设计一个函数，
    用于能够生成所有可能的并且 有效的 括号组合
输入：n = 3     1 <= n <= 8
输出：["((()))","(()())","(())()","()(())","()()()"]

 输入：n = 1
输出：["()"]

 */
 // x 思路，for 循环 ，左边 括号的个数 使用栈 ，能匹配则记录放入list （有问题）
// 动态规划  或者深度遍历 回溯

public class c22_括号生成 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }


    /**  使用 深度优先遍历   由空串 向下来判断
     * 条件：
       当前左右括号都有大于 0 个可以使用的时候，才产生分支；
       产生左分支的时候，只看当前是否还有左括号可以使用；
       产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量
           一定得在严格大于左边剩余的数量的时候，才可以产生分支；
       在左边和右边剩余的括号数都等于 0的时候结算。判断是否符合

     */

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
         if (n==0) return list;
          dfs("",n,n,list);
        return list;
     }

     //dfs 深度遍历    传入参数 ： 上次遍历得到的串 ，左括号剩余个数， 右括号剩余个数， list结果
    private static void dfs(String curStr, int left, int right, List<String> res) {
     // 因为使用 string 每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可
        //结束条件
        if (left ==0 && right==0) {
            res.add(curStr); // 当前的字符串 放入结果list
            return;
        }
        // 上次传入的情况 进行判断 剪枝（左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {  //意思是 ，先使用了 ）一定不能构成 匹配的了
            return;  //直接返回，这次没有结果
        }
        //考虑，下一个怎么放 ，两种情况
        if(left>0){ //有左 ，先放入左的情况，深度遍历
            dfs(curStr+"(", left-1, right, res);
        }
        if (right > 0) {  //放 右 ）
            dfs(curStr + ")", left, right - 1, res);
        }
    }

}
