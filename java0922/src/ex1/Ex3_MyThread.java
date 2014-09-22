package ex1;

/**
 * @author 오세현
 * Document : Ex3_MyThread 
 * Created on : 2014. 9. 22, 오전 11:32:58
 */
public class Ex3_MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("*");
        }
        System.out.println("");
        System.out.println("1 :"+ (System.currentTimeMillis()-Ex3_ThreadSingle.start));
    }  
}
