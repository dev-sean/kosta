package exam1;
/**
 * @author ������
 * Document : PaintA 
 * Created on : 2014. 9. 11, ���� 10:22:43
 */
public class PaintA {
    //����ڰ� ȣ��ÿ� Home�� �ּҰ��� �ֹ��� ������ ȣ���� �� �ֵ��� �����Ѵ�.
    //���޹��� Home�� �ּҿ��� setDoor_color�̶� �ڿ��� ����� �����Ѵ�.
    //����ڰ� ȣ��� Home�� �ݵ�� ������ �� �� �ּҸ� ����.
    public void paintHome(Home home, String doorcolor){
        System.out.println("A ȸ��");
        home.setDoor_color(doorcolor);
    }
}
