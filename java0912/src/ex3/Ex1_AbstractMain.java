package ex3;
/**
 * @author ������
 * Document : Ex1_AbstractMain 
 * Created on : 2014. 9. 12, ���� 12:04:26
 */
//�߻�Ŭ������ �߻�޼��尡 �ִٸ� �ݵ�� ������ �ؼ� ����ؾ�
//��� �޾Ƽ� �߻�Ŭ������ ������ �ִ� �ٸ� �ڿ�(���⼭�� 1000��)��
//����� �� �ִ�. ��, �߻��� �䱸������ ������ �ȴ�.
public class Ex1_AbstractMain extends Ex1_Abstract{

    @Override
    public void moveMount() {
        System.out.println("���� �ű�" + getMoney());
    }
    public static void main(String[] args) {
        //�θ� �����ؼ� ��ü�� ������ ���(�ڽ��� ��쵵 �غ��� �ٶ�)
        Ex1_Abstract ref = new Ex1_AbstractMain();
        ref.moveMount();
        //�θ��� �޼��带 ȣ�������� �����ǵ� �ڽ� �޼��尡 ȣ���� ��
        //(����) �߻� Ŭ������ ����å���� new�� �����ڷ� �����Ǿ
        //���� �� ���� ������ �̿ϼ��� �߻�޼���� ���� �صθ�
        //�����ǵ� �ڽĿ� ���ؼ� �ϼ��̵Ǿ ����� ��
        Ex1_Abstract ref1 = new Ex1_Abstract() {

            @Override
            public void moveMount() {
                System.out.println("���ϳ�?");
            }
        };
        ref1.moveMount();
    }
}