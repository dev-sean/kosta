package ex2;

/**
 * @author kosta Document : MyThread2 Created on : 2014. 9. 23, 오후 5:19:27
 */

import java.awt.Canvas;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyThread2 implements Runnable {

    private MultiCanvas myCan;

    public MyThread2(MultiCanvas myCan) {
        this.myCan = myCan;
  }

    @Override
    public void run() {
        //쓰레드의 실행을 생각해보면 먼저 메인 스레드가 실행되고
        //첫번째 원을 그리는 스레드가 시작되고 첫번째 스레드가 끝나면
        //두번째 원을 그리는 스레드가 시작되어야 한다.
        //그래서 두번째 원을 그리는 스레드는 첫번째 원을 그릴때까지 멈춰 있어야
        //하기 때문에 myCan.getT1().join( ) 을 사용해서 멈춰 있도록 만든다.
        try {
            myCan.getT1().join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        while (myCan.getArcNum2() <= 380) {
            System.out.println("두번째 스레드 동작중" + myCan.getArcNum2() + " " + Thread.currentThread().getName());
            System.out.println("두번째 arcNum2" + myCan.getArcNum());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                System.out.println("발생");
            }
            int tmpN = myCan.getArcNum2();
            tmpN += tmpN + 10;
            myCan.setArcNum2(tmpN);
            myCan.getCan().repaint();
        }
    }
}
