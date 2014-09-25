package ex1;
/**
 * @author kosta 
 * Document   : ServerThread Created on : 2014. 9. 25, ���� 8:55:18
 */
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread {
    // �����κ��� ���ӹ��� ����
    private Socket socket;
    // �����κ��� ���� ������ �ּ�
    private MultiSocketServer server;
    // �������κ��� ����� �� ��Ʈ��
    private PrintWriter pw;
    private BufferedReader in;
    // �г���
    private String nickName;

    public ServerThread(Socket socket, MultiSocketServer server) {
        this.socket = socket;
        this.server = server;
        try {
            pw = new PrintWriter(
                    new BufferedOutputStream(
                            socket.getOutputStream()), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            // Thread�� ����Ŭ������ ����
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // ���� �ϳ��� ��Ʈ���� ����
                    in = new BufferedReader(
                            new InputStreamReader(
                                    ServerThread.this.socket.getInputStream()));
                    while (true) {
                        // �������κ��� �Է��� �ޱ� ���� ����ϴ� �޼���
                        String msg = in.readLine();
                        transMsg(msg);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            // �޼��� ��ū �� ������ sendMsg ȣ�� ���
            private void transMsg(String msg) {
                // ������ sendMsg()�� ȣ���Ҷ�  �޼����� ����
                ServerThread.this.server.sendMsg(msg, ServerThread.this);
            }
        });
        // Thread�� start�ؼ� �����ٷ����� ���� ��û�Ѵ�.
        t.start();
        
    }
    
    
    
    
    
    
    
    // ������ ����ؾߵ� �ڿ���
    public PrintWriter getPw() {
        return pw;
    }

    public String getNickName() {
        return nickName;
    }

    public Socket getSocket() {
        return socket;
    }
    
}