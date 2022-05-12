package ACM;

import java.util.Scanner;

public class taotao1098 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       // System.out.println("输入十个苹果的高度");
        int hight=0;
        int total=0;
        int [] nums=new int[10];
        for (int i=0;i<10;i++){
           nums[i] = scanner.nextInt();
        }
       // System.out.println("输入身高");
         hight = scanner.nextInt();

        for (int i=0;i<10;i++){
            //进行身高与苹果的判断
           if(nums[i] <= hight+30){
               total++;
           }
        }
        System.out.println(total);

    }

}
