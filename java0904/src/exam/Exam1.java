package exam;

import java.util.Scanner;

/**
 * @author 오세현 Document : Exam1 Created on : 2014. 9. 4, 오후 1:48:15
 */
public class Exam1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int win = 0; //사용자가 이긴 횟수
        int total = 0; //사용자가 총 진행한 게임 수
        String item; //상품
        while (true) {
            int ran = (int) (Math.random() * 2); //0과 1만 출력 0=홀수, 1=짝수
            System.out.print("1 - 홀, 2 - 짝, 3 - 종료 :");
            int num = Integer.parseInt(sc.nextLine());

            if (num == 1) {
                if (ran == 0) {
                    total++;
                    win++;
                    System.out.println("TOTAL : " + total);
                    System.out.println("CPU : 홀");
                    System.out.println("YOU : 홀");
                    winning(win);
                } else {
                    total++;
                    System.out.println("TOTAL : " + total);
                    System.out.println("CPU : 짝");
                    System.out.println("YOU : 홀");
                    loosing(win);
                }
            } else if (num == 2) {
                if (ran == 1) {
                    total++;
                    System.out.println("TOTAL : " + total);
                    System.out.println("CPU : 짝");
                    System.out.println("YOU : 홀");
                    loosing(win);
                } else {
                    total++;
                    win++;
                    System.out.println("TOTAL : " + total);
                    System.out.println("CPU : 짝");
                    System.out.println("YOU : 짝");
                    winning(win);
                }
            } else if (num == 3) {
                break;
            } else {
                System.out.println("잘못된 수!");
            }
        }
        System.out.println("--------------------");
        System.out.println("TOTAL : " + total);
        System.out.println("WIN : " + win);
        /*
         double totaldouble = total; //승률을 계산하기 위한 임시 변수, 전체 게임 수
         double windouble = win; // 승률을 계산하기 위한 임시 변수, 승률
         double winratedouble = (windouble / totaldouble) * 100; //승률을계산하기 위한 임시 변수, 승률
         int winrate = (int) Math.round(winratedouble);//double형 승률을 int형으로 바꾼다.
         */
        int winrate = score(total, win);
        System.out.println("승률 : " + winrate + "%");
        System.out.println("상품 : " + gift(winrate, total));
    }

    public static void winning(int win) {
        System.out.println("--------------------");
        System.out.println("WIN : " + win);
        System.out.println("[승리하셨습니다.]");
    }

    public static void loosing(int win) {
        System.out.println("--------------------");
        System.out.println("WIN : " + win);
        System.out.println("[당신은 졌습니다.]");
    }

    public static int score(int total, int win) {
        int result = 0;
        result = (int) (((double) win / total) * 100);

        return result;
    }

    public static String gift(int score, int total) {
        String msg = "";

        if (total < 10) {
            System.out.println("10게임을 진행하지 않았습니다.");
        } else {
            if (score == 100) {
                msg = "사탕5개";
            } else if (score < 100 && score >= 90) {
                msg = "사탕4개";
            } else if (score < 90 && score >= 80) {
                msg = "사탕3개";
            } else if (score < 80 && score >= 70) {
                msg = "사탕2개";
            } else if (score < 70 && score >= 60) {
                msg = "사탕1개";
            } else {
                msg = "없음";
            }
        }
        return msg;
    }
}
