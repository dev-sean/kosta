package exam2_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현 Document : Server Created on : 2014. 9. 24, 오후 5:05:49
 */
public class Server {

    private ServerSocket ss;

    public Server() {

        try {
            ss = new ServerSocket(9999);
            System.out.println("서버시작!!");
            String path = "C:\\kosta86\\javaStudy\\workspace\\java0924\\src\\exam2\\AI.properties";
            BufferedReader bread = new BufferedReader(new FileReader(path));
            Properties prop = new Properties();
            prop.load(bread);
            bread.close();
            ex : while(true){
                Socket s = ss.accept();
                System.out.println("IP :");
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
                while(true){
                    try{
                    String msg = br.readLine();
                    System.out.println("MSG:");
                    if(prop.get(msg) != null){
                        pw.println(prop.get(msg));
                    }else{
                        pw.println("나는 몰라요");
                    }
                    }catch(SocketException e){
                        e.printStackTrace();
                        continue ex;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Server();
    }
}
