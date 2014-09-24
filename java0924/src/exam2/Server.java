package exam2;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author kosta Document : Server created on : 2014. 9. 24, ¿ÀÈÄ 3:00:21
 */
public class Server {

    private ServerSocket ss;

    public Server() {
        try {
            ss = new ServerSocket(7777);
            Socket s = ss.accept();
            String ip = s.getInetAddress().getHostAddress();
            System.out.println(ip);

            while (true) {

                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                PrintWriter pw = new PrintWriter(new BufferedOutputStream(os), true);

                String msg = br.readLine();
                String vmsg = chat(msg);
                pw.println(vmsg);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String chat(String msg) {
        String value = null;
        String path = "C:\\kosta86\\javaStudy\\workspace\\java0924\\src\\exam2\\AI.properties";
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fis);
            value = (String) prop.get(msg);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args) {
        new Server();
    }

}
