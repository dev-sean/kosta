package ex1;
/**
 * @author 오세현
 * Document : MemberControl 
 * Created on : 2014. 9. 16, 오후 5:19:02
 */
public class MemberControl {
    private MemberVO vo;
    private String check;

    public void checkAge(MemberVO vo){
        if(vo.getAge() <= 18){
            check = "[미성년자] / 성년";
        }else{
            check = "미성년자 / [성년]";
        }
    }

    public String getCheck() {
        return check;
    }
}
