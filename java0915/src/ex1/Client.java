package ex1;
/**
 * @author ������
 * Document : Client 
 * Created on : 2014. 9. 15, ���� 9:23:22
 */
public class Client {
    public static void main(String[] args) {
        Animal animal;
        animal = new Bird();
        animal.cry();
        
        animal = new Cat();
        animal.cry();
        
        animal = new Dogs();
        animal.cry();
        //�迭�� ����� ������ ó��
        //�迭�� ��ü
        // - �Ϲ��ڷ��� �迭, ���� �ڷ��� �迭
        // - ������ �迭�� ������ �迭
        // - �迭�� ������ �ݵ�� ũ�Ⱑ �����Ǿ�� �Ѵ�.
        Animal[] ar = new Animal[3];
        ar[0] = new Bird();
        ar[1] = new Cat();
        ar[2] = new Dogs();
        int size = ar.length;
        System.out.println("�迭�� ũ�� : "+ size);
        //ȿ������ �ڵ带 ����ϴ� ���
        for (int i = 0; i < size; i++) {
            ar[i].cry();            
        }
        //jdk5���� ���� for�� ����
        //(�迭/�÷����� ��ü �������� :(in�� �ǹ�) ������){
        //����
        //}
        for(Animal e : ar){
            e.cry();
        }
    }
}
