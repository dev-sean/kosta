package ex1;

import java.util.Scanner;

/**
 * @author ������
 * Document : Ex1_RoboMain 
 * Created on : 2014. 9. 5, ���� 10:36:14
 */
public class Ex1_RoboMain {
    //Ex1_Robo.class �޾Ƽ� �����ϱ� ���� �۾�
    public static void main(String[] args) {
        //�����ڷ��� Ex1_Robo ref; ����
        //new �����ڸ� ����ؼ� Ex1_Robo() Heap������ ����
        Scanner sc = new Scanner(System.in);
        Ex1_Robo ref = new Ex1_Robo();
        System.out.print("�κ��� �ӵ���? : ");
        int speed = Integer.parseInt(sc.nextLine());
        
        //�Ӽ��� ���� �Ҵ�
        ref.power = true; //�������� �ִ� Ex1_Robo��ü�� �ڿ��� power��
        //true���� ������ ����.
        // �� �� ref.isPower() �޼��带 ȣ���ϸ� �翬�� true���� ������ �ִ�
        //power ���ΰ��� Ȯ���� �� �ִ�.
        if(ref.isPower() == true){
            System.out.println("�κ��� ������ �������ϴ�.");
        }else{
            System.out.println("�κ��� ������ �������ϴ�.");
        }
        ref.move(speed);
    }
}