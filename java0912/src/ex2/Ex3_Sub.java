package ex2;
/**
 * @author ������
 * Document : Ex3_Sub 
 * Created on : 2014. 9. 12, ���� 10:43:29
 */
public class Ex3_Sub extends Ex3_Super{
    private String age;//����

    public Ex3_Sub(String age, String msg, int num) {
        super(num,msg);//super�� �׻� �������� ȣ��Ǿ�� ��.
        this.age = age;        
    }
    public void subMethod(){
        System.out.println("���� �ڽ� �޼ҵ��Դϴ�.");
    }
    //������̼� : ���� ������ �ּ�
    //���⼭�� JVM�� Override��� �ν��ϴ� Ű����
    @Override
    public void superCar() {
        System.out.println("������ �ڵ���");        
    }
}
