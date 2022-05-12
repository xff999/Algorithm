package Other;

//数论里面的定理，要注意参数
public class Gcd {
    //辗转相除，求最大公约数 gcd
    public static void main(String[] args) {
        int num =gcd(15, 5);
        System.out.println(num);
    }

    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
}
