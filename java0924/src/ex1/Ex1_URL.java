package ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author 오세현
 Document : Ex1_URL 
 Created on : 2014. 9. 24, 오전 10:17:34
 */
public class Ex1_URL {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://edu.kosta.or.kr/clazzregister/clazzRegister_findClazzWithContents?clazz.clazzId=1648&pageNum=1");
        //URLConnection 객체는 반드시 URL클래스를 생성한 후
        //반환받아서 사용한다.*****
        URLConnection urlCon = url.openConnection();
        //URLConnection의 완성
        urlCon.connect(); //객체가 완성이 됨.
        
        System.out.println("ContentType : "+urlCon.getContentType());
        //utf-8, euc-kr 짤라내서 대응하기!!
        System.out.println("Encoding : "+urlCon.getContentEncoding());
        //헤더 필드의 content-length에 대한 value를 반환
        System.out.println(urlCon.getContentLength());
        
        //OutputStream os = urlCon.getOutputStream();
        
        /*
        System.out.println(url.getPath());
        System.out.println(url.getHost());
        System.out.println(url.getProtocol());
        System.out.println(url.getRef());
        System.out.println(url.getContent());
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String res = null;
        while((res = br.readLine())!= null){
            System.out.println(res);
        }
        br.close();
                */
    }
}