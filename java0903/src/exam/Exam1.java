package exam;

import java.util.Scanner;

/**
 * @author kosta 
 * Document : Exam1 
 * Created on : 2014. 9. 3, 오전 11:35:35
 */
public class Exam1 {

    public static void main(String[] args) {
        //Scanner로부터 수를 입력받은 후 그 수가 홀수잊지 짝수인지를 출력하세요
        // ex) 수 입력 : 1 <Enter
        // 입력한 수 [ 1 ] 은 홀수입니다.
   
        Scanner sc = new Scanner(System.in);
        System.out.print("수 입력 : ");
        int num = Integer.parseInt(sc.nextLine());
        //리팩토링의 중요성!!
        if (num % 2 == 0) {
            System.out.println("입력한 수 [ " + num + " ] 은 짝수 입니다.");
        } else {
            System.out.println("입력한 수 [ " + num + " ] 은 홀수 입니다.");
        }
    }
}
