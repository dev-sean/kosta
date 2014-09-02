package ex1;

public class Ex2_DataType {
    public static void main(String[] args) {
        //자료형 변수명; -> 변수 선언
        //지역변수는 반드시 선언 후 초기화를 해야 한다.
        boolean myb = false, num = true;
        System.out.println("Boolean1의 값 :"+myb);
        
        //재사용
        //boolean myb = true;
        myb=true; //같은 지역에 있을 경우 변수 선언은 한 번만 한다.
        System.out.println("Boolean2의 값 :"+myb);
        System.out.println("Boolean num의 값 :"+num);
    }
}
