package ex3;
//인터페이스 설계 : 인터페이스는 메뉴판처럼 상수와 
public interface InterFaceTest {
    public static final int A = 100;//상수
    public int b =200;//IDE가 자동으로 상수로 만들어준다
    public abstract int getA();//추상 메서드
    public int getB();//IDE가 자동으로 추상 메서드로 만들어준다
}
