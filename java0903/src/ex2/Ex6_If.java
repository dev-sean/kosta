package ex2;

/**
 * @author kosta Document : Ex1_if Created on : 2014. 9. 3, ���� 11:16:54
 */
public class Ex6_If {

    public static void main(String[] args) {
        // if(����) // ���� true �� ���� ���� �ϰڴ�.
        int su = 3;
        String msg;
        /*
        if (su > 5) {
            System.out.println("����!");
        }
                */
        //Ư���� �Ķ���� ���� �ʱ�ȭ ��Ű�ų� �ʱ�ȭ ���� ���� �� �Ѿ���� ���� �����ϱ� ���� ���
        System.out.println("���� if���ǰ����̵ǰ�;��");
        //if-else �� default�� �����ϱ� ���ؼ� ���
        if(su > 5){
            msg = "ũ��.";
        }else{
            msg = "�۴�.";
        }
        System.out.println("��� :"+msg);
    }
}
