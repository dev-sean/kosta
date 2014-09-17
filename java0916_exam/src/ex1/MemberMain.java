package ex1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ?¤ì?¸í??
 * Document : MemberMain 
 * Created on : 2014. 9. 16, ?¤í?? 5:22:02
 */
public class MemberMain {
    

    public String checkAge(MemberVO vo){ 

        if(vo.getAge() <= 18){
            return "[ë¯¸ì?±ë????] / ?±ë??";
        }else{
            return "ë¯¸ì?±ë???? / [?±ë??]";
        }
    }
    
    public static void main(String[] args) {
        MemberMain mm = new MemberMain();
        ArrayList<MemberVO> member = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //MemberControl mc = new MemberControl();
        
        while(true){
            System.out.print("1 - ??????ë³´ì????, 2 - ????ë¦¬ì?¤í?¸ì???, 3 - ì¢?ë£? :");
            int n= Integer.parseInt(sc.nextLine());
            if(n==1){
                MemberVO vo = new MemberVO();
                System.out.print("????ë²???(int) : ");
                vo.setNum(Integer.parseInt(sc.nextLine()));
                System.out.print("?????? ?´ë?(String) : ");
                vo.setName(sc.nextLine());
                System.out.print("?????? ëª¸ë¬´ê²?(float) : ");
                vo.setWeight(Float.parseFloat(sc.nextLine()));
                System.out.print("?????? ?????¬ë?(boolean) : ");
                vo.setAgree(Boolean.parseBoolean(sc.nextLine()));
                System.out.print("?????? ?´ë???(String) : ");
                vo.setMail(sc.nextLine());
                System.out.print("?????? ????(int) : ");
                vo.setAge(Integer.parseInt(sc.nextLine()));
                //mc.checkAge(vo);
                member.add(vo); //Member?? ??ë³´ê? ?´ê¸´ VOë¥? ArrayList?? ?£ë????.
            }else if(n==2){

                member.get(0).getAge();//get(index);
                for(MemberVO e : member){
                    System.out.println("È¸¿ø¹øÈ£ : "+e.getNum());
                    System.out.println("ÀÌ¸§ : "+ e.getName());
                    System.out.println("¸ö¹«°Ô : "+e.getWeight()+" Kg");
                    System.out.println("µ¿ÀÇ¿©ºÎ : "+e.isAgree());
                    System.out.println("ÀÌ¸ÞÀÏ : "+e.getMail());
                    System.out.println("³ªÀÌ : "+e.getAge());

                    //System.out.println(mc.getCheck());
                    System.out.println(mm.checkAge(e));
                }
            }else if(n==3){
                break;
            }        
        }
    }
}
