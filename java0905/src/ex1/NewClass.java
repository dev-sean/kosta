package ex1;
/**
 * @author 오세현
 * Document : NewClass 
 * Created on : 2014. 9. 5, 오전 11:24:59
 */
//현재 클래스는 은행, 금융, 보험등 관련 회사에서 사용하는
//보안이 필요한 코드라면.......
//A팀과 B팀이 현재 코드에서 접근해서 작업을 할 수 있는데
//금액을 세팅할 팀이 A팀만 가능하게 하려면?
public class NewClass {
    private int pay; //멤버필드
    
    //insertPay(1000,"dd"); 호출될 때
    public void insertPay(int p, String str){
        //dd값을 검증해서 통과못하면 
        if(!str.equals("dd")){
            System.out.println("당신은 접근 권한이 없습니다.");
            System.exit(0); //시스템종료
        }
        pay = p;//호출시 받은 1000값을 멤버필드에 저장해놓겠다.
    }
    public int getPay(){
        return pay;
    }
}
