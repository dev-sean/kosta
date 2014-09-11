package exam2;

/**
 * @author 오세현 
 * Document : Ex1_CallByReference 
 * Created on : 2014. 9. 11, 오전 11:23:20
 */
public class Ex1_CallByReference {

    private Ex1_MemberVO ref;

    //한사람의 정보를 출력. 번호,이름,나이,성별,전화번호

    public void info(Ex1_MemberVO ref) {
        this.ref = ref;
//        System.out.println("번호 : "+ref.getNum());
//        System.out.println("이름 : "+ref.getName());
//        System.out.println("나이 : "+ref.getAge());
//        System.out.println("성별 : "+ref.getGender());
//        System.out.println("전화번호 : "+ref.getTel());
    }

    public Ex1_MemberVO getRef() {
        return ref;
    }
}
