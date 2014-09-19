package exam;
/**
 * @author 오세현
 * Document : Exam1 
 * Created on : 2014. 9. 11, 오전 9:31:29
 */
public class Exam1 {
    
    public void test(int n){
        n = n+10;
        System.out.println("n1: "+n);
    }
    public static void main(String[] args) {
        Exam1 te = new Exam1(); //자기 자신을 다시 생성
        int n = 10;
        te.test(n);
        System.out.println("n2: "+n);
    }
}
/*
public class Exam1 {
    //call by value
    //인자로 전달할때 값을 복사해서 주는 개념이다.
    //Stack에서 소멸되기 때문에
    public static void test(int n){
        n = n+10;
        System.out.println("n1: "+n);
    }
    public static void main(String[] args) {
        int n = 10;
        test(n);
        System.out.println("n2: "+n);
    }
}
*/
//static을 제거하라.
/*
public class Exam1 { 
   
    public static void main(String[] args) {
        int n = 10;
        Test test = new Test(); //또다른 클래스를 생성
        test.test(n);        
        System.out.println("n2: "+n);
    }
}
*/
