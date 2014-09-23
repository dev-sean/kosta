package ex2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 오세현
 * Document : Ex1_InetAddress 
 * Created on : 2014. 9. 23, 오후 1:54:34
 */
public class Ex1_InetAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress iaddr = InetAddress.getLocalHost();
        System.out.println(iaddr.getHostName());
        System.out.println(iaddr.getHostAddress());
        
        InetAddress iaddr2 = InetAddress.getByName("google.com");
        System.out.println(iaddr2.getHostName());
        System.out.println(iaddr2.getHostAddress());
        
        //연습문제, GUI를 사용해서 사용자로부터 호스트를 입력 받은 결과
        //아이피들을 jTextArea에 출력하시오.
    }
}
