package exam;
/**
 * @author ������
 * Document : Bird 
 * Created on : 2014. 9. 15, ���� 12:15:06
 */
public class Bird extends Animal2 implements Animal{

    @Override
    public String col() {
        return "����� ����";
    }

    @Override
    public void cry(String msg) {
        System.out.println(msg);
    }
}
