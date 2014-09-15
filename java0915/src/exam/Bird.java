package exam;
/**
 * @author 오세현
 * Document : Bird 
 * Created on : 2014. 9. 15, 오후 12:15:06
 */
public class Bird extends Animal2 implements Animal{

    @Override
    public String col() {
        return "노란색 참새";
    }

    @Override
    public void cry(String msg) {
        System.out.println(msg);
    }
}
