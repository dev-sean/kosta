package inner;
/**
 * @author ������
 * Document : Statictest 
 * Created on : 2014. 9. 15, ���� 3:05:49
 */
public class Statictest {
    //static�� �پ������� static ������ ������ �ȴ�.
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
        //static�� non-static�� ����
        System.out.println(t2.increment2());//1
    }
}
