package exam;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ������
 * Document : Thread2 
 * Created on : 2014. 9. 23, ���� 1:20:23
 */
public class Thread2 implements Runnable{

    @Override
    public void run() {
        //�������� ������ �����غ��� ���� ���� �����尡 ����ǰ�
        //ù��° ���� �׸��� �����尡 ���۵ǰ� ù��° �����尡 ������
        //�ι�° ���� �׸��� �����尡 ���۵Ǿ�� �Ѵ�.
        //�׷��� �ι�° ���� �׸��� ������� ù��° ���� �׸������� ���� �־��
        //�ϱ� ������ th1.join( ) �� ����ؼ� ���� �ֵ��� �����.
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
