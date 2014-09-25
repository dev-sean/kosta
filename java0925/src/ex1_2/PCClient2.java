
package ex1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class PCClient2 {

    private Socket socket;
    private PCServer2 server;
    private PrintWriter pw;
    private String nickName;

    public PCClient2(Socket sk, PCServer2 sv) {
        // Client 의 socket 과 서버 객체 주소 받기
        socket = sk;
        server = sv;
        try {
            pw = new PrintWriter(sk.getOutputStream(), true);
        } catch (IOException ex) {
        }

        // 데이터 읽기를 위한 Thread
        Thread t = new Thread(new Runnable() {

            private BufferedReader bfr;

            public void run() {
                try {
                    bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    // 메시지를 읽으면 메시지 변환메서드(transMsg()) 호출
                    while (true) {
                        String msg = bfr.readLine();
                        transMsg(msg); // 변환메서드 호출(transMsg(msg))
                    }
                } catch (IOException ex) {
                } finally {
                    if (bfr != null) {
                        try {
                            bfr.close();
                        } catch (IOException ex) {
                        }
                    }
                }
            }

            // 메시지 토큰 후 서버의 sendMsg 메서드 호출
            private void transMsg(String msg) {
                StringTokenizer stn = new StringTokenizer(msg, "/");
                String t1 = stn.nextToken();
                String t2 = stn.nextToken();
                String t3 = stn.nextToken();
                String t4 = stn.nextToken();
                nickName = t3; // 대화명 설정

                // 서버의 sendMsg 호출 - 토큰된 메시지를 전달한다
               server.sendMsg(t1, t2, t3, t4, PCClient2.this); // 자신의 주소도 같이 전달
            }
        });

        t.start(); // Thread 실행
    }

    public PrintWriter getPw() { // 출력스트림 주소 받기
        return pw;
    }

    public String getNickName() { // 닉네임 받기
        return nickName;
    }

}
