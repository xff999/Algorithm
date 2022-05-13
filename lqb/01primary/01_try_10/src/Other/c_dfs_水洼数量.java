package Other;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

/***
 * @author xff
 * @createTime 2022/5/13 16:33
 *
 *   n*m  w表示积水 （八块联通的水认为是一起的）  .表示空地
      n,m<=100;  求有多少个水洼
  例如  n=10, m=12
10  12
w........ww.
.www.....www
....ww...ww.
.........ww.
.........w..
..w......w..
.w.w.....ww.
w.w.w.....w.
.w.w......w.
..w.......w.

 输出 3


使用深度优先搜索 ，对一个节点，遍历他的八个邻接点的状态，注意，遍历之后要改变他的状态值，
    连续的，他就是联通的， 不连通之后就会跳出，得到一个水洼，遍历过的也都改变了状态，下次不会受到影响
 循环对每一个节点都做dfs 处理
 *
 */

public class c_dfs_水洼数量 {
    public static void main(String[] args) {

        Scanner scanner = new  Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        char[][] a= new char[N][];
        for (int i = 0; i <N; i++) {
           a[i]=scanner.nextLine().toCharArray();
            // 处理输入的程序
        }
        System.out.println();

        for (int i = 0; i <N; i++) {
            for (int j = 0; j <a[i].length ; j++) {
                System.out.print(a[i][j]);

            }
            System.out.println(a[i].length);
        }
        //遍历每个节点，判断是否是 水，若果是，dfs 找到相邻的
        //他跳出之后，必定找到一个连续的水洼
        int count =0;
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                if (a[i][j]=='w'){
                    dfs(a,i,j);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    //结果出现栈溢出的错误
    public static void dfs(char[][] a,int i,int j){
        a[i][j]='.'; // 把水哇访问过了，设置反状态
        //进行他的八个接邻点的测试
        for (int k = -1; k <=1 ; k++) { //行
            for (int l = -1; l <=1 ; l++) { //列的取值
                if (k==0 && l==0 ) continue;

                if ( k+i>=0 && i+k<= a.length-1 && j+l>=0 && j+l<=a[i].length-1){
                    if (a[k+i][j+l]=='w'){
                        dfs(a,i+k,i+j);  //条件判断，满足则遍历他的下一个
                    }

                }
            }
        }
    }
}
