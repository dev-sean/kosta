package ex1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ������
 * Document : Ex1_MyThread 
 * Created on : 2014. 9. 22, ���� 10:07:24
 */
//Thread�� �����ֱ� 3����
//New : Thread�� ������� ����(Thread th = new Thread())
//Runnable : ���డ���� ����(th.start() �޼��带 ȣ���� ����)
//�̶�, JVM�� �����췯�� �ش� �ü���� �����ٷ����� �ڿ��� �Ҵ� �ޱ� ���ؼ�
//��û�� ����
//Running : ���� ����(run() �޼��带 ������ ����)

//Thread�� �����ֱ�
//1. New -> Runnable -> Running -> Dead(����)
//2. Running -> Blocked -> Dead(���� - run�޼��尡 ����� ����)
//Thread�� Ʋ���� ������ Running ���¿��� Blocked ���·� �̵�
//����ȭ���, I/O Request ���� ������ �� �̵���.
//���� ������ ������ �� ��(��� ������ ?���� ������)���� ��� ������

//Thread�� �����ϴ� ��� ��, ���
public class Ex1_MyThread extends Thread{
    
    //�����忡�� ���� ���Ѻ���.
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(i);
        }
    }//override�� �θ�� �Ȱ��ƾ� �Ѵ�.
    //Thread�� ��ӹ޾ұ� ������ run�� �������� ������
    //�����忡�� ���� ��Ű�� ���ؼ� �������ؼ� ����ϴ� �޼����̴�.
    
    
}
