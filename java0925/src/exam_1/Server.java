
package exam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author kosta
 * Document    : Server created on : 2014. 9. 25, 오후 3:29:57
 */
public class Server {
    private ServerSocket ss;
    private Socket s;
    public Server() {
        try {            
            //서버소켓 만들기
            ss = new ServerSocket(9999);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    public void execute(){
        while(true){
            try {
                //받아들일 준비
                s= ss.accept();
                //
                ServerThread st = new ServerThread(s, this);
                
            } catch (IOException ex) {
                ex.printStackTrace();                        
            }
            
        }
    }
    public static void main(String[] args) {
        Server se = new Server();
        se.execute();
    }
    
    
}
