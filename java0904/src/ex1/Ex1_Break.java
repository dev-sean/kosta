package ex1;

/**
 * @author ������ Document : Ex1_Break Created on : 2014. 9. 4, ���� 10:10:35
 */
public class Ex1_Break {

    public static void main(String[] args) {
        //break : Ư�� ������ ���߸� �ݺ����� Ż�� �ϴ� ���
        //break label�� : jdk5���� ���� break�� �� �ٿ��� 
        //���� �ִ� ������ Ż��
        xx: for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    break xx;
                }
                System.out.println(i + " : " + j);
            }
        }
    }
}
