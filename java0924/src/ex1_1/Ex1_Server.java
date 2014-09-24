package ex1_1;

import java.io.BufferedReader;
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
 * @author 오세현 Document : Ex1_Server Created on : 2014. 9. 24, 오후 1:08:36
 */
public class Ex1_Server {

    private ServerSocket ss;

    public Ex1_Server() {

        try {
            ss = new ServerSocket(9999);
            while (true) {
                Socket s = ss.accept();
                String ip = s.getInetAddress().getHostAddress();
                System.out.println(ip);

                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(os), true);
                pw.println("반갑습니다");
                String msg = br.readLine();
                System.out.println(msg);
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Ex1_Server();
    }
}
