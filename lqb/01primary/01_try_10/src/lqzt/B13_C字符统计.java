package lqzt;

//统计出现最多的字符，如果最大的次数，不止一个字母，则按照字典序输出



import java.util.Scanner;

public class B13_C字符统计 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入大写字母串");
        String s=scanner.next();
        int [] num = new int [26];
        for (int i = 0; i <s.length() ; i++) {
            num[s.charAt(i)-65]+=1;
        }
        int max=0;
        for (int i = 0; i < 26; i++) {
            if(num[i]>max)
                max=num[i];
        }
        char m = 0;
        for (int i = 0; i < 26; i++) {
            if(num[i]==max)
            { m = (char) (i+65);
                System.out.print(m);
            }
        }

//        System.out.println(Arrays.toString(num));
    }
}
