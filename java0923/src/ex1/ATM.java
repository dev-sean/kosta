package ex1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현 Document : ATM Created on : 2014. 9. 23, 오전 10:41:36
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

    //임계영역 발생 지점 : 스레드들이 모여서 공동으로 작업하는 공간
    //여기서 동시성 문제가 발생 될 수 있다.    
    //synchronized를 걸어서 작성하면 Lock Pool에 스레드가 들어가서
    //해당 일을 할 동안 다른 스레드의 간섭을 받지 않는다.
    private synchronized void withDraw(int howMuch) {
        String tname = Thread.currentThread().getName();
        if (getDepositMoney() > 0) {
            //1000씩 감소시킨다.
            depositMoney -= howMuch;
            System.out.print("ThreadName :" + tname + " , ");
            System.out.println("잔액 :" + getDepositMoney());
        } else {
            System.out.print("ThreadName :" + tname + " , ");
            System.out.println("잔액이 부족합니다.");
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
