package ex1;

import java.util.Scanner;

/**
 * @author kosta
 * Document : Ex6_Oper Created on : 2014. 9. 2, ���� 1:59:52
 */
public class Ex6_Oper {
    public static void main(String[] args) {
//        int a=10;
//        int b=20;
//        System.out.println("a��b�� �� �� :"+(a==b));
//        //�Ϲ� �ڷ����� ���� �� ��
//        String str1 = new String("T");
//        String str2 = new String("T");
//        System.out.println("str1��str2�� �� �� :"+(str1==str2));
//        //���� �ڷ����� ���� �ּ� ��
//        
//        String str3 = "T";
//        String str4 = "T";
//        System.out.println("str3��str4�� �� �� :"+(str3==str4));
        //Scanner Ŭ������ ����ؼ� ����ڷκ��� �Է�ó��
        //Ŭ������ ����ϱ� ���ؼ��� Ctrl + space�� �ҷ��� ���
        Scanner sc = new Scanner(System.in);
        
        //UI ���ڸ��Է��ϼ���.
        System.out.print("�޼����Է�: ");
        
        //����ڷκ��� ���ڿ��� �Է¹��� �� String msg�� �� ���ϱ�
        //sc.nextLine()�� �޼��尡 ȣ���� �Ǹ� String���� ��ȯ�Ǳ� ������
        //�Ʒ��� ���� ���� Ÿ���� ������ �����ؼ� ���� �� �ִ�.
        //�޼��� �м�) �Է¹��� ���ڿ��� ���� ������ �о String�� ��ȯ�Ѵ�.
        //��ü�� �� �ѹ� ȣ���ؼ� ����Ǳ� ������ �ٽ� �޽����� �Է��Ҷ� Scanner�� �ٽ� ������ �ʿ䰡 ����.
        String msg = sc.nextLine();
        
        System.out.print("�޽����Է�2: ");
        String msg1 = sc.nextLine();
        System.out.println("====================");
        System.out.println("�Է°�1 : "+msg);
        System.out.println("�Է°�2 : "+msg1);
        System.out.println("msg/msg1 �ּҰ��� �� :"+(msg==msg1));//false
        //msg�� msg1�� �ּҰ��� �ٸ��ٴ� ������ Heap ������ sc��ü�� 2���� �����Ǿ� �ִٴ� ���� �ǹ��Ѵ�.
        //String Ŭ���� : ���ڿ����� ������ ��ü
        System.out.println("msg/msg1 ����� :"+(msg.equals(msg1)));//true
        //����
        String svc1 = new String("MyTest");
        String svc2 = new String("MyTest");
        System.out.println("svc1/svc2qq ����� :"+(svc1.equals(svc2)));//true
        System.out.println(svc1==svc2);
        String svc3 = "Q";
        String svc4 = "Q";
        System.out.println(svc3==svc4);
        //�Ͻ��� ��ü ������ ��쿡�� String�� �ּ� ���� ����.
        //scanner�� �̿��ؼ� String msg = sc.nextLine()���� ���ڿ��� �Է¹��� ����
        //nextLine()�ȿ��� new�� ����Ͽ� ��ü�� ������ �Ŀ� �Ѱ��ֱ� ������ �ּҰ��� �ٸ���.
    }
}
