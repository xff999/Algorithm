package lqzt;

import java.util.Scanner;

//给出一个初始状态字符串，一个最终状态，求翻动次数，能达到相同，
// 每次翻动时，连带着他后面一个也要翻动，
public class B4_FanYingBi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       // System.out.println("输入初始串");
        String start=scanner.next();
       // System.out.println("输入目标串");
        String end = scanner.next();
        char [] s1=start.toCharArray();
        char [] s2=end.toCharArray();
        int [] a1=new int[s1.length];
        int [] a2=new int[s1.length];
        for (int i = 0; i <s1.length ; i++) {
            if(s1[i]=='*'){
                a1[i]=1;
            }else{
                a1[i]=-1;
            }
            if(s2[i]=='*'){
                a2[i]=1;
            }else{
                a2[i]=-1;
            }

        }

        int count =0;
        if(start.length()!=end.length()) {
            return;
        }
        for (int i = 0; i <s1.length ; i++) {
            if(a1[i]!=a2[i]){

                count++;
                a1[i]=-a1[i];
                a1[i+1]=-a1[i+1];
            }
        }
        System.out.println(count);
    }
}
