package ex1;
/**
 * @author 오세현
 * Document : Ex1_Constructor 
 * Created on : 2014. 9. 11, 오후 3:47:06
 */
public class Ex1_Constructor {
    //컴파일단계 -> JVM 실행
    //개발자가 생성자를 따로 정의 해두지 않으면 컴파일러가 
    //기본생성자를 정의 해둔다.
    //생성자는 클래스명과 같고 반환형이 없다.
    //목적 : 현재클래스를 초기화시키는 것이 목적이다.
    //기본생성자
    public Ex1_Constructor(){
        
    }
    private String msg;
    //멤버의 자원을 초기화 하는 목적!!!!
    //인자값이 있는 생성자
    
    //현재클래스에 값을 주입할 수 있는 방법 : 메서드(setter), 생성자 뿐이다.
    public Ex1_Constructor(String msg){
        this.msg = msg;
    }
    //개발자가 어떤 생성자를 하나라도 정의해놓으면 
    //컴파일러는 기본생성자를 따로 제공해주지 않는다.
    public static void main(String[] args) {
        //클래스를 객체로 생성
        Ex1_Constructor ref = new Ex1_Constructor();//생성
        ref.test();
    }

    private void test(){
        System.out.println("테스트!!");
    }
}
