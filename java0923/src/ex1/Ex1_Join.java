package ex1;
/**
 * @author 오세현
 * Document : Ex1_Join 
 * Created on : 2014. 9. 23, 오전 9:06:04
 */
//현재 스레드가 무사히 종료될때 까지 다른 스레드가
//대기하도록 하는 메서드
public class Ex1_Join {
    private static long startTime;
    public static void main(String[] args) throws InterruptedException {
        Ex1_Thread1 t1 = new Ex1_Thread1();//상속
        startTime = System.currentTimeMillis();
        t1.start();
        t1.join();//t1의 작업이 끝날때까지 다른 스레드는 대기
        Ex1_Thread2 t2 = new Ex1_Thread2();
        Thread tt2 = new Thread(t2);//Runnable 인터페이스
        tt2.start();
        tt2.join();
        //runnable 인터페이스를 구현한 클래스는 추상 메서드인 run만 가지고 있기 때문에
        //start메서드를 호출할 수 없다.
        //run을 호출한다는 개념은 스레드에게 일을 시키겠다는게 아니라 메인이 run을 호출하겠다는 의미이기 때문에
        //이건 스레드가 아니다.
        //스레드를 호출하려면 start라는 메서드가 호출 되었을 때 별도의 스택을 제공받는다.
        //운영체제의 스케쥴러에 의해서 스레드가 running 되는 거다.
        //runnable인터페이스를 구현했을 때는 반드시 스레드를 생성해서 
        //스레드의 생성자 인자에 런어블을 구현한 클래스의 주소를 넣어줘야 한다.
        
        System.out.println("걸린시간 :"+(System.currentTimeMillis()-startTime));
    }
}
