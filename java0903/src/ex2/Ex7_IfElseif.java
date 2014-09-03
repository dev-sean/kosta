package ex2;

import java.util.Scanner;

/**
 * @author kosta
 * Document : Ex7_IfElseif 
 * Created on : 2014. 9. 3, 오후 1:50:58
 */
public class Ex7_IfElseif {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("좋아하는 색상 입력 : ");
        String msg = sc.nextLine();
        
        //equalsIgonoreCase를 사용하면 대소문자 구분없이 비교해준다.
        if (msg.equalsIgnoreCase("red")) {
            System.out.println("빨강");
        } else if(msg.equals("blue")){
            System.out.println("파랑");
        }else{
            System.out.println("모르는색");
        }
    }
}
