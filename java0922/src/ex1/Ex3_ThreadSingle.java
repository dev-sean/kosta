package ex1;
/**
 * @author ������
 * Document : Ex3_ThreadSingle 
 * Created on : 2014. 9. 22, ���� 11:19:46
 */
//�������� : start�� �ٸ�Ŭ������ �����ؾߵ� �ڿ��̱� ������ static����
//�����ϰ� Thread�� ����� ���� Ex3_MyThread���� �����Ѽ�
//����غ���.
public class Ex3_ThreadSingle {
    static long start;
    public static void main(String[] args) {
        start = System.currentTimeMillis();

        Ex3_MyThread mt = new Ex3_MyThread();
        mt.start();
        
        for (int i = 0; i < 300; i++) {
            System.out.print("X");
        }
        System.out.println("");
        System.out.println("2 :"+ (System.currentTimeMillis()-start));
    }
}
