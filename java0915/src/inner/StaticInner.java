package inner;
/**
 * @author 오세현
 * Document : StaticInner 
 * Created on : 2014. 9. 15, 오후 3:05:25
 */
public class StaticInner {
    int a= 10;
    private int b = 100;
    static int c = 200;
    static class Inner{
        //어쩔수 없이 내부 클래스 안에서 static 자원을 사용하게 된다면
        //이때 내부 클래스는 static내부 클래스로 정의 되어야 한다.
        static int d = 1000;
        public void printData(){
            //System.out.println("int a : "+a);
            //System.out.println("int b : "+b);
            //static 자원이 아니기 때문에 사용할 수 없다.
            //사용하기 위해서는 객체로 생성한 후에 사용해야 한다.
            System.out.println("int c : "+c);
            System.out.println("int d : "+d);
        }
    }
    public static void main(String[] args) {
        StaticInner.Inner inner = new StaticInner.Inner();//static은 생성 없이 사용
        inner.printData();
    }
}