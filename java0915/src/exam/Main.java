package exam;
/**
 * @author ¿À¼¼Çö
 * Document : Main 
 * Created on : 2014. 9. 15, ¿ÀÈÄ 12:14:30
 */
public class Main {
    public static void main(String[] args) {
        Animal[] ar = new Animal[2];
        ar[0] = new Bird();
        ar[1] = new Cat();
        String[] msg = {"Â±Â±","¾ß¿Ë"};
        int i=0;
        for(Animal e : ar){
            e.cry(msg[i]);
            i++;
        }
    }
}