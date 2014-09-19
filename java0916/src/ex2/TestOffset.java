package ex2;
/**
 * @author 오세현
 * Document : TestOffset 
 * Created on : 2014. 9. 16, 오후 3:11:33
 */
public class TestOffset {
    public static void main(String[] args) {
        String str = "abcdefghikjlnm";
        System.out.println("String = " + str);
        int retval = str.offsetByCodePoints(1, 2);
        System.out.println(retval);
    }
}