package ex3;
/**
 * @author ������
 * Document : Ex1_Abstract 
 * Created on : 2014. 9. 12, ���� 12:00:32
 */
//�߻�޼��带 ���� Ŭ������ �ݵ�� �߻�Ŭ�������� �Ѵ�.
public abstract class Ex1_Abstract {
    private String money;

    public Ex1_Abstract() {
        money = "1000���";
    }
    //�Ϲݸ޼���
    public String getMoney() {
        return money;
    }
    
    //�߻� �޼��� : ���� �Űܶ�.
    abstract public void moveMount();
}
