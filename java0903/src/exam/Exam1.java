package exam;

import java.util.Scanner;

/**
 * @author kosta 
 * Document : Exam1 
 * Created on : 2014. 9. 3, ���� 11:35:35
 */
public class Exam1 {

    public static void main(String[] args) {
        //Scanner�κ��� ���� �Է¹��� �� �� ���� Ȧ������ ¦�������� ����ϼ���
        // ex) �� �Է� : 1 <Enter
        // �Է��� �� [ 1 ] �� Ȧ���Դϴ�.
   
        Scanner sc = new Scanner(System.in);
        System.out.print("�� �Է� : ");
        int num = Integer.parseInt(sc.nextLine());
        //�����丵�� �߿伺!!
        if (num % 2 == 0) {
            System.out.println("�Է��� �� [ " + num + " ] �� ¦�� �Դϴ�.");
        } else {
            System.out.println("�Է��� �� [ " + num + " ] �� Ȧ�� �Դϴ�.");
        }
    }
}
