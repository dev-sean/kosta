
package exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.html.HTMLDocument;

/**
 * @author kosta
 * Document    : ServerThread created on : 2014. 9. 25, ���� 3:43:55
 */
public class ServerThread {
private Socket socket;
private Server server;
private ObjectInputStream os;
private PrintWriter pw;
    ServerThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    //objectinputStream���� ���Ͽ��� �޾Ƶ��� object�� �޴´�.
                    os = new ObjectInputStream(socket.getInputStream());
                    while (true) {        
                        
                        ArrayList arr = new ArrayList();
                        //Ȯ��
                        System.out.println(os.read());
                        //ArrayList�� ���� object�� ����.
//                        arr.add(os.read());
                        
                        
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
            }
        });
        t.start();
    }
    
}
