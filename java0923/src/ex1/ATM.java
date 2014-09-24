package ex1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ������ Document : ATM Created on : 2014. 9. 23, ���� 10:41:36
 */
public class ATM implements Runnable {

    private long depositMoney = 10000;

    public long getDepositMoney() {
        return depositMoney;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            withDraw(1000);
            if (getDepositMoney() <= 0) {
                break;
            }
        }
    }

    //�Ӱ迵�� �߻� ���� : ��������� �𿩼� �������� �۾��ϴ� ����
    //���⼭ ���ü� ������ �߻� �� �� �ִ�.    
    //synchronized�� �ɾ �ۼ��ϸ� Lock Pool�� �����尡 ����
    //�ش� ���� �� ���� �ٸ� �������� ������ ���� �ʴ´�.
    private synchronized void withDraw(int howMuch) {
        String tname = Thread.currentThread().getName();
        if (getDepositMoney() > 0) {
            //1000�� ���ҽ�Ų��.
            depositMoney -= howMuch;
            System.out.print("ThreadName :" + tname + " , ");
            System.out.println("�ܾ� :" + getDepositMoney());
        } else {
            System.out.print("ThreadName :" + tname + " , ");
            System.out.println("�ܾ��� �����մϴ�.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        Thread mother = new Thread(atm, "Mother");
        Thread son = new Thread(atm, "Son");

        mother.start();
        son.start();

    }
}
