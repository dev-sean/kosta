package ex1;
/**
 * @author 오세현
 * Document : Ex4_String 
 * Created on : 2014. 9. 4, 오전 11:26:56
 */
public class Ex4_String {
    public static void main(String[] args) {
        String str = "AB";
        str+="C";
        str+="D";
        System.out.println(str);
        
        String msg = "Test";
        String msg1 = "Test";
        boolean k=(msg==msg1);
        System.out.println(k);
        
        String msg2 = new String("good");
        String msg3 = new String("good");
        boolean i=(msg2==msg3);
        System.out.println(msg2);
        System.out.println(msg3);
        System.out.println(i);
    }
}
