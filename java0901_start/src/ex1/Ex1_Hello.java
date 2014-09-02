//패키지 - 묶음, 같은 성격의 기능을 가진 클래스를 모아놓는 폴더(현업에서)
package ex1;
//public : 접근제한자, public 다른 모든 패키지에서 자유롭게 접근이 가능한 접근제한자.
//(가장 넓은 의미의 접근 제한)
//class 클래스이름 : 클래스이름을 식별자라고 한다.
// 식별자 규칙 : 반드시 대문자로 만들어야 한다, 특수기용 사용 안된다.($는 예외), 공백X, 숫자시작X
public class Ex1_Hello { //class 시작
    /*
    void : 메서드는 동작이며 동작은 호출된 시점에서 실행이 되는데 이때 동작된 메서드는 
    호출된 곳으로 수행한 값을 반환하게 되어 있다. 하지만 수행할 값이 없다면
    반환값 자리에 void라고 명시하면 된다.
    main메서드는 누가 호출할까요? JVM
    프로그램의 시작이라고도 한다.
    스택에 들어가는 순서도 정리 해보기
    JVM호출시에 값이 있으면 String[] args 사용
    */
    public static void main(String[] args){
        System.out.print("줄바꿈이 안됨");
        System.out.println("Hello, world!"); //호출
    }
}//class 끝
//모든 클래스의 설계는 { } 에 이루어 져야 한다.