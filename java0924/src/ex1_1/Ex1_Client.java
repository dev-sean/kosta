package ex1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현 Document : Ex1_Client Created on : 2014. 9. 24, 오후 1:15:22
 */
public class Ex1_Client {

    private Socket s;

    public Ex1_Client() {

        try {
            s = new Socket("192.168.7.201", 9999);
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os), true);
            pw.println("안녕?");
            String msg = br.readLine();
            System.out.println(msg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Ex1_Client();
    }

}
