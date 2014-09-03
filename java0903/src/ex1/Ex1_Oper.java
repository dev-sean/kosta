package ex1;
/**
 * @author kosta
 * Document : Ex1_Oper 
 * Created on : 2014. 9. 3, 오전 10:15:10
 */
public class Ex1_Oper {
    public static void main(String[] args) {
        //비교연산자 - 변수나 상수값을 비교 할 때 쓰이는 연산자.
        //결과는 항상 boolean(true/false)
        int a = 10;
        int b = 20;
        boolean c = a<b; //변수 a가 변수 b 보다 작다.
        System.out.println("a < b : " + c);
        c = a!=b; //변수 a와 b가 서로 같지 않다.
        System.out.println("a != b : " + c);
        
        c = ((a +=12) > b) && (a==(b+=2));
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        System.out.println("c : " + c);
        // && : 선조건이 true 일 때만 후조건을 실행하며
        // 선조건이 false 이면 후조건은 실행하지 않는다.
        // || : 선조건이 true이면 후조건을 실행하지 않으며
        // 선조건이 false일 때만 후조건을 실행한다.
    }
}
