package ex1;
/**
 * @author ������
 * Document : Ex2_Main 
 * Created on : 2014. 9. 16, ���� 10:40:16
 */
public class Ex2_Main {
    Ex2_Throws et;

    public Ex2_Main(String m) {
        et = new Ex2_Throws();
        try {
            et.setData(m);
        } catch (Exception e) {
            System.out.println("������ �Է��϶���");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Ex2_Main ref = new Ex2_Main("��");
    }
}
