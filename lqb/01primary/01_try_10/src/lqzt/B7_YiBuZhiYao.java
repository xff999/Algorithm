package lqzt;

//利用辗转相除法，欧几里得的应用，
//求一步之遥，前进97，后退127，问多少步可以前进一米
public class B7_YiBuZhiYao {
    //暴力法，直接枚举出来
//      public static void main(String[] args) {
//         for (int i = 0; i < 100; i++) {
//            for(int j=0;j<100;j++){
//                if(i*97-j*127 ==1){
//                    System.out.println(i+ " "+j);
//                } } } }
    static int x,y;
    public static void main(String[] args) {
        ect_gcd(97,-127);
        System.out.println(x+" "+y);

    }
    public static int ect_gcd(int a,int b){
        if(b==0){
            x=1;
            y=0;
            return a;
        }
        int res = ect_gcd(b,a%b);
        int x1=x;
        x=y;
        y=x1 -a/b *y; //这里采用递归循环更新下， x,y
        return res;
    }

}
