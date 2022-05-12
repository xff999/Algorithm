package ACM;

import java.util.Scanner;

public class schoolTree1099 {
//使用数据标记法
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int L = scanner.nextInt();
        int M = scanner.nextInt();
        int [] nums = new int[L+1];
        int count=0;
       for(int i=0;i<M;i++){
           int m1 = scanner.nextInt();
           int m2 = scanner.nextInt();
            for(int j=m1;j<=m2;j++){
                //把这个区域的数组赋值为1
                nums[j]=1;
            }
       }
        for (int i = 0; i < L+1; i++) {
            if(nums[i]!=1){
                count++;
            }
        }
        System.out.println(count);
    }
}
