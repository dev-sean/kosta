package exam1;
/**
 * @author 오세현
 * Document : Home 
 * Created on : 2014. 9. 11, 오전 10:17:10
 */
//Call by Reference
public class Home {
    private String door_color="흰색";//대문의 색상
    //setter/getter를 사용해서 캡슐화
    public String getDoor_color() {
        return door_color;
    }

    public void setDoor_color(String door_color) {
        this.door_color = door_color;
    }
}
