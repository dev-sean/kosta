package ex1;
/**
 * @author 오세현
 * Document : Ex3_ThreadSingle 
 * Created on : 2014. 9. 22, 오전 11:19:46
 */
//연습문제 : start는 다른클래스와 공유해야될 자원이기 때문에 static으로
//변경하고 Thread가 수행될 일을 Ex3_MyThread에게 담당시켜서
//사용해보자.
public class Ex3_ThreadSingle {
    static long start;
    public static void main(String[] args) {
        start = System.currentTimeMillis();

        Ex3_MyThread mt = new Ex3_MyThread();
        mt.start();
        
        for (int i = 0; i < 300; i++) {
            System.out.print("X");
        }
        System.out.println("");
        System.out.println("2 :"+ (System.currentTimeMillis()-start));
    }
}
