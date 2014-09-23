package exam;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현
 * Document : Thread2 
 * Created on : 2014. 9. 23, 오후 1:20:23
 */
public class Thread2 implements Runnable{

    @Override
    public void run() {
        //쓰레드의 실행을 생각해보면 먼저 메인 스레드가 실행되고
        //첫번째 원을 그리는 스레드가 시작되고 첫번째 스레드가 끝나면
        //두번째 원을 그리는 스레드가 시작되어야 한다.
        //그래서 두번째 원을 그리는 스레드는 첫번째 원을 그릴때까지 멈춰 있어야
        //하기 때문에 th1.join( ) 을 사용해서 멈춰 있도록 만든다.
        try {
            Main.th1.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < 36; i++) {
            try {
                Thread.sleep(100);
                Main.angle3+=10;
                Main.can.repaint();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
