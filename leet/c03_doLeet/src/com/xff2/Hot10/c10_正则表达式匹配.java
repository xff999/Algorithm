package com.xff2.Hot10;


/**
 * @author xff
 * @createTime 2022/6/10 20:09
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 *   '.' 匹配任意单个字符
 *   '*' 匹配零个或多个前面的那一个元素
 *   所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
输入：s = "aa", p = "a"     （只能是 a -z ）  保证每次出现字符 * 时，前面都匹配到有效的字符
输出：false
解释："a" 无法匹配 "aa" 整个字符串。

输入：s = "aa", p = "a*"
输出：true
解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。

输入：s = "ab", p = ".*"
输出：true
解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 */

//重要： 两个字符串 比较，要容易想到 动规的算法
    // dp[i][j] 表示 s的前i个是否能被 p 的前 j 个匹配
/**
 dp[i-1][j-1] 入手  怎么去求 dp[i][j]

 如果（i个和j 个相同）  p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]；
 如果  （ 规则是 点）   p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1]；
 如果 p.charAt(j) == '*'：
      如果 p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2] // a*  （a 相等的， j跳到前两个）
      如果 p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.'：
 dp[i][j] = dp[i-1][j] //in this case, a* counts as multiple a
 or dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
 or dp[i][j] = dp[i][j-2] // in this case, a* counts as empty

 */
public class c10_正则表达式匹配 {

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        // 两个数组 匹配， 首先要想到 动规的思路   （和 两个字符串 最大子序列相似的 ）

        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        //"" 和p的匹配关系初始化，a*a*a*a*a*这种能够匹配空串，其他的是都是false。
        //  奇数位不管什么字符都是false，偶数位为* 时则: dp[0][i] = dp[0][i - 2]
        for (int i = 2; i <= n; i+= 2) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }


    public static void main(String[] args) {
        String s="aa";
        String p=".*";
        System.out.println(isMatch(s, p));
    }
}
