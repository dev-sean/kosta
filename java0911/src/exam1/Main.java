package exam1;
/**
 * @author ������
 * Document : Main 
 * Created on : 2014. 9. 11, ���� 10:30:57
 */
public class Main {
    public static void main(String[] args) {
        Home home = new Home();
        PaintA painta = new PaintA();
        PaintB paintb = new PaintB();        
        System.out.println("����� �빮�� ���� : "+home.getDoor_color());
        
        painta.paintHome(home, "��Ȳ��");
        //System.out.println("Aȸ�� �ֹ��� �빮�� ���� : "+ home.getDoor_color());
        
        paintb.paintHome(home, "������");
        System.out.println("����� �빮 ���� : "+home.getDoor_color());
        
    }
}
