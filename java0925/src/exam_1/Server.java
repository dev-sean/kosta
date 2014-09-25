
package exam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author kosta
 * Document    : Server created on : 2014. 9. 25, ���� 3:29:57
 */
public class Server {
    private ServerSocket ss;
    private Socket s;
    public Server() {
        try {            
            //�������� �����
            ss = new ServerSocket(9999);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    public void execute(){
        while(true){
            try {
                //�޾Ƶ��� �غ�
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
