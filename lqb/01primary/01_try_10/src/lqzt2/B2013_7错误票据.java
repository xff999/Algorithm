package lqzt2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;

/**
 * @author xff
 * @createTime 2022/5/12 20:14
每张票据有唯一的ID号。全年所有票据的ID号是连续的，但ID的开始数码是随机选定的。
工作人员疏忽，在录入ID号的时候发生了一处错误，造成了某个ID断号，另外一个ID重号。
你的任务是通过编程，找出断号的ID和重号的ID。
假设断号不可能发生在最大和最小号。
 *
 * 要求程序首先输入一个整数N(N< 100)表示后面数据行数。
 * 接着读入N行数据。
 * 每行数据长度不等，是用空格分开的若干个（不大于100个）正整数（不大于100000），请注意行内和行末可能有多余的空格，你的程序需要能处理这些空格。
 *每个整数代表一个ID号。
 *
 * 要求程序输出1行，含两个整数m  n，用空格分隔。
 * 其中，m表示断号ID，n表示重号ID
 *
2
5 6 8 11 9
10 12 9
 *
 *7 9
 */

public class B2013_7错误票据 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
         scanner.nextLine(); // 用来处理多余的 回车

        //因为数字的个数不确定，所以使用arrylist 来动态的添加数字元素
        ArrayList<Integer> list = new ArrayList<Integer>();  //指定类型
        for (int i = 0; i <N; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(" "); //以 空格分割每个数字
            for (int j = 0; j <split.length ; j++) {
                list.add(Integer.parseInt(split[j]));  //添加元素进入list集合
            }

        }
     //   System.out.println("======");
//        System.out.println(list.size());
        Collections.sort(list); // 先排序，再找出断的和重合的
        int a = 0,b = 0;
        for (int i = 1; i <list.size() ; i++) {
             if(list.get(i) - list.get(i-1) ==2){
                 a= list.get(i)-1;
             }
             if(list.get(i).equals(list.get(i-1))){
                 b=list.get(i);  //集合取出的是对象，要判断 equals
             }
        }
//        for (int i = 0; i <list.size() ; i++) {
//            System.out.print(list.get(i)+" ");
//        }

       // System.out.println();
        System.out.println(a+" "+b);


    }
}




















