package exam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현
 * Document : Server 
 * Created on : 2014. 9. 24, 오후 1:57:37
 */
public class Server {
    private ServerSocket ss;
    

    public Server() {
        HashMap map = new HashMap();
        map.put("하이", "안녕?");
        map.put("^^", "웃지마");
        
        try {
            ss = new ServerSocket(9999);
            while(true){
                Socket s = ss.accept();
                String ip = s.getInetAddress().getHostAddress();
                System.out.println("Connect IP : "+ip);
                
                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(os), true);
                
                
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public String readPro(String key){
        String path = "C:\\kosta86\\javaStudy\\workspace\\java0924\\src\\exam\\AI.properties";
        FileInputStream fis;
        Properties prop = null;
        try {
            fis = new FileInputStream(path);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            return prop.getProperty(key);
        }
        
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        new Server();

    }
}
