package ex1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현 Document : Ex2_Client Created on : 2014. 9. 24, 오전 11:02:27
 */
public class Ex2_Client {

    private Socket s;

    public Ex2_Client() {
        try {
            s = new Socket("192.168.7.3", 8888);
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
                // PrintWriter의 특징
            // - 1차 스트림, 2차 스트림(Buffer의 기능)
            // - 바이트 스트림, 문자 스트림 등을 모두 사용이 가능
            //오토플러시 : 자동으로 버퍼를 비워주는 역할을 한다.
            //문자열을 한줄 단위로 바이트스트림으로 연결 하는 것이 장점!
            PrintWriter pw = new PrintWriter(new BufferedOutputStream(os), true);
            pw.println("^^");
            String msg = br.readLine();
            System.out.println(msg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Ex2_Client();
    }
}
