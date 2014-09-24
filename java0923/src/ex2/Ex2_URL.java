package ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 오세현
 * Document : Ex2_URL 
 * Created on : 2014. 9. 23, 오후 3:02:01
 */
//Uniform Resource Locator
//인터넷에서 접근 가능한 자원(Resource)의 주소를 표현할 수 있는 형식
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
        //연습문제 : 사용자가 입력한 url의 소스를
        //jTextArea에 출력하고 save버튼을 누르면
        //사용자가 지정한 경로에 파일 이름으로 저장하는 기능을 구현하시오.
    }
}
