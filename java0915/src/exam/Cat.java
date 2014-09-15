package exam;
/**
 * @author 오세현
 * Document : Cat 
 * Created on : 2014. 9. 15, 오후 12:15:36
 */
public class Cat implements Animal{

    @Override
    public void cry(String msg) {
        System.out.println(msg);
    }

}
