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
 * @author ������
 Document : Ex1_URL 
 Created on : 2014. 9. 24, ���� 10:17:34
 */
public class Ex1_URL {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://edu.kosta.or.kr/clazzregister/clazzRegister_findClazzWithContents?clazz.clazzId=1648&pageNum=1");
        //URLConnection ��ü�� �ݵ�� URLŬ������ ������ ��
        //��ȯ�޾Ƽ� ����Ѵ�.*****
        URLConnection urlCon = url.openConnection();
        //URLConnection�� �ϼ�
        urlCon.connect(); //��ü�� �ϼ��� ��.
        
        System.out.println("ContentType : "+urlCon.getContentType());
        //utf-8, euc-kr ©�󳻼� �����ϱ�!!
        System.out.println("Encoding : "+urlCon.getContentEncoding());
        //��� �ʵ��� content-length�� ���� value�� ��ȯ
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