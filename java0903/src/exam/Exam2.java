package exam;

import java.util.Scanner;

/**
 * @author kosta 
 * Document : Exam2 Created on : 2014. 9. 3, ���� 2:33:52
 */
public class Exam2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int range;
        System.out.print("���� �Է��ϼ��� : ");
        num = Integer.parseInt(sc.nextLine());
        System.out.print("������ �Է��ϼ��� : ");
        range = Integer.parseInt(sc.nextLine());
        System.out.println("[Result]");
        for (int i = 0; i < num + 1; i++) {
            if ((i % range) == (range-1)) {
                System.out.println(i);
            } else {
                System.out.print(i + " ");
            }
        }        
        /*
        for(int i=0; i<=num; i++){
            if(i%range == 0 && i != 0){
                System.out.println();
            }
            System.out.print(i+"\t");
        }        
        */
        System.out.print("���� �Է��ϼ��� : ");
        num = Integer.parseInt(sc.nextLine());
        System.out.print("������ �Է��ϼ��� : ");
        range = Integer.parseInt(sc.nextLine());
        System.out.println("[Result]");
        for (int i = 0; i < num + 1; i++) {
            if ((i % range) == (range - 1)) {
                System.out.println(i);
            } else {
                System.out.print(i + " ");
            }
        }
    }
}