package exam3;

import java.util.Scanner;

/**
 * @author 오세현 Document : BoardMain Created on : 2014. 9. 11, 오후 2:06:16
 */
public class BoardMain {
    /*
     1.입력 , 2. 출력, 3. 종료 : 1
     제목 :
     작성자 : 
     내용 : 
     현재날짜 : 
     1.입력 , 2. 출력, 3. 종료 : 2
     제목 , 작성자, 내용, 현재날짜 출력
     */

    public static void input() {
        System.out.println("제목 : ");
        System.out.println("성별 : ");
        System.out.println("작성자 : ");
        System.out.println("내용 : ");
        System.out.println("현재날짜 : ");
    }

    public static void main(String[] args) {
        int menu;
        //boolean flag=true;
        Scanner sc = new Scanner(System.in);
        
        BoardControl a = new BoardControl();
        while (true) {
            System.out.print("1. 입력, 2. 출력, 3. 종료 :");
            menu = Integer.parseInt(sc.nextLine());
            if (menu == 1) {
                BoardVO vo = new BoardVO();
                System.out.print("제목 : ");
                vo.setTitle(sc.nextLine());
                System.out.print("성별 : ");
                vo.setGender(sc.nextLine());
                System.out.print("작성자 : ");
                vo.setWriter(sc.nextLine());
                System.out.print("내용 : ");
                vo.setFill(sc.nextLine());
                System.out.print("현재날짜 : ");
                vo.setDate(sc.nextLine());
                boolean result = a.info(vo);
                if(result == false){
                    System.out.println("성별을 다시 입력해주세요");
                }
            } else if (menu == 2) {
                System.out.println("제목 : "+a.getVo().getTitle());                
                System.out.println("성별 : "+a.getVo().getGender());
                System.out.println("작성자 : "+a.getVo().getWriter()); 
                System.out.println("내용 : "+a.getVo().getFill());
                System.out.println("현재날짜 : "+a.getVo().getDate());      

            } else {
                break;
            }
        }
    }
}
