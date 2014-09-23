package ex2;

/**
 * @author kosta Document : MyThread2 Created on : 2014. 9. 23, ���� 5:19:27
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
        try {
            myCan.getT1().join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        while (myCan.getArcNum2() <= 380) {
            System.out.println("�ι�° ������ ������" + myCan.getArcNum2() + " " + Thread.currentThread().getName());
            System.out.println("�ι�° arcNum2" + myCan.getArcNum());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                System.out.println("�߻�");
            }
            int tmpN = myCan.getArcNum2();
            tmpN += tmpN + 10;
            myCan.setArcNum2(tmpN);
            myCan.getCan().repaint();
        }
    }
}
