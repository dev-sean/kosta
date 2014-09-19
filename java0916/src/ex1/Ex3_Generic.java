package ex1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 오세현
 * Document : Ex3_Generic 
 * Created on : 2014. 9. 16, 오후 3:31:17
 */
//jdk5부터 객체간의 캐스팅 문제를 해결하기 위해서
//전용컬렉션을 도입
public class Ex3_Generic {
    public static void main(String[] args) {
        //Vector와 ArrayList차이는 동기화 지원 여부이다.
        //Vector 가 동기화를 지원하는 기능! 있지만 다른 부분으로 대체 가능!
        //Generic - String만 담을 수 있는 ArrayList
        //jdk7부터 변경된 요소. 6이하는 에러 new ArrayList<>();
        ArrayList<String> str = new ArrayList<>();
        
        str.add("ok");
        str.add(String.valueOf(10));
        str.add(String.valueOf(3.14f));
        
        for(String e : str){
            System.out.println(e);
        }
        System.out.println("iterator");
        Iterator<String> it = str.iterator();
        while (it.hasNext()) {
            String string = it.next();
            System.out.println(string);   
        }
        
        ArrayList<Integer> num = new ArrayList<>();
        num.add(10);
        num.add(Integer.parseInt("11"));
    }
}

        //과제
        //ArrayList를 사용하다 보니까
        //회원정보를 저장하고 싶다.
        //근데 제네릭으로 표현되면 어떻게 각기 다른 자료형들을 넣어서
        //회원정보에 저장할수있을까요?
        //실행화면
        //1. 회원정보입력 2.리스트 3.종료 : 1
        //회원번호(int) :
        //회원의이름(String) : 
        //회원의 몸무게(float) : 
        //회원의 동의여부(boolean) : 
        //회원의 이메일(String) : 
        //회원의 나이(int) : 
        //1. 회원정보입력 2.리스트 3.종료
        //여러번 반복해서 회원을 5명 정도 추가
        //1. 회원정보입력 2.리스트 3.종료 : 2
        //회원번호 : 1
        //이름 : 김길동
        //몸무게 : 1.1 kg
        //동의여부 : false
        //이메일 : sdjfi@naver.com
        //나이 : 18
        //[미성년자] / 성년
        //==========================
        
        //[ 과제 ] - B조 오세현 : ArrayList를 응용한 회원관리