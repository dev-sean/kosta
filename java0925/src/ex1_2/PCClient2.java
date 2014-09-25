
package ex1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class PCClient2 {

    private Socket socket;
    private PCServer2 server;
    private PrintWriter pw;
    private String nickName;

    public PCClient2(Socket sk, PCServer2 sv) {
        // Client �� socket �� ���� ��ü �ּ� �ޱ�
        socket = sk;
        server = sv;
        try {
            pw = new PrintWriter(sk.getOutputStream(), true);
        } catch (IOException ex) {
        }

        // ������ �б⸦ ���� Thread
        Thread t = new Thread(new Runnable() {

            private BufferedReader bfr;

            public void run() {
                try {
                    bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    // �޽����� ������ �޽��� ��ȯ�޼���(transMsg()) ȣ��
                    while (true) {
                        String msg = bfr.readLine();
                        transMsg(msg); // ��ȯ�޼��� ȣ��(transMsg(msg))
                    }
                } catch (IOException ex) {
                } finally {
                    if (bfr != null) {
                        try {
                            bfr.close();
                        } catch (IOException ex) {
                        }
                    }
                }
            }

            // �޽��� ��ū �� ������ sendMsg �޼��� ȣ��
            private void transMsg(String msg) {
                StringTokenizer stn = new StringTokenizer(msg, "/");
                String t1 = stn.nextToken();
                String t2 = stn.nextToken();
                String t3 = stn.nextToken();
                String t4 = stn.nextToken();
                nickName = t3; // ��ȭ�� ����

                // ������ sendMsg ȣ�� - ��ū�� �޽����� �����Ѵ�
               server.sendMsg(t1, t2, t3, t4, PCClient2.this); // �ڽ��� �ּҵ� ���� ����
            }
        });

        t.start(); // Thread ����
    }

    public PrintWriter getPw() { // ��½�Ʈ�� �ּ� �ޱ�
        return pw;
    }

    public String getNickName() { // �г��� �ޱ�
        return nickName;
    }

}
