package exam2;

/**
 * @author ������ 
 * Document : Ex1_CallByReference 
 * Created on : 2014. 9. 11, ���� 11:23:20
 */
public class Ex1_CallByReference {

    private Ex1_MemberVO ref;

    //�ѻ���� ������ ���. ��ȣ,�̸�,����,����,��ȭ��ȣ

    public void info(Ex1_MemberVO ref) {
        this.ref = ref;
//        System.out.println("��ȣ : "+ref.getNum());
//        System.out.println("�̸� : "+ref.getName());
//        System.out.println("���� : "+ref.getAge());
//        System.out.println("���� : "+ref.getGender());
//        System.out.println("��ȭ��ȣ : "+ref.getTel());
    }

    public Ex1_MemberVO getRef() {
        return ref;
    }
}
