package ex1;

import java.util.Scanner;

/**
 * @author 오세현 
 * Document : Ex2_Switch 
 * Created on : 2014. 9. 4, 오전 10:17:11
 */
public class Ex2_Switch {

    public static void main(String[] args) {
        //겨울 11,12,1,2
        //봄 3,4,5
        //여름 6,7,8
        //가을 9,10
        Scanner sc = new Scanner(System.in);
        System.out.print("월 입력 : ");
        int m = Integer.parseInt(sc.nextLine());
        String res;
        switch (m) {
            case 11:
            case 12:
            case 1:
            case 2:
                res = "겨울";
                break;
            case 3:
            case 4:
            case 5:
                res = "봄";
                break;
            case 6:
            case 7:
            case 8:
                res = "여름";
                break;
            case 9:
            case 10:
                res = "가을";
                break;
            default:
                res = "몰라 알수가없어 ";
        }
        System.out.println("선택한 월은 " + res + "입니다.");
    }
}
