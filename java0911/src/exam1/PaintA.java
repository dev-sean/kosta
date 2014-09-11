package exam1;
/**
 * @author 오세현
 * Document : PaintA 
 * Created on : 2014. 9. 11, 오전 10:22:43
 */
public class PaintA {
    //사용자가 호출시에 Home의 주소값과 주문한 색상값을 호출할 수 있도록 정의한다.
    //전달받은 Home의 주소에서 setDoor_color이란 자원을 꺼내어서 가공한다.
    //사용자가 호출시 Home을 반드시 생성한 후 그 주소를 전달.
    public void paintHome(Home home, String doorcolor){
        System.out.println("A 회사");
        home.setDoor_color(doorcolor);
    }
}
