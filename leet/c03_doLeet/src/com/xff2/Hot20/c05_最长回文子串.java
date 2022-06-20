package com.xff2.Hot20;
/**
 * @author xff
 * @createTime 2022/6/9 19:58
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。

 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 使用字符串反转 ，截取相同的 ，可能出现多段， 找最大的
 *        (不正确，有的通不过测试)
 *  babad
 *  dabad  ==>aba
 */
public class c05_最长回文子串 {

   /* public  static String longestPalindrome(String s) {
        String s1 = "" ;  //反转之后字符串
        String total = ""; //结果字符串
        for (int i = 0; i < s.length(); i++) {
            s1 = s.charAt(i)+s1;  //字符串中获取单个字符的字符的放法
        }
        int max =0 ;
        String [] str = new String[s.length()] ; //存储string  的连续 串的
         int k=0;
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) == s1.charAt(i)){
                total= total+s.charAt(i);
                max++;
            } else {  //如果遇见不相同，max 重新计数，
                str[k] = total;
                k++;
                max = 0 ;
                total= "" ;
            }

        }
      //遍历存储的 str 集合，找出最大的
        int m =0;
        for (int i = 0; i <str.length ; i++) {
            if( str[i]!=null && str[i].length() > max){
                max = str[i].length();
                total =str[i];
            }
        }
        if(max ==0){
            return  s.charAt(0)+"";
        } else {
            return  total;
        }
    } */

    /**
     * @author xff
     * @createTime 2022/6/9 20:43
     *
     *   回文必然是 对称的  使用 扩张中心，循环判断 （两种方式）
     *       从元素上扩展    n 次
     *       从元素之间的位置开始   n-1次
     *
     */
    public static String longestPalindrome(String s) {  //静态方法，不能调用非静态
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); //以本身元素位置
            int len2 = expandAroundCenter(s, i, i + 1);  //以两元素位置中间
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static void main(String[] args) {
        String s = "babad"; //s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
