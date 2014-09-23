package exam;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현 Document : Thread1 Created on : 2014. 9. 23, 오후 1:10:05
 */
public class Thread1 extends Thread {
    //HomeWork.java에 선언한 static 변수들을 가져오기 위해서
    //HomeWork.변수   를 사용한다.
    @Override
    public void run() {
        for (int i = 0; i < 36; i++) {
            try {
                Thread.sleep(100);
                //첫번째 Arc의 각도를 10씩 증가시켜준다.
                Main.angle2 += 10;
                Main.can.repaint();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }   
        }
    }
}
