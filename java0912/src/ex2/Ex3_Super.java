package ex2;
/**
 * @author ������
 * Document : Ex3_Super 
 * Created on : 2014. 9. 12, ���� 10:40:30
 */
public class Ex3_Super {
    private int num;
    private String msg;

    public Ex3_Super() {
    }

    public Ex3_Super(int num, String msg) {
        this.num = num;
        this.msg = msg;
    }
    //�θ��Ǹ޼����...
    public String superMethod(){
        return msg + " : " + num;
    }
    public void superCar(){
        System.out.println("�̰��� �θ��� �� �Դϴ�.");
    }
}
