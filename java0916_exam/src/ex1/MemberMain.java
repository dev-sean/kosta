package ex1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ������
 * Document : MemberMain 
 * Created on : 2014. 9. 16, ���� 5:22:02
 */
public class MemberMain {
    /*
    public String checkAge(MemberVO vo){
        if(vo.getAge() <= 18){
            return "[�̼�����] / ����";
        }else{
            return "�̼����� / [����]";
        }
    }
    */
    public static void main(String[] args) {
        MemberMain mm = new MemberMain();
        ArrayList<MemberVO> member = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        MemberControl mc = new MemberControl();
        
        while(true){
            System.out.print("1 - ȸ�������Է�, 2 - ȸ������Ʈ���, 3 - ���� :");
            int n= Integer.parseInt(sc.nextLine());
            if(n==1){
                MemberVO vo = new MemberVO();
                System.out.print("ȸ����ȣ(int) : ");
                vo.setNum(Integer.parseInt(sc.nextLine()));
                System.out.print("ȸ���� �̸�(String) : ");
                vo.setName(sc.nextLine());
                System.out.print("ȸ���� ������(float) : ");
                vo.setWeight(Float.parseFloat(sc.nextLine()));
                System.out.print("ȸ���� ���ǿ���(boolean) : ");
                vo.setAgree(Boolean.parseBoolean(sc.nextLine()));
                System.out.print("ȸ���� �̸���(String) : ");
                vo.setMail(sc.nextLine());
                System.out.print("ȸ���� ����(int) : ");
                vo.setAge(Integer.parseInt(sc.nextLine()));
                mc.checkAge(vo);
                member.add(vo);
            }else if(n==2){
                for(MemberVO e : member){
                    System.out.println("ȸ����ȣ : "+e.getNum());
                    System.out.println("�̸� : "+ e.getName());
                    System.out.println("������ : "+e.getWeight()+" Kg");
                    System.out.println("���ǿ��� : "+e.isAgree());
                    System.out.println("�̸��� : "+e.getMail());
                    System.out.println("���� : "+e.getAge());
                    System.out.println(mc.getCheck());
                    //System.out.println(mm.checkAge(e));
                }
            }else if(n==3){
                break;
            }        
        }
    }
}
