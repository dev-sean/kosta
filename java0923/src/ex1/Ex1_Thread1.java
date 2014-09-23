package ex1;
/**
 * @author 오세현
 * Document : Ex1_Thread1 
 * Created on : 2014. 9. 23, 오전 9:06:46
 */
public class Ex1_Thread1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
    
}
