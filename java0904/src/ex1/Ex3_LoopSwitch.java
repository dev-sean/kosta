package ex1;

import java.util.Scanner;

/**
 * @author 오세현
 * Document : Ex3_LoopSwitch 
 * Created on : 2014. 9. 4, 오전 10:35:42
 */
public class Ex3_LoopSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        xx : for(;;){
            System.out.print("색상을 입력(R,G,B) : ");
            String col = sc.nextLine();
            //String API중에서 문자열을 소문자로 변경
            col = col.toLowerCase();
            String res = "";
            switch(col){
                case "red" :
                    System.out.println("빨간색이네요");
                    break;
                case "blue" :
                    System.out.println("파란색이네요");
                    break;
                case "bye" :
                    System.out.println("빨간색이네요");
                    break xx; //break-label문을 이용한 종료
            }
            System.out.println("당신이 입력한 색상은 "+res+" 입니다.");
        }
    }
}
