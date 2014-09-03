package ex1;

import java.util.Scanner;

/**
 * @author kosta
 * Document : exam1 
 * Created on : 2014. 9. 2, ¿ÀÈÄ 3:34:37
 */
public class exam1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("num1 :");
        String msg = sc.nextLine();
        int num1 = Integer.parseInt(msg);
        //int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("num2 :");
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
