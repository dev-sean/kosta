package ex1;

import java.util.Scanner;

/**
 * @author kosta
 * Document : exam1 
 * Created on : 2014. 9. 2, ���� 3:34:37
 */
public class exam1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("����1 :");
        String msg = sc.nextLine();
        int num1 = Integer.parseInt(msg);
        System.out.print("����2 :");
        String msg1 = sc.nextLine();
        int num2 = Integer.parseInt(msg1);
        System.out.println("num1 > num2 :"+(num1>num2));
        System.out.println("num1 < num2 :"+(num1<num2));
        System.out.println("num1 >= num2 :"+(num1>=num2));
        System.out.println("num1 <= num2 :"+(num1<=num2));
        System.out.println("num1 == num2 :"+(num1==num2));
        System.out.println("num1 != num2 :"+(num1!=num2));
    }

}
