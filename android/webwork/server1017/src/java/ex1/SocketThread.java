package ex1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현
 Document : SocketThread 
 Created on : 2014. 10. 17, 오전 11:27:17
 */
class SocketThread extends Thread{
    private Socket socket;
    private ServerS server;
    private PrintWriter pw;
    private BufferedReader br;
    
    public SocketThread(Socket socket, ServerS server) {
        this.socket = socket;
        this.server = server;
        try {
            pw = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                String msg = br.readLine();
                System.out.println("Client Msg : "+msg);
                trMsg(msg);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void trMsg(String msg) {
        //protocol : msg/msg/msg/msg/msg........
        StringTokenizer stn = new StringTokenizer(msg, "/");
        String str1 = stn.nextToken();
        String str2 = stn.nextToken();
        String str3 = stn.nextToken();
        String str4 = stn.nextToken();
        String str5 = stn.nextToken();
        String str6 = stn.nextToken();
        String str7 = stn.nextToken();
        String str8 = stn.nextToken();
        
        server.sendMsg(this, str1,str2,str3,str4,str5,str6,str7,str8);
        System.out.println("프로토콜 전송 성공!");
    }

    public PrintWriter getPw() {
        return pw;
    }

}
