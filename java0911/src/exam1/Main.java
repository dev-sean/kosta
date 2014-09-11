package exam1;
/**
 * @author 오세현
 * Document : Main 
 * Created on : 2014. 9. 11, 오전 10:30:57
 */
public class Main {
    public static void main(String[] args) {
        Home home = new Home();
        PaintA painta = new PaintA();
        PaintB paintb = new PaintB();        
        System.out.println("출근전 대문의 색깔 : "+home.getDoor_color());
        
        painta.paintHome(home, "주황색");
        //System.out.println("A회사 주문후 대문의 색깔 : "+ home.getDoor_color());
        
        paintb.paintHome(home, "검은색");
        System.out.println("퇴근의 대문 색깔 : "+home.getDoor_color());
        
    }
}
