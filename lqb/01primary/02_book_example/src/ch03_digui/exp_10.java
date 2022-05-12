package ch03_digui;

/*
  找递归公式，，出口，规模间的关系
 */
import java.util.Scanner;

public class exp_10 {
    //n个数取 r 个数的可能组合
    //简单暴力的 r 重循环也可以
    static int a[]=new int [10];
    static int count=0;
    public static void main(String[] args) {
        System.out.println("输入2个整数");
        Scanner scanner= new Scanner(System.in);
        int n=scanner.nextInt();
        int r=scanner.nextInt(); //m 个数 取 r 个
        if(r>n){
            System.out.println("数据错误");
        }else{
            a[0]=r;
            qushu(n,r);
        }
        System.out.println(count);
    }

    public static void qushu(int m,int k){

        //在total中 取出 num 个的组合数目
        for(int i=m;i>=k;i--){
            //表示这个位置能放的数字 可能， 保证放入时，还够后面的num 个
            a[k]=i;  //第num个数
            if(k>1){//待取的数 >1 还要继续向下取数
                 qushu(i-1, k-1);  //这里是i-1 i每次的数可能不是m ，比m小
            } else {  //数取完了，输出
                for(int j=a[0];j>0;j--){
                    //a[0]存的是取得个数
                    System.out.print(a[j]+" ");
                }
                count++;
            System.out.println();
            }
        }

    }

}
