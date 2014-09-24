package ex1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ������ Document : Ex2_Client Created on : 2014. 9. 24, ���� 11:02:27
 */
public class Ex2_Client {

    private Socket s;

    public Ex2_Client() {
        try {
            s = new Socket("192.168.7.3", 8888);
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
                // PrintWriter�� Ư¡
            // - 1�� ��Ʈ��, 2�� ��Ʈ��(Buffer�� ���)
            // - ����Ʈ ��Ʈ��, ���� ��Ʈ�� ���� ��� ����� ����
            //�����÷��� : �ڵ����� ���۸� ����ִ� ������ �Ѵ�.
            //���ڿ��� ���� ������ ����Ʈ��Ʈ������ ���� �ϴ� ���� ����!
            PrintWriter pw = new PrintWriter(new BufferedOutputStream(os), true);
            pw.println("^^");
            String msg = br.readLine();
            System.out.println(msg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Ex2_Client();
    }
}
