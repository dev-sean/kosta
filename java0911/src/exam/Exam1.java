package exam;
/**
 * @author ������
 * Document : Exam1 
 * Created on : 2014. 9. 11, ���� 9:31:29
 */
public class Exam1 {
    
    public void test(int n){
        n = n+10;
        System.out.println("n1: "+n);
    }
    public static void main(String[] args) {
        Exam1 te = new Exam1(); //�ڱ� �ڽ��� �ٽ� ����
        int n = 10;
        te.test(n);
        System.out.println("n2: "+n);
    }
}
/*
public class Exam1 {
    //call by value
    //���ڷ� �����Ҷ� ���� �����ؼ� �ִ� �����̴�.
    //Stack���� �Ҹ�Ǳ� ������
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
//static�� �����϶�.
/*
public class Exam1 { 
   
    public static void main(String[] args) {
        int n = 10;
        Test test = new Test(); //�Ǵٸ� Ŭ������ ����
        test.test(n);        
        System.out.println("n2: "+n);
    }
}
*/
