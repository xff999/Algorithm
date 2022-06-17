package com.xff2.Hot20;

import java.util.*;

/**
 * @author xff
 * @createTime 2022/6/15 20:10

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
   答案可以按 任意顺序 返回。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
输入：digits = ""
输出：[]

输入：digits = "2"
输出：["a","b","c"]
 */
public class c17_电话号码字母组合 {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));

    }
    public static List<String> letterCombinations(String digits) {
 //map 存储  队列 方便组合
        List<String> list = new ArrayList<>();
             //定义数组，存储每个数字对应的数值

         //使用map 更好存储为数组更好操作
        HashMap<Character, String[]> map = new HashMap<Character, String[]>(){{
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }};


        if (digits == null || digits.length() == 0) return list; //判断是否为空

        //定义一个队列来存储所有的组合结果
        Queue<String> queue = new LinkedList<>();

         //遍历Digits，取到对应号码对应的字母数组
        for (int i = 0; i < digits.length(); i++) {
              //对取出的每个数字  调用函数，处理组合
            queue_letterCombinations(queue, map.get(digits.charAt(i)));
                      // i 对应的 几个字符，调用函数 放入队列中 （要与已有的产生组合）
        }
        //要求返回List   遍历队列
        for (String s : queue) {
            list.add(s);
        }
         return list;
    }
               //注意使用的 是队列 先进先出 ，拼接后再放入 队列尾部
    private static Queue<String> queue_letterCombinations(Queue<String> queue, String[] letters) {

        //初始定义的queue一定是空的，所以这时候把第一个号码的字母放入队列
        if (queue.size() == 0) {
            for (String letter : letters) { //初始时，直接放入元素
                queue.add(letter);
            }
        } else {
            //对于后面到来字母，把queue出队列然后拼接以后进入队列
            int queueLength = queue.size(); //记录本次需要进行出列组合的元素数量
            for (int i = 0; i < queueLength; i++) {  //队列已有的长度，和新来的元素串 拼接
                String s = queue.poll();    //队列头元素出队列
                for (String letter : letters) {  //遍历 来的字符串
                    queue.add(s + letter);  //将出来的队列元素和电话号码对应的字母依次进行拼接并添加进队列
                }
            }
        }
        return queue;  //最终的 数据，都放在队列中
    }
}
