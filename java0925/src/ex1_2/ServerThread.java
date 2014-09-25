package ex1;
/**
 * @author kosta 
 * Document   : ServerThread Created on : 2014. 9. 25, 오전 8:55:18
 */
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread {
    // 서버로부터 위임받은 소켓
    private Socket socket;
    // 서버로부터 받은 서버의 주소
    private MultiSocketServer server;
    // 소켓으로부터 연결된 두 스트림
    private PrintWriter pw;
    private BufferedReader in;
    // 닉네임
    private String nickName;

    public ServerThread(Socket socket, MultiSocketServer server) {
        this.socket = socket;
        this.server = server;
        try {
            pw = new PrintWriter(
                    new BufferedOutputStream(
                            socket.getOutputStream()), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            // Thread를 내부클래스로 정의
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 소켓 하나당 스트림이 연결
                    in = new BufferedReader(
                            new InputStreamReader(
                                    ServerThread.this.socket.getInputStream()));
                    while (true) {
                        // 소켓으로부터 입력을 받기 위해 대기하는 메서드
                        String msg = in.readLine();
                        transMsg(msg);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            // 메세지 토큰 후 서버의 sendMsg 호출 담당
            private void transMsg(String msg) {
                // 서버의 sendMsg()를 호출할때  메세지를 전달
                ServerThread.this.server.sendMsg(msg, ServerThread.this);
            }
        });
        // Thread를 start해서 스케줄러에게 일을 요청한다.
        t.start();
        
    }
    
    
    
    
    
    
    
    // 서버가 사용해야될 자원들
    public PrintWriter getPw() {
        return pw;
    }

    public String getNickName() {
        return nickName;
    }

    public Socket getSocket() {
        return socket;
    }
    
}