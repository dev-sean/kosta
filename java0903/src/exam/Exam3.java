package exam;

import java.util.Scanner;

/**
 * @author kosta Document : Exam3 Created on : 2014. 9. 3, ���� 4:12:33
 */
public class Exam3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("���Է� : ");
        int dan = Integer.parseInt(sc.nextLine());
        System.out.print("�����Է�(3,5,7,9) : ");
        int range = Integer.parseInt(sc.nextLine());
        /* ���� § �ڵ�
         if (range == 3 || range == 5 || range == 7 || range == 9) { //�����Է��� ����� �Ǿ����� üũ�Ѵ�
         //��� UI
         System.out.println("=====================================================================");
         for (int j = dan - (range / 2); j <= dan + (range / 2); j++) { //������ 2�� ������ �ȴ�. !!!!!!!!!!
         if (j < 2) { //2�� ������ ���������� ���� ǥ��
         System.out.print("\t");
         } else {
         System.out.print("     " + j + " �� " + "\t");
         }
         }
         System.out.println("");
         System.out.println("=====================================================================");
         //������ ���
         for (int i = 1; i < 10; i++) {
         for (int j = dan - (range / 2); j <= dan + (range / 2); j++) {
         if (j < 2) {//2�� ������ ������ ���� ���� ǥ��
         System.out.print("\t");
         } else {
         System.out.print(j + " x " + i + " = " + (i * j) + "\t");
         }
         }
         System.out.println(" ");
         }
         } else {
         System.out.println("������ �߸� �Է��ϼ̽��ϴ�.");
         }
         }
         */
        
        //��ȿ����ڵ�
        int start = dan - range / 2;
        int end = dan + range / 2;
        for (int i = 0; i < 10; i++) {
            for (int j = start; j < end + 1; j++) {
                if (i == 0) {
                    System.out.print(j + "��\t\t");
                } else {
                    if (j >= 0) {
                        System.out.print(j + " x " + i + " = " + (i * j) + "\t");
                    } else {
                        System.out.print("\t\t");
                    }
                }
            }
            System.out.println("");
        }
    }
}
