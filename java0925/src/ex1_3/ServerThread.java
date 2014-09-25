package ex1_3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * @author 오세현
 * Document : ServerThread 
 * Created on : 2014. 9. 25, 오후 7:49:16
 */
class ServerThread {
    private PrintWriter pw;
    private BufferedReader br;
    private Socket socket;
    private MultiSocketServer server;
    ServerThread(Socket socket, MultiSocketServer server) {
        this.socket = socket;
        this.server = server;
        
        try {
            pw = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                while(true){
                    try {
                        br = new BufferedReader(new InputStreamReader(ServerThread.this.socket.getInputStream()));
                        String msg = br.readLine();
                        ServerThread.this.server.sendMsg(msg, ServerThread.this);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }

    public PrintWriter getPw() {
        return pw;
    }

}
