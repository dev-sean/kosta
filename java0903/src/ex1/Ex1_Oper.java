package ex1;
/**
 * @author kosta
 * Document : Ex1_Oper 
 * Created on : 2014. 9. 3, ���� 10:15:10
 */
public class Ex1_Oper {
    public static void main(String[] args) {
        //�񱳿����� - ������ ������� �� �� �� ���̴� ������.
        //����� �׻� boolean(true/false)
        int a = 10;
        int b = 20;
        boolean c = a<b; //���� a�� ���� b ���� �۴�.
        System.out.println("a < b : " + c);
        c = a!=b; //���� a�� b�� ���� ���� �ʴ�.
        System.out.println("a != b : " + c);
        
        c = ((a +=12) > b) && (a==(b+=2));
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        System.out.println("c : " + c);
        // && : �������� true �� ���� �������� �����ϸ�
        // �������� false �̸� �������� �������� �ʴ´�.
        // || : �������� true�̸� �������� �������� ������
        // �������� false�� ���� �������� �����Ѵ�.
    }
}
