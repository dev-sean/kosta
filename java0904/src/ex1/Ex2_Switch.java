package ex1;

import java.util.Scanner;

/**
 * @author ������ 
 * Document : Ex2_Switch 
 * Created on : 2014. 9. 4, ���� 10:17:11
 */
public class Ex2_Switch {

    public static void main(String[] args) {
        //�ܿ� 11,12,1,2
        //�� 3,4,5
        //���� 6,7,8
        //���� 9,10
        Scanner sc = new Scanner(System.in);
        System.out.print("�� �Է� : ");
        int m = Integer.parseInt(sc.nextLine());
        String res;
        switch (m) {
            case 11:
            case 12:
            case 1:
            case 2:
                res = "�ܿ�";
                break;
            case 3:
            case 4:
            case 5:
                res = "��";
                break;
            case 6:
            case 7:
            case 8:
                res = "����";
                break;
            case 9:
            case 10:
                res = "����";
                break;
            default:
                res = "���� �˼������� ";
        }
        System.out.println("������ ���� " + res + "�Դϴ�.");
    }
}
