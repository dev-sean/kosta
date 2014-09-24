package ex1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현 Document : Ex2_Server Created on : 2014. 9. 24, 오전 10:53:16
 */
//물리적으로 분리된 컴퓨터에서 서버소켓을 생성한 서버객체를 생성한다.
//서비스에 대기하고 있어야 한다.
public class Ex2_Server {

    private ServerSocket ss;

    public Ex2_Server() {
        try {
            ss = new ServerSocket(8989);
            System.out.println("서버시작");
            while (true) {
                Socket s = ss.accept();//blocking
                //접속한 클라이언트의 소켓의 아이피를 얻기
                String ip = s.getInetAddress().getHostAddress();
                System.out.println("Server Log1 :" + ip);
                
                //연결된 Socket을 사용해서 클라이언트의 요청을 받기 위한
                //input 스트림을 생성한 후 다시 클라이언트에게
                //응답을 해주기 위한 output 스트림을 생성해서
                //response 한다.
                InputStream is =s.getInputStream();
                OutputStream os = s.getOutputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                // PrintWriter의 특징
                // - 1차 스트림, 2차 스트림(Buffer의 기능)
                // - 바이트 스트림, 문자 스트림 등을 모두 사용이 가능
                //오토플러시 : 자동으로 버퍼를 비워주는 역할을 한다.
                //문자열을 한줄 단위로 바이트스트림으로 연결 하는 것이 장점!
                PrintWriter pw = new PrintWriter(new BufferedOutputStream(os),true);
                
                //클라이언트의 요청을 받아들임.
                String msg = br.readLine();
                msg = "["+ip+"] : "+msg;
                System.out.println(msg);
                //(요청에 대한 응답)
                pw.println("반갑습니다."+msg+"!");
            }
        } catch (IOException ex) {
            System.out.println("port가 사용중입니다.");
        }
    }
    public static void main(String[] args) {
        new Ex2_Server();
    }
}