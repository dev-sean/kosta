package ex1;

import java.util.Scanner;

/**
 * @author ������
 * Document : Ex2_Throws 
 * Created on : 2014. 9. 16, ���� 10:22:41
 */
public class Ex2_Throws {
    public void setData(String m) throws NumberFormatException{
        if(m.length() >=1){
            String str = m.substring(0, 1);
            printData(str);
        }
        
    }
    //throws ȣ���� ������ ����
    public void printData(String m) throws NumberFormatException{
        int dan = Integer.parseInt(m);
        System.out.println(dan+" ��");
        System.out.println("==================");
        for (int i = 0; i < 9; i++) {
            System.out.println(dan +"*"+(i+1)+" = "+ (dan*(i+1)));
        }
    }
    /*
    public static void main(String[] args) {
        Ex2_Throws ref = new Ex2_Throws();
        Scanner sc = new Scanner(System.in);
        try {
            ref.setData("1");
            ref.setData("sdf");
        } catch (Exception e) {
            System.out.println("�������Է¹ٶ�");
        }
        
    }
    */
}
