package ex1;
/**
 * @author kosta
 * Document : Ex4_DataType Created on : 2014. 9. 2, ���� 11:48:04
 */
public class Ex4_DataType {
    //psvm [TAB Key]
    public static void main(String[] args) {
        String str1 = "J"; //�Ͻ������� ��ü�� ������ String
        //""�� string ��ü��. ���ڿ��̴�.
        char ch1='A'; //' ' �ѹ��ڸ� �����ϱ� ���� char
        System.out.println(str1);
        System.out.println(ch1);
        
        char ch2='��';
        System.out.println(ch2);
        char ch3='\u0042';
        System.out.println(ch3);
        
        char ch4='\ucafe';
        System.out.println(ch4);
    }

}
