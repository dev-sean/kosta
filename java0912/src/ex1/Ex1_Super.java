package ex1;
/**
 * @author 오세현
 * Document : Ex1_Super 
 * Created on : 2014. 9. 12, 오전 9:41:22
 */
/**
 * has a : 특정 객체 내에서 생성된 다른 객체의 주소를 가지고 있는 것을 의미
 * is a : 특정 객체가 다른 객체에게 자신의 능력을 포함시켜주는 상속 관계를 의미
 */
public class Ex1_Super {
    String model; //모델
    private String number; //전화번호
    int chord; //화음

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public int getChord() {
        return chord;
    }

    public String getNumber() {
        return number;
    }
    
}
