package lqzt;



//回文，前段数字递增，
//2022 --2022 22 2022 有多少个数字
//暴力枚举，用是多大，  3138
public class B13_B山 {
    public static void main(String[] args) {
       Long a= Long.valueOf(2022);
       Long b= 2022222022L;
      int total=0;
        for (Long i = a; i <=b ; i++) {
            if(huiwen(i)){
                total++;
            }
        }
        System.out.println(total);

//        Long num = Long.valueOf(1545487797);
//        if(huiwen(num)){
//            System.out.println(num);
//        }
    }


    public static boolean huiwen(Long i){
        String str = i+"";
        int len= str.length();
        for (int j = 0; j <(len/2) ; j++) {
            if(str.charAt(j)>str.charAt(j+1)){
                return false;
            }
        }
//判断是否是回文，，--->  i  length-i-1 是否是相同的
        String str2="";
        for (int j = len-1; j >=0 ; j--) {
            str2=str2+str.charAt(j);
        }
//        System.out.println(str2);
//        System.out.println(str);
        if(str.equals(str2))
            return  true;
        return false;
    }

}
