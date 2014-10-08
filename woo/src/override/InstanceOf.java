package override;
/**
 * @author 오세현
 * Document : InstanceOf 
 * Created on : 2014. 10. 8, 오후 9:14:49
 */
public class InstanceOf {
    public static void main(String[] args) {
        Bird bird = new Bird();
        //bird 클래스를 Animal 클래스와 비교한다.(가족관계인지 아닌지)
        System.out.println(bird instanceof Animal);
    }
}


