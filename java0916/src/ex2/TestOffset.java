package ex2;
/**
 * @author ������
 * Document : TestOffset 
 * Created on : 2014. 9. 16, ���� 3:11:33
 */
public class TestOffset {
    public static void main(String[] args) {
        String str = "abcdefghikjlnm";
        System.out.println("String = " + str);
        int retval = str.offsetByCodePoints(1, 2);
        System.out.println(retval);
    }
}