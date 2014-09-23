package ex1;
/**
 * @author 오세현
 * Document : Ex1_Thread2 
 * Created on : 2014. 9. 23, 오전 9:09:04
 */
public class Ex1_Thread2 implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("l");
        }
        System.out.println("");
    }

}
