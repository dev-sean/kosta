package inner;
/**
 * @author ������
 * Document : Memberinner 
 * Created on : 2014. 9. 15, ���� 2:04:52
 */
//����Ŭ���� : Ư��Ŭ���� �ȿ� �� �ٸ� Ŭ������ ���� �Ǵ� ���� �ǹ��Ѵ�.
//���� : ���, ����, static,  �͸�

public class MemberInner {
    private int a = 10;
    private int b;
    private int c;

    public MemberInner() {
        b=100;
        c=200;
    }
    
    public class inner{
        public void printData(){
            System.out.println("�ܺ�Ŭ������ private�� ���ٰ��� : "+a);
            System.out.println("�ܺ�Ŭ������ private�� ���ٰ��� : "+b);
            System.out.println("�ܺ�Ŭ������ private�� ���ٰ��� : "+c);
        }
    }
    
    //���� Ŭ���� ���� �� ����
    public static void main(String[] args) {
        //�ܺ� Ŭ������ �����Ѵ�.
        //MemberInner outer = new MemberInner();
        //�ܺ�Ŭ������ �ּҸ� ���ؼ� ����Ŭ������ ���� �� ����
        //MemberInner.inner inner = outer.new inner();
        //inner.printData();
        MemberInner.inner inner = new MemberInner().new inner();
        inner.printData();
        
    }
}