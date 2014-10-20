package ex1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현 Document : ServerS Created on : 2014. 10. 17, 오전 11:26:29
 */
public class ServerS {

    private ServerSocket ss; // 서버 소켓
    private Socket s; // 클라이언트 소켓
    private String reip; // 아이피
    private ArrayList<SocketThread> client;

    public ServerS(int port) {
        try {
            ss = new ServerSocket(port);
            System.out.println("Server Start!!");
            //ArrayList를 생성
            client = new ArrayList<>();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void execute() {
        while (true) {
            try {
                Socket s = ss.accept();
                System.out.println("클라이언트 접속");
                System.out.println(s.getInetAddress().getHostAddress());
                System.out.println("-------------------------------------");
                SocketThread st = new SocketThread(s, this);
                //ArrayList에 저장
                client.add(st);
                st.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    void sendMsg(SocketThread s, String... str) {
        StringBuffer strs = new StringBuffer();
        //Client로 보내기 위한 프로토콜을 제작
        int i = 0;
        for (String e : str) {
            if (str.length-1 > i) {
                strs.append(e).append("/");
            } else {
                strs.append(e);
            }
            i++;
        }
        System.out.println("TokenTest : " + strs);
        //모든 접속자에게 메세지를 전달한다.
        for(SocketThread e : client){
            e.getPw().println(strs.toString());
        }
    }
    public static void main(String[] args) {
        ServerS s = new ServerS(9999);
        s.execute();
    }
}
