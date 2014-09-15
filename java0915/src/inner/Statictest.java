package inner;
/**
 * @author 오세현
 * Document : Statictest 
 * Created on : 2014. 9. 15, 오후 3:05:49
 */
public class Statictest {
    //static이 붙어있으면 static 영역에 저장이 된다.
    private static int a;
    private int b;
    public int increment(){
        a++;
        return a;
    }
    public int increment2(){
        b++;
        return b;
    }
    public static void main(String[] args) {
        Statictest t1 = new Statictest();
        Statictest t2 = new Statictest();
        System.out.println(t1.increment());//1
        System.out.println(t1.increment2());//1
        System.out.println(t2.increment());//2
        //static과 non-static의 차이
        System.out.println(t2.increment2());//1
    }
}
