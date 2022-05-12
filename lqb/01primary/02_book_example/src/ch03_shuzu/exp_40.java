package ch03_shuzu;

import java.util.Scanner;

//上楼梯问题，倒退和 递归求法
//利用斐波那契数列 的变形
public class exp_40 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入楼梯数目");
        int num = scanner.nextInt();

        System.out.println(goup(num));

    }

    public static int goup(int n){
        //对于n 层楼梯，如何上，达到的方式数目；
        if(n==1){
            return 1; //还剩一个楼梯，一种
        }else{
            if(n==2){ //还剩两个楼梯，两种
                return 2;
            }else{
                return (goup(n-1)+goup(n-2));
            }
        }
    }

}
