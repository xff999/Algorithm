package ACM;


import java.util.*;
//设计邮票的面值，使得得到最大值 到1 之间每个数都能表示
//大概时 平衡三个数  三的几次方
public class c1576_YouPiaoSheJi {


        static int N; //允许粘贴的邮票数量
        static int K; //邮票种类（不同面值的邮票数量）
        static int cnt = 0; //题目中的MAX
        static int[] arr = new int[11]; //存储当前的邮票面值方案
        static int[] ans = new int[11]; //存储取得 cnt 时的邮票面值方案（即最佳方案）
    // 根据题目，我们要解决的原始问题是：
    // 给定N个邮票的位置，K种邮票种类，其邮票面值方案为：arr[1] ~ arr[count]，
    // 如何找到最大连续数
    // 例如N = 3, K = 2, 且 arr[1]=1,arr[2]=3(即邮票面值分别为1，3)
    // 如何组合出最大连续数
    // 1 <-- 1
    // 2 <-- 1 + 1
    // 3 <-- 1 + 1 + 1 或 3
    // 4 <-- 1 + 3
    // 5 <-- 1 + 1 + 3
    // 6 <-- 3 + 3
    // 7 <-- 1 + 3 + 3
    // 8 不满足了，因为受限于 N=3， 3+3+3-->9 而 3+3+1-->7，组合不了8的情况
    // 因此最大连续数为7
    // 在这里，我们并不是直接处理上述问题，而是将其转换为
    // 完全背包问题求解（单张邮票的数量不限制）
    // 给定邮票面值方案arr[1] ~ arr[count]，且背包的最大容量为N * arr[count]
    // (因为arr[i]为单调递增数组)
    // 定义dp[i]:组合成 最大连续数i 所需的最小邮票数量
    // 状态转移方程: dp[j] = min(dp[j], dp[j-arr[i]]+1);
    // 含义：如果选择邮票arr[i]去组合 最大连续数j，则相应的背包容量要减少(即j-arr[i])，且邮票使用数量加1
    //      如果不选邮票arr[i]去组合 最大连续数j，则背包容量、邮票使用数量均不变，二者取最小
    // 那怎么去求解我们需要的最大连续数呢？
    // dp[N * arr[count]] 仅仅代表着最大连续数 N * arr[count]所需的最小邮票数量，并没有保证这个最小邮票数量 <= N
    // 因此，我们需要遍历dp数组，一遇到 dp[i] > N的时候就停止遍历，i-1即为我们所需的最大连续数

        public static int updateMAX(int count) {
            if (count == 0) {   //count 代表还能放入邮票的面值的下标
                return 0;
            }
            int[] dp = new int[1010];
            //dp[i]：组合出 最大连续数i 所需的最小邮票数量
            //初始化dp
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= count; i++) {  //循环邮票的下标
                for (int j = arr[i]; j <= N * arr[count]; j++) { //根据下标的值放入
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1); //面值连续到 J 时，需要的最小张数
                }
            }
            int i = 1;
            for (; i <= N * arr[count]; i++) {
                if (dp[i] > N) {
                    break;
                }
            }   //判断得到 最大的值
            return i - 1;
        }

        public static void dfs(int count, int maxSeqNum){
            if(count > K){ //说明邮票面值的取值个数为K
                if(maxSeqNum > cnt){
                    //maxSeqNum:由当前邮票面值（前count个邮票）构成的最大连续数（即题目中的MAX）
                    //只有maxSeqNum > cnt，需要更新答案
                    cnt = maxSeqNum;
                    for(int i = 1; i <= K; i++){
                        ans[i] = arr[i];
                    }
                }
                return;
            }
            //根据前 count-1 个邮票面值的情况，枚举第 count 个邮票面值的取值
            for(int i = arr[count-1] + 1; i <= maxSeqNum + 1; i++){
                //将当前的取值作为第count个邮票面值，然后查看是否有更优的最大连续数
                arr[count] = i;
                //递归到下一层，确定第count+1个邮票面值
                //利用updateMAX()更新前count个邮票面值组合得到的最大连续数
                dfs(count+1, updateMAX(count));
            }
        }


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            K = sc.nextInt();
            //邮票面值一定会包含1，且设置前0个邮票对应的最大连续数为0
            dfs(1, 0);
            for(int i = 1; i <= K; i++){
                System.out.printf(ans[i] + " ");
            }
            System.out.println();
            System.out.println("MAX=" + cnt);
        }
    }

