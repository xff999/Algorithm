package lqzt;//第二题   求一个字符串的不同字串 的个数  填空import java.util.HashSet;//暴力枚举， set 集合去重， substring 取字串，注意控制取得个数public class B10_ZiChuan {    public static void main(String[] args) {        String tar="0100110001010001";        HashSet<String > hashSet = new HashSet<>();        //for循环，控制每次分的个数        for (int stp = 0; stp <=tar.length()-1 ; stp++) {            //控制每次的前后变量            for(int start=0 , stop= 1+stp ;stop<=tar.length();start++,stop++ ){               hashSet.add( tar.substring(start,stop));            }        }        System.out.println(hashSet.size());    }}