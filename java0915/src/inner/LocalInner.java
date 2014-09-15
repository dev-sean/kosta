package inner;

import exam.Animal2;

/**
 * @author 오세현
 * Document : LocalInner 
 * Created on : 2014. 9. 15, 오후 2:44:37
 */
//로컬내부클래스 : 특정 메서드 안에서 정의되는 클래스.
//지역변수와 같은 개념이라서 메서드가 호출 될 때 객체가 생성될 수 있고,
//메서드의 수행이 끝나면 지역변수와 같이 자동으로 소멸된다.
public class LocalInner {
    private int a = 100;//멤버변수
    public void myMethod(int n){
        int b = 200;//메서드 내의 지역변수
        final int C = 300; //상수
        //Local 내부 클래스
        //
        class Inner extends Animal2{
            public void getData(){
                //외부클래스의 자원 접근
                System.out.println("int a :"+a);
                //지역변수는 접근 못함(jdk8부터 지원, jdk5,6,7안됨)
                //jdk5-7까지라면 반드시 지역변수를 상수로 변경해야 됨
                System.out.println("int b :"+n);
            }

            @Override
            public String col() {
                return "빨간";
            }
        }
        Inner i = new Inner();
        i.getData();
    }
    public static void main(String[] args) {
        LocalInner outer = new LocalInner();
        outer.myMethod(20);
    }
}
