package ex1;
/**
 * @author ������
 * Document : Main 
 * Created on : 2014. 9. 12, ���� 10:16:56
 */
public class Main {
    public static void main(String[] args) {
        //�ڽ�Ŭ������ ������ �� ��ü ����
        D_carPhone ref = new D_carPhone("�۳�Ʈ3", "10000", 1000, "20px");
        System.out.println("�𵨸� : "+ref.model);
        System.out.println("���� : "+ref.getNumber());
        System.out.println("ȭ�� : "+ref.getChord());
        System.out.println("�ȼ� : "+ref.getPixel());
        
        MP3Phone ref1 = new MP3Phone("������6", "20000", 1001, 50);
        System.out.println("�𵨸� : "+ref1.model);
        System.out.println("���� : "+ref1.getNumber());
        System.out.println("ȭ�� : "+ref1.getChord());
        System.out.println("�ȼ� : "+ref1.getSize());
    }
}
