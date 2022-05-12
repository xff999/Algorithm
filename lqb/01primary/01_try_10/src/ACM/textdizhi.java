package ACM;

public class textdizhi {

    public static void main(String[] args) {

        Integer a1 = new Integer(10);
        Integer a2 = new Integer(10);
        if(a1==a2)
        {
            System.out.println("a1==a2true");
        }else
            System.out.println("a1==a2false");

        if(a2.equals(a1)){
            System.out.println("a1.equals(a2)==true");
        }else
            System.out.println("a1.equals(a2)==false");

    }
}
