package ex1;

import java.util.Scanner;

/**
 * @author ������
 * Document : Ex3_LoopSwitch 
 * Created on : 2014. 9. 4, ���� 10:35:42
 */
public class Ex3_LoopSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        xx : for(;;){
            System.out.print("������ �Է�(R,G,B) : ");
            String col = sc.nextLine();
            //String API�߿��� ���ڿ��� �ҹ��ڷ� ����
            col = col.toLowerCase();
            String res = "";
            switch(col){
                case "red" :
                    System.out.println("�������̳׿�");
                    break;
                case "blue" :
                    System.out.println("�Ķ����̳׿�");
                    break;
                case "bye" :
                    System.out.println("�������̳׿�");
                    break xx; //break-label���� �̿��� ����
            }
            System.out.println("����� �Է��� ������ "+res+" �Դϴ�.");
        }
    }
}
