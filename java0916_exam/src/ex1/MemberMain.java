package ex1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 오세현
 * Document : MemberMain 
 * Created on : 2014. 9. 16, 오후 5:22:02
 */
public class MemberMain {
    
<<<<<<< HEAD
    public String checkAge(MemberVO vo){
=======
    public String checkAge(MemberVO vo){ //Age를 체크하기 위한 메서드
>>>>>>> d3b27d775724b773f8efbabc014feac8da8a553e
        if(vo.getAge() <= 18){
            return "[미성년자] / 성년";
        }else{
            return "미성년자 / [성년]";
        }
    }
    
    public static void main(String[] args) {
        MemberMain mm = new MemberMain();
        ArrayList<MemberVO> member = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //MemberControl mc = new MemberControl();
        
        while(true){
            System.out.print("1 - 회원정보입력, 2 - 회원리스트출력, 3 - 종료 :");
            int n= Integer.parseInt(sc.nextLine());
            if(n==1){
                MemberVO vo = new MemberVO();
                System.out.print("회원번호(int) : ");
                vo.setNum(Integer.parseInt(sc.nextLine()));
                System.out.print("회원의 이름(String) : ");
                vo.setName(sc.nextLine());
                System.out.print("회원의 몸무게(float) : ");
                vo.setWeight(Float.parseFloat(sc.nextLine()));
                System.out.print("회원의 동의여부(boolean) : ");
                vo.setAgree(Boolean.parseBoolean(sc.nextLine()));
                System.out.print("회원의 이메일(String) : ");
                vo.setMail(sc.nextLine());
                System.out.print("회원의 나이(int) : ");
                vo.setAge(Integer.parseInt(sc.nextLine()));
                //mc.checkAge(vo);
                member.add(vo); //Member의 정보가 담긴 VO를 ArrayList에 넣는다.
            }else if(n==2){
<<<<<<< HEAD
                member.get(0).getAge();//get(index);
                for(MemberVO e : member){
                    System.out.println("ȸ����ȣ : "+e.getNum());
                    System.out.println("�̸� : "+ e.getName());
                    System.out.println("������ : "+e.getWeight()+" Kg");
                    System.out.println("���ǿ��� : "+e.isAgree());
                    System.out.println("�̸��� : "+e.getMail());
                    System.out.println("���� : "+e.getAge());
=======
                for(MemberVO e : member){ //Member의 정보를 출력한다.
                    System.out.println("회원번호 : "+e.getNum());
                    System.out.println("이름 : "+ e.getName());
                    System.out.println("몸무게 : "+e.getWeight()+" Kg");
                    System.out.println("동의여부 : "+e.isAgree());
                    System.out.println("이메일 : "+e.getMail());
                    System.out.println("나이 : "+e.getAge());
>>>>>>> d3b27d775724b773f8efbabc014feac8da8a553e
                    //System.out.println(mc.getCheck());
                    System.out.println(mm.checkAge(e));
                }
            }else if(n==3){
                break;
            }        
        }
    }
}
