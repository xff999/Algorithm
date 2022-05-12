package ch04_dp;

import java.util.Scanner;

//最大不下降子序列
 // i1<i2<i3..... 则 a[i1]<a[i2]<[i3]....
//找递推关系，公式抽象，分阶段，
public class exp_28 {
    public static void main(String[] args) {
        int max=0; //表示最后求得的结果
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入 n 个数");
        int n=scanner.nextInt();
        int tem[]=new int[n]; //表示当前的这个数 能构成最大子序列的个数 的数组
        int a[] = new int[n]; //存放这  n 个数的数组
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
            tem[i]=1; //先把数组值初始为1，因为最少，无论选哪个数字，不下降子序列也是1
        }

        //下面由前到后 做判断处理
        for(int i=1;i<n;i++){  //外层循环控制 这层的数字向后循环
            for(int j=i-1;j>=0;j--){ //内层循环控制 找这个数字前面的作比较
                if(a[i]>a[j]){ //这个数大于前面的
                    tem[i]=Math.max(tem[i],tem[j]+1); //但是可能取原来的数组，或者，把这个j 位置+1
                }
            }
          //循环内层一次结束后 ，判断当前的最大的值，和 max 相比较，
            if(max<tem[i]){
                max=tem[i];
            }
        }
        System.out.println(max);
    }
}
