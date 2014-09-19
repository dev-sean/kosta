package exam;

import java.util.Scanner;

/**
 * @author kosta 
 * Document   : ExamGame Created on : 2014. 9. 4, 오후 2:16:09
 */
public class ExamGame {
    //예시답안
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int winCnt=0, totalCnt=0;
        String[] m = {"","홀","짝"}; 
        while (true) {            
            System.out.print("홀-1,짝-2,종료-3:");
            int num = Integer.parseInt(sc.nextLine());
            int cNum = (int) (Math.random()*2)+1;
            String msg="";
            if(num == 3){
                System.out.println("TOTAL:"+totalCnt);
                System.out.println("WIN :"+winCnt);
                System.out.println("승률:"+winn(winCnt, totalCnt) +"%");
                System.out.println("상품 :"+gift(90));
                System.out.println("종료");
                break;
            }else if(num == cNum){
                msg ="[승리 하셨습니다]";
                winCnt++;
            }else if(num != cNum){
                msg ="[당신은 졌습니다.]";
            }
            totalCnt++;
            System.out.println("TOTAL:"+totalCnt);
            System.out.println("CPU :"+m[cNum]);
            System.out.println("YOU :"+m[num]);
         
            System.out.println("-------------");
            System.out.println("WIN :"+winCnt);
            System.out.println(msg);
        }
    }
    //메서드의 반환형 - 반환될 자료형으로 명시
    //return 자료형에 맞는 값을 사용해야함
    public static int winn(int win,int total){ 
    //메서드 분화. 
    //다른 클래스에서도 사용할 수있도록 만드는 것이다.
       int rate = (int) (((double)win/total) * 100);

        return rate;
    }
    public static String gift(int winNum){
        String gMsg="";
        if(winNum == 100){
            gMsg="축하합니다.  페라리 당첨입니다. ^^";
        }else if(winNum < 100 && winNum >= 90){
            gMsg="축하합니다. 그랜저 당첨입니다.";
        }else if(winNum < 90 && winNum >= 80){
            gMsg="축하합니다. 소나타2 당첨입니다.";
        }else if(winNum < 90 && winNum >= 80){
            gMsg="축하합니다. 소나타 당첨입니다.";
        }else if(winNum < 80 && winNum >= 60){
            gMsg="축하합니다. 당나귀 당첨입니다.";
        }else{
            gMsg="축하합니다. 숨쉬기 운동 1000번 당첨입니다.";
        }
        return gMsg;
    }
}