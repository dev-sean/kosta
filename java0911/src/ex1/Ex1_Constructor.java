package ex1;
/**
 * @author ������
 * Document : Ex1_Constructor 
 * Created on : 2014. 9. 11, ���� 3:47:06
 */
public class Ex1_Constructor {
    //�����ϴܰ� -> JVM ����
    //�����ڰ� �����ڸ� ���� ���� �ص��� ������ �����Ϸ��� 
    //�⺻�����ڸ� ���� �صд�.
    //�����ڴ� Ŭ������� ���� ��ȯ���� ����.
    //���� : ����Ŭ������ �ʱ�ȭ��Ű�� ���� �����̴�.
    //�⺻������
    public Ex1_Constructor(){
        
    }
    private String msg;
    //����� �ڿ��� �ʱ�ȭ �ϴ� ����!!!!
    //���ڰ��� �ִ� ������
    
    //����Ŭ������ ���� ������ �� �ִ� ��� : �޼���(setter), ������ ���̴�.
    public Ex1_Constructor(String msg){
        this.msg = msg;
    }
    //�����ڰ� � �����ڸ� �ϳ��� �����س����� 
    //�����Ϸ��� �⺻�����ڸ� ���� ���������� �ʴ´�.
    public static void main(String[] args) {
        //Ŭ������ ��ü�� ����
        Ex1_Constructor ref = new Ex1_Constructor();//����
        ref.test();
    }

    private void test(){
        System.out.println("�׽�Ʈ!!");
    }
}
