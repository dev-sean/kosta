package ex1;
/**
 * @author kosta
 * Document : Ex4_DataType Created on : 2014. 9. 2, 오전 11:48:04
 */
public class Ex4_DataType {
    //psvm [TAB Key]
    public static void main(String[] args) {
        String str1 = "J"; //암시적으로 객체가 생성된 String
        //""는 string 객체다. 문자열이다.
        char ch1='A'; //' ' 한문자를 저장하기 위한 char
        System.out.println(str1);
        System.out.println(ch1);
        
        char ch2='가';
        System.out.println(ch2);
        char ch3='\u0042';
        System.out.println(ch3);
        
        char ch4='\ucafe';
        System.out.println(ch4);
    }

}
