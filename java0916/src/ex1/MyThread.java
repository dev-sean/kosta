package ex1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ������
 * Document : MyThread 
 * Created on : 2014. 9. 16, ���� 11:34:13
 */
public class MyThread {

    public MyThread() {
    }
    public static void main(String[] args) {
        new MyThread();
        for (int i = 0; i < 10; i++) {
            try {
                //�Ϲ����� ���ܴ� �ݵ�� �����ϴܰ迡�� �����Ѵ�.
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
