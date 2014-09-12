package ex2;
/**
 * @author 오세현
 * Document : Ex3_Sub 
 * Created on : 2014. 9. 12, 오전 10:43:29
 */
public class Ex3_Sub extends Ex3_Super{
    private String age;//나이

    public Ex3_Sub(String age, String msg, int num) {
        super(num,msg);//super는 항상 상위에서 호출되어야 함.
        this.age = age;        
    }
    public void subMethod(){
        System.out.println("여긴 자식 메소드입니다.");
    }
    //어노테이션 : 실행 가능한 주석
    //여기서는 JVM이 Override라고 인식하는 키워드
    @Override
    public void superCar() {
        System.out.println("나만의 자동차");        
    }
}
