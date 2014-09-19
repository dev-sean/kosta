package ex1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ������
 * Document : Ex3_Generic 
 * Created on : 2014. 9. 16, ���� 3:31:17
 */
//jdk5���� ��ü���� ĳ���� ������ �ذ��ϱ� ���ؼ�
//�����÷����� ����
public class Ex3_Generic {
    public static void main(String[] args) {
        //Vector�� ArrayList���̴� ����ȭ ���� �����̴�.
        //Vector �� ����ȭ�� �����ϴ� ���! ������ �ٸ� �κ����� ��ü ����!
        //Generic - String�� ���� �� �ִ� ArrayList
        //jdk7���� ����� ���. 6���ϴ� ���� new ArrayList<>();
        ArrayList<String> str = new ArrayList<>();
        
        str.add("ok");
        str.add(String.valueOf(10));
        str.add(String.valueOf(3.14f));
        
        for(String e : str){
            System.out.println(e);
        }
        System.out.println("iterator");
        Iterator<String> it = str.iterator();
        while (it.hasNext()) {
            String string = it.next();
            System.out.println(string);   
        }
        
        ArrayList<Integer> num = new ArrayList<>();
        num.add(10);
        num.add(Integer.parseInt("11"));
    }
}

        //����
        //ArrayList�� ����ϴ� ���ϱ�
        //ȸ�������� �����ϰ� �ʹ�.
        //�ٵ� ���׸����� ǥ���Ǹ� ��� ���� �ٸ� �ڷ������� �־
        //ȸ�������� �����Ҽ��������?
        //����ȭ��
        //1. ȸ�������Է� 2.����Ʈ 3.���� : 1
        //ȸ����ȣ(int) :
        //ȸ�����̸�(String) : 
        //ȸ���� ������(float) : 
        //ȸ���� ���ǿ���(boolean) : 
        //ȸ���� �̸���(String) : 
        //ȸ���� ����(int) : 
        //1. ȸ�������Է� 2.����Ʈ 3.����
        //������ �ݺ��ؼ� ȸ���� 5�� ���� �߰�
        //1. ȸ�������Է� 2.����Ʈ 3.���� : 2
        //ȸ����ȣ : 1
        //�̸� : ��浿
        //������ : 1.1 kg
        //���ǿ��� : false
        //�̸��� : sdjfi@naver.com
        //���� : 18
        //[�̼�����] / ����
        //==========================
        
        //[ ���� ] - B�� ������ : ArrayList�� ������ ȸ������