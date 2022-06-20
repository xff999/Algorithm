package com.xff2.Hot20;

import java.util.HashMap;

/**
 * @author xff
 * @createTime 2022/6/16 19:37


给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    (滑动窗口 解决)

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */

public class c03_无重复字符的最长子串  {
    public static void main(String[] args) {
       String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();  //简单临界情况
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0; //最大记录    k 是元素 ，value 是下标
        int left = 0; //窗口 左下标
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1); //左下标改变的位置
                //新出现的位置 +1  或者集合中重复元素原来的位置
            }
            map.put(s.charAt(i), i);  //放入这个元素
            max = Math.max(max, i - left + 1);  //获得最大值
        }
        return max;
    }
}
