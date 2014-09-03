package ex2;

/**
 * @author kosta Document : Ex1_if Created on : 2014. 9. 3, 오전 11:16:54
 */
public class Ex6_If {

    public static void main(String[] args) {
        // if(조건) // 조건 true 일 때만 실행 하겠다.
        int su = 3;
        String msg;
        /*
        if (su > 5) {
            System.out.println("실행!");
        }
                */
        //특별한 파라미터 값을 초기화 시키거나 초기화 하지 않을 때 넘어오는 값을 감지하기 위해 사용
        System.out.println("나도 if문의가족이되고싶어요");
        //if-else 는 default를 지정하기 위해서 사용
        if(su > 5){
            msg = "크다.";
        }else{
            msg = "작다.";
        }
        System.out.println("결과 :"+msg);
    }
}
