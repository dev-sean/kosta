package exam2;

import java.util.Scanner;

/**
 * @author ������
 * Document : Ex1_Main 
 * Created on : 2014. 9. 11, ���� 11:28:57
 */
public class Ex1_Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ex1_MemberVO ref = new Ex1_MemberVO(); //VO��ü ����
        Ex1_CallByReference ref1 = new Ex1_CallByReference();
        System.out.print("��ȣ�Է� : ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.print("�̸��Է� : ");
        String name = sc.nextLine();
        System.out.print("�����Է� : ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("�����Է� : ");
         String gender = sc.nextLine();
        System.out.print("��ȭ��ȣ�Է� : ");
        String tel = sc.nextLine();
        
        ref.setNum(num);
        ref.setName(name);
        ref.setAge(age);
        ref.setGender(gender);
        ref.setTel(tel);
        
        ref1.info(ref);
        System.out.println(ref1.getRef().getName());
    }
}
/*
public class Ex1_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("��ȣ�Է� : ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.print("�̸��Է� : ");
        String name = sc.nextLine();
        System.out.print("�����Է� : ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("�����Է� : ");
        String gender = sc.nextLine();
        System.out.print("��ȭ��ȣ�Է� : ");
        String tel = sc.nextLine();
        
        Ex1_CallByReference ref = new Ex1_CallByReference();
        ref.info(num, name, age, gender, tel);
    }
}
*/