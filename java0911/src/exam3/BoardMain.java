package exam3;

import java.util.Scanner;

/**
 * @author ������ Document : BoardMain Created on : 2014. 9. 11, ���� 2:06:16
 */
public class BoardMain {
    /*
     1.�Է� , 2. ���, 3. ���� : 1
     ���� :
     �ۼ��� : 
     ���� : 
     ���糯¥ : 
     1.�Է� , 2. ���, 3. ���� : 2
     ���� , �ۼ���, ����, ���糯¥ ���
     */

    public static void input() {
        System.out.println("���� : ");
        System.out.println("���� : ");
        System.out.println("�ۼ��� : ");
        System.out.println("���� : ");
        System.out.println("���糯¥ : ");
    }

    public static void main(String[] args) {
        int menu;
        //boolean flag=true;
        Scanner sc = new Scanner(System.in);
        
        BoardControl a = new BoardControl();
        while (true) {
            System.out.print("1. �Է�, 2. ���, 3. ���� :");
            menu = Integer.parseInt(sc.nextLine());
            if (menu == 1) {
                BoardVO vo = new BoardVO();
                System.out.print("���� : ");
                vo.setTitle(sc.nextLine());
                System.out.print("���� : ");
                vo.setGender(sc.nextLine());
                System.out.print("�ۼ��� : ");
                vo.setWriter(sc.nextLine());
                System.out.print("���� : ");
                vo.setFill(sc.nextLine());
                System.out.print("���糯¥ : ");
                vo.setDate(sc.nextLine());
                boolean result = a.info(vo);
                if(result == false){
                    System.out.println("������ �ٽ� �Է����ּ���");
                }
            } else if (menu == 2) {
                System.out.println("���� : "+a.getVo().getTitle());                
                System.out.println("���� : "+a.getVo().getGender());
                System.out.println("�ۼ��� : "+a.getVo().getWriter()); 
                System.out.println("���� : "+a.getVo().getFill());
                System.out.println("���糯¥ : "+a.getVo().getDate());      

            } else {
                break;
            }
        }
    }
}
