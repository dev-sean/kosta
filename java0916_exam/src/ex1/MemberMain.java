package ex1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ?��?��??
 * Document : MemberMain 
 * Created on : 2014. 9. 16, ?��?? 5:22:02
 */
public class MemberMain {
    

    public String checkAge(MemberVO vo){ 

        if(vo.getAge() <= 18){
            return "[미�?��????] / ?��??";
        }else{
            return "미�?��???? / [?��??]";
        }
    }
    
    public static void main(String[] args) {
        MemberMain mm = new MemberMain();
        ArrayList<MemberVO> member = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //MemberControl mc = new MemberControl();
        
        while(true){
            System.out.print("1 - ??????보�????, 2 - ????리�?��?��???, 3 - �?�? :");
            int n= Integer.parseInt(sc.nextLine());
            if(n==1){
                MemberVO vo = new MemberVO();
                System.out.print("????�???(int) : ");
                vo.setNum(Integer.parseInt(sc.nextLine()));
                System.out.print("?????? ?��?(String) : ");
                vo.setName(sc.nextLine());
                System.out.print("?????? 몸무�?(float) : ");
                vo.setWeight(Float.parseFloat(sc.nextLine()));
                System.out.print("?????? ?????��?(boolean) : ");
                vo.setAgree(Boolean.parseBoolean(sc.nextLine()));
                System.out.print("?????? ?��???(String) : ");
                vo.setMail(sc.nextLine());
                System.out.print("?????? ????(int) : ");
                vo.setAge(Integer.parseInt(sc.nextLine()));
                //mc.checkAge(vo);
                member.add(vo); //Member?? ??보�? ?�긴 VO�? ArrayList?? ?��????.
            }else if(n==2){

                member.get(0).getAge();//get(index);
                for(MemberVO e : member){
                    System.out.println("ȸ����ȣ : "+e.getNum());
                    System.out.println("�̸� : "+ e.getName());
                    System.out.println("������ : "+e.getWeight()+" Kg");
                    System.out.println("���ǿ��� : "+e.isAgree());
                    System.out.println("�̸��� : "+e.getMail());
                    System.out.println("���� : "+e.getAge());

                    //System.out.println(mc.getCheck());
                    System.out.println(mm.checkAge(e));
                }
            }else if(n==3){
                break;
            }        
        }
    }
}
