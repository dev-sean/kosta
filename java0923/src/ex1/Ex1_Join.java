package ex1;
/**
 * @author ������
 * Document : Ex1_Join 
 * Created on : 2014. 9. 23, ���� 9:06:04
 */
//���� �����尡 ������ ����ɶ� ���� �ٸ� �����尡
//����ϵ��� �ϴ� �޼���
public class Ex1_Join {
    private static long startTime;
    public static void main(String[] args) throws InterruptedException {
        Ex1_Thread1 t1 = new Ex1_Thread1();//���
        startTime = System.currentTimeMillis();
        t1.start();
        t1.join();//t1�� �۾��� ���������� �ٸ� ������� ���
        Ex1_Thread2 t2 = new Ex1_Thread2();
        Thread tt2 = new Thread(t2);//Runnable �������̽�
        tt2.start();
        tt2.join();
        //runnable �������̽��� ������ Ŭ������ �߻� �޼����� run�� ������ �ֱ� ������
        //start�޼��带 ȣ���� �� ����.
        //run�� ȣ���Ѵٴ� ������ �����忡�� ���� ��Ű�ڴٴ°� �ƴ϶� ������ run�� ȣ���ϰڴٴ� �ǹ��̱� ������
        //�̰� �����尡 �ƴϴ�.
        //�����带 ȣ���Ϸ��� start��� �޼��尡 ȣ�� �Ǿ��� �� ������ ������ �����޴´�.
        //�ü���� �����췯�� ���ؼ� �����尡 running �Ǵ� �Ŵ�.
        //runnable�������̽��� �������� ���� �ݵ�� �����带 �����ؼ� 
        //�������� ������ ���ڿ� ������� ������ Ŭ������ �ּҸ� �־���� �Ѵ�.
        
        System.out.println("�ɸ��ð� :"+(System.currentTimeMillis()-startTime));
    }
}
