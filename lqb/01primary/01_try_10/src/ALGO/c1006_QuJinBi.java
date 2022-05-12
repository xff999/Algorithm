package ALGO;



import java.util.Arrays;
import java.util.Scanner;

/**  dp  的解决策略，怎么分状态，怎么找找转移方程
 *
 * 有一个N x N的方格,每一个格子都有一些金币,只要站在格子里就能拿到里面的金币。
 * 你站在最左上角的格子里,每次可以从一个格子走到它右边或下边的格子里。请问如何走才能拿到最多的金币。
 */
public class c1006_QuJinBi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("输入方格规模");
        int N=scanner.nextInt();
        int [][] arr=new int[N][N];
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j <N ; j++) {
                arr[i][j]=scanner.nextInt();
            }
        }
        for (int i = 0; i <N ; i++) {  //遍历每行的数据
            for (int j = 0; j <N ; j++) {  //每列
            //遍历数组 ，找路程
                if(i==0&&j>0){ //这个点属于上边界，走到这里获得金币的情况；每一步都是当前获得最大金币的方式
                    arr[i][j]=arr[i][j]+arr[i][j-1]; //来自左方
                }else {
                    if (j == 0 && i > 0) { //左边界，走到这里获得金币的情况；由上面方格得到
                        arr[i][j] = arr[i][j] + arr[i - 1][j];  //来自上方
                    } else if (i > 0) {  //其他方格情况
                         arr[i][j]=arr[i][j]+Math.max(arr[i][j-1], arr[i - 1][j]);
                    }
                }
            }
        }
        System.out.println(arr[N-1][N-1]);
//        for (int i = 0; i <N ; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
    }

}
