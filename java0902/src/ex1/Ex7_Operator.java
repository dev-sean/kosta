package ex1;

import java.util.Scanner;

/**
 * @author kosta
 * Document : Ex7_Operator 
 * Created on : 2014. 9. 2, ���� 3:11:32
 */
public class Ex7_Operator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("�� 1:");
        int num1 = Integer.parseInt(sc.nextLine());
        //parseInt�� static ��ü�̴�.
        System.out.print("�� 2:");
        int num2 = Integer.parseInt(sc.nextLine());
        //Integer�� Int�� WrapperClass�̴�. 
        //WrapperClass�� �⺻�� Ÿ���� ��ü�� ����ϱ� ���ؼ� ���ȴ�. 
        System.out.println(num1+ "+"+num2+"="+(num1+num2) );
        System.out.println(num1+ "-"+num2+"="+(num1-num2) );
        System.out.println(num1+ "*"+num2+"="+(num1*num2) );
        System.out.println(num1+ "/"+num2+"="+(num1/num2) );
        System.out.println("num1 : "+(num1%2==0));
        System.out.println("num2 : "+(num2%2==0));
    }
}
