package ex2;
/**
 * @author 오세현
 Document : NewMain 
 Created on : 2014. 9. 5, 오전 11:31:50
 */
public class NewMain {
    public static void main(String[] args) {
        NewClass ref = new NewClass();
        ref.insertPay(1000, "dd");
        int pay = ref.getPay();
        int res = pay * 100;
        System.out.println("급여는 : "+res);
    }    
}
