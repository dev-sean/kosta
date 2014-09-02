package ex1;

import java.util.Scanner;

/**
 * @author kosta
 * Document : Ex7_Operator 
 * Created on : 2014. 9. 2, 오후 3:11:32
 */
public class Ex7_Operator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("수 1:");
        int num1 = Integer.parseInt(sc.nextLine());
        //parseInt는 static 객체이다.
        System.out.print("수 2:");
        int num2 = Integer.parseInt(sc.nextLine());
        //Integer는 Int형 WrapperClass이다. 
        //WrapperClass는 기본형 타입을 객체로 사용하기 위해서 사용된다. 
        System.out.println(num1+ "+"+num2+"="+(num1+num2) );
        System.out.println(num1+ "-"+num2+"="+(num1-num2) );
        System.out.println(num1+ "*"+num2+"="+(num1*num2) );
        System.out.println(num1+ "/"+num2+"="+(num1/num2) );
        System.out.println("num1 : "+(num1%2==0));
        System.out.println("num2 : "+(num2%2==0));
    }
}
