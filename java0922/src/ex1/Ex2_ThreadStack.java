package ex1;
/**
 * @author 오세현
 * Document : Ex2_ThreadStack 
 * Created on : 2014. 9. 22, 오전 10:48:11
 */
public class Ex2_ThreadStack extends Thread{

    @Override
    public void run() {
        showStack();
    }
    
    public void showStack(){
        try {
            throw new InterruptedException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        //new Ex2_ThreadStack().start();
        new Ex2_ThreadStack().run();
    }
}
