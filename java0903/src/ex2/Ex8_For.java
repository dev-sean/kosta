package ex2;
/**
 * @author kosta
 * Document : Ex8_For 
 * Created on : 2014. 9. 3, 오후 2:10:16
 */
public class Ex8_For {
    
    public static void main(String[] args) {
        loopFor();
    }

    private static void loopFor() {
        //초기식, 초기화 등 => 일생동안 딱 한번의 의미
        //for(초기식; 조건식; 증감식){
        //  실행문;
        //}
        for (int i = 0; i < 10; i++) {
            System.out.println(i+"안녕");
        }
    }
}
