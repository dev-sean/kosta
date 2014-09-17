package exam;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author ������ Document : Lotto Created on : 2014. 9. 17, ���� 10:34:23
 */
public class Lotto {

    private String lotNum;

    public Lotto() {
        //�ʱ�ȭ�� ȣ��
        lottoGame();
    }

    private void lottoGame() {
        TreeSet<Integer> it = new TreeSet<>();
        while (it.size() < 6) {
            int num = (int) ((Math.random() * 45) + 1);
            it.add(num);
        }
        Iterator<Integer> ii = it.iterator();
        //*���� StringŬ������ �Һ��� Ư¡ ������
        //�޸��� ������ ���� ��ų �� �ֱ� ������
        //���ڿ��� �������� �����ϴ� ���۰�ü�� ��� �ΰ� ����Ѵ�.
        StringBuffer sb = new StringBuffer();
        while (ii.hasNext()) {
            Integer lotNumber = ii.next();
            //Stringbuffer�� ��Ƶδ� �޼���
            sb.append(lotNumber).append("\t");
        }
        lotNum = sb.toString();
    }

    public String getLotNum() {
        return lotNum;
    }

    public static void main(String[] args) {
        Lotto lo = new Lotto();

        System.out.println(lo.getLotNum());
    }
}
