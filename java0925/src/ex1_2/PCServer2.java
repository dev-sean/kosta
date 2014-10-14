package ex1_2;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class PCServer2 {

    private ServerSocket sS;
    private Socket s;
    private Vector<PCClient2> clientList; // 클라이언트 리스트

    public PCServer2(int port) {
        System.out.println("**서버를 시작합니다");
        try {
            sS = new ServerSocket(port); // 전달받은 포트로 서버소켓 생성
            
            clientList = new Vector<PCClient2>(); // 접속자 리스트 관리를 위한 벡터
        } catch (IOException ex) {
            System.out.println("서버소켓 생성시 IOException 예외처리");
        }
    }

    public void exe() {

        while (true) {
            // 서버 클라이언트를 기다림
            try {
                s = sS.accept();
                System.out.println("Client 접속");

            } catch (IOException ex1) {
            }

            // 접속이 되면 소켓을 전달하여 클라이언트 객체 생성
            PCClient2 ct = new PCClient2(s, this);
            clientList.add(ct); // 접속자 리스트에 소켓 클라이언트 객체 추가
        }
    }

    // 클라이언트 삭제 메서드
    public void removeClient(PCClient2 c) {
        clientList.remove(c);
    }

    // 현재 접속자 대화명들을 저장할 벡터
    Vector<String> conClientList = new Vector<String>();

    // 메시지 전달 메서드
    public void sendMsg(String s1, String s2, String s3, String s4, PCClient2 ct) {
        String type1 = s1; // enter, exit, draw, whisper, talk
        String type2 = s2; // nickName, color, all, someone
        String type3 = s3; // none, x, speaker
        String type4 = s4; // none, y, say
        String str = "";
        PCClient2 client = ct;

        System.out.println("type1:::::::::::::::"+type1+"x:"+type3+"y"+type4);
           if (type1.equals("draw")) { // 그리기
                str = "draw/" + type2 + "/" + type3 + "/" + type4;
                System.out.println("STR:"+str);
            } 

            // 모든 유저에게 완성된 메시지를 송출
            for (PCClient2 c : clientList) {
                c.getPw().println(str);
            }
     //   }

    }

    public static void main(String[] args) {
        PCServer2 sv = new PCServer2(7777);
        sv.exe();
    }


}
