package inner;
/**
 * @author 오세현
 * Document : Memberinner 
 * Created on : 2014. 9. 15, 오후 2:04:52
 */
//내부클래스 : 특정클래스 안에 또 다른 클래스가 정의 되는 것을 의미한다.
//종류 : 멤버, 로컬, static,  익명

public class MemberInner {
    private int a = 10;
    private int b;
    private int c;

    public MemberInner() {
        b=100;
        c=200;
    }
    
    public class inner{
        public void printData(){
            System.out.println("외부클래스의 private에 접근가능 : "+a);
            System.out.println("외부클래스의 private에 접근가능 : "+b);
            System.out.println("외부클래스의 private에 접근가능 : "+c);
        }
    }
    
    //내부 클래스 생성 및 접근
    public static void main(String[] args) {
        //외부 클래스를 생성한다.
        //MemberInner outer = new MemberInner();
        //외부클래스의 주소를 통해서 내부클래스를 생성 및 접근
        //MemberInner.inner inner = outer.new inner();
        //inner.printData();
        MemberInner.inner inner = new MemberInner().new inner();
        inner.printData();
        
    }
}