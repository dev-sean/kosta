package ex1;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author 오세현
 * Document : Ex1_BufferedWriter 
 * Created on : 2014. 9. 19, 오전 10:38:30
 */
public class Ex1_BufferedWriter {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        //문자 스트림을 바이트 스트림으로 연결하기 위해서
        //브릿지 스트림을 연결해서 사용해야 한다.
        //BufferedWriter bw = new BufferedWriter(new FileOutputStream("c:\\kosta86\text.txt")); 에러
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\kosta86\\mytext.txt"),"euc-kr"));
        
        bw.write("이것은 테스트입니다.쿄쿄");
        bw.flush();
    }
}