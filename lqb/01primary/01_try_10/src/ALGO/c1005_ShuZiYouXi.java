package ALGO;

import java.util.Scanner;

/**
 * 给定一个1～N的排列a[i]，每次将相邻两个数相加，得到新序列，再对新序列重复这样的操作，显然每次得到的序列都比上一次的序列长度少1，最终只剩一个数字。
 * 　　例如:
 * 　　3 1 2 4
 * 　　4 3 6
 * 　　7 9
 * 　　16
 * 　　现在如果知道N和最后得到的数字sum，请求出最初序列a[i]，为1～N的一个排列。若有多种答案，则输出字典序最小的那一个。数据保证有解。
 n <10 尝试暴力搜索
 */
public class c1005_ShuZiYouXi {


    static int sum;
    static int N;
    static int arr1[];
    static boolean bool = true;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        sum = input.nextInt();
        int array[] = new int[N];
        int visit[] = new int[N + 1];

        dfs(0, array, visit, bool);
    }

    public static void dfs(int step, int arr[], int vis[], Boolean b) {
        if (step == N) {
            int arr1[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr1[i] = arr[i];
            }
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < N - i; j++) {
                    arr1[j] = arr1[j] + arr1[j + 1];
                }
            }
            if (arr1[0] == sum) {
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                bool = false;
                return;

            } else
                return;
        }
        if (bool == true) { //还没找到，改变初始值，暴力搜索
            for (int i = 1; i <= N; i++) {
                if (vis[i] == 0) {
                    arr[step] = i;
                    vis[i] = 1;
                    dfs(step + 1, arr, vis, bool);
                    vis[i] = 0;
                }

            }
        }
        return;
    }
}
