package ex1;

public class Ex3_DataType {
    public static void main(String[] args) {
        byte a=10;
        byte b=20;
        byte c;
        int d;
        //demotion : ū �ڷ������� ���� �ڷ������� �����Ͱ� �̵� �� ��
        //�ڷ��� �ս��� ���� �� ����(ĳ����)
        //promotion : ���� �ڷ������� ū �ڷ������� �����Ͱ� �̵��� ��
        //�ڿ������� ����
        //JVM�� int 4����Ʈ ������ ������ ���� �� �� int������ �°� ��Ŵ
        //�׷��� a+b�� ������ �̷�� �� �� int ������ ���� ����� ������ �Ǳ� ������
        //�̰��� byte c�� �����ϱ� ���ؼ��� demotion�� �Ͼ.

        c=(byte) (a+b);
        System.out.println("C= "+c);        
        d=a+b;
        System.out.println("D= "+d);
        
        long myL = a+b; //���θ��
        //int f = myL; //����
        
        //JDK 7���� �����ϴ� �ڸ��� ǥ��, _�� �����Ѵ�.
        int e = 123_123;
        System.out.println(e);
    }
}
