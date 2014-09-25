package ex1_3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현 Document : MultiSocketServer Created on : 2014. 9. 25, 오후 7:47:09
 */
public class MultiSocketServer {

    private ServerSocket ss;
    private Socket s;
    private PrintWriter pw;
    private ArrayList<ServerThread> clientList;
    private ArrayList<String> clientNameList;
    private String ip;

    public MultiSocketServer() {
        try {
            ss = new ServerSocket(9999);
            System.out.println("==Server Start==");
            clientList = new ArrayList<ServerThread>();
            clientNameList = new ArrayList<>();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void execute() {
        while (true) {
            try {
                s = ss.accept();
                ip = s.getInetAddress().getHostAddress();
                System.out.println("Client IP : "+ip);
                ServerThread st = new ServerThread(s, this);
                clientList.add(st);
                System.out.println("Connected Client Number : "+clientList.size());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    void sendMsg(String msg, ServerThread aThis) {
        String str1 = msg;
        String str2 ="";
        str2 = "[" + ip + "]"+str1;
        
        for(ServerThread e : clientList){
            e.getPw().println(str2);
        }
    }
    
    public static void main(String[] args) {
        MultiSocketServer ms = new MultiSocketServer();
        ms.execute();
    }

}
