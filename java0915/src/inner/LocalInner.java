package inner;

import exam.Animal2;

/**
 * @author ������
 * Document : LocalInner 
 * Created on : 2014. 9. 15, ���� 2:44:37
 */
//���ó���Ŭ���� : Ư�� �޼��� �ȿ��� ���ǵǴ� Ŭ����.
//���������� ���� �����̶� �޼��尡 ȣ�� �� �� ��ü�� ������ �� �ְ�,
//�޼����� ������ ������ ���������� ���� �ڵ����� �Ҹ�ȴ�.
public class LocalInner {
    private int a = 100;//�������
    public void myMethod(int n){
        int b = 200;//�޼��� ���� ��������
        final int C = 300; //���
        //Local ���� Ŭ����
        //
        class Inner extends Animal2{
            public void getData(){
                //�ܺ�Ŭ������ �ڿ� ����
                System.out.println("int a :"+a);
                //���������� ���� ����(jdk8���� ����, jdk5,6,7�ȵ�)
                //jdk5-7������� �ݵ�� ���������� ����� �����ؾ� ��
                System.out.println("int b :"+n);
            }

            @Override
            public String col() {
                return "����";
            }
        }
        Inner i = new Inner();
        i.getData();
    }
    public static void main(String[] args) {
        LocalInner outer = new LocalInner();
        outer.myMethod(20);
    }
}
