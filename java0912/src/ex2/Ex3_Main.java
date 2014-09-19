package ex2;
/**
 * @author 오세현
 * Document : Ex3_Main 
 * Created on : 2014. 9. 12, 오전 10:51:39
 */
public class Ex3_Main{
    public static void main(String[] args) {
        //자식을 참조해서 객체를 생성하는 경우
        Ex3_Sub ref1 = new Ex3_Sub("30세", "홍길동", 3000);
        ref1.subMethod();
        System.out.println(ref1.superMethod());
        ref1.superCar(); //자식의 sueprCar(); 호출이 됨
        System.out.println("==================================================");
        
        //부모를 참조해서 객체를 생성하는 경우
        Ex3_Super ref2 = new Ex3_Sub("31세", "ㅏㅏㅏ", 3010);
    }
}
