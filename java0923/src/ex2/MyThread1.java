package ex2;

/**
 * @author kosta Document : MyThread1 Created on : 2014. 9. 23, 오후 5:19:04
 */
import java.awt.Canvas;

public class MyThread1 extends Thread{
    //MultiCanvas 객체의 주소를 가져오기 위한 멤버필드
    private MultiCanvas myCan;
    //생성자를 이용해서 현재 스레드가 생성되면
    //MultiCanvas 객체를 가져온다. 
    //이렇게 되면 MyThread1 클래스에서 MultiCanvas 클래스에 접근할 수 있다.
    public MyThread1(MultiCanvas myCan) {
        this.myCan = myCan;
    }

    @Override
    public void run() {
        
        while (myCan.getArcNum() <= 380) {
            System.out.println("첫번째 스레드 동작중" + myCan.getArcNum() + " " + Thread.currentThread().getName());
            System.out.println("arcNum2" + myCan.getArcNum2());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                System.out.println("발생");
            }
            int tmpN = myCan.getArcNum();
            tmpN += tmpN + 10;
            myCan.setArcNum(tmpN);//Arc의 angle값을 설정한다.
            myCan.getCan().repaint();//Canvas를 다시 설정한다.
        }
    }
}
