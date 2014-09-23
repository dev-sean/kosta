package ex2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ������
 * Document : Ex1_InetAddress 
 * Created on : 2014. 9. 23, ���� 1:54:34
 */
public class Ex1_InetAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress iaddr = InetAddress.getLocalHost();
        System.out.println(iaddr.getHostName());
        System.out.println(iaddr.getHostAddress());
        
        InetAddress iaddr2 = InetAddress.getByName("google.com");
        System.out.println(iaddr2.getHostName());
        System.out.println(iaddr2.getHostAddress());
        
        //��������, GUI�� ����ؼ� ����ڷκ��� ȣ��Ʈ�� �Է� ���� ���
        //�����ǵ��� jTextArea�� ����Ͻÿ�.
    }
}
