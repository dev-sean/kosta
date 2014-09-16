package ex1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현
 * Document : MyThread 
 * Created on : 2014. 9. 16, 오전 11:34:13
 */
public class MyThread {

    public MyThread() {
    }
    public static void main(String[] args) {
        new MyThread();
        for (int i = 0; i < 10; i++) {
            try {
                //일반적인 예외는 반드시 컴파일단계에서 점검한다.
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
