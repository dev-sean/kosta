package inner;
/**
 * @author ������
 * Document : StaticInner 
 * Created on : 2014. 9. 15, ���� 3:05:25
 */
public class StaticInner {
    int a= 10;
    private int b = 100;
    static int c = 200;
    static class Inner{
        //��¿�� ���� ���� Ŭ���� �ȿ��� static �ڿ��� ����ϰ� �ȴٸ�
        //�̶� ���� Ŭ������ static���� Ŭ������ ���� �Ǿ�� �Ѵ�.
        static int d = 1000;
        public void printData(){
            //System.out.println("int a : "+a);
            //System.out.println("int b : "+b);
            //static �ڿ��� �ƴϱ� ������ ����� �� ����.
            //����ϱ� ���ؼ��� ��ü�� ������ �Ŀ� ����ؾ� �Ѵ�.
            System.out.println("int c : "+c);
            System.out.println("int d : "+d);
        }
    }
    public static void main(String[] args) {
        StaticInner.Inner inner = new StaticInner.Inner();//static�� ���� ���� ���
        inner.printData();
    }
}