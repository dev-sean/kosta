package ex2;
/**
 * @author ������
 * Document : Main 
 * Created on : 2014. 9. 15, ���� 10:13:20
 */
public class Main {
    public static void main(String[] args) {
        //�߻� Ŭ������ new�� ������ �� ����.
         Super[] ar = new Super[2];//�迭����
         
         ar[0] = new A();
         ar[1] = new B();
         String msg[] = {"�簢��","������"};
         int i = 0;
         for(Super e : ar){
             e.draw(msg[i]);
             i++;
         }
    }
}
