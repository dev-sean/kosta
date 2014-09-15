package ex3;
/**
 * @author 오세현
 * Document : InterTestEx 
 * Created on : 2014. 9. 15, 오전 11:32:08
 */
//인터페이스를 사용하는 클래스는 implements라는 키워드로 인터페이스를
//구현해서 추상 메서드를 재정의해야 될 목적이 있다.
public class InterTestEx implements InterFaceTest, MsgBank {

    @Override
    public int getA() {
        return A;
    }
    
    @Override
    public int getB() {
        return b;
    }
    

    @Override
    public String printMsg(String msg) {
        return msg+"입니다";
    }
    
    
    public static void main(String[] args) {
        InterTestEx it1 = new InterTestEx();
        
        System.out.println("A의 값 : "+it1.getA());
        System.out.println("B의 값 : "+it1.getB());
    }
}