package exam;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ������ Document : Thread1 Created on : 2014. 9. 23, ���� 1:10:05
 */
public class Thread1 extends Thread {
    //HomeWork.java�� ������ static �������� �������� ���ؼ�
    //HomeWork.����   �� ����Ѵ�.
    @Override
    public void run() {
        for (int i = 0; i < 36; i++) {
            try {
                Thread.sleep(100);
                //ù��° Arc�� ������ 10�� ���������ش�.
                Main.angle2 += 10;
                Main.can.repaint();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }   
        }
    }
}
