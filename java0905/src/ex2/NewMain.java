package ex2;
/**
 * @author ������
 Document : NewMain 
 Created on : 2014. 9. 5, ���� 11:31:50
 */
public class NewMain {
    public static void main(String[] args) {
        NewClass ref = new NewClass();
        ref.insertPay(1000, "dd");
        int pay = ref.getPay();
        int res = pay * 100;
        System.out.println("�޿��� : "+res);
    }    
}
