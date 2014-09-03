package exam;

import java.util.Scanner;

/**
 * @author kosta 
 * Document : Exam3 Created on : 2014. 9. 3, 오후 4:12:33
 */
public class Exam3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("단입력 : ");
        int dan = Integer.parseInt(sc.nextLine());
        System.out.print("범위입력(3,5,7,9) : ");
        int range = Integer.parseInt(sc.nextLine());

        if (range == 3 || range == 5 || range == 7 || range == 9) { //범위입력이 제대로 되었는지 체크한다
            //결과 UI
            System.out.println("=====================================================================");
            for (int j = dan - (range / 2); j <= dan + (range / 2); j++) { //범위를 2로 나누면 된다. !!!!!!!!!!
                if (j < 2) { //2단 밑으로 떨어질때는 공백 표시
                    System.out.print("\t");
                } else {
                    System.out.print("     " + j + " 단 " + "\t");
                }
            }
            System.out.println("");
            System.out.println("=====================================================================");
            //구구단 출력
            for (int i = 1; i < 10; i++) {
                for (int j = dan - (range / 2); j <= dan + (range / 2); j++) {
                    if (j < 2) {//2단 밑으로 떨어질 때는 공백 표시
                        System.out.print("\t");
                    } else {
                        System.out.print(j + " x " + i + " = " + (i * j) + "\t");
                    }
                }
                System.out.println(" ");
            }
        } else {
            System.out.println("범위를 잘못 입력하셨습니다.");
        }
    }
}