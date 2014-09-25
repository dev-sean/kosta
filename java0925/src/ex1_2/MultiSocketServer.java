package ex1;
/**
 * @author kosta 
 * Document   : MultiSocketServer Created on : 2014. 9. 25, 오전 8:54:21
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiSocketServer {
    // 서버 소켓 
    private ServerSocket ss;
    // 접속된 클라이언트의 소켓
    private Socket s;
    // 클라이언트 소켓을 저장할 Collection
    private ArrayList<ServerThread> clientList;
    // 현재 접속사 대화명을 저장할 ArrayList
    private ArrayList<String> conClientList;
    // 접속자의 ip
    private String reip;
    public MultiSocketServer() {
        try {
            ss = new ServerSocket(9898);
            System.out.println("** Server Start **");
            //Socket의 주소를 가지고, 응답을 위한 Thread의
            //주소들을 저장할 ArrayList 생성
            clientList = new ArrayList<ServerThread>();
            conClientList = new ArrayList<>();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    
    
    
    
      // 실행 메서드
    public void execute() {
        // 서버는 항상 대기상태...
        while (true) {
            try {
                s = ss.accept();
                reip = s.getInetAddress().getHostAddress();
                System.out.println("Client Connected : [ " + reip + " ]");
                // Thread 객체 생성 한후 readLine을 위임한 상태 *****
                ServerThread ct = new ServerThread(s, this);
                // 스레드가 생성될 때 마다 ArrayList에 기억 
                clientList.add(ct);
                System.out.println("Current number of clients : " 
                        + clientList.size());
            } catch (IOException ex) {
            }
        }
    }
    public void sendMsg(String str1, ServerThread aThis) {
        String type1 = str1; 
        String str = "";
            // ArrayList에 등록된 모든 client를 읽어와서 하나씩 각각의 소켓에 연결된
            // 스트림을 통해 str메세지를 전달한다.
            str = "["+aThis.getSocket().getInetAddress().getHostAddress()+"]" + type1;
            System.out.println("msg : " +str);
        // 모든 유저에게 완성된 str을 송출
        for (ServerThread c : clientList) {
            c.getPw().println(str);
        }
    }
    public static void main(String[] args) {
        MultiSocketServer mss = new MultiSocketServer();
        mss.execute();
    }
}