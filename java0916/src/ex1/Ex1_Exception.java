package ex1;
/**
 * @author 오세현
 * Document : Ex1_Exception 
 * Created on : 2014. 9. 16, 오전 9:28:26
 */
/*
Exceptino : 가벼운 오류이며 프로그램적으로 처리한다.
   - 일반적인 예외 : 컴파일 할 때 발생하는 오류
        예) I/O시 파일을 읽고자 하는데 대상 파일이 없다면...
   - 실행 시 예외 : 
        예) 0으로 나누는 프로그램, 문자형 숫자에 문자를 넣는다는 등
            컴파일 시에는 알 수 없는 예외
Error : 치명적인 오류이며 JVM에 의존하여 처리한다.
    예외처리)
    try{
        예외가 발생 가능한 문장들;
        실행문; <- 예외가 발생되면 수행이 안됨*****
    }catch(예외객체의변수명){
        예외 수행 문장들;
    }
*/
public class Ex1_Exception {
    public static void main(String[] args) {
        //배열의 선언과 생성과 초기화를 한번에 한 문장
        int[] bar = {10,200,30};
        for (int i = 0; i <=3; i++){
            try {
                System.out.println(bar[i]);//예외발생. 3을 못찾음.
                System.out.println("캬캬?캬캬캬");
            } catch (Exception e) {
                System.out.println("배열의 범위를 넘었다.");
            }
        }
        System.out.println("프로그램의 끝");
    }
}