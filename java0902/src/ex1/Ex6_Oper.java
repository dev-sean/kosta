package ex1;

import java.util.Scanner;

/**
 * @author kosta
 * Document : Ex6_Oper Created on : 2014. 9. 2, 오후 1:59:52
 */
public class Ex6_Oper {
    public static void main(String[] args) {
//        int a=10;
//        int b=20;
//        System.out.println("a와b의 값 비교 :"+(a==b));
//        //일반 자료형일 때는 값 비교
//        String str1 = new String("T");
//        String str2 = new String("T");
//        System.out.println("str1와str2의 값 비교 :"+(str1==str2));
//        //참조 자료형일 때는 주소 비교
//        
//        String str3 = "T";
//        String str4 = "T";
//        System.out.println("str3와str4의 값 비교 :"+(str3==str4));
        //Scanner 클래스를 사용해서 사용자로부터 입력처리
        //클래스를 사용하기 위해서는 Ctrl + space로 불러서 사용
        Scanner sc = new Scanner(System.in);
        
        //UI 글자를입력하세요.
        System.out.print("메세지입력: ");
        
        //사용자로부터 문자열을 입력받은 후 String msg에 저 장하기
        //sc.nextLine()란 메서드가 호출이 되면 String으로 반환되기 때문에
        //아래와 같이 같은 타입의 변수에 저장해서 사용될 수 있다.
        //메서드 분석) 입력받은 문자열을 한줄 단위로 읽어서 String로 반환한다.
        //객체는 딱 한번 호출해서 재사용되기 때문에 다시 메시지를 입력할때 Scanner를 다시 선언할 필요가 없다.
        String msg = sc.nextLine();
        
        System.out.print("메시지입력2: ");
        String msg1 = sc.nextLine();
        System.out.println("====================");
        System.out.println("입력값1 : "+msg);
        System.out.println("입력값2 : "+msg1);
        System.out.println("msg/msg1 주소값을 비교 :"+(msg==msg1));//false
        //msg와 msg1의 주소값이 다르다는 이유는 Heap 영역에 sc객체가 2개가 생성되어 있다는 것을 의미한다.
        //String 클래스 : 문자열값을 가지는 객체
        System.out.println("msg/msg1 내용비교 :"+(msg.equals(msg1)));//true
        //증명
        String svc1 = new String("MyTest");
        String svc2 = new String("MyTest");
        System.out.println("svc1/svc2qq 내용비교 :"+(svc1.equals(svc2)));//true
        System.out.println(svc1==svc2);
        String svc3 = "Q";
        String svc4 = "Q";
        System.out.println(svc3==svc4);
        //암시적 객체 생성일 경우에는 String의 주소 값이 같다.
        //scanner를 이용해서 String msg = sc.nextLine()으로 문자열을 입력받을 때는
        //nextLine()안에서 new를 사용하여 객체를 생성한 후에 넘겨주기 때문에 주소값이 다르다.
    }
}
