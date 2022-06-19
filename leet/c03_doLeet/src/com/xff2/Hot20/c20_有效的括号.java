package com.xff2.Hot20;

import java.util.*;

/**
 * @author xff
 * @createTime 2022/6/16 19:44

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
       左括号必须用相同类型的右括号闭合。
       左括号必须以正确的顺序闭合。
输入：s = "()"
输出：true
输入：s = "()[]{}"
输出：true
输入：s = "(]"
输出：false
输入：s = "([)]"
输出：false
输入：s = "{[]}"
输出：true
 */

//思路 ： 首先想到栈  放入和匹配取出
     //注意处理 跳出的条件的 初始临界值 （使用标志）

public class c20_有效的括号 {
    public static void main(String[] args) {
       //String  s = "()[]{}";
        String  s  = "([)]";
        //String  s =  "(]";
       System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if(s.isEmpty())
             return true;

        char[] chars = s.toCharArray(); // 转为char 数组
  //题目的 匹配 关系放入map 集合中，方便查询
        Map<Character,Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        map.put('?','?'); //给栈 赋初值，处理栈为空时，peek 报错
        Stack<Character> stack = new Stack<>();
         stack.add('?');

        for (int i = 0; i <chars.length ; i++) {
            char ch = chars[i]; //取出这个 字符
         //如果这个字符 是map 的key  直接放入
            if(map.containsKey(ch)){
                stack.push(ch);
            } else {   //如果再value 里面直接 看是否匹配 然后出栈
                Character peek = stack.peek();
                if(map.get(peek)==ch){
                    stack.pop();
                } else return false;
            }
         }
          //初始值 的 ？
        if(stack.size()==1) return true;
        return  false;
    }
}
