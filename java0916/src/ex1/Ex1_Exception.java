package ex1;
/**
 * @author ������
 * Document : Ex1_Exception 
 * Created on : 2014. 9. 16, ���� 9:28:26
 */
/*
Exceptino : ������ �����̸� ���α׷������� ó���Ѵ�.
   - �Ϲ����� ���� : ������ �� �� �߻��ϴ� ����
        ��) I/O�� ������ �а��� �ϴµ� ��� ������ ���ٸ�...
   - ���� �� ���� : 
        ��) 0���� ������ ���α׷�, ������ ���ڿ� ���ڸ� �ִ´ٴ� ��
            ������ �ÿ��� �� �� ���� ����
Error : ġ������ �����̸� JVM�� �����Ͽ� ó���Ѵ�.
    ����ó��)
    try{
        ���ܰ� �߻� ������ �����;
        ���๮; <- ���ܰ� �߻��Ǹ� ������ �ȵ�*****
    }catch(���ܰ�ü�Ǻ�����){
        ���� ���� �����;
    }
*/
public class Ex1_Exception {
    public static void main(String[] args) {
        //�迭�� ����� ������ �ʱ�ȭ�� �ѹ��� �� ����
        int[] bar = {10,200,30};
        for (int i = 0; i <=3; i++){
            try {
                System.out.println(bar[i]);//���ܹ߻�. 3�� ��ã��.
                System.out.println("ļļ?ļļļ");
            } catch (Exception e) {
                System.out.println("�迭�� ������ �Ѿ���.");
            }
        }
        System.out.println("���α׷��� ��");
    }
}