package ex1;
/**
 * @author ������
 * Document : MemberControl 
 * Created on : 2014. 9. 16, ���� 5:19:02
 */
public class MemberControl {
    private MemberVO vo;
    private String check;

    public void checkAge(MemberVO vo){
        if(vo.getAge() <= 18){
            check = "[�̼�����] / ����";
        }else{
            check = "�̼����� / [����]";
        }
    }

    public String getCheck() {
        return check;
    }
}
