package ex1;
/**
 * @author kosta
 * Document : Ex5_Oper 
 * Created on : 2014. 9. 3, ���� 11:12:49
 */
public class Ex5_Oper {
    public static void main(String[] args) {
        //����Ʈ������. >> bit���� ���������� �̵�
        //���ڸ��� ��ȣ������ ����
        int a = 12;//0000 1100
        int b = 2; //
        int c = a>>b; //0000 0011 => 3
        System.out.println("c :"+c);
    }
}
