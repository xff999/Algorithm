package lqzt2;

import java.util.Calendar;

/**
 * @author xff
 * @createTime 2022/5/12 18:02
 *
 *   主要调用日期的api
 *   1999 12.31  是星期五 -->离我们最近的 世纪末 （xx99.12.31) 哪个是星期日
 *
 */
public class B2013_世纪末的星期日 {
    public static void main(String[] args) {
        Calendar calendar= Calendar.getInstance();
        for (int i = 1999; i <10000 ; i=i+100) {
            calendar.set(Calendar.YEAR,i);
            calendar.set(Calendar.MONTH,11); //12月
            calendar.set(Calendar.DAY_OF_MONTH,31);
            if(calendar.get(Calendar.DAY_OF_WEEK)==1){
                System.out.println(i);
                break;
            }
        }
    }
}
