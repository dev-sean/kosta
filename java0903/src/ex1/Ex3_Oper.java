package ex1;
/**
 * @author kosta
 * Document : Ex3_Oper 
 * Created on : 2014. 9. 3, 오전 11:01:44
 */
public class Ex3_Oper {
    //1씩 증가, 감소 하는 연산자, ++, -- 의 위치가 중요한 연산자.
    public static void main(String[] args) {
        int a= 10;
        System.out.println(a++); //후치
        System.out.println(++a); //전치
        
        int b = 20;
        System.out.println(b--);
        System.out.println(--b);
    }
}
