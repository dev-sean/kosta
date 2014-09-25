package ex2;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author ������
 * Document : ServerThread 
 * Created on : 2014. 9. 25, ���� 1:47:57
 */
class ServerThread {

    //�����κ��� ���ӹ��� ����
    private Socket socket;
    //�����κ��� ���� ������ �ּ�
    private MultiSocketServer server;
    //�����κ��� ����� �� ��Ʈ��
    private PrintWriter pw;
    private BufferedReader in;
    //x,y��ǥ, �÷���
    private int x;
    private int y;
    private String col;
    

    public ServerThread(Socket socket, MultiSocketServer server) {
        this.socket = socket;
        this.server = server;

        try {
            pw = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //Thread�� ����Ŭ������ ����
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    //���� �ϳ��� ��Ʈ���� ����
                    in = new BufferedReader(new InputStreamReader(ServerThread.this.socket.getInputStream()));
                    while(true){
                        //�������κ��� �Է��� �ޱ� ���� ����ϴ� �޼���
                        String msg = in.readLine();
                        draw();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            private void draw() {
                //ServerThread.this.server.sendMsg(msg, ServerThread.this);
                //ServerThread.this.server.sendMsg(col, null);
            }
        });
        //Thread�� start�ؼ� �����췯���� ���� ��û�Ѵ�.
        t.start();
    }

    public PrintWriter getPw() {
        return pw;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCol() {
        return col;
    }

}
