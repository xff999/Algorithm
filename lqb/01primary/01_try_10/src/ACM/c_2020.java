package ACM;

public class c_2020 {
    public static void main(String[] args) {
        String str = "";
        int num=0;
        for (int i = 1; i <=3181 ; i++) {
            str=str+i;
        }

        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)=='1'){
                num++;
            }
        }
        System.out.println(num);
        //System.out.println(str);
    }
}
