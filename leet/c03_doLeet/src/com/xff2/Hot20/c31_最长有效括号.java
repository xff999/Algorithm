package com.xff2.Hot20;


import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @author xff
 * @createTime 2022/6/20 15:03

 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"

输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"

输入：s = ""
输出：0

 */
public class c31_最长有效括号 {
    public static void main(String[] args) {
//       String s="(()";
        //String s = ")()())";
        String s = "()(())";
       System.out.println(longestValidParentheses(s));
    }

    //使用 栈的方式 匹配括号

    public static int longestValidParentheses(String s) {
        int n = s.length();
        int maxLen = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);  //存放一个边界 变量
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 如果是左括号直接入栈即可
            if (ch == '(')
                stack.push(i);  //栈里面 存的索引 （方便计算数量）
            else {
                // 如果是 ） 右括号，存在两种情况
                // 1.如果前面可以有左括号和它进行匹配，那么就存在一个由左括号、右括号组成的子串
                // 2.如果前面没有左括号和它进行匹配，那么这个右括号就形成了新的边界。新的子串匹配时，起点必须在该边界右边
                if (stack.size() == 1) {  //没有左括号 可以做匹配
                    // 如果栈的大小为1，说明只存放了边界 -1
                    // 说明存放的内容为:边界
                    // 相应的做法为边界替换，将旧的边界出栈，然后放入新的边界
                    // 说明该右括号找不到和它可以匹配的左括号，那么该子串长度无效。同时这个右括号形成了新的边界(参照物)
                    stack.pop();
                    stack.push(i);  //把-1 这个标志 替换为 ）的下标
                } else {  //可以做匹配
                    // 说明存放的内容为: -1 边界+ ） 左括号索引 +......
                    // 说明可以找到和它进行匹配的左括号
                    stack.pop();   //能够匹配到       //i - （ 上次的索引
                    maxLen = Math.max(maxLen,i-stack.peek());
                }
            }
        }
        return maxLen;
    }
}
