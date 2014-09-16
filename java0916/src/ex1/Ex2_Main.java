package ex1;
/**
 * @author 오세현
 * Document : Ex2_Main 
 * Created on : 2014. 9. 16, 오전 10:40:16
 */
public class Ex2_Main {
    Ex2_Throws et;

    public Ex2_Main(String m) {
        et = new Ex2_Throws();
        try {
            et.setData(m);
        } catch (Exception e) {
            System.out.println("정수만 입력하랑께");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Ex2_Main ref = new Ex2_Main("야");
    }
}
