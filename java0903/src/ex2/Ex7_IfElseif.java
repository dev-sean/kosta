package ex2;

import java.util.Scanner;

/**
 * @author kosta
 * Document : Ex7_IfElseif 
 * Created on : 2014. 9. 3, ���� 1:50:58
 */
public class Ex7_IfElseif {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("�����ϴ� ���� �Է� : ");
        String msg = sc.nextLine();
        
        //equalsIgonoreCase�� ����ϸ� ��ҹ��� ���о��� �����ش�.
        if (msg.equalsIgnoreCase("red")) {
            System.out.println("����");
        } else if(msg.equals("blue")){
            System.out.println("�Ķ�");
        }else{
            System.out.println("�𸣴»�");
        }
    }
}
