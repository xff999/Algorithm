package com.xff2.hot40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author xff
 * @createTime 2022/6/29 20:37
给你一个字符串数组，请你将 字母异位词 组合在一起。
可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的字母得到的一个新单词，
所有源单词中的字母通常恰好只用一次。

 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

输入: strs = [""]
输出: [[""]]

输入: strs = [""]
输出: [[""]]

 ==>( 一个字符串，他的所有的单个字符是相等的 ，)
    ==> 可以排序啊，排序之后的字符串作为哈希表的键。

 */
public class c49_字母异位词分组 {

    public static void main(String[] args) {
        String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
       // String [] strs ={""};
        System.out.println(groupAnagrams(strs));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
              //  排序后的字母， 值：原来的字符串

        //遍历 str 数组，判断里面的 字符串
        for (String str :strs) {
          char[] arr = str.toCharArray(); //转换为char 数组
            Arrays.sort(arr);  //排序
           String key = new String(arr); //把排序后的值，作为key
           List<String> list = map.getOrDefault(key, new ArrayList<String>());
                   //获得这个key的val (list集合） 或者新建
             list.add(str);   //把这个str 放入对应的list
            map.put(key, list);  //放入map 中
        }
        return new ArrayList<List<String>>(map.values());
    }
}
