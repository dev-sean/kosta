package ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author ������
 * Document : Ex2_URL 
 * Created on : 2014. 9. 23, ���� 3:02:01
 */
//Uniform Resource Locator
//���ͳݿ��� ���� ������ �ڿ�(Resource)�� �ּҸ� ǥ���� �� �ִ� ����
//urlconnection openstream
public class Ex2_URL {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://book.naver.com/bookdb/today_book.nhn?bid=6888227#wer");
        System.out.println(url.getPath());// /bookdb/today_book.nhn
        System.out.println(url.getHost());// book.naver.com
        System.out.println(url.getProtocol());// http
        System.out.println(url.getRef());// wer
        System.out.println(url.getContent());
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String res = null;
        while((res = br.readLine())!= null){
            System.out.println(res);
        }
        br.close();
        //�������� : ����ڰ� �Է��� url�� �ҽ���
        //jTextArea�� ����ϰ� save��ư�� ������
        //����ڰ� ������ ��ο� ���� �̸����� �����ϴ� ����� �����Ͻÿ�.
    }
}
