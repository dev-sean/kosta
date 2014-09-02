package ex1;

/**
 *
 * @author kosta
 * @since 2014.09.02
 */
public class Ex1_MyComm {
    /**
     * @serialField
     *  num 이란 멤버필드
     */
    int num;
    /**
     *  void : 반환값이 없음
     */
    public  void print(){
        num=10;
        System.out.println("Num :"+ num);
        System.out.println(num);
    }
  
}
