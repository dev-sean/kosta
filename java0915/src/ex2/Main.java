package ex2;
/**
 * @author 오세현
 * Document : Main 
 * Created on : 2014. 9. 15, 오전 10:13:20
 */
public class Main {
    public static void main(String[] args) {
        //추상 클래스는 new로 생성될 수 없다.
         Super[] ar = new Super[2];//배열생성
         
         ar[0] = new A();
         ar[1] = new B();
         String msg[] = {"사각형","육각형"};
         int i = 0;
         for(Super e : ar){
             e.draw(msg[i]);
             i++;
         }
    }
}
