package exam;
/**
 * @author ������
 * Document : Main 
 * Created on : 2014. 9. 15, ���� 12:14:30
 */
public class Main {
    public static void main(String[] args) {
        Animal[] ar = new Animal[2];
        ar[0] = new Bird();
        ar[1] = new Cat();
        String[] msg = {"±±","�߿�"};
        int i=0;
        for(Animal e : ar){
            e.cry(msg[i]);
            i++;
        }
    }
}