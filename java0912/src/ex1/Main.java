package ex1;
/**
 * @author 오세현
 * Document : Main 
 * Created on : 2014. 9. 12, 오전 10:16:56
 */
public class Main {
    public static void main(String[] args) {
        //자식클래스를 참조로 한 객체 생성
        D_carPhone ref = new D_carPhone("겡노트3", "10000", 1000, "20px");
        System.out.println("모델명 : "+ref.model);
        System.out.println("가격 : "+ref.getNumber());
        System.out.println("화음 : "+ref.getChord());
        System.out.println("픽셀 : "+ref.getPixel());
        
        MP3Phone ref1 = new MP3Phone("아이폰6", "20000", 1001, 50);
        System.out.println("모델명 : "+ref1.model);
        System.out.println("가격 : "+ref1.getNumber());
        System.out.println("화음 : "+ref1.getChord());
        System.out.println("픽셀 : "+ref1.getSize());
    }
}
